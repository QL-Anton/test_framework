import org.testng.annotations.Test;

public class TestCheck extends TestBase {

    @Test
    private void test() {
        pageProvider
                .getLoginPage()
                .loginToCafeTown();
        System.out.println();
    }
}
