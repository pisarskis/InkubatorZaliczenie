package English.primary.C2D;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("en")
public class TestC2DFormSummaryEng extends Base {

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
        getFormPage().clickLanguageSelector();
        getFormPage().closeCookiesPopup();
    }

    @Before
    public void apmSummarySetUp() throws InterruptedException {
        formRunThrough();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {
        getFormPage().chooseDeliveryC2D();
        fillC2DFormData();
        getFormPage().clickTermsCheckboxEngish();
        getFormPage().clickNewsletterCheckbox();
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeAInSummary() throws Exception {
        // given
        String expectedParcelSize = "Small";
        String errorMessage = "";

        // when
        getFormPage().clickA();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelSize, getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeBInSummary() throws Exception {
        // given
        String expectedParcelSize = "Medium";
        String errorMessage = "";

        // when
        getFormPage().clickB();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelSize, getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelSizeCInSummary() throws Exception {
        // given
        String expectedParcelSize = "Large";
        String errorMessage = "";

        // when
        getFormPage().clickC();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelSize, getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelAImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickA();
        getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage, getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelBImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickB();
        getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage, getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelCImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickC();
        getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage, getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelAPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.C2D_A_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickA();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getSummaryPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelBPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.C2D_B_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickB();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getSummaryPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldShowCorrectParcelCPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.C2D_C_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickC();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getSummaryPage().getParcelPrice().getText());
    }
}
