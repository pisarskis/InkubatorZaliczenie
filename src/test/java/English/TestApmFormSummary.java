package English;

import helper.FormDataFactory;
import helper.WaitPage;
import org.junit.*;
import pages.*;

public class TestApmFormSummary extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static TestApmForm apmTest;
    private static SummaryPage summaryPage;
    private static FormDataFactory formDataFactory;

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        apmTest = new TestApmForm();
        summaryPage = new SummaryPage();
        waitPage = new WaitPage();
        formDataFactory = new FormDataFactory();

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

    private static void formRunThrough() throws InterruptedException {
        formPage.chooseDeliveryToAPM();
        receiverForm.fillReceiverName(formDataFactory.getReceiverName());
        receiverForm.fillReceiverEmail(formDataFactory.getReceiverEmail());
        receiverForm.fillReceiverNumber(formDataFactory.getReceiverEmail());
        receiverForm.fillReceiverAPMCode(formDataFactory.getParcelBoxNo());
        senderForm.fillSenderName(formDataFactory.getSenderName());
        senderForm.fillSenderEmail(formDataFactory.getSenderEmail());
        senderForm.fillSenderNumber(formDataFactory.getSenderPhoneNo());
        formPage.clickTermsCheckboxEngish();
        formPage.clickNewsletterCheckbox();
    }

    @Test
    public void shouldShowCorrectParcelSizeAInSummary() throws Exception {
        // given
        String desiredParcelSize = "Small";

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(desiredParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    public void shouldShowCorrectParcelSizeBInSummary() throws Exception {
        // given
        String desiredParcelSize = "Medium";

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(desiredParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    public void shouldShowCorrectParcelSizeCInSummary() throws Exception {
        // given
        String desiredParcelSize = "Large";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(desiredParcelSize, summaryPage.getParcelSize().getText());
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
        String desiredParcelPrice = "PLN 12.99";

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelBPriceInSummary() throws Exception {
        // given
        String desiredParcelPrice = "PLN 13.99";

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    public void shouldShowCorrectParcelCPriceInSummary() throws Exception {
        // given
        String desiredParcelPrice = "PLN 15.49";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(desiredParcelPrice, summaryPage.getParcelPrice().getText());
    }
}
