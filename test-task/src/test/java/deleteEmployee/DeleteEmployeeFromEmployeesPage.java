package deleteEmployee;

import model.EmployeeData;
import model.EmployeeDataBuilder;
import org.testng.annotations.BeforeMethod;
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
 * Expected result:
 * - Pop up with text "Are you sure want to delete employeeFirstName employeeLastName"
 * <p>
 * Step 2:
 * - Click "Yes" button
 * Expected result:
 * - Employee is deleted (List of employees doesn't contain deleted employee)
 * <p>
 */

public class DeleteEmployeeFromEmployeesPage extends CafeTownTestBase {

    private EmployeeData employeeData = new EmployeeDataBuilder().build();

    @Test
    private void test_ak_t013() {
        //Step 1
        clickDeleteButtonAndCheckConfirmation();
        //Step 2
        confirmDeletion();
        checkEmployeeIsDeleted();

    }

    private void checkEmployeeIsDeleted() {
        loginToCafeTownApp();
        pageProvider
                .getEmployeesPage()
                .checkEmployeeIsNotPresentedOnTheListByEmployeeData(employeeData);
    }

    private void confirmDeletion() {
        pageProvider
                .getEmployeesPage()
                .confirmDeletion();
    }

    private void clickDeleteButtonAndCheckConfirmation() {
        pageProvider
                .getEmployeesPage()
                .clickOnEmployeeByEmployeeData(employeeData)
                .clickDeleteButton()
                .checkConfirmationTextIsCorrect(employeeData);
    }

    @BeforeMethod
    private void createEmployee() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .createNewEmployee(employeeData);
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage();
    }
}
