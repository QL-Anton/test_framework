package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BasePage {

    protected WebDriver wd;

    public BasePage(WebDriver wd) {
        this.wd = wd;
    }

    protected void input(WebElement element, String text) {
        element.click();
        if (text != null) {
            String existingText = element.getAttribute("value");
            if (!text.equals(existingText)) {
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void checkValidationFieldIsFailed(WebElement element) {
        assertTrue(element.getAttribute("className").contains("ng-invalid"));
    }

    public void checkValidationFieldIsSuccessful(WebElement element) {
        assertFalse(element.getAttribute("className").contains("ng-invalid"));
    }
}
