package English;

import helper.FormDataFactory;
import helper.WaitPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFormStatic extends Base {
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static WaitPage waitPage;
    private static FormDataFactory formDataFactory;
    private static FormPageStatics formPageStatics;

    private static List<WebElement> linkList;
    private static List<String> cleanLinkList;

    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        formDataFactory = new FormDataFactory();
        formPageStatics = new FormPageStatics();

        linkList = new ArrayList<WebElement>();
        cleanLinkList = new ArrayList<String>();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
        formPage.clickLanguageSelector();
        formPage.closeCookiesPopup();
    }

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
    public void shouldPrintCorrectHTSModalTitle() throws Exception {
        // given
        String desiredTitle = "How to send the parcel?";
        String errorMessage = "";

        // when
        formPage.clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, desiredTitle, formPageStatics.getModalTitle().getText());
        refreshPage();
    }

    @Test
    public void shouldPrintCorrectHTSModalBody() throws Exception {
        // given
        String desiredBody = "To start choose the form of shipping that is right for you: you can send from a Parcel Locker/ Parcel Point to Parcel Locker/ Parcel Point or a choose delivery by courier. Then complete the required data for the sender and recipient.\n" +
                "\n" +
                "After you have filled in all the information, you will be redirected to a website with convenient on-line payments. Choose the most convenient payment method for you, then download and print the label. Remember that you can download the label in PDF format and print it anywhere you like.\n" +
                "\n" +
                "With the package ready, go to any Parcel Locker or Parcel Point. If you chose to post the parcel at a Parcel Locker, select the option \"I already have a parcel with a special label\" on the device screen, then scan the barcode on the label and put the parcel in the locker. If you chose to send from a Parcel Point, deliver the prepared package there.\n" +
                "\n" +
                "All done!";
        String errorMessage = "";

        // when
        formPage.clickHowToSendParcel();

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getModalBody().getText());
        refreshPage();
    }

    @Test
    public void shouldPrintCorrectHTPModalTitle() throws Exception {
        // given
        String desiredTitle = "How to pack the parcel?";
        String errorMessage = "";

        // when
        formPage.clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, desiredTitle, formPageStatics.getModalTitle().getText());
        refreshPage();
    }

    @Test
    public void shouldPrintCorrectTermsText() {
        // given
        String desiredText = "*I have read the Terms and Conditions for the provision of services InPost Sp. z o.o. and I accept them.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredText, formPageStatics.getTermsTextEnglish().getText());
    }

    @Test
    public void shouldPrintCorrectNewsletterText() {
        // given
        String desiredText = "I agree to receive from InPost Sp. z o.o. marketing messages about products and services offered by InPost Sp. z o.o., companies from the Integer.pl Group and entities cooperating with these companies to the phone number or email address I provide.\n" +
                             "The administrator of your personal data is InPost Sp. z o.o. The personal data provided will be processed for the purpose of performing the service and for statistical and analytical purposes of the administrator, as well as for possible redress or defence against claims.\n" +
                             "\n" +
                             "If you agree to receive marketing messages, InPost Sp. z o.o. will process your personal data for marketing purposes, including profiling and to send marketing messages to you electronically to the extent covered by the consent. Withdrawal of consent to receive commercial information is possible at any time, which does not affect the compliance of data processing before its withdrawal. You also have the right to object to the processing of your data for marketing purposes.\n" +
                             "\n" +
                             "For more information on the processing of personal data, including your rights, see our privacy policy.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredText, formPageStatics.getNewsletterBody().getText());
    }

    @Test
    public void shouldPrintCorrectHTPModalBody() throws Exception {
        // given
        String desiredBody = "Make sure the parcel is properly secured and measure its dimensions. If you need additional information on how to properly pack an item for shipping, please see our Packaging Guide below. You will find many interesting and useful tips there that will ensure that preparing a package for shipping will hold no secrets for you.";
        String errorMessage = "";

        // when
        formPage.clickHowToPackParcel();

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getModalBody().getText());
        refreshPage();
    }

    @Test
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
    public void shouldPrintHeaderFirstText() throws Exception {
        // given
        String desiredBody = "Pack the parcel";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getHomeHeaderStepFistText().getText());
    }

    @Test
    public void shouldPrintHeaderStepSecondText() throws Exception {
        // given
        String desiredBody = "Complete delivery details";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getHomeHeaderStepSecondText().getText());
    }

    @Test
    public void shouldPrintHeaderStepThirdText() throws Exception {
        // given
        String desiredBody = "Pay for, print, and stick on the label";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getHomeHeaderStepThirdText().getText());
    }

    @Test
    public void shouldPrintHeaderStepFourthText() throws Exception {
        // given
        String desiredBody = "Send from a Parcel Locker or Parcel Point";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getHomeHeaderStepFourthText().getText());
    }

    @Test
    public void shouldPrintTypeOfDeliveryHeader() throws Exception {
        // given
        String desiredBody = "Delivery method";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getTypeOfDeliveryHeader().getText());
    }

    @Test
    public void shouldPrintTypeOfDeliveryHeaderSubtitle() throws Exception {
        // given
        String desiredBody = "Choose a delivery method";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getTypeOfDeliveryHeaderSubtitle().getText());
    }

    @Test
    public void shouldPrintSizeOfParcelHeader() throws Exception {
        // given
        String desiredBody = "Parcel size";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSizeOfParcelHeader().getText());
    }

    @Test
    public void shouldPrintSizeOfParcelHeaderSubtitle() throws Exception {
        // given
        String desiredBody = "Choose parcel size";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSizeOfParcelHeaderSubtitle().getText());
    }

    @Test
    public void shouldPrintReceiverHeader() throws Exception {
        // given
        String desiredBody = "Parcel size";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getReceiverHeader().getText());
    }

    @Test
    public void shouldPrintReceiverHeaderSubtitle() throws Exception {
        // given
        String desiredBody = "Enter receiver's data";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getReceiverHeaderSubtitle().getText());
    }

    @Test
    public void shouldPrintSenderHeader() throws Exception {
        // given
        String desiredBody = "Sender";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSenderHeader().getText());
    }

    @Test
    public void shouldPrintSenderHeaderSubtitle() throws Exception {
        // given
        String desiredBody = "Enter your data";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSenderHeaderSubtitle().getText());
    }

    @Test
    public void shouldPrintSummaryHeader() throws Exception {
        // given
        String desiredBody = "Summary";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSummaryHeader().getText());
    }

    @Test
    public void shouldPrintSummaryTypeOfDelivery() throws Exception {
        // given
        String desiredBody = "Delivery";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSummaryTypeOfDelivery().getText());
    }

    @Test
    public void shouldPrintSummaryInsuranceHeader() throws Exception {
        // given
        String desiredBody = "Insurance";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSummaryInsuranceHeader().getText());
    }

    @Test
    public void shouldPrintSummaryInsuranceHeaderSubtitle() throws Exception {
        // given
        String desiredBody = "Parcel has basic insurance amount up to PLN 5000.";
        String errorMessage = "";

        // when

        // then
        Assert.assertEquals(errorMessage, desiredBody, formPageStatics.getSummaryInsuranceHeaderSubtitle().getText());
    }
}