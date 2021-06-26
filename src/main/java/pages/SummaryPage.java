package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[3]/div[2]/button")
    private WebElement payButton;

    @FindBy(css = "div.d-flex > h4")
    private WebElement parcelSize;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[1]/div/div[2]/div/div[2]/img")
    private WebElement parcelImg;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[5]/div/div[2]")
    private WebElement parcelPrice;

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


    private WebDriver driver;

    public SummaryPage () {
        PageFactory.initElements(Base.driver, this);
    }

    public WebElement getParcelSize() {
        return parcelSize;
    }

    public WebElement getParcelImg() { return parcelImg; }

    public WebElement getParcelPrice() { return parcelPrice; }

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

    public WebElement getInvoiceName() {
        return invoiceName;
    }

    public WebElement getInvoiceNIP() {
        return invoiceNIP;
    }

    public WebElement getInvoiceTown() {
        return invoiceTown;
    }

    public WebElement getInvoiceStreet() {
        return invoiceStreet;
    }
}
