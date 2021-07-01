package Polish.secondary;

import org.junit.*;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFormStatic extends Base {
    private static List<WebElement> linkList;
    private static List<String> cleanLinkList;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        linkList = new ArrayList<WebElement>();
        cleanLinkList = new ArrayList<String>();

        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
    }

    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
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
    @Tag("pl")
    public void shouldPrintCorrectHTSModalTitle() throws Exception {
        // given
        String expectedTitle = "Jak nadać paczkę?";
        String errorMessage = "";

        // when
        getFormPage().clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, expectedTitle, getFormPageStatics().getModalTitle().getText());
        refreshPage();
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectHTSModalBody() throws Exception {
        // given
        String expectedBody = "Na początku wybierz odpowiednią dla Ciebie formę wysyłki: możesz wysłać z Paczkomatu/PaczkoPunktu do Paczkomatu/PaczkoPunktu lub wybrać dostawę przez kuriera. Następnie uzupełnij wymagane dane dla nadawcy i odbiorcy.\n" +
                             "\n" +
                             "Po uzupełnieniu informacji, zostaniesz przekierowany do strony z wygodnymi płatnościami online. Wybierz najwygodniejszy dla siebie sposób płatności, a następnie pobierz i wydrukuj etykietę. Pamiętaj, że etykietę możesz pobrać w PDF i wydrukować, gdzie Ci wygodnie.\n" +
                             "\n" +
                             "Z przygotowaną paczką, udaj się do dowolnego Paczkomatu lub PaczkoPunktu. Jeśli wybrałeś nadanie przesyłki w Paczkomacie, na ekranie maszyny wybierz opcję „Mam już paczkę ze specjalną etykietą”, a następnie zeskanuj kod kreskowy z etykiety i włóż paczkę do skrytki. W przypadku, gdy wybrałeś nadanie w PaczkoPunkcie, dostarcz tam przygotowaną przesyłkę.\n" +
                             "\n" +
                             "Gotowe!";
        String errorMessage = "";

        // when
        getFormPage().clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getModalBody().getText());
        refreshPage();
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectHTPModalTitle() throws Exception {
        // given
        String expectedTitle = "Jak spakować paczkę?";
        String errorMessage = "";

        // when
        getFormPage().clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, expectedTitle, getFormPageStatics().getModalTitle().getText());
        refreshPage();
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectTermsText() {
        // given
        String expectedText = "*Zapoznałam/em się z Regulaminem świadczenia usług pocztowych i przewozowych przez InPost Sp. z o.o. i akceptuję jego treść.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedText, getFormPageStatics().getTermsText().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectNewsletterText() {
        // given
        String expectedText = "Wyrażam zgodę na otrzymywanie od InPost Sp. z o.o. informacji handlowych dotyczących produktów i usług InPost Sp. z o.o., spółek z Grupy Integer.pl oraz podmiotów współpracujących z ww. spółkami na podany przeze mnie numer telefonu lub adres e-mail.\n" +
                             "Administratorem Twoich danych osobowych jest InPost Sp. z o.o. Podane dane osobowe będą przetwarzane w celu wykonania usługi oraz w celach statystycznych i analitycznych administratora, a także w celu ewentualnego dochodzenia roszczeń lub obrony przed roszczeniami.\n" +
                             "\n" +
                             "W przypadku wyrażenia zgody na otrzymywanie informacji handlowych InPost Sp. z o.o. będą przetwarzać Twoje dane osobowe w celach marketingowych, w tym poprzez profilowanie oraz w celu kierowania do Ciebie informacji handlowych drogą elektroniczną w zakresie objętym wyrażoną zgodą. Wycofanie zgody na otrzymywanie informacji handlowych jest możliwe w dowolnym momencie, co nie wpływa na zgodność przetwarzania danych przed jej wycofaniem. Masz też prawo wyrazić sprzeciw wobec przetwarzania Twoich danych w celach marketingowych.\n" +
                             "\n" +
                             "Więcej informacji na temat przetwarzania danych osobowych, w tym o przysługujących Ci prawach, znajduje się w polityce prywatności.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedText, getFormPageStatics().getNewsletterBody().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintCorrectHTPModalBody() throws Exception {
        // given
        String expectedBody = "Zadbaj o odpowiednie zabezpieczenie przesyłki i zmierz jej gabaryt. Jeśli potrzebujesz dodatkowych informacji o tym, jak poprawnie spakować przedmiot do wysyłki, zapoznaj się z naszym Poradnikiem Pakowania. Znajdziesz tam wiele ciekawych i przydatnych wskazówek, które sprawią, że przygotowanie paczki do wysyłki nie będzie miało dla Ciebie żadnych tajemnic.";
        String errorMessage = "";

        // when
        getFormPage().clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getModalBody().getText());
        refreshPage();
    }

    @Test
    @Tag("pl")
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

    @Test
    @Tag("pl")
    public void shouldPrintHeaderFirstText() {
        // given
        String expectedBody = "Spakuj paczkę";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepFistText().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintHeaderStepSecondText() {
        // given
        String expectedBody = "Uzupełnij dane\n" +
                             "dostawy";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepSecondText().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintHeaderStepThirdText() {
        // given
        String expectedBody = "Opłać, wydrukuj i naklej\n" +
                             "etykietę na paczkę";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepThirdText().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintHeaderStepFourthText() {
        // given
        String expectedBody = "Nadaj w Paczkomacie\n" +
                             "lub PaczkoPunkcie";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepFourthText().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintTypeOfDeliveryHeader() {
        // given
        String expectedBody = "Sposób dostawy";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getTypeOfDeliveryHeader().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintTypeOfDeliveryHeaderSubtitle() {
        // given
        String expectedBody = "Wybierz sposób dostawy";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getTypeOfDeliveryHeaderSubtitle().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSizeOfParcelHeader() {
        // given
        String expectedBody = "Rozmiar paczki";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSizeOfParcelHeader().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSizeOfParcelHeaderSubtitle() {
        // given
        String expectedBody = "Wybierz rozmiar paczki";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSizeOfParcelHeaderSubtitle().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintReceiverHeader() {
        // given
        String expectedBody = "Rozmiar paczki";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getReceiverHeader().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintReceiverHeaderSubtitle() {
        // given
        String expectedBody = "Wpisz dane odbiorcy";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getReceiverHeaderSubtitle().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSenderHeader() {
        // given
        String expectedBody = "Nadawca";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSenderHeader().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSenderHeaderSubtitle() {
        // given
        String expectedBody = "Wpisz swoje dane";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSenderHeaderSubtitle().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSummaryHeader() {
        // given
        String expectedBody = "Podsumowanie";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryHeader().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSummaryTypeOfDelivery() {
        // given
        String expectedBody = "Sposób\n" +
                "dostawy";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryTypeOfDelivery().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSummaryInsuranceHeader() {
        // given
        String expectedBody = "Ubezpieczenie";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryInsuranceHeader().getText());
    }

    @Test
    @Tag("pl")
    public void shouldPrintSummaryInsuranceHeaderSubtitle() {
        // given
        String expectedBody = "Przesyłka jest objęta podstawowym ubezpieczeniem do kwoty 5000 zł.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryInsuranceHeaderSubtitle().getText());
    }
}