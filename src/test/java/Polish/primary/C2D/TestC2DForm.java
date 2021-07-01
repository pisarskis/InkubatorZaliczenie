package Polish.primary.C2D;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestC2DForm extends Base {

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
    }

    @Before
    public void setUpBeforeEach() throws InterruptedException {
        getFormPage().chooseDeliveryC2D();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectSizeForAParcel() {
        // given
        String parcelASize = "mała";

        // when
        getFormPage().clickA();
        String returnedSize = getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectSizeForBParcel() {
        // given
        String parcelBSize = "średnia";

        // when
        getFormPage().clickB();
        String returnedSize = getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBSize;

        // then
        Assert.assertEquals(errorMessage, parcelBSize, returnedSize);
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectSizeForCParcel() {
        // given
        String parcelCSize = "duża";

        // when
        getFormPage().clickC();
        String returnedSize = getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;


        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelADimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                "8 x 38 x 64 cm\n" +
                "do 25 kg";

        // when
        getFormPage().clickA();

        // then
        Assert.assertEquals(parcelADimensions, getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelBDimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                "19 x 38 x 64 cm\n" +
                "do 25 kg";

        // when
        getFormPage().clickB();

        // then
        Assert.assertEquals(parcelADimensions, getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelCDimensions() {
        // given
        String parcelADimensions = "max. wymiar\n" +
                "41 x 38 x 64 cm\n" +
                "do 25 kg";

        // when
        getFormPage().clickC();

        // then
        Assert.assertEquals(parcelADimensions, getFormPage().getParcelDimensions().getText());
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelAImg() {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickA();

        // then
        Assert.assertTrue( errorMessage,getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelBImg() {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickB();

        // then
        Assert.assertTrue( errorMessage,getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    public void shouldReturnCorrectParcelCImg() {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        getFormPage().clickC();

        // then
        Assert.assertTrue( errorMessage,getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldReturnCorrectParcelAPrice() {
        // given
        String correctParcelPrice = Prices.C2D_A_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldReturnCorrectParcelBPrice() {
        //given
        String correctParcelPrice = Prices.C2D_B_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        getFormPage().clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldReturnCorrectParcelCPrice() {
        // given
        String correctParcelPrice = Prices.C2D_C_PL.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        getFormPage().clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        String email = "foo.pl";
        String expectedErrorMessage = "NIEPRAWIDŁOWY ADRES EMAIL";
        String errorMessage = "";

        // when
        getReceiverForm().fillReceiverEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        getReceiverForm().fillReceiverEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForBadSenderEmail() throws Exception {
        // given
        String email = "bar.pl";
        String expectedErrorMessage = "NIEPRAWIDŁOWY ADRES EMAIL";
        String errorMessage = "";

        // when
        getSenderForm().fillSenderEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getSenderForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("pl")
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "WARTOŚĆ JEST ZA KRÓTKA. POWINNA MIEĆ 4 ZNAKI LUB WIĘCEJ";
        String errorMessage = "";

        // when
        getSenderForm().fillSenderEmail(email);
        getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, getSenderForm().emailErrorMessage().getText());
    }
}