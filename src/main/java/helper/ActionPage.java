package helper;

import pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionPage {

    private Actions actions = new Actions(Base.driver);

    public void moveToElement (WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public void clickElement (WebElement webElement)  {
        moveToElement(webElement);
        webElement.click();
    }

    public void writeToForm (WebElement webElement, String formText)  {
        moveToElement(webElement);
        webElement.click();
        webElement.sendKeys(formText);
    }
}
