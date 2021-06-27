package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(css = "[for = parcelSizeA]>span")
    private WebElement parcelSizeA;

    @FindBy(css = "[for = parcelSizeB]>span")
    private WebElement parcelSizeB;

    @FindBy(css = "[for = parcelSizeC]>span")
    private WebElement parcelSizeC;

    @FindBy(css = ".modal-bdy > span")
    private WebElement labelReady;

    @FindBy(css = ".modal-body")
    private WebElement modal;

    @FindBy(css = "app-section.col-12 > div.form-section > app-input.section-input > div > span.label > span.custom-action-in-title")
    private WebElement howToSendParcel;

    @FindBy(css = "app-section.mt-3 > div.form-section > app-input.section-input > div > span.label > span.custom-action-in-title")
    private WebElement howToPackParcel;

    @FindBy(css ="div.step-modal > div.modal-content > div.modal-header > h4")
    private WebElement modalTitle;

    @FindBy(css ="div.step-modal > div.modal-content > div.modal-body > div")
    private WebElement modalBody;

    @FindBy(css = "[for = terms")
    private WebElement termsCheckbox;

    @FindBy(css = "[for = newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(css = "ul.errors > li")
    private WebElement newsletterError;

    @FindBy(xpath = "//*[@id=\"parcelFormButton\"]/button")
    private WebElement sendButton;

    @FindBy(css = "div.buttons > div:nth-of-type(2) > button")
    private WebElement payButton;

    @FindBy(css = "label[for='terms'] > span.checkbox-label > span")
    private WebElement termsText;

    @FindBy(css = "label[for='newsletter'] > span.checkbox-label > span")
    private WebElement newsletterText;

//    Do zweryfikowania, dlaczego nie chce mi wyprintować zawartości tego diva.
//    @FindBy(css = "div.ml-20 > h4")
//    private WebElement parcelSizeText;
//
//    @FindBy(css = "div.ml-20 > img")
//    private WebElement parcelSizeImg;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[1]/ul/li[2]/div/div[1]/div/div/div")
    private WebElement parcelSizeText;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[1]/ul/li[2]/div/div[2]/div/div[2]/img")
    private WebElement parcelSizeImg;

//    @FindBy(css = "li.pb-15 > div.to-pay < div:nth-of-type(2)")
//    private WebElement parcelPrice;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[2]/div/span[2]")
    private WebElement parcelPrice;

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
        return this;
    }

    public FormPage chooseDeliveryC2D() throws InterruptedException {
        actionPage.clickElement(deliveryToAddress);
        return this;
    }

    public FormPage clickA() {
        actionPage.clickElement(parcelSizeA);
        return this;
    }

    public FormPage clickB() {
        actionPage.clickElement(parcelSizeB);
        return this;
    }

    public FormPage clickC() {
        actionPage.clickElement(parcelSizeC);
        return this;
    }

    public FormPage clickHowToSendParcel() throws InterruptedException {
        howToSendParcel.click();
        waitPage.waitShort();
        return this;
    }

    public FormPage clickHowToPackParcel() throws InterruptedException {
        howToPackParcel.click();
        waitPage.waitShort();
        return this;
    }

    public FormPage clickTermsCheckbox() throws InterruptedException {
        actionPage.clickElement(termsCheckbox);
        return this;
    }

    public FormPage clickNewsletterCheckbox() throws InterruptedException {
        actionPage.clickElement(newsletterCheckbox);
        return this;
    }

    public FormPage clickSendButton() throws InterruptedException {
        actionPage.clickElement(sendButton);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickPayButton() throws InterruptedException {
        actionPage.clickElement(payButton);
        return this;
    }

    public WebElement getParcelSizeText() {
        return parcelSizeText;
    }

    public WebElement getParcelSizeImg() {
        return parcelSizeImg;
    }

    public WebElement getParcelPrice() {
        return parcelPrice;
    }

    public WebElement getNewsletterError() {
        return newsletterError;
    }

    public WebElement getModalTitle() {
        return modalTitle;
    }

    public WebElement getModalBody() {
        return modalBody;
    }

    public WebElement getTermsText() { return termsText; }

    public WebElement getNewsletterBody() {
        return newsletterText;
    }
}

