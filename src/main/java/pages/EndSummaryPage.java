package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

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

    @FindBy(css = "div.third-column > div.mb-3 > div.name")
    private WebElement invoiceName;

    @FindBy(css = "div.third-column > div.mb-3 > div:nth-of-type(2)")
    private WebElement invoiceNIP;

    @FindBy(css = "div.third-column > div.mb-3 > div:nth-of-type(3)")
    private WebElement invoiceTown;

    @FindBy(css = "div.third-column > div.mb-3 > div:nth-of-type(4)")
    private WebElement invoiceStreet;


    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    public EndSummaryPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public EndSummaryPage clickRefreshButton() throws InterruptedException {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actionPage.clickElement(refreshButton);
        waitPage.waitLong();
        return this;
    }
    public WebElement getPaymentStatus() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return paymentStatus;
    }

    public WebElement getReceiverName() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return receiverName;
    }

    public WebElement getReceiverPhoneNo() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return receiverPhoneNo;
    }

    public WebElement getReceiverEmail() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return receiverEmail;
    }

    public WebElement getSenderName() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return senderName;
    }

    public WebElement getSenderPhoneNo() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return senderPhoneNo;
    }

    public WebElement getSenderEmail() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return senderEmail;
    }

    public WebElement getApmNo() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return apmNo;
    }

    public WebElement getApmAdress() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return apmAdress;
    }

    public WebElement getInvoiceName() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return invoiceName;
    }

    public WebElement getInvoiceNIP() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return invoiceNIP;
    }

    public WebElement getInvoiceTown() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return invoiceTown;
    }

    public WebElement getInvoiceStreet() {
        Base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return invoiceStreet;
    }
}
