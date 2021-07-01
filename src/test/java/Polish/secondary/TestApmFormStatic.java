package Polish.secondary;

import helper.Prices;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestApmFormStatic extends Base {

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
    }

    @After
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return corret tile dimensions for Parcel size A")
    public void shouldReturnCorrectTileADimensions() {
        // given
        String parcelADimensions = "max.\n" +
                "8 x 38 x 64 cm\n" +
                "do 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, getParcelTiles().getParcelATileDimensions().getText());
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile dimensions for Parcel size B")
    public void shouldReturnCorrectTileBDimensions() {
        // given
        String parcelADimensions = "max.\n" +
                "19 x 38 x 64 cm\n" +
                "do 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, getParcelTiles().getParcelBTileDimensions().getText());
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile dimensions for Parcel size C")
    public void shouldReturnCorrectTileCDimensions() {
        // given
        String parcelADimensions = "max.\n" +
                "41 x 38 x 64 cm\n" +
                "do 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, getParcelTiles().getParcelCTileDimensions().getText());
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile image for Parcel size A")
    public void shouldReturnCorrectTileAImg() {
        // given
        String imgSize = "20351";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue(errorMessage, getParcelTiles().getParcelATileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile image for Parcel size B")
    public void shouldReturnCorrectTileBImg() {
        // given
        String imgSize = "20350";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue(errorMessage, getParcelTiles().getParcelBTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile image for Parcel size C")
    public void shouldReturnCorrectTileCImg() {
        // given
        String imgSize = "20349";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue(errorMessage, getParcelTiles().getParcelCTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile price for Parcel size A")
    public void shouldReturnCorrectTileAPrice() {
        // given
        String correctParcelPrice = Prices.APM_A_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, getParcelTiles().getParcelATilePrice().getText());
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile price for Parcel size B")
    public void shouldReturnCorrectTileBPrice() {
        //given
        String correctParcelPrice = Prices.APM_B_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, getParcelTiles().getParcelBTilePrice().getText());
    }

    @Test
    @Tag("pl")
    @DisplayName("Should return correct tile price for Parcel size C")
    public void shouldReturnCorrectTileCPrice() {
        // given
        String correctParcelPrice = Prices.APM_C_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, getParcelTiles().getParcelCTilePrice().getText());
    }
}
