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


    public FormPage clickA() throws InterruptedException {
        actionPage.moveToElement(parcelSizeA);
        parcelSizeA.click();
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public FormPage clickB() throws InterruptedException {
        actionPage.moveToElement(parcelSizeA);
        parcelSizeB.click();
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public FormPage clickC() throws InterruptedException {
        actionPage.moveToElement(parcelSizeA);
        parcelSizeC.click();
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public FormPage closeCookiesPopup() throws InterruptedException {
        cookiesButton.click();
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public FormPage closeBottomCookiesPopup() throws InterruptedException {
        cookiesBottomButton.click();
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public FormPage clickHowToSendButton() throws InterruptedException {
        howToSendParcel.click();
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public String getLabelReady() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return labelReady.getText();
    }

    public boolean isDisplayedPopup(){
        return modal.isDisplayed();
    }

    public void insertText (String text) {
        parcelSizeC.sendKeys(text);
    }

    public FormPage clickInvoice() throws InterruptedException {
        actionPage.clickCheckBox(invoiceCheckbox);
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public FormPage clickForeignCompanyCheckbox() throws InterruptedException {
        clickInvoice();
        actionPage.clickCheckBox(foreignCompanyCheckbox);
        TimeUnit.SECONDS.sleep(3);
        return this;
    }
}

