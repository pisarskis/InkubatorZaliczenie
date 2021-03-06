package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EndSummaryPage {
    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();
//    WebDriverWait wait = new WebDriverWait(Base.driver, 60);

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

    public EndSummaryPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public EndSummaryPage clickRefreshButton() throws InterruptedException {
        waitPage.waitForCss("div.parcel-summary-container > button.btn");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.parcel-summary-container > button.btn")));
        actionPage.clickElement(refreshButton);
        waitPage.waitLong();
        return this;
    }

    public WebElement getPaymentStatus() {
        waitPage.waitForCss("div.wrapper > div.text-wrapper > span");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wrapper > div.text-wrapper > span")));
        return paymentStatus;
    }

    public WebElement getReceiverName() {
        waitPage.waitForCss("li.border-line > div.row > div.first-column > div.name");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.border-line > div.row > div.first-column > div.name")));
        return receiverName;
    }

    public WebElement getReceiverPhoneNo() {
        waitPage.waitForCss("li.border-line > div.row > div.first-column > div:nth-of-type(2)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.border-line > div.row > div.first-column > div:nth-of-type(2)")));
        return receiverPhoneNo;
    }

    public WebElement getReceiverEmail() {
        waitPage.waitForCss("li.border-line > div.row > div.first-column > div:nth-of-type(3)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.border-line > div.row > div.first-column > div:nth-of-type(3)")));
        return receiverEmail;
    }

    public WebElement getSenderName() {
        waitPage.waitForCss("div.deliveryType > div.mb-3 > div.name");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.deliveryType > div.mb-3 > div.name")));
        return senderName;
    }

    public WebElement getSenderPhoneNo() {
        waitPage.waitForCss("div.deliveryType > div.mb-3 > div:nth-of-type(2)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.deliveryType > div.mb-3 > div:nth-of-type(2)")));
        return senderPhoneNo;
    }

    public WebElement getSenderEmail() {
        waitPage.waitForCss("div.deliveryType > div.mb-3 > div:nth-of-type(3)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.deliveryType > div.mb-3 > div:nth-of-type(3)")));
        return senderEmail;
    }

    public WebElement getApmNo() {
        waitPage.waitForCss("li.border-line > div.row > div.third-column > div > div.name");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.border-line > div.row > div.third-column > div > div.name")));
        return apmNo;
    }

    public WebElement getApmAdress() {
        waitPage.waitForCss("li.border-line > div.row > div.third-column > div > div:nth-of-type(2)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.border-line > div.row > div.third-column > div > div:nth-of-type(2)")));
        return apmAdress;
    }

    public WebElement getInvoiceName() {
        waitPage.waitForCss("div.third-column > div.mb-3 > div.name");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.third-column > div.mb-3 > div.name")));
        return invoiceName;
    }

    public WebElement getInvoiceNIP() {
        waitPage.waitForCss("div.third-column > div.mb-3 > div:nth-of-type(2)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.third-column > div.mb-3 > div:nth-of-type(2)")));
        return invoiceNIP;
    }

    public WebElement getInvoiceTown() {
        waitPage.waitForCss("div.third-column > div.mb-3 > div:nth-of-type(3)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.third-column > div.mb-3 > div:nth-of-type(3)")));
        return invoiceTown;
    }

    public WebElement getInvoiceStreet() {
        waitPage.waitForCss("div.third-column > div.mb-3 > div:nth-of-type(4)");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.third-column > div.mb-3 > div:nth-of-type(4)")));
        return invoiceStreet;
    }
}
