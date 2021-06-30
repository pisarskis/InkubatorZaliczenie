package primary.APM;

import helper.*;
import org.junit.*;
import pages.*;

public class TestApmFormSummary extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static TestApmForm apmTest;
    private static SummaryPage summaryPage;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        apmTest = new TestApmForm();
        summaryPage = new SummaryPage();
        waitPage = new WaitPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Before
    public void formRunThrough() throws InterruptedException {
        formPage.chooseDeliveryToAPM();
        fillAPMFormData();
        formPage.clickTermsCheckbox();
        formPage.clickNewsletterCheckbox();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        waitPage.waitShort();
        formPage.closeCookiesPopup();
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
    public void shouldShowCorrectParcelSizeAInSummary() throws Exception {
        // given
        String desiredParcelSize = "Mała";
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
        String desiredParcelSize = "Średnia";
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
        String desiredParcelSize = "Duża";
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
        String desiredParcelPrice = Prices.APM_A_PL.getPrice();
        String errorMessage = "";

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelBPriceInSummary() throws Exception {
        // given
        String desiredParcelPrice = Prices.APM_B_PL.getPrice();
        String errorMessage = "";

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelCPriceInSummary() throws Exception {
        // given
        String desiredParcelPrice = Prices.APM_C_PL.getPrice();
        String errorMessage = "";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }
}
