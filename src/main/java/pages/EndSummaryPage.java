package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndSummaryPage {

    @FindBy(css = "div.wrapper > div.text-wrapper > span")
    private WebElement paymentStatus;

    @FindBy(css = "div.parcel-summary-container > button.btn")
    private WebElement refreshButton;

    @FindBy(css = "li.border-line > div.row > div.first-column > div.name")
    private WebElement receiverName;

    @FindBy(css = "li.border-line > div.row > div.first-column > div:nth-of-type(2)")
    private WebElement receiverPhoneNo;

    @FindBy(css = "li.border-line > div.row > div.first-column > div:nth-of-type(3)")
    private WebElement receiverEmail;

    @FindBy(css = "div.deliveryType > div.mb-3 > div.name")
    private WebElement senderName;

    @FindBy(css = "div.deliveryType > div.mb-3 > div:nth-of-type(2)")
    private WebElement senderPhoneNo;

    @FindBy(css = "div.deliveryType > div.mb-3 > div:nth-of-type(3)")
    private WebElement senderEmail;

    @FindBy(css = "li.border-line > div.row > div.third-column > div > div.name")
    private WebElement apmNo;

    @FindBy(css = "li.border-line > div.row > div.third-column > div > div:nth-of-type(2)")
    private WebElement apmAdress;


    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    public EndSummaryPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public EndSummaryPage clickRefreshButton() throws InterruptedException {
        actionPage.clickElement(refreshButton);
        waitPage.waitLong();
        return this;
    }
    public WebElement getPaymentStatus() {
        return paymentStatus;
    }

    public WebElement getReceiverName() {
        return receiverName;
    }

    public WebElement getReceiverPhoneNo() {
        return receiverPhoneNo;
    }

    public WebElement getReceiverEmail() {
        return receiverEmail;
    }

    public WebElement getSenderName() {
        return senderName;
    }

    public WebElement getSenderPhoneNo() {
        return senderPhoneNo;
    }

    public WebElement getSenderEmail() {
        return senderEmail;
    }

    public WebElement getApmNo() {
        return apmNo;
    }

    public WebElement getApmAdress() {
        return apmAdress;
    }
}
