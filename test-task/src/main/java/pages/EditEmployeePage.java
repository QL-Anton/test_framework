package pages;

import model.EmployeeData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driverManager.DriverHandler.getWebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertTrue;

public class EditEmployeePage extends BasePage {

    private static final String EDIT_EMPLOYEE_PART_URL = "edit";

    private static final By UPDATE_BUTTON_LOCATOR = By.xpath(".//button[text()='Update']");
    private static final By CANCEL_BUTTON_LOCATOR = By.cssSelector("a.subButton.bCancel");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath(".//p[text()='Delete']");
    private static final By FIRST_NAME_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.firstName']");
    private static final By FIRST_NAME_LABEL_LOCATOR = By.xpath(".//input[@ng-model='selectedEmployee.firstName']//..//span");
    private static final By LAST_NAME_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.lastName']");
    private static final By LAST_NAME_LABEL_LOCATOR = By.xpath("//input[@ng-model='selectedEmployee.lastName']//..//span");
    private static final By START_DATE_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.startDate']");
    private static final By START_DATE_LABEL_LOCATOR = By.xpath("//input[@ng-model='selectedEmployee.startDate']//..//span");
    private static final By EMAIL_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.email']");
    private static final By EMAIL_LABEL_LOCATOR = By.xpath("//input[@ng-model='selectedEmployee.email']//..//span");

    public EditEmployeePage(WebDriver wd) {
        super(wd);
    }

    public EditEmployeePage checkUserIsOnEditEmployeePage() {
        getWebDriverWait().until(visibilityOfElementLocated(UPDATE_BUTTON_LOCATOR));
        assertTrue(wd.getCurrentUrl().contains(EDIT_EMPLOYEE_PART_URL));
        return this;
    }

    public EditEmployeePage clickDeleteButton() {
        getDeleteButtonElement().click();
        return this;
    }

    public EditEmployeePage confirmDeletion() {
        wd.switchTo().alert().accept();
        return this;
    }

    public EmployeeData getEmployeeDataFromEditDetailsPage() {
        return new EmployeeData()
                .setFirstName(getFirstNameFieldElement().getAttribute("value"))
                .setLastName(getLastNameFieldElement().getAttribute("value"))
                .setStartDate(getStartDateFieldElement().getAttribute("value"))
                .setEmail(getEmailFieldElement().getAttribute("value"));
    }

    public EditEmployeePage inputToFirstNameField(String text) {
        input(getFirstNameFieldElement(), text);
        return this;
    }

    public EditEmployeePage inputToLastNameField(String text) {
        input(getLastNameFieldElement(), text);
        return this;
    }

    public EditEmployeePage inputToStartDateField(String text) {
        input(getStartDateFieldElement(), text);
        return this;
    }

    public EditEmployeePage inputToEmailField(String text) {
        input(getEmailFieldElement(), text);
        return this;
    }

    public EditEmployeePage clickUpdateButton() {
        getUpdateButtonElement().click();
        return this;
    }

    //region getters
    private WebElement getCancelButtonElement() {
        return wd.findElement(CANCEL_BUTTON_LOCATOR);
    }

    private WebElement getUpdateButtonElement() {
        return wd.findElement(UPDATE_BUTTON_LOCATOR);
    }

    private WebElement getFirstNameLabelElement() {
        return wd.findElement(FIRST_NAME_LABEL_LOCATOR);
    }

    private WebElement getFirstNameFieldElement() {
        return wd.findElement(FIRST_NAME_FIELD_LOCATOR);
    }

    private WebElement getLastNameLabelElement() {
        return wd.findElement(LAST_NAME_LABEL_LOCATOR);
    }

    private WebElement getLastNameFieldElement() {
        return wd.findElement(LAST_NAME_FIELD_LOCATOR);
    }

    private WebElement getStartDateLabelElement() {
        return wd.findElement(START_DATE_LABEL_LOCATOR);
    }

    private WebElement getStartDateFieldElement() {
        return wd.findElement(START_DATE_FIELD_LOCATOR);
    }

    private WebElement getEmailLabelElement() {
        return wd.findElement(EMAIL_LABEL_LOCATOR);
    }

    private WebElement getDeleteButtonElement() {
        return wd.findElement(DELETE_BUTTON_LOCATOR);
    }

    private WebElement getEmailFieldElement() {
        return wd.findElement(EMAIL_FIELD_LOCATOR);
    }
    //endregion
}
