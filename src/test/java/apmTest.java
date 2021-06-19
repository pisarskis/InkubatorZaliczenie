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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    public void clikAPMCheckbox() throws Exception {
        formPage.chooseDeliveryToAPM();
    }

    @Test
    @Order(2)
    public void clikParcelSizeA() throws Exception {
        formPage.clickA();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    @Order(3)
    public void clikParcelSizeB() throws Exception {
        formPage.clickB();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    @Order(4)
    public void clikParcelSizeC() throws Exception {
        formPage.clickC();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    @Order(5)
    public void fillReceiverName() throws Exception {
        String name = "Szymon Pisarski";
        receiverForm.fillReceiverName(name);
    }

    @Test
    @Order(6)
    public void fillReceiverEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        receiverForm.fillReceiverEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    @Test
    @Order(7)
    public void fillReceiverNumber() throws Exception {
        String email = "666999666";
        receiverForm.fillReceiverNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    @Test
    @Order(8)
    public void fillReceiverAPM() throws Exception {
        String apmNo = "PJ11A";
        receiverForm.fillReceiverAPMCode(apmNo);
    }

    @Test
    @Order(9)
    public void fillSenderName() throws Exception {
        String name = "Szymon Pisarski";
        senderForm.fillSenderName(name);
    }

    @Test
    @Order(10)
    public void fillSenderEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        senderForm.fillSenderEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    @Test
    @Order(11)
    public void fillSenderNumber() throws Exception {
        String email = "666999666";
        senderForm.fillSenderNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    @Test
    @Order(18)
    public void clickSendButton() throws Exception {
        formPage.clickSendButton();
    }

    @Test
    @Order(12)
    public void clickInvoiceCheckbox() throws Exception {
        senderForm.clickInvoice();
    }

    @Test
    @Order(13)
    public void clickPlishCompanyCheckbox() throws Exception {
        senderForm.clickPlishCompanyCheckbox();
    }

    @Test
    @Order(14)
    public void clickLegalStatusIndividualCheckbox() throws Exception {
        senderForm.clickLegalStatusIndividualCheckbox();
    }

    @Test
    @Order(15)
    public void clickForeignCompanyCheckbox() throws Exception {
        senderForm.clickForeignCompanyCheckbox();
    }

    @Test
    @Order(16)
    public void clickTermsCheckbox() throws Exception {
        formPage.clickTermsCheckbox();
    }

    @Test
    @Order(17)
    public void clickNewsletterCheckbox() throws Exception {
        formPage.clickNewsletterCheckbox();
    }


}
