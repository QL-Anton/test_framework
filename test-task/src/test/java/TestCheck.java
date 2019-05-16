import org.testng.annotations.Test;

public class TestCheck extends TestBase {

    @Test
    private void test() {
        pageProvider.loginPage().loginToApp();
        System.out.println();
    }
}
