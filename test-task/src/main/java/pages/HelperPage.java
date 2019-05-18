package pages;

import org.openqa.selenium.WebDriver;

import static driverManager.DriverHandler.getWebDriver;

public class HelperPage extends BasePage {

    LoginPage loginPage = new LoginPage(getWebDriver());
    EmployeesPage employeesPage = new EmployeesPage(getWebDriver());
    CreateNewEmployeePage createNewEmployeePage = new CreateNewEmployeePage(getWebDriver());

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
}
