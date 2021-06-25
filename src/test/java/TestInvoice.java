import helper.ActionPage;
import helper.WaitPage;
import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pages.*;

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
    }

    @Before
    public void setUpBeforeEach() throws Exception {
        fillFormAllData();
    }

    @After
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    public void fillFormAllData() throws Exception {
        String receiverName = "qweqwe";
        String receiverEmail = "qwe@qwe.pl";
        String receiverPhoneNo = "666999666";
        String apmNo = "PAW04A";
        String senderName = "qweqwe";
        String senderEmail = "qwe@qwe.pl";
        String senderPhoneNo = "666999666";

        formPage.chooseDeliveryToAPM();
        formPage.clickA();
        receiverForm.fillReceiverName(receiverName);
        receiverForm.fillReceiverEmail(receiverEmail);
        receiverForm.fillReceiverNumber(receiverPhoneNo);
        receiverForm.fillReceiverAPMCode(apmNo);

        senderForm.fillSenderName(senderName);
        senderForm.fillSenderEmail(senderEmail);
        senderForm.fillSenderNumber(senderPhoneNo);
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
    }

    void fillIndividualInvoiceData() throws InterruptedException {
        String name = "qweqwe";
        String email = "qwe@qwe.pl";
        String zipCode = "02-677";
        String town = "Warszawa";
        String street = "Cybernetyki";
        String buildingNo = "10";

        senderForm.clickInvoice();
        senderForm.clickLegalStatusIndividualCheckbox();
        senderForm.clickInvoiceIndividualName(name);
        senderForm.clickInvoiceIndividualEmail(email);
        senderForm.clickInvoiceIndividualZIPCode(zipCode);
        senderForm.clickInvoiceIndividualTown(town);
        senderForm.clickInvoiceIndividualStreet(street);
        senderForm.clickInvoiceIndividualBuildingNo(buildingNo);
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
        fillFormAllData();
        senderForm.clickInvoice();
        senderForm.clickPlishCompanyCheckbox();
        senderForm.clickPolishCompanyNIP(nipNo);
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredText, senderForm.getInvoiceNameFromSummary().getText());
    }

    @Test
    public void shouldPrintNameWhenIndividualIsChosen() throws Exception {
        // given
        String errorMessage = "";
        String name = "qweqwe";

        // when
        fillFormAllData();
        fillIndividualInvoiceData();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, name, senderForm.getInvoiceNameFromSummary().getText());
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
