import helper.ActionPage;
import helper.WaitPage;
import org.junit.*;
import pages.*;

public class TestPayment extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        paymentPage = new PaymentPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
        String receiverName = "foo";
        String receiverEmail = "foo@foo.pl";
        String receiverPhoneNo = "555555555";
        String apmNo = "PAW04A";
        String senderName = "bar";
        String senderEmail = "bar@bar.pl";
        String senderPhoneNo = "666666666";

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
        waitPage.waitLong();
        waitPage.waitLong();
    }

    @Test
    public void shouldShowCorrectParcelAPriceInPayment() {
        // given
        String desiredParcelPrice = "12,99 PLN";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, paymentPage.getSenderParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectNameInSummary() {
        // given
        String desiredSenderName = "bar";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredSenderName, paymentPage.getSenderName().getText());
    }

    @Test
    public void shouldShowCorrectEMailInSummary() throws InterruptedException {
        // given
        String desiredParcelPrice = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertTrue(errorMessage, paymentPage.getSenderEmail().getText().contains(desiredParcelPrice));
        waitPage.waitLong();
        waitPage.waitLong();
        waitPage.waitLong();
        waitPage.waitLong();
        waitPage.waitLong();
    }
}
