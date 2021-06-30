package secondary;

import helper.Prices;
import helper.WaitPage;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag("pl")
public class TestC2DFormStatic extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static ParcelTiles parcelTiles;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        parcelTiles = new ParcelTiles();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Before
    public void setUpForm() throws InterruptedException {
        formPage.chooseDeliveryC2D();
    }

    @After
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileADimensions() {
        // given
        String parcelADimensions =  "max.\n" +
                                    "8 x 38 x 64 cm\n" +
                                    "do 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelATileDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileBDimensions() {
        // given
        String parcelADimensions = "max.\n" +
                                   "19 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelBTileDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileCDimensions() {
        // given
        String parcelADimensions = "max.\n" +
                                   "41 x 38 x 64 cm\n" +
                                   "do 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelCTileDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileAImg() {
        // given
        String imgSize = "20351";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage, parcelTiles.getParcelATileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileBImg() {
        // given
        String imgSize = "20350";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage, parcelTiles.getParcelBTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileCImg() {
        // given
        String imgSize = "20349";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage, parcelTiles.getParcelCTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileAPrice() {
        // given
        String correctParcelPrice = Prices.C2D_A_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelATilePrice().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileBPrice() {
        //given
        String correctParcelPrice = Prices.C2D_B_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelBTilePrice().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectTileCPrice() {
        // given
        String correctParcelPrice = Prices.C2D_C_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelCTilePrice().getText());
    }
}
