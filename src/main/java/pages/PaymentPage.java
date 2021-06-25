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

    @FindBy(css = "div[title='Płacę z Alior Banku']")
    private WebElement aliorBank;

    @FindBy(css = "div.button-container > button.finish-button")
    private WebElement finishButton;

    @FindBy(css = "p.seller-name-surname")
    private WebElement buyerName;

    @FindBy(css = "p.seller-orderdescription")
    private WebElement buyerEmail;

    @FindBy(css = "p.seller-amount")
    private WebElement parcelPrice;

    @FindBy(css = "button[value='1']")
    private WebElement acceptPaymentButton;

    @FindBy(css = "button[value='2']")
    private WebElement declinePaymentButton;

    @FindBy(css = "button[value='3']")
    private WebElement setPaymentAsPendingButton;

    public PaymentPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public PaymentPage clickBank() throws InterruptedException {
        actionPage.clickElement(aliorBank);
        waitPage.waitShort();
        return this;
    }

    public PaymentPage clickNextButton() throws InterruptedException {
        actionPage.clickElement(finishButton);
        waitPage.waitShort();
        return this;
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

    public WebElement getSenderName() {
        return buyerName;
    }

    public WebElement getSenderEmail() {
        return buyerEmail;
    }

    public WebElement getSenderParcelPrice() {
        return parcelPrice;
    }

}
