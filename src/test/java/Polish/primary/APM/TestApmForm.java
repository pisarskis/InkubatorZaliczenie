package Polish.primary.APM;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestApmForm extends Base {

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
    }

    @Before
    public void setUpBeforeEach() throws InterruptedException {
        getFormPage().chooseDeliveryToAPM();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    public void fillFormAllData() throws Exception {
        getFormPage().clickA();
        fillAPMFormData();
        getFormPage().clickTermsCheckbox();
        getFormPage().clickNewsletterCheckbox();
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectSizeForAParcel() {
        // given
        String parcelASize = "mała";

        // when
        getFormPage().clickA();
        String returnedSize = getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectSizeForBParcel() {
        // given
        String parcelBSize = "średnia";

        // when
        getFormPage().clickB();
        String returnedSize = getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBSize;

        // then
        Assert.assertEquals(errorMessage, parcelBSize, returnedSize);
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectSizeForCParcel() {
        // given
        String parcelCSize = "duża";

        // when
        getFormPage().clickC();
        String returnedSize = getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;


        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelADimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                                   "8 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when
        getFormPage().clickA();

        // then
        Assert.assertEquals(parcelADimensions, getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelBDimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                                   "19 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when
        getFormPage().clickB();

        // then
        Assert.assertEquals(parcelADimensions, getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelCDimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                                   "41 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when
        getFormPage().clickC();

        // then
        Assert.assertEquals(parcelADimensions, getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelAImg() {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickA();

        // then
        Assert.assertTrue( errorMessage,getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelBImg() {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickB();

        // then
        Assert.assertTrue( errorMessage,getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelCImg() {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickC();

        // then
        Assert.assertTrue( errorMessage,getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldReturnCorrectParcelAPrice() {
        // given
        String correctParcelPrice = Prices.APM_A_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldReturnCorrectParcelBPrice() {
        //given
        String correctParcelPrice = Prices.APM_B_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        getFormPage().clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldReturnCorrectParcelCPrice() {
        // given
        String correctParcelPrice = Prices.APM_C_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        String email = "foo.pl";
        String expectedErrorMessage = "NIEPRAWIDŁOWY ADRES EMAIL";
        String errorMessage = "";

        // when
        getReceiverForm().fillReceiverEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        String email = "foo";
        String expectedErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        getReceiverForm().fillReceiverEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForBadSenderEmail() throws Exception {
        // given
        String email = "foo.pl";
        String expectedErrorMessage = "NIEPRAWIDŁOWY ADRES EMAIL";
        String errorMessage = "";

        // when
        getSenderForm().fillSenderEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getSenderForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        String email = "foo";
        String expectedErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        getSenderForm().fillSenderEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getSenderForm().emailErrorMessage().getText());
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
    public void shouldOpenParcelMap() throws Exception {
        // given
        String expectedModalHeader = "Paczkomat lub PaczkoPunkt, do którego dostarczymy przesyłkę";
        String errorMessage = "";

        // when
        getReceiverForm().clickMapButton();

        // then
        Assert.assertEquals(errorMessage, expectedModalHeader, getReceiverForm().getMapModal().getText());
    }

    @Test
    @Tag("pl")
    public void shouldSearchMapModalForParcelBox() throws Exception {
        // given
        String parcelBox = "POP-WAW62";
        String town = "Warszawa";
        String errorMessage = "";

        // when
        getReceiverForm().clickMapButton();
        getReceiverForm().fillSearchBarWithData(town);
        getReceiverForm().clickMapModalSearchResult();
        getReceiverForm().clickMapModalParcelBox(parcelBox);
        getReceiverForm().clickMMParcelBoxChoseButton();
        getReceiverForm().clickReceiverAPMCode();

        // then
        Assert.assertEquals(errorMessage, parcelBox, getReceiverForm().getReceiverAPMNo(parcelBox).getText());
    }

    @Test
    @Tag("pl")
    public void shouldShotParcelBoxDetailsInModal() throws Exception {
        // given
        String parcelBox = "POP-WAW62";
        String town = "Warszawa";
        String errorMessage = "";

        // when
        getReceiverForm().clickMapButton();
        getReceiverForm().fillSearchBarWithData(town);
        getReceiverForm().clickMapModalSearchResult();
        getReceiverForm().clickMapModalParcelBox(parcelBox);
        getReceiverForm().clickMMParcelBoxDetailsButton();

        // then
        Assert.assertEquals(errorMessage, parcelBox, getReceiverForm().getMMDetailsParcelBoxNo().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorWhenTermsNotChecked() throws Exception {
        // given
        String expectedErrorMessage = "POLE WYMAGANE";
        String errorMessage = "";

        // when
        fillFormAllData();
        getFormPage().clickTermsCheckbox();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getFormPage().getTermsError().getText());
    }
}
