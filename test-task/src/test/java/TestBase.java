import Pages.PageProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static PageProvider pageProvider = new PageProvider();

    @BeforeMethod
    public void setUp() throws Exception {
        pageProvider.init();
    }

    @AfterMethod
    public void tearDown() {
        pageProvider.stop();
    }

    protected PageProvider getPageProvider() {
        return new PageProvider();
    }
}
