import helper.FormDataFactory;
import helper.WaitPage;
import org.junit.*;
import pages.*;

public class TestEndSummary extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static TestApmForm testApmForm;
    private static SummaryPage summaryPage;
    private static EndSummaryPage endSummaryPage;
    private static FormDataFactory formDataFactory;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        paymentPage = new PaymentPage();
        testApmForm = new TestApmForm();
        summaryPage = new SummaryPage();
        endSummaryPage = new EndSummaryPage();
        formDataFactory = new FormDataFactory();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        waitPage.waitLong();
        waitPage.waitLong();
    }

    public void apmSummarySetUp() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        formRunThrough();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    private static void formRunThrough() throws InterruptedException {
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        receiverForm.fillReceiverName(formDataFactory.getReceiverName());
        receiverForm.fillReceiverEmail(formDataFactory.getReceiverEmail());
        receiverForm.fillReceiverNumber(formDataFactory.getReceiverEmail());
        receiverForm.fillReceiverAPMCode(formDataFactory.getParcelBoxNo());
        senderForm.fillSenderName(formDataFactory.getSenderName());
        senderForm.fillSenderEmail(formDataFactory.getSenderEmail());
        senderForm.fillSenderNumber(formDataFactory.getSenderPhoneNo());
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
        formPage.clickPayButton();
        paymentPage.clickBank();
        paymentPage.clickNextButton();
    }

    public void checkRefreshButton(String expectedMessage) throws InterruptedException {
        int count = 0;
        waitPage.waitLong();

        while (!endSummaryPage.getPaymentStatus().getText().equals(expectedMessage)) {
            endSummaryPage.clickRefreshButton();
            count ++;

            if (count >= 5){
                expectedMessage = endSummaryPage.getPaymentStatus().getText();
            }
        }
    }

    @Test
    public void shouldMarkParcelAsPaidFor() throws Exception {
        // given
        String expectedMessage = "Twoja płatność została potwierdzona";
        String errorMessage = "";

        // when
        formRunThrough();
        paymentPage.clickAcceptPayment();
        waitPage.waitShort();
        formPage.closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(errorMessage, expectedMessage, endSummaryPage.getPaymentStatus().getText());
    }

    @Test
    public void shouldMarkParcelPaymentAsPending() throws Exception {
        // given
        String expectedMessage = "Twoja transakcja nie została jeszcze zakończona.\n" +
                                  "To może potrwać kilka minut. Odśwież stronę,\n" +
                                  "aby sprawdzić jej status.";
        String errorMessage = "";

        // when
        formRunThrough();
        paymentPage.clickSetPaymentAsPendingButton();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(errorMessage, expectedMessage, endSummaryPage.getPaymentStatus().getText());
    }

    @Test
    public void shouldMarkParcelPaymentAsRejected() throws Exception {
        // given
        String expectedMessage = "Ups, mamy problem.\n" +
                                 "Niestety nie udało się opłacić paczki.\n" +
                                 "Spróbuj jeszcze raz.";
        String errorMessage = "";

        // when
        formRunThrough();
        paymentPage.clickDeclinePaymentButton();
        waitPage.waitLong();
        formPage.closeCookiesPopup();

        // then
        Assert.assertEquals(errorMessage, expectedMessage, endSummaryPage.getPaymentStatus().getText());
    }
}
