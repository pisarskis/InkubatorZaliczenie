package English.primary.C2D;

import helper.Prices;
import helper.WaitPage;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;

@Tag("en")
public class TestC2DFormEng extends Base {

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        Base.getFormPage().closeCookiesPopup();
        Base.getFormPage().closeBottomCookiesPopup();
        Base.getFormPage().clickLanguageSelector();
        Base.getFormPage().closeCookiesPopup();
    }

    @Before
    public void setUpBeforeEach() throws InterruptedException {
        Base.getFormPage().chooseDeliveryC2D();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        Base.getWaitPage().waitLong();
        Base.getFormPage().closeCookiesPopup();
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForAParcel() {
        // given
        String parcelASize = "small";

        // when
        Base.getFormPage().clickA();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelASize;

        // then
        Assert.assertEquals(errorMessage, parcelASize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForBParcel() {
        // given
        String parcelBSize = "medium";

        // when
        Base.getFormPage().clickB();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelBSize;

        // then
        Assert.assertEquals(errorMessage, parcelBSize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectSizeForCParcel() {
        // given
        String parcelCSize = "large";

        // when
        Base.getFormPage().clickC();
        String returnedSize = Base.getFormPage().getParcelSizeText().getText().toLowerCase();
        String errorMessage = "The size text in summary is printed wrong. Is: " + returnedSize + " should be: " + parcelCSize;


        // then
        Assert.assertEquals(errorMessage, parcelCSize, returnedSize);
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAImg() {
        // given
        String imgSize = "parcel_A";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBImg() {
        // given
        String imgSize = "parcel_B";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickB();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCImg() {
        // given
        String imgSize = "parcel_C";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertTrue( errorMessage,Base.getFormPage().getParcelSizeImg().getAttribute("src").contains(imgSize));
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelAPrice() {
        // given
        String correctParcelPrice = Prices.C2D_A_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        Base.getFormPage().clickA();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelBPrice() {
        //given
        String correctParcelPrice = Prices.C2D_B_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        //when
        Base.getFormPage().clickB();

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldReturnCorrectParcelCPrice() {
        // given
        String correctParcelPrice = Prices.C2D_C_EN.getPrice();
        String errorMessage = "Wrong price for parcel of this size.";

        // when
        Base.getFormPage().clickC();

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, Base.getFormPage().getParcelPrice().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadReceiverEmail() throws Exception {
        // given
        String email = "foo.pl";
        String expectedErrorMessage = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        Base.getReceiverForm().fillReceiverEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortReceiverEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        Base.getReceiverForm().fillReceiverEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getReceiverForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForBadSenderEmail() throws Exception {
        // given
        String email = "bar.pl";
        String expectedErrorMessage = "INCORRECT E-MAIL ADDRESS";
        String errorMessage = "";

        // when
        Base.getSenderForm().fillSenderEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getSenderForm().emailErrorMessage().getText());
    }

    @Test
    @Tag("en")
    public void shouldThrowErrorForShortSenderEmail() throws Exception {
        // given
        String email = "q";
        String expectedErrorMessage = "THE VALUE IS TOO SHORT. IT SHOULD BE 4 CHARACTERS LONG OR LONGER.";
        String errorMessage = "";

        // when
        Base.getSenderForm().fillSenderEmail(email);
        Base.getFormPage().chooseDeliveryToAPM();

        // then
        Assert.assertEquals(errorMessage, expectedErrorMessage, Base.getSenderForm().emailErrorMessage().getText());
    }
}