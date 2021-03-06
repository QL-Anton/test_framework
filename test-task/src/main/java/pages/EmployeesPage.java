package pages;

import model.EmployeeData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static driverManager.DriverHandler.getWebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*Class for Cafe Town Home page */
public class EmployeesPage extends BasePage {

    private static final String EMPLOYEES_PART_URL = "employees";

    private static final By CREATE_BUTTON_LOCATOR = By.cssSelector("#bAdd");
    private static final By HEADER_ELEMENT_LOCATOR = By.cssSelector("#greetings");
    private static final By LOGOUT_BUTTON_LOCATOR = By.cssSelector("p[ng-click='logout()']");
    private static final By EDIT_BUTTON_LOCATOR = By.cssSelector("#bEdit");
    private static final By DELETE_BUTTON_LOCATOR = By.cssSelector("#bDelete");
    private static final By EMPLOYEES_LIST_LOCATOR = By.cssSelector("#employee-list li");

    public EmployeesPage(WebDriver wd) {
        super(wd);
    }

    public EmployeesPage checkUserIsOnEmployeesPage() {
        getWebDriverWait().until(visibilityOfElementLocated(CREATE_BUTTON_LOCATOR));
        assertTrue(wd.getCurrentUrl().contains(EMPLOYEES_PART_URL));
        return this;
    }

    public EmployeesPage checkHeaderIsCorrect(String userName) {
        assertEquals(getHeaderElement().getText(), String.format("Hello %s", userName));
        return this;
    }

    public EmployeesPage clickLogoutButton() {
        getLogoutButtonElement().click();
        return this;
    }

    public EmployeesPage clickCreateButton() {
        getCreateButtonElement().click();
        return this;
    }

    public EmployeesPage clickEditButton() {
        getEditButtonElement().click();
        return this;
    }

    public EmployeesPage clickDeleteButton() {
        getDeleteButtonElement().click();
        return this;
    }

    public EmployeesPage checkConfirmationTextIsCorrect(EmployeeData employeeData) {
        assertEquals(wd.switchTo().alert().getText(), String.format("Are you sure you want to delete %s %s?", employeeData.getFirstName(), employeeData.getLastName()));
        return this;
    }

    public EmployeesPage confirmDeletion() {
        wd.switchTo().alert().accept();
        return this;
    }

    public EmployeesPage dismissDeletion() {
        wd.switchTo().alert().dismiss();
        return this;
    }

    public EmployeesPage doubleClickOnEmployee(EmployeeData employeeData) {
        Actions action = new Actions(wd);
        action
                .moveToElement(
                        wd.findElement(By.xpath(String.format(".//li[contains(text(),'%s %s')]", employeeData.getFirstName(), employeeData.getLastName()))))
                .doubleClick()
                .perform();
        return this;
    }

    public EmployeesPage clickFirstEmployee() {
        List<WebElement> elements = getEmployeeListLocator();
        elements.get(0).click();
        return this;
    }

    public EmployeesPage clickOnEmployeeByFirstAndLastName(String firstName, String lastName) {
        wd.findElement(By.xpath(String.format(".//li[contains(text(),'%s %s')]", firstName, lastName))).click();
        return this;
    }

    public EmployeesPage clickOnEmployeeByEmployeeData(EmployeeData employeeData) {
        clickOnEmployeeByFirstAndLastName(employeeData.getFirstName(), employeeData.getLastName());
        return this;
    }

    public String findEmployeeUserNameByEmployeeData(EmployeeData employeeData) {
        return wd.findElements(By.cssSelector("ul#employee-list li"))
                .stream()
                .map(WebElement::getText)
                .filter(employeeElement -> employeeElement.equals(employeeData.getFirstName() + " " + employeeData.getLastName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No employee found with username " + employeeData.getFirstName() + " " + employeeData.getLastName()));
    }

    public void checkEmployeeIsNotPresentedOnTheListByEmployeeData(EmployeeData employeeData) {
        List<String> listOfEmployees = wd.findElements(By.cssSelector("ul#employee-list li"))
                .stream()
                .map(WebElement::getText)
                .filter(employeeElement -> employeeElement.equals(employeeData.getFirstName() + " " + employeeData.getLastName()))
                .collect(Collectors.toList());

        assertTrue(listOfEmployees.isEmpty());
    }

    //region getters
    private WebElement getCreateButtonElement() {
        return wd.findElement(CREATE_BUTTON_LOCATOR);
    }

    private WebElement getLogoutButtonElement() {
        return wd.findElement(LOGOUT_BUTTON_LOCATOR);
    }

    private WebElement getHeaderElement() {
        return wd.findElement(HEADER_ELEMENT_LOCATOR);
    }

    private WebElement getEditButtonElement() {
        return wd.findElement(EDIT_BUTTON_LOCATOR);
    }

    private WebElement getDeleteButtonElement() {
        return wd.findElement(DELETE_BUTTON_LOCATOR);
    }

    private List<WebElement> getEmployeeListLocator() {
        return wd.findElements(EMPLOYEES_LIST_LOCATOR);
    }
    //endregion
}
