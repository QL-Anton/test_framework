package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driverManager.DriverHandler.getWebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    private static String LOGIN_PART_URL = "login";

    private static final By USER_NAME_INPUT_FIELD_LOCATOR = By.cssSelector("input[ng-model='user.name']");
    private static final By USER_NAME_LABEL_LOCATOR = By.xpath(".//input[@ng-model='user.name']//..//span");
    private static final By PASSWORD_LABEL_LOCATOR = By.xpath(".//input[@ng-model='user.password']//..//span");
    private static final By PASSWORD_LOCATOR = By.cssSelector("input[ng-model='user.password']");
    private static final By LOGIN_BUTTON = By.cssSelector("button.main-button");
    private static final By ERROR_MESSAGE_LOCATOR = By.cssSelector("p.error-message");

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    public LoginPage inputToUserNameField(String text) {
        input(getUserNameInputFieldElement(), text);
        return this;
    }

    public LoginPage inputToPasswordField(String text) {
        input(getPasswordInputFieldElement(), text);
        return this;
    }

    public LoginPage checkUserNameLabelIsCorrect() {
        assertEquals(getUserNameLabelElement().getAttribute("innerText"), "Username*", "Incorrect label's text!");
        return this;
    }

    public LoginPage checkPasswordLabelIsCorrect() {
        assertEquals(getPasswordLabelElement().getAttribute("innerText"), "Password*", "Incorrect label's text!");
        return this;
    }

    public LoginPage checkUserNameFieldIsEmpty() {
        assertTrue(getUserNameInputFieldElement().getAttribute("value").isEmpty());
        return this;
    }

    public LoginPage checkPasswordFieldIsEmpty() {
        assertEquals(getPasswordInputFieldElement().getAttribute("value"), "");
        return this;
    }

    public LoginPage clickLoginButton() {
        getLoginButtonElement().click();
        return this;
    }

    public LoginPage checkLoginButtonIsEnabled() {
        assertTrue(getLoginButtonElement().isEnabled());
        return this;
    }

    public LoginPage checkLoginButtonLabelIsCorrect() {
        assertEquals(getLoginButtonElement().getAttribute("innerText"), "Login");
        return this;
    }

    public LoginPage checkUserIsOnLoginPage() {
        getWebDriverWait().until(visibilityOfElementLocated(LOGIN_BUTTON));
        assertTrue(wd.getCurrentUrl().contains(LOGIN_PART_URL));
        return this;
    }

    public LoginPage checkErrorMessageIsDisplayed() {
        getWebDriverWait().until(visibilityOfElementLocated(ERROR_MESSAGE_LOCATOR));
        assertEquals(getErrorMessageElement().getText(), "Invalid username or password!");
        return this;
    }

    //region getters
    private WebElement getUserNameInputFieldElement() {
        return wd.findElement(USER_NAME_INPUT_FIELD_LOCATOR);
    }

    private WebElement getPasswordInputFieldElement() {
        return wd.findElement(PASSWORD_LOCATOR);
    }

    private WebElement getLoginButtonElement() {
        return wd.findElement(LOGIN_BUTTON);
    }

    private WebElement getUserNameLabelElement() {
        return wd.findElement(USER_NAME_LABEL_LOCATOR);
    }

    private WebElement getPasswordLabelElement() {
        return wd.findElement(PASSWORD_LABEL_LOCATOR);
    }

    private WebElement getErrorMessageElement() {
        return wd.findElement(ERROR_MESSAGE_LOCATOR);
    }
    //endregion
}
