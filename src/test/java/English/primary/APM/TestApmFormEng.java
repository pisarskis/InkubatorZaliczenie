package English.primary.APM;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.Base;

public class TestApmFormEng extends Base {

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        Base.getFormPage().closeCookiesPopup();
        Base.getFormPage().closeBottomCookiesPopup();
        Base.getFormPage().clickLanguageSelector();
        Base.getFormPage().closeCookiesPopup();
    }

    @Before
    public void setUpBeforeEach() throws InterruptedException {
        Base.getFormPage().chooseDeliveryToAPM();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        Base.getWaitPage().waitLong();
        Base.getFormPage().closeCookiesPopup();
    }

    public void fillFormAllData() throws Exception {
        Base.getFormPage().clickA();
        Base.fillAPMFormData();
        Base.getFormPage().clickTermsCheckboxEngish();
        Base.getFormPage().clickNewsletterCheckbox();
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForAParcel() {
        // given
        final String PARCEL_A_SIZE = "Small";

        // when
        Base.getFormPage().clickA();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + PARCEL_A_SIZE;

        // then
        Assert.assertEquals(errorMessage, PARCEL_A_SIZE, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForBParcel() {
        // given
        final String PARCEL_B_SIZE = "Medium";

        // when
        Base.getFormPage().clickB();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + PARCEL_B_SIZE;

        // then
        Assert.assertEquals(errorMessage, PARCEL_B_SIZE, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForCParcel() {
        // given
        final String PARCEL_C_SIZE = "Large";

        // when
        Base.getFormPage().clickC();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + PARCEL_C_SIZE;


        // then
        Assert.assertEquals(errorMessage, PARCEL_C_SIZE, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelADimensions() {
        // given
        final String PARCEL_A_DIMENSIONS = "max. dimension\n" +
                "8 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertEquals(PARCEL_A_DIMENSIONS, Base.getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBDimensions() {
        // given
        final String PARCEL_B_DIMENSIONS = "max. dimension\n" +
                "19 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        Base.getFormPage().clickB();

        // then
        Assert.assertEquals(PARCEL_B_DIMENSIONS, Base.getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCDimensions() {
        // given
        final String PARCEL_C_DIMENSIONS = "max. dimension\n" +
                "41 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertEquals(PARCEL_C_DIMENSIONS, Base.getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAImg() {
        // given
        final String IMG_SIZE = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(IMG_SIZE));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBImg() {
        // given
        final String IMG_SIZE = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickB();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(IMG_SIZE));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCImg() {
        // given
        final String IMG_SIZE = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(IMG_SIZE));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAPrice() {
        // given
        final String CORRECT_PARCEL_PRICE = Prices.APM_A_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertEquals(errorMessage, CORRECT_PARCEL_PRICE, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBPrice() {
        //given
        final String CORRECT_PARCEL_PRICE = Prices.APM_B_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        Base.getFormPage().clickB();

        //then
        Assert.assertEquals(errorMessage, CORRECT_PARCEL_PRICE, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCPrice() {
        // given
        final String CORRECT_PARCEL_PRICE = Prices.APM_C_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertEquals(errorMessage, CORRECT_PARCEL_PRICE, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        final String EMAIL = "qweqwe.pl";
        final String EXPECTED_ERROR_MESSAGE = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        Base.getReceiverForm().fillReceiverEmail(EMAIL);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE, Base.getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        final String EMAIL = "q";
        final String EXPECTED_ERROR_MESSAGE = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        Base.getReceiverForm().fillReceiverEmail(EMAIL);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE, Base.getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadSenderEmail() throws Exception {
        // given
        final String EMAIL = "qweqwe.pl";
        final String EXPECTED_ERROR_MESSAGE = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        Base.getSenderForm().fillSenderEmail(EMAIL);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE, Base.getSenderForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        final String EMAIL = "q";
        final String EXPECTED_ERROR_MESSAGE = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        Base.getSenderForm().fillSenderEmail(EMAIL);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE, Base.getSenderForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintInvoiceOptions() throws Exception {
        // given
        final String EXPECTED_TEXT = "Company in Poland";
        String errorMessage = "";

        // when
        Base.getSenderForm().clickInvoice();

        // then
        Assert.assertEquals(errorMessage, EXPECTED_TEXT, Base.getSenderForm().checkInInvoiceWasClicked().getText());
    }



    @Test
    @Tag("en")
    public void shouldOpenParcelMap() throws Exception {
        // given
        final String EXPECTED_TEXT = "Parcel locker or Parcel Point where your shipment will be delivered";
        String errorMessage = "";

        // when
        Base.getReceiverForm().clickMapButton();

        // then
        Assert.assertEquals(errorMessage, EXPECTED_TEXT, Base.getReceiverForm().getMapModal().getText());
    }

    @Test
    @Tag("en")
    public void shouldSearchMapModalForParcelBox() throws Exception {
        // given
        final String PARCEL_BOX = "POP-WAW62";
        final String TOWN = "Warszawa";
        String errorMessage = "";

        // when
        Base.getReceiverForm().clickMapButton();
        Base.getReceiverForm().fillSearchBarWithData(TOWN);
        Base.getReceiverForm().clickMapModalSearchResult();
        Base.getReceiverForm().clickMapModalParcelBox(PARCEL_BOX);
        Base.getReceiverForm().clickMMParcelBoxChoseButton();
        Base.getReceiverForm().clickReceiverAPMCode();

        // then
        Assert.assertEquals(errorMessage, PARCEL_BOX, Base.getReceiverForm().getReceiverAPMNo(PARCEL_BOX).getText());
    }

    @Test
    @Tag("en")
    public void shouldShotParcelBoxDetailsInModal() throws Exception {
        // given
        final String PARCEL_BOX = "POP-WAW62";
        final String TOWN = "Warszawa";
        String errorMessage = "";

        // when
        Base.getReceiverForm().clickMapButton();
        Base.getReceiverForm().fillSearchBarWithData(TOWN);
        Base.getReceiverForm().clickMapModalSearchResult();
        Base.getReceiverForm().clickMapModalParcelBox(PARCEL_BOX);
        Base.getReceiverForm().clickMMParcelBoxDetailsButton();

        // then
        Assert.assertEquals(errorMessage, PARCEL_BOX, Base.getReceiverForm().getMMDetailsParcelBoxNo().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorWhenTermsNotChecked() throws Exception {
        // given
        final String EXPECTED_ERROR_MESSAGE = "REQUIRED FIELD";
        String errorMessage = "";

        // when
        fillFormAllData();
        Base.getFormPage().clickTermsCheckboxEngish();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE, Base.getFormPage().getTermsErrorEnglish().getText());
    }
}