package helper;

import org.openqa.selenium.By;
import pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitPage {

    WebDriverWait webDriverWait = new WebDriverWait(Base.driver, 10);

    public void waitShort() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public void waitLong() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }
}
