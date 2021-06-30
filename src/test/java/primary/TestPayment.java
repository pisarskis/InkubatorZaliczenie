package primary;

import helper.*;
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
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {

        fillAPMFormData();
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
        formPage.clickPayButton();
        waitPage.waitLong();
        waitPage.waitLong();
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

    @Test
    public void shouldShowAPMParcelAPriceInPayment() throws InterruptedException {
        // given
        String desiredParcelPrice = "12,99 PLN";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, paymentPage.getSenderParcelPrice().getText());
    }

    @Test
    public void shouldShowAPMParcelBPriceInPayment() throws InterruptedException {
        // given
        String desiredParcelPrice = "13,99 PLN";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickB();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, paymentPage.getSenderParcelPrice().getText());
    }

    @Test
    public void shouldShowAPMParcelCPriceInPayment() throws InterruptedException {
        // given
        String desiredParcelPrice = "15,49 PLN";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickC();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, paymentPage.getSenderParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectNameInSummary() throws InterruptedException {
        // given
        String desiredSenderName = "bar";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, desiredSenderName, paymentPage.getSenderName().getText());
    }

    @Test
    public void shouldShowCorrectEMailInSummary() throws InterruptedException {
        // given
        String desiredParcelPrice = "bar@bar.pl";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        formRunThrough();

        // then
        Assert.assertTrue(errorMessage, paymentPage.getSenderEmail().getText().contains(desiredParcelPrice));
    }
}
