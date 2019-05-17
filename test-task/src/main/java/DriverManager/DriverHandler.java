package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverHandler {

    private static WebDriver wd;

    public static void initWebDriver() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void stopWebDriver() {
        wd.quit();
    }

    public static WebDriver getWebDriver() {
        return wd;
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getWebDriver(), 5);
    }
}
