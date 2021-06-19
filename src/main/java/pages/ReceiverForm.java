package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ReceiverForm {
    @FindBy(name = "targetAddress.name")
    private WebElement reveiverName;

    @FindBy(name = "addresseeEmail")
    private WebElement reveiverEmail;

    @FindBy(name = "phoneNumber")
    private WebElement reveiverPhoneNo;

    @FindBy(name = "targetAddress.zipCode")
    private WebElement reveiverZipCode;

    @FindBy(css = ".ng-input > input")
    private WebElement receiverAPMNo;

    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    public ReceiverForm() {
        PageFactory.initElements(Base.driver, this);
    }

    public ReceiverForm fillReceiverName(String name) throws InterruptedException {
        actionPage.writeToForm(reveiverName ,name);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm fillReceiverEmail(String email) throws InterruptedException {
        actionPage.writeToForm(reveiverEmail ,email);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm fillReceiverNumber(String mumber) throws InterruptedException {
        actionPage.writeToForm(reveiverPhoneNo ,mumber);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm fillReceiverAPMCode(String apmNo) throws InterruptedException {
        actionPage.writeToForm(receiverAPMNo ,apmNo);
        waitPage.waitShort();
        receiverAPMNo.sendKeys(Keys.ENTER);
        return this;
    }
}
