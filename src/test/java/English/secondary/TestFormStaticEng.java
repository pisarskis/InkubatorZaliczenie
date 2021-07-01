package English.secondary;

import helper.WaitPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag("en")
public class TestFormStaticEng extends Base {
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

    public void refreshPage() throws InterruptedException {
        Base.driver.navigate().refresh();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    public List<String> pullUpAllLinks(){
        linkList = Base.driver.findElements(By.tagName("a"));

        for(WebElement link:linkList){
            cleanLinkList.add(link.getAttribute("href"));
        }

        while (cleanLinkList.remove(null)){}

        return cleanLinkList;
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectHTSModalTitle() throws Exception {
        // given
        String expectedTitle = "How to send the parcel?";
        String errorMessage = "";

        // when
        getFormPage().clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, expectedTitle, getFormPageStatics().getModalTitle().getText());
        refreshPage();
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectHTSModalBody() throws Exception {
        // given
        String expectedBody = "To start choose the form of shipping that is right for you: you can send from a Parcel Locker/ Parcel Point to Parcel Locker/ Parcel Point or a choose delivery by courier. Then complete the required data for the sender and recipient.\n" +
                "\n" +
                "After you have filled in all the information, you will be redirected to a website with convenient on-line payments. Choose the most convenient payment method for you, then download and print the label. Remember that you can download the label in PDF format and print it anywhere you like.\n" +
                "\n" +
                "With the package ready, go to any Parcel Locker or Parcel Point. If you chose to post the parcel at a Parcel Locker, select the option \"I already have a parcel with a special label\" on the device screen, then scan the barcode on the label and put the parcel in the locker. If you chose to send from a Parcel Point, deliver the prepared package there.\n" +
                "\n" +
                "All done!";
        String errorMessage = "";

        // when
        getFormPage().clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getModalBody().getText());
        refreshPage();
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectHTPModalTitle() throws Exception {
        // given
        String expectedTitle = "How to pack the parcel?";
        String errorMessage = "";

        // when
        getFormPage().clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, expectedTitle, getFormPageStatics().getModalTitle().getText());
        refreshPage();
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectTermsText() {
        // given
        String expectedText = "*I have read the Terms and Conditions for the provision of services InPost Sp. z o.o. and I accept them.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedText, getFormPageStatics().getTermsTextEnglish().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectNewsletterText() {
        // given
        String expectedText = "I agree to receive from InPost Sp. z o.o. marketing messages about products and services offered by InPost Sp. z o.o., companies from the Integer.pl Group and entities cooperating with these companies to the phone number or email address I provide.\n" +
                             "The administrator of your personal data is InPost Sp. z o.o. The personal data provided will be processed for the purpose of performing the service and for statistical and analytical purposes of the administrator, as well as for possible redress or defence against claims.\n" +
                             "\n" +
                             "If you agree to receive marketing messages, InPost Sp. z o.o. will process your personal data for marketing purposes, including profiling and to send marketing messages to you electronically to the extent covered by the consent. Withdrawal of consent to receive commercial information is possible at any time, which does not affect the compliance of data processing before its withdrawal. You also have the right to object to the processing of your data for marketing purposes.\n" +
                             "\n" +
                             "For more information on the processing of personal data, including your rights, see our privacy policy.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedText, getFormPageStatics().getNewsletterBody().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintCorrectHTPModalBody() throws Exception {
        // given
        String expectedBody = "Make sure the parcel is properly secured and measure its dimensions. If you need additional information on how to properly pack an item for shipping, please see our Packaging Guide below. You will find many interesting and useful tips there that will ensure that preparing a package for shipping will hold no secrets for you.";
        String errorMessage = "";

        // when
        getFormPage().clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getModalBody().getText());
        refreshPage();
    }

    @Test
    @Tag("en")
    public void shouldHaveGoodLinks(){
        // given
        List<String> missingLinks = new ArrayList<String>();
        List<String> expectedLinksList = Arrays.asList(
                "https://inpost.pl/en",
                "https://inpost.pl/en/regulations",
                "https://integer.pl/en",
                "https://inpost.pl/en/policy",
                "https://policies.google.com/privacy",
                "https://policies.google.com/terms",
                "https://inpost.pl/en/make-complaint",
                "https://inpost.pl/en/contact?fulltext=quick%20send",
                "https://inpost.pl/en/contact",
                "https://inpost.pl/polityka-prywatnosci#policy-inpost-pp",
                "https://www.onetrust.com/products/cookie-consent/"
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
    @Tag("en")
    public void shouldPrintHeaderFirstText() {
        // given
        String expectedBody = "Pack the parcel";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepFistText().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintHeaderStepSecondText() {
        // given
        String expectedBody = "Complete delivery details";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepSecondText().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintHeaderStepThirdText() {
        // given
        String expectedBody = "Pay for, print, and stick on the label";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepThirdText().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintHeaderStepFourthText() {
        // given
        String expectedBody = "Send from a Parcel Locker or Parcel Point";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getHomeHeaderStepFourthText().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintTypeOfDeliveryHeader() {
        // given
        String expectedBody = "Delivery method";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getTypeOfDeliveryHeader().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintTypeOfDeliveryHeaderSubtitle() {
        // given
        String expectedBody = "Choose a delivery method";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getTypeOfDeliveryHeaderSubtitle().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSizeOfParcelHeader() {
        // given
        String expectedBody = "Parcel size";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSizeOfParcelHeader().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSizeOfParcelHeaderSubtitle() {
        // given
        String expectedBody = "Choose parcel size";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSizeOfParcelHeaderSubtitle().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintReceiverHeader() {
        // given
        String expectedBody = "Parcel size";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getReceiverHeader().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintReceiverHeaderSubtitle() {
        // given
        String expectedBody = "Enter receiver's data";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getReceiverHeaderSubtitle().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSenderHeader() {
        // given
        String expectedBody = "Sender";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSenderHeader().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSenderHeaderSubtitle() {
        // given
        String expectedBody = "Enter your data";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSenderHeaderSubtitle().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSummaryHeader() {
        // given
        String expectedBody = "Summary";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryHeader().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSummaryTypeOfDelivery() {
        // given
        String expectedBody = "Delivery";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryTypeOfDelivery().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSummaryInsuranceHeader() {
        // given
        String expectedBody = "Insurance";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryInsuranceHeader().getText());
    }

    @Test
    @Tag("en")
    public void shouldPrintSummaryInsuranceHeaderSubtitle() {
        // given
        String expectedBody = "Parcel has basic insurance amount up to PLN 5000.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, expectedBody, getFormPageStatics().getSummaryInsuranceHeaderSubtitle().getText());
    }
}