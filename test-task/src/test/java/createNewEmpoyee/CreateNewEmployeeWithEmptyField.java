package createNewEmpoyee;

import model.EmployeeData;
import model.EmployeeDataBuilder;
import org.testng.annotations.Test;
import pages.CafeTownTestBase;

/**
 * User: Anton Kiselev
 * Date: 17.05.2019
 * <p>
 * Preconditions:
 * - User is logged in the test application (http://cafetownsend-angular-rails.herokuapp.com)
 * - User is on the Employees page
 * <p>
 * Description:
 * <p>
 * Step 1:
 * - Full fill all required fields with correct values except First Name field
 * - Click "Add" button
 * Expected result:
 * - User on the Create New Employee page
 * - "First name" field validation is failed
 * <p>
 * Step 2:
 * - Fullfill all required fields with correct values except Last Name field
 * - Click "Add" button
 * Expected result:
 * - User on the Create New Employee page
 * - "Last name" field validation is failed
 * <p>
 * Step 3:
 * - Fullfill all required fields with correct values except Start date field
 * - Click "Add" button
 * Expected result:
 * - User on the Create New Employee page
 * - "Start date" field validation is failed
 * <p>
 * Step 4:
 * - Fullfill all required fields with correct values except Email field
 * - Click "Add" button
 * Expected result:
 * - User on the Create New Employee page
 * - "Email" field validation is failed
 * <p>
 */

public class CreateNewEmployeeWithEmptyField extends CafeTownTestBase {

    private EmployeeData newEmployeeData = new EmployeeDataBuilder().build();

    @Test
    private void test_ak_t009() {
        navigateToCreateNewEmployeePage();
        //Step 1
        fillRequiredFieldsExceptFirstName();
        clickAddButton();
        checkUserIsOnCreateNewEmployeePage();
        //Step 2
        fillRequiredFieldsExceptLastName();
        clickAddButton();
        checkUserIsOnCreateNewEmployeePage();
        //Step 3
        fillRequiredFieldsExceptStartDate();
        clickAddButton();
        checkUserIsOnCreateNewEmployeePage();
        //Step 4
        fillRequiredFieldsExceptEmail();
        clickAddButton();
        checkUserIsOnCreateNewEmployeePage();

    }

    private void checkUserIsOnCreateNewEmployeePage() {
        pageProvider
                .getCreateNewEmployeePage()
                .checkUserIsOnCreateNewEmployeePage();
    }

    private void clickAddButton() {
        pageProvider
                .getCreateNewEmployeePage()
                .clickAddButton();
    }

    private void navigateToCreateNewEmployeePage() {
        navigateToLoginPage();
        pageProvider
                .getHelperPage()
                .goToCreatePage();
    }

    private void fillRequiredFieldsExceptFirstName() {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToFirstNameField("")
                .inputToLastNameField(newEmployeeData.getLastName())
                .inputToStartDateField(newEmployeeData.getStartDate())
                .inputToEmailField(newEmployeeData.getEmail());
    }

    private void fillRequiredFieldsExceptLastName() {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToFirstNameField(newEmployeeData.getFirstName())
                .inputToLastNameField("");
    }

    private void fillRequiredFieldsExceptStartDate() {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToLastNameField(newEmployeeData.getLastName())
                .inputToStartDateField("");
    }

    private void fillRequiredFieldsExceptEmail() {
        pageProvider
                .getCreateNewEmployeePage()
                .inputToStartDateField(newEmployeeData.getStartDate())
                .inputToEmailField("");
    }
}
