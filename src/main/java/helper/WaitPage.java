package helper;

import pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitPage {

    WebDriverWait webDriverWait = new WebDriverWait(Base.driver, 10);

    public void waitUntilElement (WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitShort() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    public void waitLong() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }
}
