package createNewEmpoyeeTests;

import model.EmployeeData;
import model.EmployeeDataBuilder;
import org.testng.annotations.Test;
import pages.CafeTownTestBase;

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
 * - Full fill all required fields with correct values
 * - Click "Cancel" button
 * Expected result:
 * - User is redirected to Employees Page
 * - User are not created (List of Employees doesn't contain user with appropriate data)
 * <p>
 */

public class CreateNewEmployeeDiscardChanges extends CafeTownTestBase {

    private EmployeeData employeeData = new EmployeeDataBuilder().build();

    @Test
    private void test_ak_t007() {
        navigateToCreateNewEmployeePage();
        //Step 1
        fillAllRequiredFields();
        clickCancelButton();
        checkUserIsOnEmployeesPage();
        checkEmployeeWasNotCreated();
    }

    private void checkEmployeeWasNotCreated() {
        pageProvider
                .getEmployeesPage()
                .checkEmployeeIsNotPresentedOnTheListByEmployeeData(employeeData);
    }

    private void checkUserIsOnEmployeesPage() {
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage();
    }

    private void clickCancelButton() {
        pageProvider
                .getCreateNewEmployeePage()
                .clickCancelButton();
    }

    private void fillAllRequiredFields() {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToFirstNameField(employeeData.getFirstName())
                .inputToLastNameField(employeeData.getLastName())
                .inputToStartDateField(employeeData.getStartDate())
                .inputToEmailField(employeeData.getEmail());
    }

    private void navigateToCreateNewEmployeePage() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .goToCreatePage();
    }
}
