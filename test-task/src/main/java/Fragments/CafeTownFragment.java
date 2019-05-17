package Fragments;

import DriverManager.DriverHandler;
import Pages.LoginPage;

public class CafeTownFragment {

    LoginPage loginPage = new LoginPage(DriverHandler.getWebDriver());

    public void loginToApp() {
        loginPage
                .loginToCafeTown();
    }
}
