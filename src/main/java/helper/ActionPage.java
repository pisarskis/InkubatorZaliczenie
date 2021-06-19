package helper;

import pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionPage {

    private Actions actions = new Actions(Base.driver);

    public void moveToElement (WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public void clickCheckBox (WebElement webElement)  {
        moveToElement(webElement);
        webElement.click();
    }

}
