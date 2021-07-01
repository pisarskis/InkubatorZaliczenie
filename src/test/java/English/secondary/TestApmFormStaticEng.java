package English.secondary;

import helper.Prices;
import helper.WaitPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class TestApmFormStaticEng extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static ParcelTiles parcelTiles;

    private static List<WebElement> linkList;
    private static List<String> cleanLinkList;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        parcelTiles = new ParcelTiles();

        linkList = new ArrayList<WebElement>();
        cleanLinkList = new ArrayList<String>();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formPage.clickLanguageSelector();
        formPage.closeCookiesPopup();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectHTSModalTitle() throws Exception {
        // given
        String expectedTitle = "How to send the parcel?";

        // when
        formPage.clickHowToSendParcel();

        // then
        Assert.assertEquals(expectedTitle, formPage.getModalTitle().getText());

        refreshPage();
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileADimensions() {
        // given
        String parcelADimensions = "max. 8 x 38 x 64 cm\n" +
                                   "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelATileDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileBDimensions() {
        // given
        String parcelADimensions = "max. 19 x 38 x 64 cm\n" +
                                   "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelBTileDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileCDimensions() {
        // given
        String parcelADimensions = "max. 41 x 38 x 64 cm\n" +
                                   "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelCTileDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileAImg() {
        // given
        String imgSize = "20351";

        // when

        // then
        Assert.assertTrue(parcelTiles.getParcelATileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileBImg() {
        // given
        String imgSize = "20350";

        // when

        // then
        Assert.assertTrue(parcelTiles.getParcelBTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileCImg() {
        // given
        String imgSize = "20349";

        // when

        // then
        Assert.assertTrue(parcelTiles.getParcelCTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileAPrice() {
        // given
        String correctParcelPrice = Prices.APM_A_EN.getPrice();

        // when

        // then
        Assert.assertEquals(correctParcelPrice, parcelTiles.getParcelATilePrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileBPrice() {
        //given
        String correctParcelPrice = Prices.APM_B_EN.getPrice();

        //when

        //then
        Assert.assertEquals(correctParcelPrice, parcelTiles.getParcelBTilePrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileCPrice() {
        // given
        String correctParcelPrice = Prices.APM_C_EN.getPrice();

        // when

        // then
        Assert.assertEquals(correctParcelPrice, parcelTiles.getParcelCTilePrice().getText());
    }
}
