package createNewEmpoyee;

import model.EmployeeData;
import model.EmployeeDataBuilder;
import org.testng.annotations.AfterMethod;
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
 * - User clicks "Create" button and redirected to Create New Employee Page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Input random alphabetical symboll to "First name" field, eg.
 * "Efrfsss"
 * -  Input random alphabetical symboll to "Last name" field, eg.
 * "Cccdddeee"
 * - Input correct date (YYYY-MM-DD format) to Start Date, eg.
 * 2015-10-11
 * -  Input random email with correct format , eg.
 * "abcemail@efg.klm"
 * - Check "Add" button
 * Expected result:
 * - "Add" button is enabled
 * <p>
 * Step 2:
 * Click "Add" button
 * Expected result:
 * - User is redirected to Employees page
 * <p>
 * Step 3:
 * Check created Employee is appeared in list of Employees
 * Expected result:
 * List with Employees on the Employees Page contains created Employee with appropriate data
 * <p>
 * Step 4:
 * - Click on created Employee and go to Edit Employee page
 * - Check User details
 * Expected result:
 * - Employee created with appropriate data
 * <p>
 */

public class CreateNewEmployee extends CafeTownTestBase {

    private EmployeeData newEmployeeData = new EmployeeDataBuilder().build();

    @Test
    private void test_ak_t004() {
        navigateToLoginPage();
        loginToCafeTown();
        clickCreateButton();
        checkUserIsOnCreateNewEmployeePage();
        //Step 1
        fillRequiredFields();
        checkAddButtonIsEnabled();
        //Step 2
        clickAddButton();
        checkUserIsOnEmployeesPage();
        //Step 3
        checkCreatedEmployeePresentInEmployeesList();
        //Step 4
        navigateToEditEmployeePage();
        checkUserIsOnEditEmployeePage();
        checkEmployeeCreatedCorrectly();
    }

    private void navigateToEditEmployeePage() {
        pageProvider
                .getEmployeesPage()
                .clickOnEmployeeByEmployeeData(newEmployeeData)
                .clickEditButton();
    }

    private void checkUserIsOnEditEmployeePage() {
        pageProvider
                .getEditEmployeePage()
                .checkUserIsOnEditEmployeePage();
    }

    private void checkEmployeeCreatedCorrectly() {
        assertEquals(pageProvider
                .getEditEmployeePage()
                .getEmployeeDataFromEditDetailsPage(), newEmployeeData);
    }

    @AfterMethod
    private void deleteCreatedEmployee() {
        pageProvider
                .getEditEmployeePage()
                .clickDeleteButton()
                .confirmDeletion();
    }

    private void checkUserIsOnEmployeesPage() {
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage();
    }

    private void clickAddButton() {
        pageProvider
                .getCreateNewEmployeePage()
                .clickAddButton();
    }

    private void checkAddButtonIsEnabled() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkAddButtonIsEnabled();
    }

    private void fillRequiredFields() {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToFirstNameField(newEmployeeData.getFirstName())
                .inputToLastNameField(newEmployeeData.getLastName())
                .inputToStartDateField(newEmployeeData.getStartDate())
                .inputToEmailField(newEmployeeData.getEmail());
    }

    private void checkCreatedEmployeePresentInEmployeesList() {
        String foundedUserName = pageProvider.getEmployeesPage().findEmployeeUserNameByEmployeeData(newEmployeeData);
        assertEquals(foundedUserName, newEmployeeData.getFirstName() + " " + newEmployeeData.getLastName());
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
