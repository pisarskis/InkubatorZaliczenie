package helper;

import org.openqa.selenium.By;
import pages.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitPage {

    WebDriverWait webDriverWait = new WebDriverWait(Base.driver, 60);

    public void waitForCss(String value){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(value)));
    }

    public void waitForXPath(String value){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
    }

    public void waitForID(String value){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
    }

    public void waitShort() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public void waitLong() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }
}
