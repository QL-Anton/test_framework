package Pages;

import DriverManager.DriverHandler;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PageProvider {

    private WebDriver webDriver = DriverHandler.getWebDriver();
   private LoginPage loginPage;

    public void init() {
        loginPage = new LoginPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    public void stop() {
        webDriver.quit();
    }

    public LoginPage loginPage() {
        return loginPage;
    }
}
