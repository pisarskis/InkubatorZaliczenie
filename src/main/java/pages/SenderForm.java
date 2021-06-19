package pages;

import helper.ActionPage;
import helper.WaitPage;
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

    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    public SenderForm() {
        PageFactory.initElements(Base.driver, this);
    }

    public SenderForm fillSenderName(String name) throws InterruptedException {
        actionPage.writeToForm(senderName ,name);
        waitPage.waitShort();
        return this;
    }

    public SenderForm fillSenderEmail(String email) throws InterruptedException {
        actionPage.writeToForm(senderEmail ,email);
        waitPage.waitShort();
        return this;
    }

    public SenderForm fillSenderNumber(String mumber) throws InterruptedException {
        actionPage.writeToForm(senderPhoneNo ,mumber);
        waitPage.waitShort();
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
}
