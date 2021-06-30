package English.primary.APM;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("en")
public class TestApmFormSummaryEng extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static TestApmFormEng apmTest;
    private static SummaryPage summaryPage;


    @BeforeClass
    public static void closeAllCookies() throws Exception {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        apmTest = new TestApmFormEng();
        summaryPage = new SummaryPage();
        waitPage = new WaitPage();

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
        formPage.chooseDeliveryToAPM();
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
    public void shouldShowCorrectParcelSizeAInSummary() throws Exception {
        // given
        String expectedParcelSize = "Small";

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(expectedParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeBInSummary() throws Exception {
        // given
        String expectedParcelSize = "Medium";

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(expectedParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeCInSummary() throws Exception {
        // given
        String expectedParcelSize = "Large";

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(expectedParcelSize, summaryPage.getParcelSize().getText());
    }

    @Test
    @Tag("en")
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
    @Tag("en")
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
    @Tag("en")
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
    @Tag("en")
    public void shouldShowCorrectParcelAPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.APM_A_EN.getPrice();

        // when
        formPage.clickA();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(expectedParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelBPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.APM_B_EN.getPrice();

        // when
        formPage.clickB();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(expectedParcelPrice, summaryPage.getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelCPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.APM_C_EN.getPrice();

        // when
        formPage.clickC();
        formPage.clickSendButton();

        // then
        Assert.assertEquals(expectedParcelPrice, summaryPage.getParcelPrice().getText());
    }
}
