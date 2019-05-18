package createNewEmpoyee;

import org.testng.annotations.Test;
import pages.CafeTownTestBase;

/**
 * User: Anton Kiselev
 * Date: 17.05.2019
 * <p>
 * Preconditions:
 * - User is logged in the test application (http://cafetownsend-angular-rails.herokuapp.com)
 * - User is on the Employees page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * Click "Create" button
 * Expected result:
 * - User is redirected to Create New Employee page
 * <p>
 * Step 2:
 * Check fields are displayed correctly
 * Expected result:
 * - "First name:" field is displayed
 * - "First name:" field is empty by default
 * - "Last name:" field is displayed
 * - "Last name:" field is empty by default
 * - "Start date:" field is displayed
 * - "Start date:" field is empty by default
 * - "Email:" field is displayed
 * - "Email:" field is empty by default
 * - "Add" button is displayed
 * - "Add" button is enabled
 * - "Cancel" button is displayed
 * - "Cancel" button is enabled
 * <p>
 */

public class CreateNewEmployeeView extends CafeTownTestBase {

    @Test
    private void test_ak_t003() {
        navigateToLoginPage();
        loginToCafeTown();
        //Step 1
        clickCreateButton();
        checkUserIsOnCreateNewEmployeePage();
        //Step 2
        checkFieldsAreDisplayedCorrectly();
    }

    private void checkFieldsAreDisplayedCorrectly() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkFirstNameLabelIsCorrect()
                .checkFirsNameFieldHasText("")
                .checkLastNameLabelIsCorrect()
                .checkLastNameFieldHasText("")
                .checkStartDateLabelIsCorrect()
                .checkStartDateFieldHasText("")
                .checkEmailLabelIsCorrect()
                .checkEmailFieldHasText("")
                .checkAddButtonIsDisplayed()
                .checkAddButtonIsEnabled()
                .checkCancelButtonIsDisplayed()
                .checkCancelButtonIsEnabled();
    }

    private void checkUserIsOnCreateNewEmployeePage() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkUserIsOnCreateNewEmployeePage();
    }

    private void clickCreateButton() {
        pageProvider
                .getEmployeesPage()
                .clickCreateButton();
    }

    private void loginToCafeTown() {
        pageProvider
                .getHelperPage()
                .loginToCafeTown();
    }
}
