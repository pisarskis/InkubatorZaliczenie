import helper.ActionPage;
import helper.WaitPage;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

public class apmTest_summary extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;


    @BeforeClass
    public static void closeAllCookies() throws InterruptedException {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    public void clikAPMCheckbox() throws Exception {
        formPage.chooseDeliveryToAPM();
    }

    public void clikParcelSizeA() throws Exception {
        formPage.clickA();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    public void clikParcelSizeB() throws Exception {
        formPage.clickB();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    public void clikParcelSizeC() throws Exception {
        formPage.clickC();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    public void fillReceiverName() throws Exception {
        String name = "Szymon Pisarski";
        receiverForm.fillReceiverName(name);
    }

    public void fillReceiverEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        receiverForm.fillReceiverEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    public void fillReceiverNumber() throws Exception {
        String email = "666999666";
        receiverForm.fillReceiverNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    public void fillReceiverAPM() throws Exception {
//        String apmNo = "PJ11A";
        String apmNo = "PAW04A";
        receiverForm.fillReceiverAPMCode(apmNo);
    }

    public void fillSenderName() throws Exception {
        String name = "Szymon Pisarski";
        senderForm.fillSenderName(name);
    }

    public void fillSenderEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        senderForm.fillSenderEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    public void fillSenderNumber() throws Exception {
        String email = "666999666";
        senderForm.fillSenderNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    public void clickInvoiceCheckbox() throws Exception {
        senderForm.clickInvoice();
    }

    public void clickPlishCompanyCheckbox() throws Exception {
        senderForm.clickPlishCompanyCheckbox();
    }

    public void clickLegalStatusIndividualCheckbox() throws Exception {
        senderForm.clickLegalStatusIndividualCheckbox();
    }

    public void clickForeignCompanyCheckbox() throws Exception {
        senderForm.clickForeignCompanyCheckbox();
    }

    public void clickTermsCheckbox() throws Exception {
        formPage.clickTermsCheckbox();
    }

    public void clickNewsletterCheckbox() throws Exception {
        formPage.clickNewsletterCheckbox();
    }

    @Test
    public void clickSendButton() throws Exception {
        clikAPMCheckbox();
        clikParcelSizeA();
        fillReceiverName();
        fillReceiverEmail();
        fillReceiverNumber();
        fillReceiverAPM();
        fillSenderName();
        fillSenderEmail();
        fillSenderNumber();
        clickTermsCheckbox();
        clickNewsletterCheckbox();

        formPage.clickSendButton();
        formPage.clickPayButton();
        waitPage.waitLong();
    }
}
