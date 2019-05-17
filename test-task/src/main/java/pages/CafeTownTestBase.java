package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static driverManager.DriverHandler.*;

public class CafeTownTestBase {

    protected static PageProvider pageProvider
            = new PageProvider();

    @BeforeMethod
    public void setUp() throws Exception {
        initializeDriver();
        pageProvider
                .initPages();
    }

    @AfterMethod
    public void tearDown() {
        stopWebDriver();
    }

    public void navigateTo(String url) {
        if (url == null || url.replaceAll("\\s+", "").isEmpty()) {
            throw new RuntimeException(String.format("unable to navigate to the following url: '%s'", url));
        }
        getWebDriver().get(url);
    }

    public void navigateToLoginPage() {
        navigateTo("http://cafetownsend-angular-rails.herokuapp.com/");
    }

    public void loginToCafeTownApp() {
        navigateToLoginPage();
        pageProvider.
                getHelperPage()
                .loginToCafeTown();
    }
}
