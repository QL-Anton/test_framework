package editEmployeeTests;

import org.testng.annotations.Test;
import pages.CafeTownTestBase;

/**
 * User: Anton Kiselev
 * Date: 17.05.2019
 * <p>
 * Preconditions:
 * - User is logged in the test application (http://cafetownsend-angular-rails.herokuapp.com)
 * - User is on the Edit Employee page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Click "Back" button
 * Expected result:
 * - User is redirected to Employees page
 * <p>
 */

public class EditEmployeeBackButton extends CafeTownTestBase {

    @Test
    private void test_ak_t012() {
        loginToCafeTownApp();
        navigateToEditPage();
        //Step 1
        clickBackButton();
        checkUserIsOnEmployeesPage();
    }

    private void checkUserIsOnEmployeesPage() {
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage();
    }

    private void clickBackButton() {
        pageProvider
                .getEditEmployeePage()
                .clickBackButton();
    }

    private void navigateToEditPage() {
        pageProvider
                .getEmployeesPage()
                .clickFirstEmployee()
                .clickEditButton();
        pageProvider
                .getEditEmployeePage()
                .checkUserIsOnEditEmployeePage();
    }

}
