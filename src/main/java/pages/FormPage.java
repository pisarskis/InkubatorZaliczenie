package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FormPage {
// cookies
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookiesButton;

    @FindBy(className = "btn-cookie-trigger")
    private WebElement cookiesBottomButton;

// type of parcel
    @FindBy(css = "[for = deliveryTypeboxmachine")
    private WebElement deliveryToAPM;

    @FindBy(css = "[for = deliveryTypeaddress")
    private WebElement deliveryToAddress;

// size of parcel
    @FindBy(css = "[for = parcelSizeA]>span")
    private WebElement parcelSizeA;

    @FindBy(css = "[for = parcelSizeB]>span")
    private WebElement parcelSizeB;

    @FindBy(css = "[for = parcelSizeC]>span")
    private WebElement parcelSizeC;

    @FindBy(linkText = "Jak nadać paczkę?")
    private WebElement howToSendParcel;

    @FindBy(css = ".modal-bdy > span")
    private WebElement labelReady;

    @FindBy(css = ".modal-body")
    private WebElement modal;

    @FindBy(css = "[for = terms")
    private WebElement termsCheckbox;

    @FindBy(css = "[for = newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//*[@id=\"parcelFormButton\"]/button")
    private WebElement sendButton;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[3]/div[2]/button")
    private WebElement payButton;


    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    public FormPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public FormPage closeCookiesPopup() throws InterruptedException {
        cookiesButton.click();
        waitPage.waitShort();
        return this;
    }

    public FormPage closeBottomCookiesPopup() throws InterruptedException {
        cookiesBottomButton.click();
        waitPage.waitShort();
        return this;
    }

    public FormPage chooseDeliveryToAPM() throws InterruptedException {
        actionPage.clickElement(deliveryToAPM);
        waitPage.waitShort();
        return this;
    }

    public FormPage chooseDeliveryC2D() throws InterruptedException {
        actionPage.clickElement(deliveryToAddress);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickA() throws InterruptedException {
        actionPage.clickElement(parcelSizeA);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickB() throws InterruptedException {
        actionPage.clickElement(parcelSizeB);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickC() throws InterruptedException {
        actionPage.clickElement(parcelSizeC);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickHowToSendButton() throws InterruptedException {
        howToSendParcel.click();
        waitPage.waitShort();
        return this;
    }

    public String getLabelReady() throws InterruptedException {
        waitPage.waitShort();
        return labelReady.getText();
    }

    public boolean isDisplayedPopup(){
        return modal.isDisplayed();
    }

    public FormPage clickTermsCheckbox() throws InterruptedException {
        actionPage.clickElement(termsCheckbox);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickNewsletterCheckbox() throws InterruptedException {
        actionPage.clickElement(newsletterCheckbox);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickSendButton() throws InterruptedException {
        actionPage.clickElement(sendButton);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickPayButton() throws InterruptedException {
        actionPage.clickElement(payButton);
        waitPage.waitShort();
        return this;
    }

}

