import helper.ActionPage;
import helper.FormDataFactory;
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
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        formDataFactory.fillAPMFormData();
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
    public void shouldShowCorrectEMailInSummary(){
        // given
        String desiredParcelPrice = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertTrue(errorMessage, paymentPage.getSenderEmail().getText().contains(desiredParcelPrice));
    }
}
