import helper.WaitPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

public class TestApmEndSummaryStatic extends Base {
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
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
        String receiverName = "foo";
        String receiverEmail = "foo@foo.pl";
        String receiverPhoneNo = "666999666";
        String apmNo = "PAW04A";
        String senderName = "bar";
        String senderEmail = "bar@bar.pl";
        String senderPhoneNo = "666777666";
        String nipNo = "6793087624";

        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        receiverForm.fillReceiverName(receiverName);
        receiverForm.fillReceiverEmail(receiverEmail);
        receiverForm.fillReceiverNumber(receiverPhoneNo);
        receiverForm.fillReceiverAPMCode(apmNo);
        senderForm.fillSenderName(senderName);
        senderForm.fillSenderEmail(senderEmail);
        senderForm.fillSenderNumber(senderPhoneNo);
        senderForm.clickInvoice();
        senderForm.clickPlishCompanyCheckbox();
        senderForm.clickPolishCompanyNIP(nipNo);
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
        formPage.clickPayButton();
        waitPage.waitLong();
        paymentPage.clickBank();
        paymentPage.clickNextButton();
        paymentPage.clickAcceptPayment();
        formPage.closeCookiesPopup();
    }

    @Test
    public void shouldPrintCorrectReceiverName(){
        // given
        String expectedReceiverName = "foo";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverName, endSummaryPage.getReceiverName().getText());
    }

    @Test
    public void shouldPrintCorrectReceiverPhoneNo() {
        // given
        String expectedReceiverPhoneNo = "666 999 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverPhoneNo, endSummaryPage.getReceiverPhoneNo().getText());
    }

    @Test
    public void shouldPrintCorrectReceiverEmail() {
        // given
        String expectedReceiverEmail = "foo@foo.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverEmail, endSummaryPage.getReceiverEmail().getText());
    }

    @Test
    public void shouldPrintCorrectSenderName() {
        // given
        String expectedSenderName = "bar";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderName, endSummaryPage.getSenderName().getText());
    }

    @Test
    public void shouldPrintCorrectSenderPhoneNo() {
        // given
        String expectedSenderPhoneNo = "666 777 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderPhoneNo, endSummaryPage.getSenderPhoneNo().getText());
    }

    @Test
    public void shouldPrintCorrectSenderEmail() {
        // given
        String expectedSenderEmail = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderEmail, endSummaryPage.getSenderEmail().getText());
    }

    @Test
    public void shouldPrintCorrectApmNo() {
        // given
        String expectedApmNo = "PAW04A";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedApmNo, endSummaryPage.getApmNo().getText());
    }

    @Test
    public void shouldPrintCorrectApmAdress() {
        // given
        String expectedApmAdress = "Warszawa 00-175";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedApmAdress, endSummaryPage.getApmAdress().getText());
    }
}
