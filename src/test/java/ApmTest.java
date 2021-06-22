import helper.ActionPage;
import helper.WaitPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

public class ApmTest extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;


    @BeforeClass
    public static void closeAllCookies() throws InterruptedException {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitPage.waitShort();
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
    public void shouldReturnCorrectSizeForAParcel() throws Exception {
        // given
        String parcelASize = "mała";
        String returnedSize = formPage.checkParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickA();

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectSizeForBParcel() throws Exception {
        // given
        String parcelBize = "średnia";
        String returnedSize = formPage.checkParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBize;

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickB();

        // then
        Assert.assertEquals(errorMessage, parcelBize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectSizeForCParcel() throws Exception {
        // given
        String parcelCSize = "duża";
        String returnedSize = formPage.checkParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;

        // when
        formPage.chooseDeliveryToAPM();
        formPage.clickC();

        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectParcelAImg() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.chooseDeliveryToAPM();
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
        formPage.chooseDeliveryToAPM();
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
        formPage.chooseDeliveryToAPM();
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
        formPage.chooseDeliveryToAPM();
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
        formPage.chooseDeliveryToAPM();
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
        formPage.chooseDeliveryToAPM();
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
        formPage.chooseDeliveryToAPM();
        receiverForm.fillReceiverEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, receiverForm.emailErrorMessage().getText());
        refreshPage();
    }

    @Test
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        String email = "q";
        String desiredErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        receiverForm.fillReceiverEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, receiverForm.emailErrorMessage().getText());
        refreshPage();
    }

    @Test
    public void shouldThrowErrorBadSenderEmail() throws Exception {
        // given
        String email = "qweqwe.pl";
        String desiredErrorMessage = "NIEPRAWIDŁOWY ADRES EMAIL";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        senderForm.fillSenderEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, senderForm.emailErrorMessage().getText());
        refreshPage();
    }

    @Test
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        String email = "q";
        String desiredErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        formPage.chooseDeliveryToAPM();
        senderForm.fillSenderEmail(email);
        formPage.chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, desiredErrorMessage, senderForm.emailErrorMessage().getText());
        refreshPage();
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
        refreshPage();
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
        Assert.assertEquals(errorMessage, desiredText, senderForm.checkPolishCompanyName().getText());
        refreshPage();
    }

    @Test
    public void shouldPrintNameWhenIndividualIsChosen() throws Exception {
        // given
        String errorMessage = "";

        // when
        fillFormAllData();
        fillIndividualInvoiceData();
        formPage.clickSendButton();

        // then
//        Assert.assertEquals(errorMessage, name, senderForm.checkPolishCompanyName().getText());
        refreshPage();

    }
}

