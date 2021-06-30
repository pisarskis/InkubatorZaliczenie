package English.primary;

import English.primary.APM.TestApmForm;
import helper.ReceiverFormData;
import helper.SenderFormData;
import helper.WaitPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
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
        formPage.clickTermsCheckboxEngish();
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
