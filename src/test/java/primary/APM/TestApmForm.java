package primary.APM;

import helper.*;
import org.junit.*;
import pages.*;

public class TestApmForm extends Base {
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
        formPage.clickTermsCheckbox();
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
    public void shouldReturnCorrectSizeForAParcel() {
        // given
        String parcelASize = "mała";

        // when
        formPage.clickA();
        String returnedSize = formPage.getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectSizeForBParcel() {
        // given
        String parcelBSize = "średnia";

        // when
        formPage.clickB();
        String returnedSize = formPage.getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBSize;

        // then
        Assert.assertEquals(errorMessage, parcelBSize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectSizeForCParcel() {
        // given
        String parcelCSize = "duża";

        // when
        formPage.clickC();
        String returnedSize = formPage.getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;


        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectParcelADimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                                   "8 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when
        formPage.clickA();

        // then
        Assert.assertEquals(parcelADimensions, formPage.getParcelDimensions().getText());
    }

    @Test
    public void shouldReturnCorrectParcelBDimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                                   "19 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when
        formPage.clickB();

        // then
        Assert.assertEquals(parcelADimensions, formPage.getParcelDimensions().getText());
    }

    @Test
    public void shouldReturnCorrectParcelCDimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                                   "41 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when
        formPage.clickC();

        // then
        Assert.assertEquals(parcelADimensions, formPage.getParcelDimensions().getText());
    }

    @Test
    public void shouldReturnCorrectParcelAImg() {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickA();

        // then
        Assert.assertTrue( errorMessage,formPage.getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelBImg() {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickB();

        // then
        Assert.assertTrue( errorMessage,formPage.getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelCImg() {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickC();

        // then
        Assert.assertTrue( errorMessage,formPage.getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelAPrice() {
        // given
        String correctParcelPrice = Prices.APM_A_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelBPrice() {
        //given
        String correctParcelPrice = Prices.APM_B_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        formPage.clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelCPrice() {
        // given
        String correctParcelPrice = Prices.APM_C_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.getParcelPrice().getText());
    }

    @Test
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        String email = "foo.pl";
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
        String email = "foo";
        String desiredErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
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
        String email = "foo.pl";
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
        String email = "foo";
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
        Assert.assertEquals(errorMessage, desiredErrorMessage, formPage.getTermsError().getText());
    }
}
