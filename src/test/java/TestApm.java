import helper.ActionPage;
import helper.WaitPage;
import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pages.*;

public class TestApm extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static SummaryPage summaryPage;

    @BeforeClass
    public static void closeAllCookies() throws InterruptedException {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        summaryPage = new SummaryPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Before
    public void apmSetUp() throws InterruptedException {
        formPage.chooseDeliveryToAPM();
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
    public void shouldReturnCorrectSizeForAParcel() throws Exception {
        // given
        String parcelASize = "mała";

        // when
        formPage.clickA();
        String returnedSize = formPage.checkParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectSizeForBParcel() throws Exception {
        // given
        String parcelBSize = "średnia";

        // when
        formPage.clickB();
        String returnedSize = formPage.checkParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBSize;

        // then
        Assert.assertEquals(errorMessage, parcelBSize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectSizeForCParcel() throws Exception {
        // given
        String parcelCSize = "duża";

        // when
        formPage.clickC();
        String returnedSize = formPage.checkParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;


        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectParcelAImg() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickA();

        // then
        Assert.assertTrue( errorMessage,formPage.checkParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelBImg() throws Exception {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickB();

        // then
        Assert.assertTrue( errorMessage,formPage.checkParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelCImg() throws Exception {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickC();

        // then
        Assert.assertTrue( errorMessage,formPage.checkParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelAPrice() throws Exception {
        // given
        String correctParcelPrice = "12,99 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.checkParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelBPrice() throws Exception {
        //given
        String correctParcelPrice = "13,99 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        formPage.clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.checkParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelCPrice() throws Exception {
        // given
        String correctParcelPrice = "15,49 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.checkParcelPrice().getText());
    }

    @Test
    public void shouldThrowErrorBadReceiverEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String desiredErrorMessage = "NIEPRAWIDŁOWY ADRES EMAIL";
        String errorMessage = "";

        // when
        receiverForm.fillReceiverEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, receiverForm.emailErrorMessage().getText());
    }

    @Test
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        String email = "q";
        String desiredErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        receiverForm.fillReceiverEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, receiverForm.emailErrorMessage().getText());
    }

    @Test
    public void shouldThrowErrorBadSenderEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String desiredErrorMessage = "NIEPRAWIDŁOWY ADRES EMAIL";
        String errorMessage = "";

        // when
        senderForm.fillSenderEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, senderForm.emailErrorMessage().getText());
    }

    @Test
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        String email = "q";
        String desiredErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        senderForm.fillSenderEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, senderForm.emailErrorMessage().getText());
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

    @Test
    public void shouldOpenParcelMap() throws Exception {
        // given
        String desiredModalHeader = "Paczkomat lub PaczkoPunkt, do którego dostarczymy przesyłkę";
        String errorMessage = "";

        // when
        receiverForm.clickMapButton();

        // then
        Assert.assertEquals(errorMessage, desiredModalHeader, receiverForm.getMapModal().getText());
    }

    @Test
    public void shouldSearchMapModalForParcelBox() throws Exception {
        // given
        String parcelBox = "POP-WAW62";
        String town = "Warszawa";
        String errorMessage = "";

        // when
        receiverForm.clickMapButton();
        receiverForm.fillSearchBarWithData(town);
        receiverForm.clickMapModalSearchResult();
        receiverForm.clickMapModalParcelBox(parcelBox);
        receiverForm.clickMMParcelBoxChoseButton();
        receiverForm.clickReceiverAPMCode();

        // then
        Assert.assertEquals(errorMessage, parcelBox, receiverForm.getReceiverAPMNo(parcelBox).getText());
    }

    @Test
    public void shouldShotParcelBoxDetailsInModal() throws Exception {
        // given
        String parcelBox = "POP-WAW62";
        String town = "Warszawa";
        String errorMessage = "";

        // when
        receiverForm.clickMapButton();
        receiverForm.fillSearchBarWithData(town);
        receiverForm.clickMapModalSearchResult();
        receiverForm.clickMapModalParcelBox(parcelBox);
        receiverForm.clickMMParcelBoxDetailsButton();

        // then
        Assert.assertEquals(errorMessage, parcelBox, receiverForm.getMMDetailsParcelBoxNo().getText());
    }

    @Test
    public void shouldThrowErrorWhenTermsNotChecked() throws Exception {
        // given
        String desiredErrorMessage = "POLE WYMAGANE";
        String errorMessage = "";

        // when
        fillFormAllData();
        formPage.clickTermsCheckbox();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, formPage.getNewsletterError().getText());
    }
}
