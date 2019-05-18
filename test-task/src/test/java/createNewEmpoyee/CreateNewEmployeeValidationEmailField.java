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
 * - Input email with values
 * - "abcdef@ghij.com"
 * - Check validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 2:
 * - Clear "email" field
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 * Step 3:
 * - Input "ABDEFE@DFE.CF" to "Email" field
 * - Check validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 4:
 * - Clear "email" field
 * - Input "abc123@ru.ru" to "Email" field
 * - Check validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 5:
 * - Clear "email" field
 * - Input "abc123@98com.ac" to "Email" field
 * - Check validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 6:
 * - Clear "email" field
 * - Input "abc-123@98com.ac" to "Email" field
 * - Check validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 7:
 * - Clear "email" field
 * - Input "sad   sdfsd@sdf.com" to "Email" field
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 * Step 8:
 * - Clear "email" field
 * - Input string with more than 320 characters in correct format (with @) to "Email" field
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 */

public class CreateNewEmployeeValidationEmailField extends CafeTownTestBase {


    @Test
    private void test_ak_t006() {
        navigateToCreateNewEmployeePage();
        //Step 1
        inputToEmailField("abcdef@ghij.com");
        checkEmailFieldValidationSuccessful();
        //Step 2
        inputToEmailField("");
        checkEmailFieldValidationFailed();
        //Step 3
        inputToEmailField("ABDEFE@DFE.CF");
        checkEmailFieldValidationSuccessful();
        //Step 4
        inputToEmailField("abc123@ru.ru");
        checkEmailFieldValidationSuccessful();
        //Step 5
        inputToEmailField("abc123@98com.ac");
        checkEmailFieldValidationSuccessful();
        //Step 6
        inputToEmailField("abc-123@98com.ac");
        checkEmailFieldValidationSuccessful();
        //Step 7
        inputToEmailField("sad   sdfsd@sdf.com");
        checkEmailFieldValidationFailed();
        //Step 8
        inputToEmailField(RandomStringUtils.randomAlphabetic(200) + "@" + RandomStringUtils.randomAlphabetic(45));
        checkEmailFieldValidationSuccessful();
    }

    private void checkEmailFieldValidationSuccessful() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkEmailFieldValidationSuccessful();
    }

    private void checkEmailFieldValidationFailed() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkEmailFieldValidationFailed();
    }

    private CreateNewEmployeePage inputToEmailField(String text) {
        return pageProvider
                .getCreateNewEmployeePage()
                .inputToEmailField(text);
    }

    private void navigateToCreateNewEmployeePage() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .goToCreatePage();
    }
}
