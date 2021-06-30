package English.primary.APM;

import helper.FormDataFactory;
import helper.WaitPage;
import org.junit.*;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

public class TestApmForm extends Base {
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
        formDataFactory.fillAPMFormData();
        formPage.clickTermsCheckboxEngish();
        formPage.clickNewsletterCheckbox();
    }

    @Test
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
    public void shouldReturnCorrectParcelAPrice() throws Exception {
        // given
        String correctParcelPrice = "PLN 12.99";
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelBPrice() throws Exception {
        //given
        String correctParcelPrice = "PLN 13.99";
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        formPage.clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelCPrice() throws Exception {
        // given
        String correctParcelPrice = "PLN 15.49";
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String desiredErrorMessage = "INCORRECT E-MAIL ADDRESS";
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
        String desiredErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        receiverForm.fillReceiverEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, receiverForm.emailErrorMessage().getText());
    }

    @Test
    public void shouldThrowErrorForBadSenderEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String desiredErrorMessage = "INCORRECT E-MAIL ADDRESS";
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
        String desiredErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
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
        String desiredText = "Company in Poland";
        String errorMessage = "";

        // when
        senderForm.clickInvoice();

        // then
        Assert.assertEquals(errorMessage, desiredText, senderForm.checkInInvoiceWasClicked().getText());
    }



    @Test
    public void shouldOpenParcelMap() throws Exception {
        // given
        String desiredModalHeader = "Parcel locker or Parcel Point where your shipment will be delivered";
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
        String desiredErrorMessage = "REQUIRED FIELD";
        String errorMessage = "";

        // when
        fillFormAllData();
        formPage.clickTermsCheckboxEngish();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, formPage.getTermsErrorEnglish().getText());
    }
}
