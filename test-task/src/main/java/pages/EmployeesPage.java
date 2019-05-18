package pages;

import model.EmployeeData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driverManager.DriverHandler.getWebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EmployeesPage extends BasePage {

    private static final String EMPLOYEES_PART_URL = "employees";

    private static final By CREATE_BUTTON_LOCATOR = By.cssSelector("#bAdd");
    private static final By HEADER_ELEMENT_LOCATOR = By.cssSelector("#greetings");
    private static final By LOGOUT_BUTTON_LOCATOR = By.cssSelector("p[ng-click='logout()']");
    private static final By EDIT_BUTTON_LOCATOR = By.cssSelector("#bEdit");

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

    public EmployeesPage clickOnEmployeeByFirstAndLastName(String firstName, String lastName) {
        wd.findElement(By.xpath(String.format(".//li[contains(text(),'%s %s')]", firstName, lastName))).click();
        return this;
    }

    public EmployeesPage clickOnEmployeeByEmployeeData(EmployeeData employeeData) {
        clickOnEmployeeByFirstAndLastName(employeeData.getFirstName(), employeeData.getLastName());
        return this;
    }

    public String findEmployeeByEmployeeData(EmployeeData employeeData) {
        return wd.findElements(By.cssSelector("ul#employee-list li"))
                .stream()
                .map(WebElement::getText)
                .filter(employeeElement -> employeeElement.equals(employeeData.getFirstName() + " " + employeeData.getLastName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No employee found with username " + employeeData.getFirstName() + " " + employeeData.getLastName()));
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
    //endregion
}
