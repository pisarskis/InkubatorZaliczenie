import helper.ActionPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

public class ApmTest extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;


    @BeforeClass
    public static void closeAllCookies() throws InterruptedException {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Test
    public void clikAPMCheckbox() throws Exception {
        formPage.chooseDeliveryToAPM();
    }

    @Test
    public void clikParcelSizeA() throws Exception {
        formPage.clickA();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void clikParcelSizeB() throws Exception {
        formPage.clickB();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void clikParcelSizeC() throws Exception {
        formPage.clickC();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void fillReceiverName() throws Exception {
        String receiverName = "Szymon Pisarski";
        receiverForm.fillReceiverName(receiverName);
    }

    @Test
    public void fillReceiverEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        receiverForm.fillReceiverEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    @Test
    public void fillReceiverNumber() throws Exception {
        String receiverPhoneNo = "666999666";
        receiverForm.fillReceiverNumber(receiverPhoneNo);
        // todo zrobić weryfikacja porawności numeru?
    }

    @Test
    public void fillReceiverAPM() throws Exception {
//        String apmNo = "PJ11A";
        String apmNo = "PAW04A";
        receiverForm.fillReceiverAPMCode(apmNo);
    }

    @Test
    public void fillSenderName() throws Exception {
        String name = "Szymon Pisarski";
        senderForm.fillSenderName(name);
    }

    @Test
    public void fillSenderEmail() throws Exception {
        String senderEmail = "spiarski@inpost.pl";
        senderForm.fillSenderEmail(senderEmail);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    @Test
    public void fillSenderNumber() throws Exception {
        String email = "666999666";
        senderForm.fillSenderNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    @Test
    public void clickInvoiceCheckbox() throws Exception {
        senderForm.clickInvoice();
    }

    @Test
    public void clickPolishCompanyCheckbox() throws Exception {
        senderForm.clickPlishCompanyCheckbox();
    }

    @Test
    public void clickLegalStatusIndividualCheckbox() throws Exception {
        senderForm.clickLegalStatusIndividualCheckbox();
    }

    @Test
    public void clickForeignCompanyCheckbox() throws Exception {
        senderForm.clickForeignCompanyCheckbox();
    }

    @Test
    public void clickTermsCheckbox() throws Exception {
        formPage.clickTermsCheckbox();
    }

    @Test
    public void clickNewsletterCheckbox() throws Exception {
        formPage.clickNewsletterCheckbox();
    }

    @Test
    public void clickSendButton() throws Exception {
        clikAPMCheckbox();
        clikParcelSizeA();
        fillReceiverName();
        fillReceiverEmail();
        fillReceiverNumber();
        fillReceiverAPM();
        fillSenderName();
        fillSenderEmail();
        fillSenderNumber();
        clickTermsCheckbox();
        clickNewsletterCheckbox();

        formPage.clickSendButton();
    }

    @Test
    public void shouldReturnCorrectSizeForAParcel() throws Exception {
        // given
        String parcelASize = "mała";
        String returnedSize = formPage.checkParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // when
        clikParcelSizeA();

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
        clikParcelSizeB();

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
        clikParcelSizeC();

        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    public void shouldReturnCorrectParcelAImg() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        clikParcelSizeA();

        // then
        Assert.assertTrue( errorMessage,formPage.checkParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelBImg() throws Exception {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        clikParcelSizeB();

        // then
        Assert.assertTrue( errorMessage,formPage.checkParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelCImg() throws Exception {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        clikParcelSizeC();

        // then
        Assert.assertTrue( errorMessage,formPage.checkParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectParcelAPrice() throws Exception {
        // given
        String correctParcelPrice = "12,99 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        clikAPMCheckbox();
        clikParcelSizeA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.checkParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelBPrice() throws Exception {
        //given
        String correctParcelPrice = "13,99 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        clikAPMCheckbox();
        clikParcelSizeB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.checkParcelPrice().getText());
    }

    @Test
    public void shouldReturnCorrectParcelCPrice() throws Exception {
        // given
        String correctParcelPrice = "15,49 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        clikAPMCheckbox();
        clikParcelSizeC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, formPage.checkParcelPrice().getText());
    }
}
