
import helper.FormDataFactory;
import helper.WaitPage;
import org.junit.*;
import pages.*;

public class TestInvoice extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static FormDataFactory formDataFactory;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        formDataFactory = new FormDataFactory();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Before
    public void setUpBeforeEach() throws Exception {
        fillFormAllData();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    public void fillFormAllData() throws Exception {
        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        receiverForm.fillReceiverName(formDataFactory.getReceiverName());
        receiverForm.fillReceiverEmail(formDataFactory.getReceiverEmail());
        receiverForm.fillReceiverNumber(formDataFactory.getReceiverPhoneNo());
        receiverForm.fillReceiverAPMCode(formDataFactory.getParcelBoxNo());
        senderForm.fillSenderName(formDataFactory.getSenderName());
        senderForm.fillSenderEmail(formDataFactory.getSenderEmail());
        senderForm.fillSenderNumber(formDataFactory.getSenderPhoneNo());
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
    }

    void fillIndividualInvoiceData() throws InterruptedException {
        senderForm.clickInvoice();
        senderForm.clickLegalStatusIndividualCheckbox();
        senderForm.clickInvoiceIndividualName(formDataFactory.getIndividualInvoiceName());
        senderForm.clickInvoiceIndividualEmail(formDataFactory.getIndividualInvoiceEmail());
        senderForm.clickInvoiceIndividualZIPCode(formDataFactory.getIndividualInvoiceZipCode());
        senderForm.clickInvoiceIndividualTown(formDataFactory.getIndividualInvoiceTown());
        senderForm.clickInvoiceIndividualStreet(formDataFactory.getIndividualInvoiceStreet());
        senderForm.clickInvoiceIndividualBuildingNo(formDataFactory.getIndividualInvoiceStreetNo());
    }

    @Test
    public void shouldPrintInvoiceOptions() throws Exception {
        // given
        String desiredText = "Firma w Polsce";
        String errorMessage = "";

        // when
        senderForm.clickInvoice();

        // then
        Assert.assertEquals(errorMessage, desiredText, senderForm.checkInInvoiceWasClicked().getText());
    }

    @Test
    public void shouldPrintPolishCompanyNameWhenNIPGiven() throws Exception {
        // given
        String nipNo = "6793087624";
        String desiredText = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when
        senderForm.clickInvoice();
        senderForm.clickPlishCompanyCheckbox();
        senderForm.clickPolishCompanyNIP(nipNo);
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredText, senderForm.getInvoiceNameFormSummary().getText());
    }

    @Test
    public void shouldPrintNameWhenIndividualIsChosen() throws Exception {
        // given
        String errorMessage = "";
        String name = "foo-bar";

        // when
        fillIndividualInvoiceData();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, name, senderForm.getInvoiceNameFormSummary().getText());
    }

    @Test
    public void shouldThrowErrorWhenToShortTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "00000000";
        String desiredErrorMessage = "PODANY NUMER NIP JEST NIEPRAWIDŁOWY";

        // when
        senderForm.clickInvoice();
        senderForm.clickForeignCompanyCheckbox();
        senderForm.clickInvoiceCountryPrefix(countryPreFix);
        senderForm.fillInvoiceCountryTaxNo(taxNo);
        senderForm.clickForeignCompanyCheckbox();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, senderForm.invoiceCountryTaxNoError().getText());
    }

    @Test
    public void shouldThrowErrorWhenToLongTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "0000000000";
        String desiredErrorMessage = "PODANY NUMER NIP JEST NIEPRAWIDŁOWY";

        // when
        senderForm.clickInvoice();
        senderForm.clickForeignCompanyCheckbox();
        senderForm.clickInvoiceCountryPrefix(countryPreFix);
        senderForm.fillInvoiceCountryTaxNo(taxNo);
        senderForm.clickForeignCompanyCheckbox();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, senderForm.invoiceCountryTaxNoError().getText());
    }
}
