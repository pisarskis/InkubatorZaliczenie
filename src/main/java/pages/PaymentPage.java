package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public PaymentPage clickBank() {
        waitPage.waitForCss("div[title='Płacę z Alior Banku");
        actionPage.clickElement(aliorBank);
        return this;
    }

    public PaymentPage clickNextButton() throws InterruptedException {
        actionPage.clickElement(finishButton);
        waitPage.waitLong();
        return this;
    }

    public PaymentPage clickAcceptPayment() throws InterruptedException {
        waitPage.waitForCss("button[value='1']");
        actionPage.clickElement(acceptPaymentButton);
        waitPage.waitLong();
        return this;
    }

    public PaymentPage clickDeclinePaymentButton() throws InterruptedException {
        waitPage.waitForCss("button[value='2']");
        actionPage.clickElement(declinePaymentButton);
        waitPage.waitLong();
        return this;
    }

    public PaymentPage clickSetPaymentAsPendingButton() throws InterruptedException {
        waitPage.waitForCss("button[value='3']");
        actionPage.clickElement(setPaymentAsPendingButton);
        waitPage.waitShort();
        return this;
    }

    public WebElement getSenderName() {
        waitPage.waitForCss("div[title='Płacę z Alior Banku");
        return buyerName;
    }

    public WebElement getSenderEmail() {
        waitPage.waitForCss("div[title='Płacę z Alior Banku");
        return buyerEmail;
    }

    public WebElement getSenderParcelPrice() {
        waitPage.waitForCss("div[title='Płacę z Alior Banku");
        return parcelPrice;
    }
}
