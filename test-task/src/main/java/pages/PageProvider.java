package pages;

import static driverManager.DriverHandler.getWebDriver;

public class PageProvider {

    private LoginPage loginPage;
    private EmployeesPage employeesPage;
    private HelperPage helperPage;
    private CreateNewEmployeePage createNewEmployeePage;

    public void initPages() {
        loginPage = new LoginPage(getWebDriver());
        employeesPage = new EmployeesPage(getWebDriver());
        helperPage = new HelperPage(getWebDriver());
        createNewEmployeePage = new CreateNewEmployeePage(getWebDriver());
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public EmployeesPage getEmployeesPage() {
        return employeesPage;
    }

    public HelperPage getHelperPage() {
        return helperPage;
    }

    public CreateNewEmployeePage getCreateNewEmployeePage() {
        return createNewEmployeePage;
    }
}
