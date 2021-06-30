package English.primary.C2D;

import English.primary.APM.TestApmForm;
import helper.*;
import org.junit.*;
import pages.*;

public class TestC2DFormSummary extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static PaymentPage paymentPage;
    private static TestApmForm apmTest;
    private static SummaryPage summaryPage;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        paymentPage = new PaymentPage();
        apmTest = new TestApmForm();
        summaryPage = new SummaryPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formPage.clickLanguageSelector();
        formPage.closeCookiesPopup();
    }

    @Before
    public void apmSummarySetUp() throws InterruptedException {
        formRunThrough();
    }

    @After
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {
        formPage.chooseDeliveryC2D();
        fillC2DFormData();
        formPage.clickTermsCheckboxEngish();
        formPage.clickNewsletterCheckbox();
    }

    public void fillC2DFormData() throws InterruptedException {
        receiverForm.fillReceiverName(ReceiverFormData.NAME.getValue());
        receiverForm.fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        receiverForm.fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        receiverForm.fillReceiverZipCode(ReceiverFormData.ZIPCODE.getValue());
        receiverForm.fillReceiverTown(ReceiverFormData.TOWN.getValue());
        receiverForm.fillReceiverStreet(ReceiverFormData.STREET.getValue());
        receiverForm.fillReceiverStreetNo(ReceiverFormData.STREETNO.getValue());
        receiverForm.fillReceiverFlatNo(ReceiverFormData.FLATNO.getValue());
        senderForm.fillSenderName(SenderFormData.NAME.getValue());
        senderForm.fillSenderEmail(SenderFormData.EMAIL.getValue());
        senderForm.fillSenderNumber(SenderFormData.PHONENO.getValue());
    }

    @Test
    public void shouldShowCorrectParcelSizeAInSummary() throws Exception {
        // given
        String desiredParcelSize = "Small";
        String errorMessage = "";

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    public void shouldShowCorrectParcelSizeBInSummary() throws Exception {
        // given
        String desiredParcelSize = "Medium";
        String errorMessage = "";

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    public void shouldShowCorrectParcelSizeCInSummary() throws Exception {
        // given
        String desiredParcelSize = "Large";
        String errorMessage = "";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    public void shouldShowCorrectParcelAImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertTrue( errorMessage,summaryPage.getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldShowCorrectParcelBImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertTrue( errorMessage,summaryPage.getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldShowCorrectParcelCImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertTrue( errorMessage,summaryPage.getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldShowCorrectParcelAPriceInSummary() throws Exception {
        // given
        String desiredParcelPrice = Prices.C2D_A_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelBPriceInSummary() throws Exception {
        // given
        String desiredParcelPrice = Prices.C2D_B_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelCPriceInSummary() throws Exception {
        // given
        String desiredParcelPrice = Prices.C2D_C_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }
}
