package editEmployeeTests;

import model.EmployeeData;
import model.EmployeeDataBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CafeTownTestBase;
import pages.EmployeesPage;

public class EditEmployeeWitIncorrectFieldValues extends CafeTownTestBase {

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
     * - Full fill all required fields with new values except First Name field
     * - Click "Update" button
     * Expected result:
     * - User is on Edit Employee page
     * - Validation of First Name field is failed
     * <p>
     * Step 2:
     * - Full fill all required fields with new values except Last Name field
     * - Click "Update" button
     * Expected result:
     * - User is on Edit Employee page
     * - Validation of First Name field is failed
     * <p>
     * Step 3:
     * - Full fill all required fields  with new values except Start Date field
     * - Click "Update" button
     * Expected result:
     * - User is on Edit Employee page
     * - Validation of First Name field is failed
     * <p>
     * Step 4:
     * - Full fill all required fields with new values except Email field
     * - Click "Update" button
     * Expected result:
     * - User is on Edit Employee page
     * - Validation of First Name field is failed
     * <p>
     * Step 5:
     * - Full fill all required fields with new correct values except Start date
     * - Input "19090-09-65" to Start date field
     * - Click "Update" button
     * Expected result:
     * - User is on Edit Employee page
     * - Validation of First Name field is failed
     * <p>
     */

    private EmployeeData employeeData = new EmployeeDataBuilder().build();
    private EmployeeData employeeDataForEdit = new EmployeeDataBuilder().build();

    @Test
    private void test_ak_t010() {
        //Step 1
        fillRequiredFieldsExceptFirstName();
        clickUpdateButton();
        checkUserIsOnEditEmployeePage();
        //Step 2
        fillRequiredFieldsExceptLastName();
        clickUpdateButton();
        checkUserIsOnEditEmployeePage();
        //Step 3
        fillRequiredFieldsExceptStartDate();
        clickUpdateButton();
        checkUserIsOnEditEmployeePage();
        //Step 4
        fillRequiredFieldsExceptEmail();
        clickUpdateButton();
        checkUserIsOnEditEmployeePage();
    }

    @BeforeMethod
    private void createEmployee() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .createNewEmployee(employeeData);
        clickOnEmployeeByFirstAndLastName();
        clickEditButton();
        checkUserIsOnEditEmployeePage();
    }

    @AfterMethod
    private void deleteEmployee() {
        loginToCafeTownApp();
        pageProvider
                .getEmployeesPage()
                .checkUserIsOnEmployeesPage()
                .clickOnEmployeeByEmployeeData(employeeData)
                .clickDeleteButton()
                .confirmDeletion();
    }

    private void checkUserIsOnEditEmployeePage() {
        pageProvider
                .getEditEmployeePage()
                .checkUserIsOnEditEmployeePage();
    }

    private void clickUpdateButton() {
        pageProvider
                .getEditEmployeePage()
                .clickUpdateButton();
    }

    private void fillRequiredFieldsExceptFirstName() {
        pageProvider
                .getEditEmployeePage()
                .inputToFirstNameField("")
                .inputToLastNameField(employeeDataForEdit.getLastName())
                .inputToStartDateField(employeeDataForEdit.getStartDate())
                .inputToEmailField(employeeDataForEdit.getEmail());
    }

    private void fillRequiredFieldsExceptLastName() {
        pageProvider
                .getEditEmployeePage()
                .inputToFirstNameField(employeeDataForEdit.getFirstName())
                .inputToLastNameField("");
    }

    private void fillRequiredFieldsExceptStartDate() {
        pageProvider
                .getEditEmployeePage()
                .inputToLastNameField(employeeDataForEdit.getLastName())
                .inputToStartDateField("");
    }

    private void fillRequiredFieldsExceptEmail() {
        pageProvider
                .getEditEmployeePage()
                .inputToStartDateField(employeeDataForEdit.getStartDate())
                .inputToEmailField("");
    }

    private void clickEditButton() {
        pageProvider
                .getEmployeesPage()
                .clickEditButton();
    }

    private EmployeesPage clickOnEmployeeByFirstAndLastName() {
        return pageProvider
                .getEmployeesPage()
                .clickOnEmployeeByFirstAndLastName(employeeData.getFirstName(), employeeData.getLastName());
    }
}
