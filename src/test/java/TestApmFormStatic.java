import helper.WaitPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestApmFormStatic extends Base {
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
        String parcelADimensions = "max.\n" +
                "8 x 38 x 64 cm\n" +
                "do 25 kg";

        // when

        // then
        Assert.assertEquals(parcelADimensions, parcelTiles.getParcelATileDimensions().getText());
    }

    @Test
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
    public void shouldReturnCorrectTileAImg() {
        // given
        String imgSize = "20351";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage,parcelTiles.getParcelATileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectTileBImg() {
        // given
        String imgSize = "20350";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage,parcelTiles.getParcelBTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectTileCImg() {
        // given
        String imgSize = "20349";
        String errorMessage = "Wrong img loaded for chosen parcel size.";

        // when

        // then
        Assert.assertTrue( errorMessage,parcelTiles.getParcelCTileImg().getAttribute("src").contains(imgSize));
    }

    @Test
    public void shouldReturnCorrectTileAPrice() {
        // given
        String correctParcelPrice = "12,99 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelATilePrice().getText());
    }

    @Test
    public void shouldReturnCorrectTileBPrice() {
        //given
        String correctParcelPrice = "13,99 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        //when

        //then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelBTilePrice().getText());
    }

    @Test
    public void shouldReturnCorrectTileCPrice() {
        // given
        String correctParcelPrice = "15,49 zł";
        String errorMessage = "Wrong price for parcel of this size.";

        // when

        // then
        Assert.assertEquals(errorMessage, correctParcelPrice, parcelTiles.getParcelCTilePrice().getText());
    }

    @Test
    public void shouldPrintCorrectHTSModalTitle() throws Exception {
        // given
        String desiredTitle = "Jak nadać paczkę?";
        String errorMessage = "";

        // when
        formPage.clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, desiredTitle, formPage.getModalTitle().getText());

        refreshPage();
    }

    @Test
    public void shouldPrintCorrectHTSModalBody() throws Exception {
        // given
        String desiredBody = "Na początku wybierz odpowiednią dla Ciebie formę wysyłki: możesz wysłać z Paczkomatu/PaczkoPunktu do Paczkomatu/PaczkoPunktu lub wybrać dostawę przez kuriera. Następnie uzupełnij wymagane dane dla nadawcy i odbiorcy.\n" +
                             "\n" +
                             "Po uzupełnieniu informacji, zostaniesz przekierowany do strony z wygodnymi płatnościami online. Wybierz najwygodniejszy dla siebie sposób płatności, a następnie pobierz i wydrukuj etykietę. Pamiętaj, że etykietę możesz pobrać w PDF i wydrukować, gdzie Ci wygodnie.\n" +
                             "\n" +
                             "Z przygotowaną paczką, udaj się do dowolnego Paczkomatu lub PaczkoPunktu. Jeśli wybrałeś nadanie przesyłki w Paczkomacie, na ekranie maszyny wybierz opcję „Mam już paczkę ze specjalną etykietą”, a następnie zeskanuj kod kreskowy z etykiety i włóż paczkę do skrytki. W przypadku, gdy wybrałeś nadanie w PaczkoPunkcie, dostarcz tam przygotowaną przesyłkę.\n" +
                             "\n" +
                             "Gotowe!";
        String errorMessage = "";

        // when
        formPage.clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPage.getModalBody().getText());
    }

    @Test
    public void shouldPrintCorrectHTPModalTitle() throws Exception {
        // given
        String desiredTitle = "Jak spakować paczkę?";
        String errorMessage = "";

        // when
        formPage.clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, desiredTitle, formPage.getModalTitle().getText());
    }

    @Test
    public void shouldPrintCorrectHTPModalBody() throws Exception {
        // given
        String desiredBody = "Zadbaj o odpowiednie zabezpieczenie przesyłki i zmierz jej gabaryt. Jeśli potrzebujesz dodatkowych informacji o tym, jak poprawnie spakować przedmiot do wysyłki, zapoznaj się z naszym Poradnikiem Pakowania. Znajdziesz tam wiele ciekawych i przydatnych wskazówek, które sprawią, że przygotowanie paczki do wysyłki nie będzie miało dla Ciebie żadnych tajemnic.";
        String errorMessage = "";

        // when
        formPage.clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPage.getModalBody().getText());
    }

    @Test
    public void shouldPrintCorrectTermsText() {
        // given
        String desiredText = "*Zapoznałam/em się z Regulaminem świadczenia usług pocztowych i przewozowych przez InPost Sp. z o.o. i akceptuję jego treść.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredText, formPage.getTermsText().getText());
    }

    @Test
    public void shouldPrintCorrectNewsletterText() {
        // given
        String desiredText = "Wyrażam zgodę na otrzymywanie od InPost Sp. z o.o. informacji handlowych dotyczących produktów i usług InPost Sp. z o.o., spółek z Grupy Integer.pl oraz podmiotów współpracujących z ww. spółkami na podany przeze mnie numer telefonu lub adres e-mail.\n" +
                             "Administratorem Twoich danych osobowych jest InPost Sp. z o.o. Podane dane osobowe będą przetwarzane w celu wykonania usługi oraz w celach statystycznych i analitycznych administratora, a także w celu ewentualnego dochodzenia roszczeń lub obrony przed roszczeniami.\n" +
                             "\n" +
                             "W przypadku wyrażenia zgody na otrzymywanie informacji handlowych InPost Sp. z o.o. będą przetwarzać Twoje dane osobowe w celach marketingowych, w tym poprzez profilowanie oraz w celu kierowania do Ciebie informacji handlowych drogą elektroniczną w zakresie objętym wyrażoną zgodą. Wycofanie zgody na otrzymywanie informacji handlowych jest możliwe w dowolnym momencie, co nie wpływa na zgodność przetwarzania danych przed jej wycofaniem. Masz też prawo wyrazić sprzeciw wobec przetwarzania Twoich danych w celach marketingowych.\n" +
                             "\n" +
                             "Więcej informacji na temat przetwarzania danych osobowych, w tym o przysługujących Ci prawach, znajduje się w polityce prywatności.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredText, formPage.getNewsletterBody().getText());
    }

    @Test
    public void shouldHaveGoodLinks(){
        // given
        List<String> missingLinks = new ArrayList<String>();
        List<String> expectedLinksList = Arrays.asList(
                "https://inpost.pl/",
                "https://inpost.pl/regulaminy",
                "http://integer.pl/",
                "https://inpost.pl/polityka-prywatnosci",
                "https://policies.google.com/privacy",
                "https://policies.google.com/terms",
                "https://inpost.pl/",
                "https://inpost.pl/regulaminy#paczkomaty",
                "https://inpost.pl/polityka-prywatnosci",
                "https://inpost.pl/kontakt/zloz-reklamacje",
                "https://inpost.pl/pomoc?fulltext=szybkie+nadania",
                "https://inpost.pl/kontakt",
                "https://inpost.pl/regulaminy#paczkomaty",
                "https://inpost.pl/polityka-prywatnosci",
                "https://inpost.pl/kontakt/zloz-reklamacje",
                "https://inpost.pl/pomoc?fulltext=szybkie+nadania",
                "https://inpost.pl/kontakt",
                "https://inpost.pl/polityka-prywatnosci#policy-inpost-pp",
                "https://www.onetrust.com/products/cookie-consent/",
                "https://inpost.pl/polityka-prywatnosci#policy-inpost-pp"
        );

        for (String link: expectedLinksList){
            if (!pullUpAllLinks().contains(link)){
                missingLinks.add(link);
            }
        }
        String errorMessage = "Link(s): " + missingLinks + " missing.";

        // when

        // then
        Assert.assertEquals(errorMessage, 0, missingLinks.size());
    }
}
