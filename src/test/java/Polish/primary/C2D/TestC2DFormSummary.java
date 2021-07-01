package Polish.primary.C2D;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;
import Polish.primary.APM.TestApmForm;

@Tag("pl")
public class TestC2DFormSummary extends Base {

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
    }

    @Before
    public void apmSummarySetUp() throws InterruptedException {
        formRunThrough();
    }

    @After
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {
        getFormPage().chooseDeliveryC2D();
        fillC2DFormData();
        getFormPage().clickTermsCheckbox();
        getFormPage().clickNewsletterCheckbox();
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectParcelSizeAInSummary() throws Exception {
        // given
        String expectedParcelSize = "Mała";
        String errorMessage = "";

        // when
        getFormPage().clickA();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelSize, getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectParcelSizeBInSummary() throws Exception {
        // given
        String expectedParcelSize = "Średnia";
        String errorMessage = "";

        // when
        getFormPage().clickB();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelSize, getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectParcelSizeCInSummary() throws Exception {
        // given
        String expectedParcelSize = "Duża";
        String errorMessage = "";

        // when
        getFormPage().clickC();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelSize, getSummaryPage().getParcelSize().getText());
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectParcelAImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickA();
        getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage,getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectParcelBImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickB();
        getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage,getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectParcelCImgInSummary() throws Exception {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickC();
        getFormPage().clickSendButton();

        // then
        Assert.assertTrue( errorMessage,getSummaryPage().getParcelImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldShowCorrectParcelAPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.C2D_A_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickA();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getSummaryPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldShowCorrectParcelBPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.C2D_B_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickB();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getSummaryPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldShowCorrectParcelCPriceInSummary() throws Exception {
        // given
        String expectedParcelPrice = Prices.C2D_C_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickC();
        getFormPage().clickSendButton();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getSummaryPage().getParcelPrice().getText());
    }
}
