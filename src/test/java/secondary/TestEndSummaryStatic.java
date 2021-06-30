package secondary;

import helper.ReceiverFormData;
import helper.SenderFormData;
import helper.WaitPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import pages.*;

public class TestEndSummaryStatic extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static EndSummaryPage endSummaryPage;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        paymentPage = new PaymentPage();
        endSummaryPage = new EndSummaryPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        fillAPMFormData();
        senderForm.clickInvoice();
        senderForm.clickPlishCompanyCheckbox();
        senderForm.clickPolishCompanyNIP(SenderFormData.NIPNO.getValue());
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

    public static void fillAPMFormData() throws InterruptedException {
        receiverForm.fillReceiverName(ReceiverFormData.NAME.getValue());
        receiverForm.fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        receiverForm.fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        receiverForm.fillReceiverAPMCode(ReceiverFormData.APNNO.getValue());
        senderForm.fillSenderName(SenderFormData.NAME.getValue());
        senderForm.fillSenderEmail(SenderFormData.EMAIL.getValue());
        senderForm.fillSenderNumber(SenderFormData.PHONENO.getValue());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverName(){
        // given
        String expectedReceiverName = "foo";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverName, endSummaryPage.getReceiverName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverPhoneNo() {
        // given
        String expectedReceiverPhoneNo = "555 555 555";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverPhoneNo, endSummaryPage.getReceiverPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverEmail() {
        // given
        String expectedReceiverEmail = "foo@foo.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverEmail, endSummaryPage.getReceiverEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderName() {
        // given
        String expectedSenderName = "bar";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderName, endSummaryPage.getSenderName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderPhoneNo() {
        // given
        String expectedSenderPhoneNo = "666 666 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderPhoneNo, endSummaryPage.getSenderPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderEmail() {
        // given
        String expectedSenderEmail = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderEmail, endSummaryPage.getSenderEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectApmNo() {
        // given
        String expectedApmNo = "PAW04A";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedApmNo, endSummaryPage.getApmNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectApmAdress() {
        // given
        String expectedApmAdress = "Warszawa 00-175";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedApmAdress, endSummaryPage.getApmAdress().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceName() {
        // given
        String expectedInvoiceName = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceName, endSummaryPage.getInvoiceName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceNIP() {
        // given
        String expectedInvoiceNIP = "NIP: PL6793087624";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceNIP, endSummaryPage.getInvoiceNIP().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceTown() {
        // given
        String expectedInvoiceTown = "30-624 Kraków";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceTown, endSummaryPage.getInvoiceTown().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceStreet() {
        // given
        String expectedInvoiceStreet = "ul. Test-Krucza 130";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceStreet, endSummaryPage.getInvoiceStreet().getText());
    }
}
