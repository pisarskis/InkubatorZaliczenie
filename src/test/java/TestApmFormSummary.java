import helper.ActionPage;
import helper.WaitPage;
import org.junit.*;
import pages.*;

public class TestApmFormSummary extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static TestApm apmTest;
    private static SummaryPage summaryPage;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        apmTest = new TestApm();
        summaryPage = new SummaryPage();
        waitPage = new WaitPage();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
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

    private static void formRunThrough() throws InterruptedException {
        String receiverName = "qweqwe";
        String receiverEmail = "qwe@qwe.pl";
        String receiverPhoneNo = "666999666";
        String apmNo = "PAW04A";
        String senderName = "qweqwqwe";
        String senderEmail = "qweqwe@qwe.pl";
        String senderPhoneNo = "666777666";

        formPage.chooseDeliveryToAPM();
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
        String desiredParcelPrice = "12,99 zł";
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
        String desiredParcelPrice = "13,99 zł";
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
        String desiredParcelPrice = "15,49 zł";
        String errorMessage = "";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(errorMessage, desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }
}
