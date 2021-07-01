package English.primary.APM;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

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
        String parcelASize = "Small";

        // when
        Base.getFormPage().clickA();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForBParcel() {
        // given
        String parcelBSize = "Medium";

        // when
        Base.getFormPage().clickB();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBSize;

        // then
        Assert.assertEquals(errorMessage, parcelBSize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForCParcel() {
        // given
        String parcelCSize = "Large";

        // when
        Base.getFormPage().clickC();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;


        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelADimensions() {
        // given
        String parcelADimensions = "max. dimension\n" +
                "8 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertEquals(parcelADimensions, Base.getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBDimensions() {
        // given
        String parcelADimensions = "max. dimension\n" +
                "19 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        Base.getFormPage().clickB();

        // then
        Assert.assertEquals(parcelADimensions, Base.getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCDimensions() {
        // given
        String parcelADimensions = "max. dimension\n" +
                "41 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertEquals(parcelADimensions, Base.getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAImg() {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBImg() {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickB();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCImg() {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAPrice() {
        // given
        String correctParcelPrice = Prices.APM_A_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBPrice() {
        //given
        String correctParcelPrice = Prices.APM_B_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        Base.getFormPage().clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCPrice() {
        // given
        String correctParcelPrice = Prices.APM_C_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String expectedErrorMessage = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        Base.getReceiverForm().fillReceiverEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        Base.getReceiverForm().fillReceiverEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadSenderEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String expectedErrorMessage = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        Base.getSenderForm().fillSenderEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getSenderForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        Base.getSenderForm().fillSenderEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getSenderForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintInvoiceOptions() throws Exception {
        // given
        String expectedText = "Company in Poland";
        String errorMessage = "";

        // when
        Base.getSenderForm().clickInvoice();

        // then
        Assert.assertEquals(errorMessage, expectedText, Base.getSenderForm().checkInInvoiceWasClicked().getText());
    }



    @Test
    @Tag("en")
    public void shouldOpenParcelMap() throws Exception {
        // given
        String expectedModalHeader = "Parcel locker or Parcel Point where your shipment will be delivered";
        String errorMessage = "";

        // when
        Base.getReceiverForm().clickMapButton();

        // then
        Assert.assertEquals(errorMessage, expectedModalHeader, Base.getReceiverForm().getMapModal().getText());
    }

    @Test
    @Tag("en")
    public void shouldSearchMapModalForParcelBox() throws Exception {
        // given
        String parcelBox = "POP-WAW62";
        String town = "Warszawa";
        String errorMessage = "";

        // when
        Base.getReceiverForm().clickMapButton();
        Base.getReceiverForm().fillSearchBarWithData(town);
        Base.getReceiverForm().clickMapModalSearchResult();
        Base.getReceiverForm().clickMapModalParcelBox(parcelBox);
        Base.getReceiverForm().clickMMParcelBoxChoseButton();
        Base.getReceiverForm().clickReceiverAPMCode();

        // then
        Assert.assertEquals(errorMessage, parcelBox, Base.getReceiverForm().getReceiverAPMNo(parcelBox).getText());
    }

    @Test
    @Tag("en")
    public void shouldShotParcelBoxDetailsInModal() throws Exception {
        // given
        String parcelBox = "POP-WAW62";
        String town = "Warszawa";
        String errorMessage = "";

        // when
        Base.getReceiverForm().clickMapButton();
        Base.getReceiverForm().fillSearchBarWithData(town);
        Base.getReceiverForm().clickMapModalSearchResult();
        Base.getReceiverForm().clickMapModalParcelBox(parcelBox);
        Base.getReceiverForm().clickMMParcelBoxDetailsButton();

        // then
        Assert.assertEquals(errorMessage, parcelBox, Base.getReceiverForm().getMMDetailsParcelBoxNo().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorWhenTermsNotChecked() throws Exception {
        // given
        String expectedErrorMessage = "REQUIRED FIELD";
        String errorMessage = "";

        // when
        fillFormAllData();
        Base.getFormPage().clickTermsCheckboxEngish();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getFormPage().getTermsErrorEnglish().getText());
    }
}