package deleteEmployeeTests;

import org.testng.annotations.Test;
import pages.CafeTownTestBase;

/**
 * User: Anton Kiselev
 * Date: 18.05.2019
 * <p>
 * Preconditions:
 * - User is logged in the test application (http://cafetownsend-angular-rails.herokuapp.com)
 * - User is on Employees page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Select employee
 * - Click "Delete" button
 * - Click "No" button
 * Expected result:
 * - User still on the Employees page
 * <p>
 */

public class DeleteEmployeeNotConfirm extends CafeTownTestBase {

    @Test
    private void test_ak_t013() {
        loginToCafeTownApp();
        //Step 1
        pageProvider
                .getEmployeesPage()
                .clickFirstEmployee()
                .clickDeleteButton()
                .dismissDeletion()
                .checkUserIsOnEmployeesPage();
    }
}
