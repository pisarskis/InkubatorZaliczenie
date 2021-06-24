package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    @FindBy(xpath = "//*[@id=\"paymenttypeMain\"]/div[7]")
    private WebElement clickAliorBank;

    @FindBy(xpath = "//*[@id=\"blikPaymentForm\"]/div[7]/button[1]")
    private WebElement clickNextButton;

    @FindBy(xpath = "/html/body/div[5]/section[1]/p[1]")
    private WebElement senderName;

    @FindBy(xpath = "/html/body/div[5]/section[1]/p[2]")
    private WebElement senderEmail;

    @FindBy(xpath = "/html/body/div[5]/section[1]/p[3]")
    private WebElement senderParcelPrice;

    @FindBy(xpath = "//*[@id=\"nifty\"]/p/button[1]")
    private WebElement acceptPaymentButton;

    @FindBy(xpath = "//*[@id=\"nifty\"]/p/button[2]")
    private WebElement declinePaymentButton;

    @FindBy(xpath = "//*[@id=\"nifty\"]/p/button[3]")
    private WebElement setPaymentAsPendingButton;

    public PaymentPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public PaymentPage clickBank() throws InterruptedException {
        actionPage.clickElement(clickAliorBank);
        waitPage.waitShort();
        return this;
    }

    public PaymentPage clickNextButton() throws InterruptedException {
        actionPage.clickElement(clickNextButton);
        waitPage.waitLong();
        waitPage.waitLong();
        return this;
    }

    public WebElement getSenderName() {
        return senderName;
    }

    public WebElement getSenderEmail() {
        return senderEmail;
    }

    public WebElement getSenderParcelPrice() {
        return senderParcelPrice;
    }

    public PaymentPage clickAcceptPayment() throws InterruptedException {
        actionPage.clickElement(acceptPaymentButton);
        waitPage.waitShort();
        return this;
    }

    public PaymentPage clickDeclinePaymentButton() throws InterruptedException {
        actionPage.clickElement(declinePaymentButton);
        waitPage.waitShort();
        return this;
    }

    public PaymentPage clickSetPaymentAsPendingButton() throws InterruptedException {
        actionPage.clickElement(setPaymentAsPendingButton);
        waitPage.waitShort();
        return this;
    }

}
