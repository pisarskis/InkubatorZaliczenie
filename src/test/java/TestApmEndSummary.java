import helper.ActionPage;
import helper.WaitPage;
import org.junit.*;
import pages.*;

public class TestApmEndSummary extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static TestApm testApm;
    private static SummaryPage summaryPage;
    private static EndSummaryPage endSummaryPage;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        paymentPage = new PaymentPage();
        testApm = new TestApm();
        summaryPage = new SummaryPage();
        endSummaryPage = new EndSummaryPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        waitPage.waitLong();
        waitPage.waitLong();
    }

    public void apmSummarySetUp() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        formRunThrough();
    }

    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
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
        formPage.clickPayButton();
        waitPage.waitLong();
        paymentPage.clickBank();
        paymentPage.clickNextButton();
    }

    @Test
    public void shouldMarkParcelAsPaidFor() throws Exception {
        // given
        String desiredPaymentStatus = "Twoja płatność została potwierdzona";
        String errorMessage = "";

        // when
        formRunThrough();
        paymentPage.clickAcceptPayment();
        formPage.closeCookiesPopup();
        waitPage.waitLong();
        endSummaryPage.clickRefreshButton();

        // then
        Assert.assertEquals(errorMessage, desiredPaymentStatus, endSummaryPage.getPaymentStatus().getText());
    }
}
