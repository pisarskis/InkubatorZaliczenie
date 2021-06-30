package primary;

import helper.ActionPage;
import helper.FormDataFactory;
import helper.Prices;
import helper.WaitPage;
import org.junit.*;
import pages.*;

public class TestPayment extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static FormDataFactory formDataFactory;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        paymentPage = new PaymentPage();
        formDataFactory = new FormDataFactory();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {

        formDataFactory.fillAPMFormData();
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
        formPage.clickPayButton();
        waitPage.waitLong();
        waitPage.waitLong();
    }

    @Test
    public void shouldShowCorrectParcelAPriceInPayment() throws InterruptedException {
        // given
        String desiredParcelPrice = Prices.APM_A_PL.getPrice();
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickA();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, paymentPage.getSenderParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelBPriceInPayment() throws InterruptedException {
        // given
        String desiredParcelPrice = Prices.APM_B_PL.getPrice();
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickB();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, paymentPage.getSenderParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelCPriceInPayment() throws InterruptedException {
        // given
        String desiredParcelPrice = Prices.APM_C_PL.getPrice();
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickC();

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

        // then
        Assert.assertTrue(errorMessage, paymentPage.getSenderEmail().getText().contains(desiredParcelPrice));
    }
}
