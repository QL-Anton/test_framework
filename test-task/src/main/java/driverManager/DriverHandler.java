package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverHandler {

    private static WebDriver wd;
    private static WebDriverWait webDriverWait;

    public static void initializeDriver() {
        if (System.getProperty("browser", BrowserType.CHROME).equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            wd = new FirefoxDriver();
            webDriverWait = new WebDriverWait(wd, 3);
            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
            WebDriverManager.chromedriver().setup();
            wd = new ChromeDriver();
            webDriverWait = new WebDriverWait(wd, 3);
            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public static void stopWebDriver() {
        wd.quit();
    }

    public static WebDriver getWebDriver() {
        return wd;
    }

    public static WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
