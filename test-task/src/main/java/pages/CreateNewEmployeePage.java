package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static driverManager.DriverHandler.getWebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateNewEmployeePage extends BasePage {

    private static final String CREATE_EMPLOYEE_URL_PART = "new";

    private static final By ADD_BUTTON_LOCATOR = By.xpath(".//button[text()='Add']");
    private static final By CANCEL_BUTTON_LOCATOR = By.cssSelector("a.subButton.bCancel");
    private static final By FIRST_NAME_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.firstName']");
    private static final By FIRST_NAME_LABEL_LOCATOR = By.xpath(".//input[@ng-model='selectedEmployee.firstName']//..//span");
    private static final By LAST_NAME_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.lastName']");
    private static final By LAST_NAME_LABEL_LOCATOR = By.xpath("//input[@ng-model='selectedEmployee.lastName']//..//span");
    private static final By START_DATE_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.startDate']");
    private static final By START_DATE_LABEL_LOCATOR = By.xpath("//input[@ng-model='selectedEmployee.startDate']//..//span");
    private static final By EMAIL_FIELD_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.email']");
    private static final By EMAIL_LABEL_LOCATOR = By.xpath("//input[@ng-model='selectedEmployee.email']//..//span");

    public CreateNewEmployeePage(WebDriver wd) {
        super(wd);
    }

    public CreateNewEmployeePage checkUserIsOnCreateNewEmployeePage() {
        getWebDriverWait().until(visibilityOfElementLocated(ADD_BUTTON_LOCATOR));
        assertTrue(wd.getCurrentUrl().contains(CREATE_EMPLOYEE_URL_PART));
        return this;
    }

    public CreateNewEmployeePage inputToFirstNameField(String text) {
        input(getFirstNameFieldElement(), text);
        return this;
    }

    public CreateNewEmployeePage inputToLastNameField(String text) {
        input(getLastNameFieldElement(), text);
        return this;
    }

    public CreateNewEmployeePage inputToStartDateField(String text) {
        input(getStartDateFieldElement(), text);
        return this;
    }

    public CreateNewEmployeePage inputToEmailField(String text) {
        input(getEmailFieldElement(), text);
        return this;
    }

    public CreateNewEmployeePage clickAddButton() {
        getAddButtonElement().click();
        return this;
    }

    public CreateNewEmployeePage checkFirstNameLabelIsCorrect() {
        assertEquals(getFirstNameLabelElement().getText(), "First name:");
        return this;
    }

    public CreateNewEmployeePage checkStartDateLabelIsCorrect() {
        assertEquals(getStartDateLabelElement().getText(), "Start date:");
        return this;
    }

    public CreateNewEmployeePage checkLastNameLabelIsCorrect() {
        assertEquals(getLastNameLabelElement().getText(), "Last name:");
        return this;
    }

    public CreateNewEmployeePage checkEmailLabelIsCorrect() {
        assertEquals(getEmailLabelElement().getText(), "Email:");
        return this;
    }

    public CreateNewEmployeePage checkFirsNameFieldHasText(String text) {
        assertEquals(getFirstNameFieldElement().getAttribute("value"), text);
        return this;
    }

    public CreateNewEmployeePage checkLastNameFieldHasText(String text) {
        assertEquals(getLastNameFieldElement().getAttribute("value"), text);
        return this;
    }

    public CreateNewEmployeePage checkStartDateFieldHasText(String text) {
        assertEquals(getStartDateFieldElement().getAttribute("value"), text);
        return this;
    }

    public CreateNewEmployeePage checkEmailFieldHasText(String text) {
        assertEquals(getEmailFieldElement().getAttribute("value"), text);
        return this;
    }

    public CreateNewEmployeePage checkCancelButtonIsDisplayed() {
        assertTrue(getCancelButtonElement().isDisplayed());
        return this;
    }

    public CreateNewEmployeePage clickCancelButton() {
        getCancelButtonElement().click();
        return this;
    }

    public CreateNewEmployeePage checkCancelButtonIsEnabled() {
        assertTrue(getCancelButtonElement().isEnabled());
        return this;
    }

    public CreateNewEmployeePage checkStarDateFieldValidationSuccessful(){
        checkValidationFieldIsSuccessful(getStartDateFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkStarDateFieldValidationFailed(){
        checkValidationFieldIsFailed(getStartDateFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkFirstNameFieldValidationSuccessful(){
        checkValidationFieldIsSuccessful(getStartDateFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkFirstNameFieldValidationFailed(){
        checkValidationFieldIsFailed(getStartDateFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkLastNameFieldValidationSuccessful(){
        checkValidationFieldIsSuccessful(getStartDateFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkLastNameFieldValidationFailed(){
        checkValidationFieldIsFailed(getStartDateFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkEmailFieldValidationSuccessful(){
        checkValidationFieldIsSuccessful(getEmailFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkEmailFieldValidationFailed(){
        checkValidationFieldIsFailed(getEmailFieldElement());
        return this;
    }

    public CreateNewEmployeePage checkAddButtonIsDisplayed() {
        assertTrue(getAddButtonElement().isDisplayed());
        return this;
    }

    public CreateNewEmployeePage checkAddButtonIsEnabled() {
        assertTrue(getAddButtonElement().isEnabled());
        return this;
    }

    //region getters
    private WebElement getCancelButtonElement() {
        return wd.findElement(CANCEL_BUTTON_LOCATOR);
    }

    private WebElement getAddButtonElement() {
        return wd.findElement(ADD_BUTTON_LOCATOR);
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

    private WebElement getEmailFieldElement() {
        return wd.findElement(EMAIL_FIELD_LOCATOR);
    }
    //endregion
}
