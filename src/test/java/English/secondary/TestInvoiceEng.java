package English.secondary;

import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.Base;

@Tag("en")
public class TestInvoiceEng extends Base {

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
        getFormPage().clickLanguageSelector();
        getFormPage().closeCookiesPopup();
    }

    @Before
    public void setUpBeforeEach() throws Exception {
        fillFormAllData();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    public void fillFormAllData() throws Exception {
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickA();
        fillAPMFormData();
        getFormPage().clickTermsCheckboxEngish();
        getFormPage().clickNewsletterCheckbox();
    }

    @Test
    @Tag("en")
    public void shouldPrintInvoiceOptions() throws Exception {
        // given
        String expectedText = "Company in Poland";
        String errorMessage = "";

        // when
        getSenderForm().clickInvoice();

        // then
        Assert.assertEquals(errorMessage, expectedText, getSenderForm().checkInInvoiceWasClicked().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintPolishCompanyNameWhenNIPGiven() throws Exception {
        // given
        String nipNo = "6793087624";
        String expectedText = "INPOST SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        String errorMessage = "";

        // when
        getSenderForm().clickInvoice();
        getSenderForm().clickPlishCompanyCheckbox();
        getSenderForm().clickPolishCompanyNIP(nipNo);
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedText, getSenderForm().getInvoiceNameFormSummary().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintNameWhenIndividualIsChosen() throws Exception {
        // given
        String errorMessage = "";
        String name = "bar";

        // when
        fillIndividualInvoice();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, name, getSenderForm().getInvoiceNameFormSummary().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorWhenToShortTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "00000000";
        String expectedErrorMessage = "THE PROVIDED TAX IDENTIFICATION NUMBER (POL. NIP) IS INCORRECT.";

        // when
        getSenderForm().clickInvoice();
        getSenderForm().clickForeignCompanyCheckbox();
        getSenderForm().clickInvoiceCountryPrefix(countryPreFix);
        getSenderForm().fillInvoiceCountryTaxNo(taxNo);
        getSenderForm().clickForeignCompanyCheckbox();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getSenderForm().invoiceCountryTaxNoError().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorWhenToLongTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "0000000000";
        String expectedErrorMessage = "THE PROVIDED TAX IDENTIFICATION NUMBER (POL. NIP) IS INCORRECT.";

        // when
        getSenderForm().clickInvoice();
        getSenderForm().clickForeignCompanyCheckbox();
        getSenderForm().clickInvoiceCountryPrefix(countryPreFix);
        getSenderForm().fillInvoiceCountryTaxNo(taxNo);
        getSenderForm().clickForeignCompanyCheckbox();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getSenderForm().invoiceCountryTaxNoError().getText());
    }
}
