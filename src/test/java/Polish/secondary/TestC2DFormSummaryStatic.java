package Polish.secondary;

import helper.ReceiverFormData;
import helper.SenderFormData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestC2DFormSummaryStatic extends Base {

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
        getFormPage().chooseDeliveryC2D();
        fillC2DFormData();
        getSenderForm().clickInvoice();
        getSenderForm().clickPlishCompanyCheckbox();
        getSenderForm().clickPolishCompanyNIP(SenderFormData.NIPNO.getValue());
        getFormPage().clickTermsCheckbox();
        getFormPage().clickNewsletterCheckbox();
        getFormPage().clickSendButton();
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverName(){
        // given
        String expectedReceiverName = "foo";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverName, getSummaryPage().getReceiverName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverPhoneNo() {
        // given
        String expectedReceiverPhoneNo = "555 555 555";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverPhoneNo, getSummaryPage().getReceiverPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverEmail() {
        // given
        String expectedReceiverEmail = "foo@foo.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverEmail, getSummaryPage().getReceiverEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderName() {
        // given
        String expectedSenderName = "bar";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderName, getSummaryPage().getSenderName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderPhoneNo() {
        // given
        String expectedSenderPhoneNo = "666 666 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderPhoneNo, getSummaryPage().getSenderPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderEmail() {
        // given
        String expectedSenderEmail = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderEmail, getSummaryPage().getSenderEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceName() {
        // given
        String expectedInvoiceName = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceName, getSummaryPage().getInvoiceName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceNIP() {
        // given
        String expectedInvoiceNIP = "NIP: 6793087624";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceNIP, getSummaryPage().getInvoiceNIP().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceTown() {
        // given
        String expectedInvoiceTown = "30-624 Kraków";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceTown, getSummaryPage().getInvoiceTown().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceStreet() {
        // given
        String expectedInvoiceStreet = "ul. Test-Krucza 130";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceStreet, getSummaryPage().getInvoiceStreet().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverTown() {
        // given
        String expectedReceiverTown = "02-677 Warszawa";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverTown, getSummaryPage().getSenderTown().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverStreet() {
        // given
        String expectedReceiverStreet = "Cybernetyki 10/5";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverStreet, getSummaryPage().getSenderStreet().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceCountry() {
        // given
        String expectedReceiverCountry = "Polska";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverCountry, getSummaryPage().getSenderCountry().getText());
    }
}
