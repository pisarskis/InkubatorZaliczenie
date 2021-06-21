import helper.ActionPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

public class apmTest extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;


    @BeforeClass
    public static void closeAllCookies() throws InterruptedException {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Test
    public void clikAPMCheckbox() throws Exception {
        formPage.chooseDeliveryToAPM();
    }

    @Test
    public void clikParcelSizeA() throws Exception {
        formPage.clickA();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void clikParcelSizeB() throws Exception {
        formPage.clickB();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void clikParcelSizeC() throws Exception {
        formPage.clickC();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void fillReceiverName() throws Exception {
        String name = "Szymon Pisarski";
        receiverForm.fillReceiverName(name);
    }

    @Test
    public void fillReceiverEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        receiverForm.fillReceiverEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    @Test
    public void fillReceiverNumber() throws Exception {
        String email = "666999666";
        receiverForm.fillReceiverNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    @Test
    public void fillReceiverAPM() throws Exception {
        String apmNo = "PJ11A";
        receiverForm.fillReceiverAPMCode(apmNo);
    }

    @Test
    public void fillSenderName() throws Exception {
        String name = "Szymon Pisarski";
        senderForm.fillSenderName(name);
    }

    @Test
    public void fillSenderEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        senderForm.fillSenderEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    @Test
    public void fillSenderNumber() throws Exception {
        String email = "666999666";
        senderForm.fillSenderNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    @Test
    public void clickInvoiceCheckbox() throws Exception {
        senderForm.clickInvoice();
    }

    @Test
    public void clickPlishCompanyCheckbox() throws Exception {
        senderForm.clickPlishCompanyCheckbox();
    }

    @Test
    public void clickLegalStatusIndividualCheckbox() throws Exception {
        senderForm.clickLegalStatusIndividualCheckbox();
    }

    @Test
    public void clickForeignCompanyCheckbox() throws Exception {
        senderForm.clickForeignCompanyCheckbox();
    }

    @Test
    public void clickTermsCheckbox() throws Exception {
        formPage.clickTermsCheckbox();
    }

    @Test
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
    }
}
