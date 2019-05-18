package createNewEmpoyeeTests;

import org.testng.annotations.Test;
import pages.CafeTownTestBase;
import pages.CreateNewEmployeePage;

/**
 * User: Anton Kiselev
 * Date: 18.05.2019
 * <p>
 * Preconditions:
 * - User is logged in the test application (http://cafetownsend-angular-rails.herokuapp.com)
 * - User is on the Employyes page
 * - User clicks "Create" button and redirected to Create New Employee Page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Input data with incorrect format "YYYY_MM_DD"
 * - Check validation
 * - Validation is failed
 * <p>
 * Step 2:
 * - Input data with incorrect format "YYYY MM DD"
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 * Step 3:
 * - Input data with incorrect format "MM YYYY DD"
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 * Step 4:
 * - Input data with value 1899-12-31
 * - Check validation
 * Expected result:
 * - Validation is failed
 * <p>
 * Step 5:
 * - Input data with value 1900-01-01
 * - Check validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 6:
 * - Input data with value 2040-01-01
 * - Check validation
 * Expected result:
 * - Validation is successful
 * <p>
 * Step 7:
 * - Input data with value abc1923-12-11def
 * - Check validation
 * Expected result:
 * - Validation is failed
 */

public class CreateNewEmployeeStartDateFieldValidation extends CafeTownTestBase {

    @Test
    private void test_ak_t005() {
        navigateToCreateNewEmployeePage();
        //Step 1
        inputToStartDateField("2015_11_11");
        checkStarDateFieldValidationFailed();
        //Step 2
        inputToStartDateField("2013 11 11");
        checkStarDateFieldValidationFailed();
        //Step 3
        inputToStartDateField("11 2011 10");
        checkStarDateFieldValidationFailed();
        //Step 4
        inputToStartDateField("1899-12-31");
        checkStarDateFieldValidationFailed();
        //Step 5
        inputToStartDateField("1900-01-01");
        checkStarDateFieldValidationSuccessful();
        //Step 6
        inputToStartDateField("2040-01-01");
        checkStarDateFieldValidationSuccessful();
        //Step 7
        inputToStartDateField(" abc1923-12-11def");
        checkStarDateFieldValidationFailed();
    }

    private void checkStarDateFieldValidationSuccessful() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkStarDateFieldValidationSuccessful();
    }

    private void checkStarDateFieldValidationFailed() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkStarDateFieldValidationFailed();
    }

    private CreateNewEmployeePage inputToStartDateField(String text) {
        return pageProvider
                .getCreateNewEmployeePage()
                .inputToStartDateField(text);
    }

    private void navigateToCreateNewEmployeePage() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .goToCreatePage();
    }
}
