package helper;

import pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitPage {

    WebDriverWait webDriverWait = new WebDriverWait(Base.driver, 10);

    public void waitUntilElement (WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
