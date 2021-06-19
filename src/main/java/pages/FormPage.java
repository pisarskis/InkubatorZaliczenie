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

    @FindBy(css = "[for = in_changer")
    private WebElement invoiceCheckbox;

    @FindBy(css = "[for = legalStatusforeignCompany")
    private WebElement foreignCompanyCheckbox;


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
        actionPage.clickCheckBox(deliveryToAPM);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickA() throws InterruptedException {
        actionPage.clickCheckBox(parcelSizeA);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickB() throws InterruptedException {
        actionPage.clickCheckBox(parcelSizeB);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickC() throws InterruptedException {
        actionPage.clickCheckBox(parcelSizeC);
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

    public FormPage clickInvoice() throws InterruptedException {
        actionPage.clickCheckBox(invoiceCheckbox);
        waitPage.waitShort();
        return this;
    }

    public FormPage clickForeignCompanyCheckbox() throws InterruptedException {
        clickInvoice();
        actionPage.clickCheckBox(foreignCompanyCheckbox);
        waitPage.waitShort();
        return this;
    }
}

