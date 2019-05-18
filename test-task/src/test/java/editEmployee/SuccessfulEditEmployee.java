package editEmployee;

import model.EmployeeData;
import model.EmployeeDataBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CafeTownTestBase;

import static org.testng.Assert.assertEquals;

/**
 * User: Anton Kiselev
 * Date: 17.05.2019
 * <p>
 * Preconditions:
 * - User is logged in the test application (http://cafetownsend-angular-rails.herokuapp.com)
 * - User is on the Employees page
 * -  Double click on random employee in the Employees list
 * -  User is redirected to Edit Employee page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Edit all fields with correct values  and click "Update" button.
 * Expected result:
 * - User is redirected to Employees page
 * <p>
 * Step 2:
 * - Check employee is updated correctly on the Employees Page
 * Expected result:
 * - List of Employees contains updated employee with correct values of First and Last Names
 * <p>
 * Step 3:
 * - Click on updated employee and  go to Edit Employee page
 * - Check employee was updated correctly
 * Expected result:
 * - First name, Last name, Start date, email updated correctly and contains appropriate data
 * <p>
 */

public class SuccessfulEditEmployee extends CafeTownTestBase {

    private EmployeeData employeeData = new EmployeeDataBuilder().build();
    private EmployeeData employeeDataForEdit = new EmployeeDataBuilder().build();

    @Test
    private void test_ak_t011() {
        //Step 1
        fillRequiredFieldsExceptFirstName();
        clickUpdateButton();
        checkUserIsOnEmployeesPage();
        //Step 2
        checkUserIsUpdatedCorrectlyOnTheEmployeesPage();
        //Step 3
        checkUserIsUpdatedCorrectlyOnTheEditPage();
    }

    private void checkUserIsUpdatedCorrectlyOnTheEditPage() {
        pageProvider
                .getEmployeesPage()
                .doubleClickOnEmployee(employeeDataForEdit);
        assertEquals(pageProvider.getEditEmployeePage().getEmployeeDataFromEditDetailsPage(), employeeDataForEdit);
    }

    private void checkUserIsUpdatedCorrectlyOnTheEmployeesPage() {
        String editedEmployee = pageProvider
                .getEmployeesPage()
                .findEmployeeUserNameByEmployeeData(employeeDataForEdit);
        assertEquals(editedEmployee, employeeDataForEdit.getFirstName() + " " + employeeDataForEdit.getLastName());
    }

    private void checkUserIsOnEmployeesPage() {
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage();
    }

    private void fillRequiredFieldsExceptFirstName() {
        pageProvider
                .getEditEmployeePage()
                .inputToFirstNameField(employeeDataForEdit.getFirstName())
                .inputToLastNameField(employeeDataForEdit.getLastName())
                .inputToStartDateField(employeeDataForEdit.getStartDate())
                .inputToEmailField(employeeDataForEdit.getEmail());
    }

    private void clickUpdateButton() {
        pageProvider
                .getEditEmployeePage()
                .clickUpdateButton();
    }

    @AfterMethod
    private void deleteEmployee() {
        loginToCafeTownApp();
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage()
                .clickOnEmployeeByEmployeeData(employeeDataForEdit)
                .clickDeleteButton()
                .confirmDeletion();
    }

    @BeforeMethod
    private void createEmployee() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .createNewEmployee(employeeData);
        pageProvider
                .getEmployeesPage()
                .doubleClickOnEmployee(employeeData);
        checkUserIsOnEditEmployeePage();
    }

    private void checkUserIsOnEditEmployeePage() {
        pageProvider
                .getEditEmployeePage()
                .checkUserIsOnEditEmployeePage();
    }
}
