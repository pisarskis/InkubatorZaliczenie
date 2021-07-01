package English.primary.APM;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

public class TestApmFormEng extends Base {
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
        formPage.clickLanguageSelector();
        formPage.closeCookiesPopup();
    }

    @Before
    public void setUpBeforeEach() throws InterruptedException {
        formPage.chooseDeliveryToAPM();
    }

    @After
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    public void fillFormAllData() throws Exception {
        formPage.clickA();
        fillAPMFormData();
        formPage.clickTermsCheckboxEngish();
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

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForAParcel() throws Exception {
        // given
        String parcelASize = "Small";

        // when
        formPage.clickA();
        String returnedSize = formPage.getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForBParcel() throws Exception {
        // given
        String parcelBSize = "Medium";

        // when
        formPage.clickB();
        String returnedSize = formPage.getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBSize;

        // then
        Assert.assertEquals(errorMessage, parcelBSize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForCParcel() throws Exception {
        // given
        String parcelCSize = "Large";

        // when
        formPage.clickC();
        String returnedSize = formPage.getParcelSizeText().getText();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;


        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelADimensions() throws Exception {
        // given
        String parcelADimensions = "max. dimension\n" +
                "8 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        formPage.clickA();

        // then
        Assert.assertEquals(parcelADimensions, formPage.getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBDimensions() throws Exception {
        // given
        String parcelADimensions = "max. dimension\n" +
                "19 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        formPage.clickB();

        // then
        Assert.assertEquals(parcelADimensions, formPage.getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCDimensions() throws Exception {
        // given
        String parcelADimensions = "max. dimension\n" +
                "41 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when
        formPage.clickC();

        // then
        Assert.assertEquals(parcelADimensions, formPage.getParcelDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAImg() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickA();

        // then
        Assert.assertTrue( errorMessage,formPage.getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBImg() throws Exception {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickB();

        // then
        Assert.assertTrue( errorMessage,formPage.getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCImg() throws Exception {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickC();

        // then
        Assert.assertTrue( errorMessage,formPage.getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAPrice() throws Exception {
        // given
        String correctParcelPrice = Prices.APM_A_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBPrice() throws Exception {
        //given
        String correctParcelPrice = Prices.APM_B_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        formPage.clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCPrice() throws Exception {
        // given
        String correctParcelPrice = Prices.APM_C_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String expectedErrorMessage = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        receiverForm.fillReceiverEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, receiverForm.emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        receiverForm.fillReceiverEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, receiverForm.emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadSenderEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String expectedErrorMessage = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        senderForm.fillSenderEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, senderForm.emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        senderForm.fillSenderEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, senderForm.emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintInvoiceOptions() throws Exception {
        // given
        String expectedText = "Company in Poland";
        String errorMessage = "";

        // when
        senderForm.clickInvoice();

        // then
        Assert.assertEquals(errorMessage, expectedText, senderForm.checkInInvoiceWasClicked().getText());
    }



    @Test
    @Tag("en")
    public void shouldOpenParcelMap() throws Exception {
        // given
        String expectedModalHeader = "Parcel locker or Parcel Point where your shipment will be delivered";
        String errorMessage = "";

        // when
        receiverForm.clickMapButton();

        // then
        Assert.assertEquals(errorMessage, expectedModalHeader, receiverForm.getMapModal().getText());
    }

    @Test
    @Tag("en")
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
    @Tag("en")
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
    @Tag("en")
    public void shouldThrowErrorWhenTermsNotChecked() throws Exception {
        // given
        String expectedErrorMessage = "REQUIRED FIELD";
        String errorMessage = "";

        // when
        fillFormAllData();
        formPage.clickTermsCheckboxEngish();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, formPage.getTermsErrorEnglish().getText());
    }
}