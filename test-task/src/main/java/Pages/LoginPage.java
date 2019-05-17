package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By USER_NAME_LOCATOR = By.cssSelector("input[ng-model='user.name']");
    private static final By PASSWORD_LOCATOR = By.cssSelector("input[ng-model='user.password']");
    private static final By LOGIN_BUTTON = By.cssSelector("button.main-button");

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    public void loginToCafeTown() {
        wd.get("http://cafetownsend-angular-rails.herokuapp.com/");
        type(USER_NAME_LOCATOR,"Luke");
        type(PASSWORD_LOCATOR,"Skywalker");
        click(LOGIN_BUTTON);
    }
}
