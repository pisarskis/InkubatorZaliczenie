package pages;

import helper.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {
    private WebDriver driver;
    private WaitPage waitPage = new WaitPage();

    @FindBy(css = "div.d-block > button.btn-Polish.primary")
    private WebElement payButton;

    @FindBy(css = "div.ml-20 > h4")
    private WebElement parcelSize;

    @FindBy(css = "div.ml-20 > img")
    private WebElement parcelImg;

    @FindBy(css = "li.pb-15 > div.price > div:nth-of-type(2)")
    private WebElement parcelPrice;

    @FindBy(css = "li.border-line > div.row > div.first-column > div.name")
    private WebElement receiverName;

    @FindBy(css = "li.border-line > div.row > div.first-column > div:nth-of-type(2)")
    private WebElement receiverPhoneNo;

    @FindBy(css = "li.border-line > div.row > div.first-column > div:nth-of-type(3)")
    private WebElement receiverEmail;

    @FindBy(css = "li.border-line > div.row > div.first-column > div:nth-of-type(4)")
    private WebElement senderTown;

    @FindBy(css = "li.border-line > div.row > div.first-column > div:nth-of-type(5)")
    private WebElement senderStreet;

    @FindBy(css = "li.border-line > div.row > div.first-column > div:nth-of-type(6)")
    private WebElement senderCountry;

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

    public SummaryPage () {
        PageFactory.initElements(Base.driver, this);
    }

    public WebElement getParcelSize() {
        waitPage.waitForCss("div.ml-20 > h4");
        return parcelSize;
    }

    public WebElement getParcelImg() {
        waitPage.waitForCss("div.ml-20 > h4");
        return parcelImg;
    }

    public WebElement getParcelPrice() {
        waitPage.waitForCss("div.ml-20 > h4");
        return parcelPrice;
    }

    public WebElement getReceiverName() {
        waitPage.waitForCss("div.ml-20 > h4");
        return receiverName;
    }

    public WebElement getReceiverPhoneNo() {
        waitPage.waitForCss("div.ml-20 > h4");
        return receiverPhoneNo;
    }

    public WebElement getReceiverEmail() {
        waitPage.waitForCss("div.ml-20 > h4");
        return receiverEmail;
    }

    public WebElement getSenderName() {
        waitPage.waitForCss("div.ml-20 > h4");
        return senderName;
    }

    public WebElement getSenderPhoneNo() {
        waitPage.waitForCss("div.ml-20 > h4");
        return senderPhoneNo;
    }

    public WebElement getSenderEmail() {
        waitPage.waitForCss("div.ml-20 > h4");
        return senderEmail;
    }

    public WebElement getSenderTown() {
        waitPage.waitForCss("div.ml-20 > h4");
        return senderTown;
    }

    public WebElement getSenderStreet() {
        waitPage.waitForCss("div.ml-20 > h4");
        return senderStreet;
    }

    public WebElement getSenderCountry() {
        waitPage.waitForCss("div.ml-20 > h4");
        return senderCountry;
    }

    public WebElement getApmNo() {
        waitPage.waitForCss("div.ml-20 > h4");
        return apmNo;
    }

    public WebElement getApmAdress() {
        waitPage.waitForCss("div.ml-20 > h4");
        return apmAdress;
    }

    public WebElement getInvoiceName() {
        waitPage.waitForCss("div.ml-20 > h4");
        return invoiceName;
    }

    public WebElement getInvoiceNIP() {
        waitPage.waitForCss("div.ml-20 > h4");
        return invoiceNIP;
    }

    public WebElement getInvoiceTown() {
        waitPage.waitForCss("div.ml-20 > h4");
        return invoiceTown;
    }

    public WebElement getInvoiceStreet() {
        waitPage.waitForCss("div.ml-20 > h4");
        return invoiceStreet;
    }
}
