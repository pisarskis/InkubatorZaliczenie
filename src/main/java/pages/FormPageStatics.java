package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPageStatics {
    @FindBy(css = "app-section.col-12 > div.title-section > app-input.section-input > div > span.label > span.custom-action-in-title")
    private WebElement howToSendParcel;

//    @FindBy(xpath = "//h4[contains(.,'Jak spakować paczkę?')]")
//    private WebElement packInstructions;

    @FindBy(css = "app-section.mt-3 > div.form-section > app-input.section-input > div > span.label > span.custom-action-in-title")
    private WebElement howToPackParcel;

    @FindBy(css ="div.step-modal > div.modal-content > div.modal-header > h4")
    private WebElement modalTitle;

    @FindBy(css ="div.step-modal > div.modal-content > div.modal-body > div")
    private WebElement modalBody;

    @FindBy(css = "label[for='terms'] > span.checkbox-label > span")
    private WebElement termsText;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[15]/div/app-input[2]/div/div/div/app-input-checkbox/div/label/span/span")
    private WebElement termsTextEnglish;

    @FindBy(css = "label[for='newsletter'] > span.checkbox-label > span")
    private WebElement newsletterText;

    @FindBy(css = "div.home-header-step > div:nth-of-type(2) > p ")
    private WebElement homeHeaderStepFistText;

    @FindBy(css = "div.home-header-step > div:nth-of-type(3) > p ")
    private WebElement homeHeaderStepSecondText;

    @FindBy(css = "div.home-header-step > div:nth-of-type(4) > p ")
    private WebElement homeHeaderStepThirdText;

    @FindBy(css = "div.home-header-step > div:nth-of-type(5) > p ")
    private WebElement homeHeaderStepFourthText;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[1]/div/app-input[1]/div/div/h3")
    private WebElement typeOfDeliveryHeader;

    @FindBy(css = "span.radioParcelLabel > span")
    private WebElement typeOfDeliveryHeaderSubtitle;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[1]/div/div/h3")
    private WebElement sizeOfParcelHeader;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/span/span[1]")
    private WebElement sizeOfParcelHeaderSubtitle;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[1]/div/div/h3")
    private WebElement receiverHeader;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[3]/div/app-input/div/div/span")
    private WebElement receiverHeaderSubtitle;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[8]/div/app-input/div/div/h3")
    private WebElement senderHeader;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[8]/div/app-input/div/div/span")
    private WebElement senderHeaderSubtitle;

    @FindBy(css = "div.sticky-element > app-parcel-form-summary > div.summaryForm > div.padding-top > h3.title")
    private WebElement summaryHeader;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[1]/ul/li[1]/div/div/div/div[1]/h4")
    private WebElement summaryTypeOfDelivery;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[1]/ul/li[4]/div/div/span")
    private WebElement summaryInsuranceHeader;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[1]/ul/li[4]/div/div/div")
    private WebElement summaryInsuranceHeaderSubtitle;

    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();
    WebDriverWait wait = new WebDriverWait(Base.driver, 60);

    public FormPageStatics() {
        PageFactory.initElements(Base.driver, this);
    }

    public FormPageStatics clickHowToSendParcel() throws InterruptedException {
        howToSendParcel.click();
        waitPage.waitShort();
        return this;
    }

    public FormPageStatics clickHowToPackParcel() throws InterruptedException {
        howToPackParcel.click();
        waitPage.waitShort();
        return this;
    }

    public WebElement getModalTitle() {
        return modalTitle;
    }

    public WebElement getModalBody() {
        return modalBody;
    }

    public WebElement getTermsText() { return termsText; }

    public WebElement getTermsTextEnglish() { return termsTextEnglish; }

    public WebElement getNewsletterBody() {
        return newsletterText;
    }

    public WebElement getHomeHeaderStepFistText() {
        return homeHeaderStepFistText;
    }

    public WebElement getHomeHeaderStepSecondText() {
        return homeHeaderStepSecondText;
    }

    public WebElement getHomeHeaderStepThirdText() {
        return homeHeaderStepThirdText;
    }

    public WebElement getHomeHeaderStepFourthText() { return homeHeaderStepFourthText; }

    public WebElement getTypeOfDeliveryHeader() { return typeOfDeliveryHeader; }

    public WebElement getTypeOfDeliveryHeaderSubtitle() { return typeOfDeliveryHeaderSubtitle; }

    public WebElement getSizeOfParcelHeader() { return sizeOfParcelHeader; }

    public WebElement getSizeOfParcelHeaderSubtitle() { return sizeOfParcelHeaderSubtitle; }

    public WebElement getReceiverHeader() { return receiverHeader; }

    public WebElement getReceiverHeaderSubtitle() { return receiverHeaderSubtitle; }

    public WebElement getSenderHeader() { return senderHeader; }

    public WebElement getSenderHeaderSubtitle() { return senderHeaderSubtitle; }

    public WebElement getSummaryHeader() { return summaryHeader; }

    public WebElement getSummaryTypeOfDelivery() { return summaryTypeOfDelivery; }

    public WebElement getSummaryInsuranceHeader() { return summaryInsuranceHeader; }

    public WebElement getSummaryInsuranceHeaderSubtitle() { return summaryInsuranceHeaderSubtitle; }

}

