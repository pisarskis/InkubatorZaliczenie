package English.primary.APM;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("en")
public class TestApmFormSummaryEng extends Base {

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        Base.getFormPage().closeCookiesPopup();
        Base.getFormPage().closeBottomCookiesPopup();
        Base.getFormPage().clickLanguageSelector();
        Base.getFormPage().closeCookiesPopup();
    }

    @Before
    public void apmSummarySetUp() throws InterruptedException {
        formRunThrough();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        Base.getWaitPage().waitLong();
        Base.getFormPage().closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {
        Base.getFormPage().chooseDeliveryToAPM();
        Base.fillAPMFormData();
        Base.getFormPage().clickTermsCheckboxEngish();
        Base.getFormPage().clickNewsletterCheckbox();
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeAInSummary() throws Exception {
        // given
        String expectedParcelSize = "Small";

        // when
        Base.getFormPage().clickA();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(expectedParcelSize, Base.getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeBInSummary() throws Exception {
        // given
        String expectedParcelSize = "Medium";

        // when
        Base.getFormPage().clickB();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(expectedParcelSize, Base.getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeCInSummary() throws Exception {
        // given
        String expectedParcelSize = "Large";

        // when
        Base.getFormPage().clickC();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(expectedParcelSize, Base.getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelAImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickA();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage,Base.getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelBImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickB();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage,Base.getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelCImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickC();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage,Base.getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelAPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.APM_A_EN.getPrice();

        // when
        Base.getFormPage().clickA();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(expectedParcelPrice, Base.getSummaryPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelBPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.APM_B_EN.getPrice();

        // when
        Base.getFormPage().clickB();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(expectedParcelPrice, Base.getSummaryPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelCPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.APM_C_EN.getPrice();

        // when
        Base.getFormPage().clickC();
        Base.getFormPage().clickSendButton();

        // then
        Assert.assertEquals(expectedParcelPrice, Base.getSummaryPage().getParcelPrice().getText());
    }
}
