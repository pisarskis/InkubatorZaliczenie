import helper.ActionPage;
import helper.WaitPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

public class TestFormSummary extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static TestApm apmTest;
    private static SummaryPage summaryPage;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        apmTest = new TestApm();
        summaryPage = new SummaryPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Before
    public void apmSummarySetUp() throws InterruptedException {
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
        String receiverName = "qweqwe";
        String receiverEmail = "qwe@qwe.pl";
        String receiverPhoneNo = "666999666";
        String apmNo = "PAW04A";
        String senderName = "qweqwqwe";
        String senderEmail = "qweqwe@qwe.pl";
        String senderPhoneNo = "666777666";

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
    }

    @Test
    public void shouldShowCorrectReceiverNameInSummary() throws Exception {
        // given
        String receiverName = "qweqwe";
        String errorMessage = "";
        // when


        // then
        Assert.assertEquals(errorMessage, receiverName, summaryPage.getReceiverName().getText());
    }

    @Test
    public void shouldShowCorrectReceiverPhoneNoInSummary() throws Exception {
        // given
        String receiverName = "666 999 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, receiverName, summaryPage.getReceiverPhoneNo().getText());
    }

    @Test
    public void shouldShowCorrectReceiverEmailInSummary() throws Exception {
        // given
        String receiverName = "qwe@qwe.pl";
        String errorMessage = "";

        // when


        // then
        Assert.assertEquals(errorMessage, receiverName, summaryPage.getReceiverEmail().getText());
    }

    @Test
    public void shouldShowCorrectSenderNameInSummary() throws Exception {
        // given
        String senderName = "qweqweqwe";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, senderName, summaryPage.getSenderName().getText());
    }

    @Test
    public void shouldShowCorrectSenderPhoneNoInSummary() throws Exception {
        // given
        String senderName = "666 777 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, senderName, summaryPage.getSenderPhoneNo().getText());
    }

    @Test
    public void shouldShowCorrectSenderEmailInSummary() throws Exception {
        // given
        String senderName = "qweqwe@qwe.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, senderName, summaryPage.getSenderEmail().getText());
    }

    @Test
    public void shouldShowCorrectApmIconInSummary() throws Exception {
        // given
        String errorMessage = "";

        // when

        // then
    }

}
