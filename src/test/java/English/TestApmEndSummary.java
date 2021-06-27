package English;

import helper.WaitPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

public class TestApmEndSummary extends Base {
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
        formPage.clickLanguageSelector();
        formPage.closeCookiesPopup();
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
        formPage.clickTermsCheckboxEngish();
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
        String expectedMessage = "Your payment was confirmed";

        // when
        formRunThrough();
        paymentPage.clickAcceptPayment();
        waitPage.waitShort();
        formPage.closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(expectedMessage, endSummaryPage.getPaymentStatus().getText());
    }

    @Test
    public void shouldMarkParcelPaymentAsPending() throws Exception {
        // given
        String expectedMessage = "Your transaction has not been concluded – this may take a few minutes. Refresh the page to check its status.";

        // when
        formRunThrough();
        paymentPage.clickSetPaymentAsPendingButton();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(expectedMessage, endSummaryPage.getPaymentStatus().getText());
    }

    @Test
    public void shouldMarkParcelPaymentAsRejected() throws Exception {
        // given
        String expectedMessage = "Oops, we have a problem. Your payment did not succeed. Try again.";

        // when
        formRunThrough();
        paymentPage.clickDeclinePaymentButton();
        waitPage.waitLong();
        formPage.closeCookiesPopup();

        // then
        Assert.assertEquals(expectedMessage, endSummaryPage.getPaymentStatus().getText());
    }
}
