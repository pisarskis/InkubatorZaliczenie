package English.secondary;

import helper.Prices;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class TestApmFormStaticEng extends Base {
    private static List<WebElement> linkList;
    private static List<String> cleanLinkList;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        linkList = new ArrayList<WebElement>();
        cleanLinkList = new ArrayList<String>();

        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
        getFormPage().clickLanguageSelector();
        getFormPage().closeCookiesPopup();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectHTSModalTitle() throws Exception {
        // given
        String expectedTitle = "How to send the parcel?";

        // when
        getFormPage().clickHowToSendParcel();

        // then
        Assert.assertEquals(expectedTitle, getFormPage().getModalTitle().getText());

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
        Assert.assertEquals(parcelADimensions, getParcelTiles().getParcelATileDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileBDimensions() {
        // given
        String parcelADimensions = "max. 19 x 38 x 64 cm\n" +
                                   "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, getParcelTiles().getParcelBTileDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileCDimensions() {
        // given
        String parcelADimensions = "max. 41 x 38 x 64 cm\n" +
                                   "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, getParcelTiles().getParcelCTileDimensions().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileAImg() {
        // given
        String imgSize = "20351";

        // when

        // then
        Assert.assertTrue(getParcelTiles().getParcelATileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileBImg() {
        // given
        String imgSize = "20350";

        // when

        // then
        Assert.assertTrue(getParcelTiles().getParcelBTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileCImg() {
        // given
        String imgSize = "20349";

        // when

        // then
        Assert.assertTrue(getParcelTiles().getParcelCTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileAPrice() {
        // given
        String correctParcelPrice = Prices.APM_A_EN.getPrice();

        // when

        // then
        Assert.assertEquals(correctParcelPrice, getParcelTiles().getParcelATilePrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileBPrice() {
        //given
        String correctParcelPrice = Prices.APM_B_EN.getPrice();

        //when

        //then
        Assert.assertEquals(correctParcelPrice, getParcelTiles().getParcelBTilePrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectTileCPrice() {
        // given
        String correctParcelPrice = Prices.APM_C_EN.getPrice();

        // when

        // then
        Assert.assertEquals(correctParcelPrice, getParcelTiles().getParcelCTilePrice().getText());
    }
}
