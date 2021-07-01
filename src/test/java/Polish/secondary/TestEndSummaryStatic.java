package Polish.secondary;

import helper.ReceiverFormData;
import helper.SenderFormData;
import helper.WaitPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import pages.*;

public class TestEndSummaryStatic extends Base {
    @BeforeClass
    public static void closeAllCookies() throws Exception {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
        formRunThrough();
    }

    private static void formRunThrough() throws InterruptedException {
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickA();
        fillAPMFormData();
        getSenderForm().clickInvoice();
        getSenderForm().clickPlishCompanyCheckbox();
        getSenderForm().clickPolishCompanyNIP(SenderFormData.NIPNO.getValue());
        getFormPage().clickTermsCheckbox();
        getFormPage().clickNewsletterCheckbox();
        getFormPage().clickSendButton();
        getFormPage().clickPayButton();
        getWaitPage().waitLong();
        getPaymentPage().clickBank();
        getPaymentPage().clickNextButton();
        getPaymentPage().clickAcceptPayment();
        getFormPage().closeCookiesPopup();
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverName(){
        // given
        String expectedReceiverName = "foo";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverName, getEndSummaryPage().getReceiverName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverPhoneNo() {
        // given
        String expectedReceiverPhoneNo = "555 555 555";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverPhoneNo, getEndSummaryPage().getReceiverPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectReceiverEmail() {
        // given
        String expectedReceiverEmail = "foo@foo.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedReceiverEmail, getEndSummaryPage().getReceiverEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderName() {
        // given
        String expectedSenderName = "bar";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderName, getEndSummaryPage().getSenderName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderPhoneNo() {
        // given
        String expectedSenderPhoneNo = "666 666 666";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderPhoneNo, getEndSummaryPage().getSenderPhoneNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectSenderEmail() {
        // given
        String expectedSenderEmail = "bar@bar.pl";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedSenderEmail, getEndSummaryPage().getSenderEmail().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectApmNo() {
        // given
        String expectedApmNo = "PAW04A";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedApmNo, getEndSummaryPage().getApmNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectApmAdress() {
        // given
        String expectedApmAdress = "Warszawa 00-175";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedApmAdress, getEndSummaryPage().getApmAdress().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceName() {
        // given
        String expectedInvoiceName = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceName, getEndSummaryPage().getInvoiceName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceNIP() {
        // given
        String expectedInvoiceNIP = "NIP: PL6793087624";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceNIP, getEndSummaryPage().getInvoiceNIP().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceTown() {
        // given
        String expectedInvoiceTown = "30-624 Kraków";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceTown, getEndSummaryPage().getInvoiceTown().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectInvoiceStreet() {
        // given
        String expectedInvoiceStreet = "ul. Test-Krucza 130";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedInvoiceStreet, getEndSummaryPage().getInvoiceStreet().getText());
    }
}
