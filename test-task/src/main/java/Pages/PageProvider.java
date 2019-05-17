package Pages;

import static DriverManager.DriverHandler.getWebDriver;

public class PageProvider {

    private LoginPage loginPage;
    private EmployeesPage employeesPage;
    private HelperPage helperPage;

    public void initPages() {
        loginPage = new LoginPage(getWebDriver());
        employeesPage = new EmployeesPage(getWebDriver());
        helperPage = new HelperPage(getWebDriver());
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
}
