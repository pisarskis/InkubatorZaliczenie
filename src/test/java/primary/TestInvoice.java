package primary;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestInvoice extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        waitPage.waitShort();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        waitPage.waitShort();
        formPage.closeCookiesPopup();
    }

    @Before
    public void fillFormAllData() throws Exception {
        formPage.chooseDeliveryToAPM();
        formPage.clickC();
        fillAPMFormData();
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
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

    public void fillIndividualInvoice() throws InterruptedException {
        senderForm.clickInvoice();
        senderForm.clickLegalStatusIndividualCheckbox();
        senderForm.clickInvoiceIndividualName(SenderFormData.NAME.getValue());
        senderForm.clickInvoiceIndividualEmail(SenderFormData.EMAIL.getValue());
        senderForm.clickInvoiceIndividualZIPCode(SenderFormData.ZIPCODE.getValue());
        senderForm.clickInvoiceIndividualTown(SenderFormData.TOWN.getValue());
        senderForm.clickInvoiceIndividualStreet(SenderFormData.STREET.getValue());
        senderForm.clickInvoiceIndividualBuildingNo(SenderFormData.STREETNO.getValue());
    }

    @Test
    @Tag("pl")
    public void shouldPrintInvoiceOptions() throws Exception {
        // given
        String expectedText = "Firma w Polsce";
        String errorMessage = "";

        // when
        senderForm.clickInvoice();

        // then
        Assert.assertEquals(errorMessage, expectedText, senderForm.checkInInvoiceWasClicked().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintPolishCompanyNameWhenNIPGiven() throws Exception {
        // given
        String nipNo = "6793087624";
        String expectedText = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when
        senderForm.clickInvoice();
        senderForm.clickPlishCompanyCheckbox();
        senderForm.clickPolishCompanyNIP(nipNo);
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedText, senderForm.getInvoiceNameFormSummary().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintNameWhenIndividualIsChosen() throws Exception {
        // given
        String errorMessage = "";
        String name = "bar";

        // when
        fillIndividualInvoice();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, name, senderForm.getInvoiceNameFormSummary().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorWhenToShortTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "00000000";
        String expectedErrorMessage = "PODANY NUMER NIP JEST NIEPRAWIDŁOWY";

        // when
        senderForm.clickInvoice();
        senderForm.clickForeignCompanyCheckbox();
        senderForm.clickInvoiceCountryPrefix(countryPreFix);
        senderForm.fillInvoiceCountryTaxNo(taxNo);
        senderForm.clickForeignCompanyCheckbox();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, senderForm.invoiceCountryTaxNoError().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorWhenToLongTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "0000000000";
        String expectedErrorMessage = "PODANY NUMER NIP JEST NIEPRAWIDŁOWY";

        // when
        senderForm.clickInvoice();
        senderForm.clickForeignCompanyCheckbox();
        senderForm.clickInvoiceCountryPrefix(countryPreFix);
        senderForm.fillInvoiceCountryTaxNo(taxNo);
        senderForm.clickForeignCompanyCheckbox();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, senderForm.invoiceCountryTaxNoError().getText());
    }
}
