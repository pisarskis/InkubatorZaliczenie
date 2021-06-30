package English.secondary;

import helper.FormDataFactory;
import helper.Prices;
import helper.WaitPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestC2DFormStatic extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static ParcelTiles parcelTiles;
    private static FormDataFactory formDataFactory;

    private static List<WebElement> linkList;
    private static List<String> cleanLinkList;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        parcelTiles = new ParcelTiles();
        formDataFactory = new FormDataFactory();

        linkList = new ArrayList<WebElement>();
        cleanLinkList = new ArrayList<String>();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formPage.clickLanguageSelector();
        formPage.closeCookiesPopup();
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

    public List<String> pullUpAllLinks(){
        linkList = driver.findElements(By.tagName("a"));

        for(WebElement link:linkList){
            cleanLinkList.add(link.getAttribute("href"));
        }

        while (cleanLinkList.remove(null)){}

        return cleanLinkList;
    }

    @Test
    public void shouldReturnCorrectTileADimensions() {
        // given
        String parcelADimensions = "max. 8 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelATileDimensions().getText());
    }

    @Test
    public void shouldReturnCorrectTileBDimensions() {
        // given
        String parcelADimensions = "max. 19 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelBTileDimensions().getText());
    }

    @Test
    public void shouldReturnCorrectTileCDimensions() {
        // given
        String parcelADimensions = "max. 41 x 38 x 64 cm\n" +
                "up to 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelCTileDimensions().getText());
    }

    @Test
    public void shouldReturnCorrectTileAImg() {
        // given
        String imgSize = "20351";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage, parcelTiles.getParcelATileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectTileBImg() {
        // given
        String imgSize = "20350";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage, parcelTiles.getParcelBTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectTileCImg() {
        // given
        String imgSize = "20349";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage, parcelTiles.getParcelCTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectTileAPrice() {
        // given
        String correctParcelPrice = Prices.C2D_A_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelATilePrice().getText());
    }

    @Test
    public void shouldReturnCorrectTileBPrice() {
        //given
        String correctParcelPrice = Prices.C2D_B_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelBTilePrice().getText());
    }

    @Test
    public void shouldReturnCorrectTileCPrice() {
        // given
        String correctParcelPrice = Prices.C2D_C_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelCTilePrice().getText());
    }

    @Test
    public void shouldPrintCorrectHTSModalTitle() throws Exception {
        // given
        String desiredTitle = "How to send the parcel?";
        String errorMessage = "";

        // when
        formPage.clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, desiredTitle, formPage.getModalTitle().getText());

        refreshPage();
    }
}
