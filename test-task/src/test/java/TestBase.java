import Pages.PageProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static DriverManager.DriverHandler.initWebDriver;
import static DriverManager.DriverHandler.stopWebDriver;

public class TestBase {

    protected static PageProvider pageProvider = new PageProvider();

    @BeforeMethod
    public void setUp() throws Exception {
        initWebDriver();
        pageProvider
                .initPages();
    }

    @AfterMethod
    public void tearDown() {
        stopWebDriver();
    }

}
