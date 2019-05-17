package Pages;

import static DriverManager.DriverHandler.getWebDriver;

public class PageProvider {

    private LoginPage loginPage;
    private EmployeesPage employeesPage;

    public void initPages() {
        loginPage = new LoginPage(getWebDriver());
        employeesPage = new EmployeesPage(getWebDriver());
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public EmployeesPage getEmployeesPage() {
        return employeesPage;
    }
}
