package Pages;

import org.openqa.selenium.WebDriver;

import static DriverManager.DriverHandler.getWebDriver;

public class HelperPage extends BasePage {

    LoginPage loginPage = new LoginPage(getWebDriver());

    public HelperPage(WebDriver wd) {
        super(wd);
    }

    public void loginToCafeTown() {
        loginPage
                .inputToUserNameField("Luke")
                .inputToPasswordField("Skywalker")
                .clickLoginButton()
                .checkUserIsOnLoginPage();
    }
}