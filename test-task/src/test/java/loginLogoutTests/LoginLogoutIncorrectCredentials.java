package loginLogoutTests;

import pages.CafeTownTestBase;
import org.testng.annotations.Test;

/**
 * User: Anton Kiselev
 * Date: 17.05.2019
 * <p>
 * Preconditions:
 * - Navigate to CafeTown login page http://cafetownsend-angular-rails.herokuapp.com/
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Input incorrect value to Username field, eg. "errorLoginName"
 * - Leave Password field empty
 * - Click "Login" button
 * Expected result:
 * - User still is on Login page
 * <p>
 * Step 2:
 * - Input incorrect value to Password field, eg. "errorPAssword"
 * - Leave Username field empty
 * - Click "Login" button
 * Expected result:
 * - User still is on Login page
 * <p>
 * Step 3:
 * - Leave both fields Login and Password empty
 * - Click "Login" button
 * Expected result:
 * - User still is on Login page
 * <p>
 * Step 4:
 * - Input incorrect value to Username field, eg. "errorLoginName"
 * - Input incorrect value to Password field, eg. "errorPAssword"
 * - Click "Login" button
 * Expected result:
 * - Error message with text "Invalid username or password!" is displayed
 * <p>
 */

public class LoginLogoutIncorrectCredentials extends CafeTownTestBase {

    @Test
    private void test_ak_t002() {
        loginToCafeTownApp();
        navigateToLoginPage();
        //Step 1
        inputToUserNameField("errorLoginName");
        clickLoginButton();
        checkUserIsOnLoginPage();
        //Step 2
        inputToUserNameField("");
        inputToPasswordField("errorPAssword");
        clickLoginButton();
        checkUserIsOnLoginPage();
        //Step 3
        inputToUserNameField("");
        inputToPasswordField("");
        clickLoginButton();
        checkUserIsOnLoginPage();
        //Step 4
        inputToUserNameField("errorLoginName");
        inputToPasswordField("errorPAssword");
        clickLoginButton();
        checkUserIsOnLoginPage();
        checkErrorMessageIsDisplayed();
    }

    private void checkErrorMessageIsDisplayed() {
        pageProvider
                .getLoginPage()
                .checkErrorMessageIsDisplayed();
    }

    private void inputToPasswordField(String password) {
        pageProvider
                .getLoginPage()
                .inputToPasswordField(password);
    }

    private void checkUserIsOnLoginPage() {
        pageProvider
                .getLoginPage()
                .checkUserIsOnLoginPage();
    }

    private void clickLoginButton() {
        pageProvider
                .getLoginPage()
                .clickLoginButton();
    }

    private void inputToUserNameField(String errorLoginName) {
        pageProvider
                .getLoginPage()
                .inputToUserNameField(errorLoginName);
    }
}
