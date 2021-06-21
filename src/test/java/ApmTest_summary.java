import helper.ActionPage;
import helper.WaitPage;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

public class ApmTest_summary extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static ApmTest apmTest;



    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        paymentPage = new PaymentPage();

        apmTest = new ApmTest();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();

        runThroughForms();
    }

    private static void runThroughForms() throws Exception {
        String receiverName = "Szymon Pisarski";
        String receiverEmail = "spiarski@inpost.pl";
        String receiverPhoneNo = "666999666";
        String apmNo = "PAW04A";
        String senderName = "Szymon Pisarski";
        String senderEmail = "spiarski@inpost.pl";
        String senderPhoneNo = "666999666";

        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        receiverForm.fillReceiverName(receiverName);
        receiverForm.fillReceiverEmail(receiverEmail);
        receiverForm.fillReceiverNumber(receiverPhoneNo);
        receiverForm.fillReceiverAPMCode(apmNo);

        senderForm.fillSenderName(senderName);
        senderForm.fillSenderEmail(senderEmail);
        senderForm.fillSenderNumber(senderPhoneNo);
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
        formPage.clickPayButton();
    }

    @Test
    public void chooseBank() throws Exception {
        String bankName = "alior";
        paymentPage.setBankName(bankName);
        paymentPage.chooseBank();
    }


    // todo ustalić co w sytuacji gdzie najpierw chcę przetestować kliawisz a dopiero później przeklikać się do stanępnego ekranu

    @Test
    public void clickFinishButton() throws Exception {
        paymentPage.chooseBank();
        paymentPage.clickFinishButton();
    }


}
