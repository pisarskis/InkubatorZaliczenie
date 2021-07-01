package Polish.primary;

import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestInvoice extends Base {

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
        getWaitPage().waitShort();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        getWaitPage().waitShort();
        getFormPage().closeCookiesPopup();
    }

    @Before
    public void fillFormAllData() throws Exception {
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickC();
        fillAPMFormData();
        getFormPage().clickTermsCheckbox();
        getFormPage().clickNewsletterCheckbox();
    }

    @Test
    @Tag("pl")
    public void shouldPrintInvoiceOptions() throws Exception {
        // given
        String expectedText = "Firma w Polsce";
        String errorMessage = "";

        // when
        getSenderForm().clickInvoice();

        // then
        Assert.assertEquals(errorMessage, expectedText, getSenderForm().checkInInvoiceWasClicked().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
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
    @Tag("pl")
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
    @Tag("pl")
    public void shouldThrowErrorWhenToShortTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "00000000";
        String expectedErrorMessage = "PODANY NUMER NIP JEST NIEPRAWIDŁOWY";

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
    @Tag("pl")
    public void shouldThrowErrorWhenToLongTaxNoIsGiven() throws Exception {
        // given
        String errorMessage = "";
        String countryPreFix = "DE";
        String taxNo = "0000000000";
        String expectedErrorMessage = "PODANY NUMER NIP JEST NIEPRAWIDŁOWY";

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
