package primary;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;
import primary.APM.TestApmForm;

@Tag("pl")
public class TestEndSummary extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static TestApmForm testApmForm;
    private static SummaryPage summaryPage;
    private static EndSummaryPage endSummaryPage;

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

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        fillAPMFormData();
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
        formPage.clickPayButton();
        paymentPage.clickBank();
        paymentPage.clickNextButton();
    }

    public void fillAPMFormData() throws InterruptedException {
        receiverForm.fillReceiverName(ReceiverFormData.NAME.getValue());
        receiverForm.fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        receiverForm.fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        receiverForm.fillReceiverAPMCode(ReceiverFormData.APNNO.getValue());
        senderForm.fillSenderName(SenderFormData.NAME.getValue());
        senderForm.fillSenderEmail(SenderFormData.EMAIL.getValue());
        senderForm.fillSenderNumber(SenderFormData.PHONENO.getValue());
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
    @Tag("pl")
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
    @Tag("pl")
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
    @Tag("pl")
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
