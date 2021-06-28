package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SenderForm {
    @FindBy(name = "senderAddress.name")
    private WebElement senderName;

    @FindBy(name = "senderAddress.email")
    private WebElement senderEmail;

    @FindBy(name = "senderAddress.phoneNum")
    private WebElement senderPhoneNo;

    @FindBy(css = "[for = in_changer")
    private WebElement invoiceCheckbox;

    @FindBy(css = "[for = legalStatuscompany")
    private WebElement polishCompanyCheckbox;

    @FindBy(css = "[for = legalStatusindividual")
    private WebElement legalStatusIndividualCheckbox;

    @FindBy(css = "[for = legalStatusforeignCompany")
    private WebElement foreignCompanyCheckbox;

    @FindBy(css = "ul.errors > li")
    private WebElement badEmailError;

    @FindBy(css = "[for = legalStatuscompany] > span > span")
    private WebElement polishCompanyCheckboxText;

    @FindBy(name = "invoice.company.nip")
    private WebElement invoicePolishCompanyNip;

    @FindBy(css = "div.third-column > div.mb-3 > div.name")
    private WebElement invoiceNameFormSummary;

    @FindBy(name = "invoice.individual.companyName")
    private WebElement invoiceIndividualName;

    @FindBy(name = "invoice.individual.email")
    private WebElement invoiceIndividualEmail;

    @FindBy(name = "invoice.individual.zipCode")
    private WebElement invoiceIndividualZIPCode;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[22]/div/app-input/div/div/div/app-selectpicker/ng-select/div/div/div[2]/input")
    private WebElement invoiceIndividualTown;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[23]/div/app-input/div/div/div/app-selectpicker/ng-select/div/div/div[2]/input")
    private WebElement invoiceIndividualStreet;

    @FindBy(name = "invoice.individual.buildingNo")
    private WebElement invoiceIndividualBuildingNo;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[19]/div/app-input/div/div/div/app-complex-select/ng-select/div/div/div[2]/input")
    private WebElement invoiceCountryPrefix;

    @FindBy(name = "invoice.foreignCompany.nip")
    private WebElement invoiceCountryTaxNo;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[20]/div/app-input/div/div/app-error/small/ul/li")
    private WebElement invoiceCountryTaxNoError;


    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    public SenderForm() {
        PageFactory.initElements(Base.driver, this);
    }

    public SenderForm clickInvoiceIndividualName(String name) throws InterruptedException {
        actionPage.writeToForm(invoiceIndividualName ,name);
        return this;
    }

    public SenderForm clickInvoiceIndividualEmail(String email) throws InterruptedException {
        actionPage.writeToForm(invoiceIndividualEmail ,email);
        return this;
    }

    public SenderForm clickInvoiceIndividualZIPCode(String zip) throws InterruptedException {
        actionPage.writeToForm(invoiceIndividualZIPCode ,zip);
        waitPage.waitShort();
        actionPage.clickElement(invoiceIndividualZIPCode);
        return this;
    }

    public SenderForm clickInvoiceIndividualTown(String town) throws InterruptedException {
        actionPage.writeToForm(invoiceIndividualTown ,town);
        waitPage.waitShort();
        invoiceIndividualTown.sendKeys(Keys.ENTER);
        waitPage.waitShort();
        return this;
    }

    public SenderForm clickInvoiceIndividualStreet(String street) throws InterruptedException {
        actionPage.writeToForm(invoiceIndividualStreet ,street);
        waitPage.waitShort();
        invoiceIndividualStreet.sendKeys(Keys.ENTER);
        waitPage.waitShort();
        return this;
    }

    public SenderForm clickInvoiceIndividualBuildingNo(String apmNo) throws InterruptedException {
        actionPage.writeToForm(invoiceIndividualBuildingNo ,apmNo);
        waitPage.waitShort();
        return this;
    }

    public SenderForm fillSenderName(String name) throws InterruptedException {
        actionPage.writeToForm(senderName ,name);
        return this;
    }

    public SenderForm fillSenderEmail(String email) throws InterruptedException {
        actionPage.writeToForm(senderEmail ,email);
        return this;
    }

    public SenderForm fillSenderNumber(String mumber) throws InterruptedException {
        actionPage.writeToForm(senderPhoneNo ,mumber);
        return this;
    }

    public SenderForm clickInvoice() throws InterruptedException {
        actionPage.clickElement(invoiceCheckbox);
        waitPage.waitShort();
        return this;
    }

    public SenderForm clickPlishCompanyCheckbox() throws InterruptedException {
        actionPage.clickElement(polishCompanyCheckbox);
        waitPage.waitShort();
        return this;
    }

    public SenderForm clickLegalStatusIndividualCheckbox() throws InterruptedException {
        actionPage.clickElement(legalStatusIndividualCheckbox);
        waitPage.waitShort();
        return this;
    }

    public SenderForm clickForeignCompanyCheckbox() throws InterruptedException {
        actionPage.clickElement(foreignCompanyCheckbox);
        waitPage.waitShort();
        return this;
    }

    public WebElement emailErrorMessage() {
        return badEmailError;
    }

    public WebElement checkInInvoiceWasClicked() {
        return polishCompanyCheckboxText;
    }

    public SenderForm clickPolishCompanyNIP(String nipNo) throws InterruptedException {
        actionPage.writeToForm(invoicePolishCompanyNip, nipNo);
        waitPage.waitLong();
        return this;
    }

    public WebElement getInvoiceNameFormSummary() {
        return invoiceNameFormSummary;
    }

    public SenderForm clickInvoiceCountryPrefix(String street) throws InterruptedException {
        actionPage.writeToForm(invoiceCountryPrefix ,street);
        waitPage.waitShort();
        invoiceCountryPrefix.sendKeys(Keys.ENTER);
        waitPage.waitShort();
        return this;
    }

    public SenderForm fillInvoiceCountryTaxNo(String taxNo) throws InterruptedException {
        actionPage.writeToForm(invoiceCountryTaxNo ,taxNo);
        return this;
    }

    public WebElement invoiceCountryTaxNoError() {
        return invoiceCountryTaxNoError;
    }
}
