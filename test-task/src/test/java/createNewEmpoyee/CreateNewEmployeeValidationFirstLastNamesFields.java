package createNewEmpoyee;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pages.CafeTownTestBase;
import pages.CreateNewEmployeePage;

/**
 * User: Anton Kiselev
 * Date: 18.05.2019
 * <p>
 * Preconditions:
 * - User is logged in the test application (http://cafetownsend-angular-rails.herokuapp.com)
 * - User is on the Employees page
 * - User clicks "Create" button and redirected to Create New Employee Page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Input random 60 letters to "First name"  field
 * - Check that validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 2:
 * - Clear "First name" field
 * - Remove focus
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 * Step 3:
 * - Input random 1 letter to "First name"  field
 * - Check that validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 4:
 * - Input  to "First name"  field string with space, eg.
 * "ABC DEF"
 * - Check that validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 5:
 * - Input random 60 letters to "Last name"  field
 * - Check that validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 6:
 * - Clear "Last name" field
 * - Remove focus
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 * Step 7:
 * - Input random 1 letter to "Last name"  field
 * - Check that validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 8:
 * - Input  to "Last name" field string with space, eg.
 * "ABC DEF"
 * - Check that validation
 * Expected result:
 * - Validation is successful
 * <p>
 */

public class CreateNewEmployeeValidationFirstLastNamesFields extends CafeTownTestBase {

    @Test
    private void test_ak_t008() {
        navigateToCreateNewEmployeePage();
        //Step 1
        inputToFirstNameField(RandomStringUtils.randomAlphabetic(60));
        checkFirstNameFieldValidationSuccessful();
        //Step 2
        inputToFirstNameField("");
        checkFirstNameFieldValidationFailed();
        //Step 3
        inputToFirstNameField("a");
        checkFirstNameFieldValidationSuccessful();
        //Step 4
        inputToFirstNameField("ABC DEF");
        checkFirstNameFieldValidationSuccessful();
        //Step 5
        inputToLastNameField(RandomStringUtils.randomAlphabetic(60));
        checkLastNameFieldValidationSuccessful();
        //Step 6
        inputToLastNameField("");
        checkLastNameFieldValidationFailed();
        //Step 7
        inputToLastNameField("a");
        checkLastNameFieldValidationSuccessful();
        //Step 7
        inputToLastNameField("ABC DEF");
        checkLastNameFieldValidationSuccessful();
    }

    private CreateNewEmployeePage checkLastNameFieldValidationFailed() {
        return pageProvider
                .getCreateNewEmployeePage()
                .checkLastNameFieldValidationFailed();
    }

    private void checkLastNameFieldValidationSuccessful() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkLastNameFieldValidationSuccessful();
    }

    private void checkFirstNameFieldValidationFailed() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkFirstNameFieldValidationFailed();
    }

    private void checkFirstNameFieldValidationSuccessful() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkFirstNameFieldValidationSuccessful();
    }

    private void inputToLastNameField(String text) {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToLastNameField(text);
    }

    private void inputToFirstNameField(String text) {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToFirstNameField(text);
    }

    private void navigateToCreateNewEmployeePage() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .goToCreatePage();
    }
}
