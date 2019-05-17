package loginLogoutTests;

import pages.CafeTownTestBase;
import org.testng.annotations.Test;

import static utils.Constants.PASSWORD;
import static utils.Constants.USER_LOGIN;

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
 * Check Login page view
 * Expected result:
 * - "Username*" label is displayed
 * - "Username*" field is empty by default
 * - "Password*" label is displayed
 * - "Password*" field is empty by default
 * - "Login" button is displayed
 * - "Login" button is enabled by default
 * <p>
 * Step 2:
 * Input  correct credentials to Username and Password fields, eg. Username - Luke, Password - Skywalker
 * Expected result:
 * - "Login" button is enabled
 * <p>
 * Step 3:
 * Click "Login" button
 * Expected result:
 * - User is redirected to the Employees page
 * - "Hello Luke" header is displayed
 * <p>
 * Step 4:
 * Click "Logout" button
 * Expected result:
 * - User is redirected to Login page
 * <p>
 * Step 5:
 * Check Username and Password fields
 * Expected result:
 * - "Username*" field is empty
 * - "Password*" field is empty
 * <p>
 */

public class LoginLogout extends CafeTownTestBase {

    @Test
    private void test_ak_t001() {
        navigateToLoginPage();
        //Step 1
        checkFieldsAreDisplayedCorrectly();
        //Step 2
        inputUserName();
        inputPassword();
        checkLoginButtonIsEnabled();
        //Step 3
        clickLoginButton();
        checkUserIsOnEmployeesPage();
        checkHeaderIsCorrect();
        //Step 4
        clickLogoutButton();
        checkUserIsOnLoginPage();
        //Step 5
        checkUserNameAndPasswordsFieldsEmpty();
    }

    private void checkUserNameAndPasswordsFieldsEmpty() {
        pageProvider
                .getLoginPage()
                .checkUserNameFieldIsEmpty()
                .checkPasswordFieldIsEmpty();
    }

    private void checkUserIsOnLoginPage() {
        pageProvider
                .getLoginPage()
                .checkUserIsOnLoginPage();
    }

    private void clickLogoutButton() {
        pageProvider
                .getEmployeesPage()
                .clickLogoutButton();
    }

    private void checkHeaderIsCorrect() {
        pageProvider
                .getEmployeesPage()
                .checkHeaderIsCorrect(USER_LOGIN);
    }

    private void checkUserIsOnEmployeesPage() {
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage();
    }

    private void clickLoginButton() {
        pageProvider
                .getLoginPage()
                .clickLoginButton();
    }

    private void checkLoginButtonIsEnabled() {
        pageProvider
                .getLoginPage()
                .checkLoginButtonIsEnabled();
    }

    private void inputPassword() {
        pageProvider
                .getLoginPage()
                .inputToPasswordField(PASSWORD);
    }

    private void inputUserName() {
        pageProvider
                .getLoginPage()
                .inputToUserNameField(USER_LOGIN);
    }

    private void checkFieldsAreDisplayedCorrectly() {
        pageProvider
                .getLoginPage()
                .checkPasswordLabelIsCorrect()
                .checkUserNameLabelIsCorrect()
                .checkUserNameFieldIsEmpty()
                .checkPasswordFieldIsEmpty()
                .checkLoginButtonLabelIsCorrect()
                .checkLoginButtonIsEnabled();
    }
}
