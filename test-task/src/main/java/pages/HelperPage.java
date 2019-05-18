package pages;

import model.EmployeeData;
import org.openqa.selenium.WebDriver;

import static driverManager.DriverHandler.getWebDriver;

/*Class for common methods  */
public class HelperPage extends BasePage {

    private LoginPage loginPage = new LoginPage(getWebDriver());
    private EmployeesPage employeesPage = new EmployeesPage(getWebDriver());
    private CreateNewEmployeePage createNewEmployeePage = new CreateNewEmployeePage(getWebDriver());

    public HelperPage(WebDriver wd) {
        super(wd);
    }

    public void loginToCafeTown() {
        loginPage
                .inputToUserNameField("Luke")
                .inputToPasswordField("Skywalker")
                .clickLoginButton()
                .checkUserIsOnLoginPage();
    }

    public void goToCreatePage() {
        loginToCafeTown();
        employeesPage
                .clickCreateButton();
        createNewEmployeePage
                .checkUserIsOnCreateNewEmployeePage();
    }

    public void createNewEmployee(EmployeeData employeeData) {
        goToCreatePage();
        createNewEmployeePage
                .inputToFirstNameField(employeeData.getFirstName())
                .inputToLastNameField(employeeData.getLastName())
                .inputToStartDateField(employeeData.getStartDate())
                .inputToEmailField(employeeData.getEmail())
                .clickAddButton();
        employeesPage
                .checkUserIsOnEmployeesPage();
    }
}

