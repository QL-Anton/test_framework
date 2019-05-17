package Pages;

import static DriverManager.DriverHandler.getWebDriver;

public class PageProvider {

    private LoginPage loginPage;

    public void initPages() {
        loginPage = new LoginPage(getWebDriver());
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
