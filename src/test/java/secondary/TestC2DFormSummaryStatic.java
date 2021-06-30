package secondary;

import helper.FormDataFactory;
import helper.SenderFormData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

public class TestC2DFormSummaryStatic extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SummaryPage summaryPage;
    private static SenderForm senderForm;
    private static FormDataFactory formDataFactory;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        summaryPage = new SummaryPage();
        senderForm = new SenderForm();
        formDataFactory = new FormDataFactory();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
         formPage.chooseDeliveryC2D();
        formDataFactory.fillC2DFormData();
        senderForm.clickInvoice();
        senderForm.clickPlishCompanyCheckbox();
        senderForm.clickPolishCompanyNIP(SenderFormData.NIPNO.getValue());
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
    }

    @Test
    public void shouldPrintCorrectReceiverName(){
        // given
        String expectedReceiverName = "foo";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverName, summaryPage.getReceiverName().getText());
    }

    @Test
    public void shouldPrintCorrectReceiverPhoneNo() {
        // given
        String expectedReceiverPhoneNo = "555 555 555";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverPhoneNo, summaryPage.getReceiverPhoneNo().getText());
    }

    @Test
    public void shouldPrintCorrectReceiverEmail() {
        // given
        String expectedReceiverEmail = "foo@foo.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverEmail, summaryPage.getReceiverEmail().getText());
    }

    @Test
    public void shouldPrintCorrectSenderName() {
        // given
        String expectedSenderName = "bar";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderName, summaryPage.getSenderName().getText());
    }

    @Test
    public void shouldPrintCorrectSenderPhoneNo() {
        // given
        String expectedSenderPhoneNo = "666 666 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderPhoneNo, summaryPage.getSenderPhoneNo().getText());
    }

    @Test
    public void shouldPrintCorrectSenderEmail() {
        // given
        String expectedSenderEmail = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderEmail, summaryPage.getSenderEmail().getText());
    }

    @Test
    public void shouldPrintCorrectInvoiceName() {
        // given
        String expectedInvoiceName = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceName, summaryPage.getInvoiceName().getText());
    }

    @Test
    public void shouldPrintCorrectInvoiceNIP() {
        // given
        String expectedInvoiceNIP = "NIP: 6793087624";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceNIP, summaryPage.getInvoiceNIP().getText());
    }

    @Test
    public void shouldPrintCorrectInvoiceTown() {
        // given
        String expectedInvoiceTown = "30-624 Kraków";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceTown, summaryPage.getInvoiceTown().getText());
    }

    @Test
    public void shouldPrintCorrectInvoiceStreet() {
        // given
        String expectedInvoiceStreet = "ul. Test-Krucza 130";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceStreet, summaryPage.getInvoiceStreet().getText());
    }

    @Test
    public void shouldPrintCorrectReceiverTown() {
        // given
        String expectedReceiverTown = "02-677 Warszawa";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverTown, summaryPage.getSenderTown().getText());
    }

    @Test
    public void shouldPrintCorrectReceiverStreet() {
        // given
        String expectedReceiverStreet = "Cybernetyki 10/5";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverStreet, summaryPage.getSenderStreet().getText());
    }

    @Test
    public void shouldPrintCorrectInvoiceCountry() {
        // given
        String expectedReceiverCountry = "Polska";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverCountry, summaryPage.getSenderCountry().getText());
    }
}
