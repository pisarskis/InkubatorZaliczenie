package secondary;

import helper.ReceiverFormData;
import helper.SenderFormData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestC2DFormSummaryStatic extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SummaryPage summaryPage;
    private static SenderForm senderForm;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        summaryPage = new SummaryPage();
        senderForm = new SenderForm();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
        formPage.chooseDeliveryC2D();
        fillC2DFormData();
        senderForm.clickInvoice();
        senderForm.clickPlishCompanyCheckbox();
        senderForm.clickPolishCompanyNIP(SenderFormData.NIPNO.getValue());
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
        formPage.clickSendButton();
    }

    public static void fillC2DFormData() throws InterruptedException {
        receiverForm.fillReceiverName(ReceiverFormData.NAME.getValue());
        receiverForm.fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        receiverForm.fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        receiverForm.fillReceiverZipCode(ReceiverFormData.ZIPCODE.getValue());
        receiverForm.fillReceiverTown(ReceiverFormData.TOWN.getValue());
        receiverForm.fillReceiverStreet(ReceiverFormData.STREET.getValue());
        receiverForm.fillReceiverStreetNo(ReceiverFormData.STREETNO.getValue());
        receiverForm.fillReceiverFlatNo(ReceiverFormData.FLATNO.getValue());
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
        Assert.assertEquals(errorMessage, expectedReceiverName, summaryPage.getReceiverName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverPhoneNo() {
        // given
        String expectedReceiverPhoneNo = "555 555 555";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverPhoneNo, summaryPage.getReceiverPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverEmail() {
        // given
        String expectedReceiverEmail = "foo@foo.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverEmail, summaryPage.getReceiverEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderName() {
        // given
        String expectedSenderName = "bar";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderName, summaryPage.getSenderName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderPhoneNo() {
        // given
        String expectedSenderPhoneNo = "666 666 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderPhoneNo, summaryPage.getSenderPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderEmail() {
        // given
        String expectedSenderEmail = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderEmail, summaryPage.getSenderEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceName() {
        // given
        String expectedInvoiceName = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceName, summaryPage.getInvoiceName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceNIP() {
        // given
        String expectedInvoiceNIP = "NIP: 6793087624";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceNIP, summaryPage.getInvoiceNIP().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceTown() {
        // given
        String expectedInvoiceTown = "30-624 Kraków";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceTown, summaryPage.getInvoiceTown().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceStreet() {
        // given
        String expectedInvoiceStreet = "ul. Test-Krucza 130";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceStreet, summaryPage.getInvoiceStreet().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverTown() {
        // given
        String expectedReceiverTown = "02-677 Warszawa";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverTown, summaryPage.getSenderTown().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverStreet() {
        // given
        String expectedReceiverStreet = "Cybernetyki 10/5";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverStreet, summaryPage.getSenderStreet().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceCountry() {
        // given
        String expectedReceiverCountry = "Polska";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverCountry, summaryPage.getSenderCountry().getText());
    }
}
