package Polish.primary;

import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("pl")
public class TestPayment extends Base {

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {

        Base.fillAPMFormData();
        getFormPage().clickTermsCheckbox();
        getFormPage().clickNewsletterCheckbox();
        getFormPage().clickSendButton();
        getFormPage().clickPayButton();
        getWaitPage().waitLong();
        getWaitPage().waitLong();
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldShowAPMParcelAPriceInPayment() throws InterruptedException {
        // given
        String expectedParcelPrice = "12,99 PLN";
        String errorMessage = "";

        // when
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickA();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getPaymentPage().getSenderParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldShowAPMParcelBPriceInPayment() throws InterruptedException {
        // given
        String expectedParcelPrice = "13,99 PLN";
        String errorMessage = "";

        // when
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickB();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getPaymentPage().getSenderParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    @Tag("primary")
    public void shouldShowAPMParcelCPriceInPayment() throws InterruptedException {
        // given
        String expectedParcelPrice = "15,49 PLN";
        String errorMessage = "";

        // when
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickC();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, expectedParcelPrice, getPaymentPage().getSenderParcelPrice().getText());
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectNameInSummary() throws InterruptedException {
        // given
        String expectedSenderName = "bar";
        String errorMessage = "";

        // when
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickA();
        formRunThrough();

        // then
        Assert.assertEquals(errorMessage, expectedSenderName, getPaymentPage().getSenderName().getText());
    }

    @Test
    @Tag("pl")
    public void shouldShowCorrectEMailInSummary() throws InterruptedException {
        // given
        String expectedParcelPrice = "bar@bar.pl";
        String errorMessage = "";

        // when
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickA();
        formRunThrough();

        // then
        Assert.assertTrue(errorMessage, getPaymentPage().getSenderEmail().getText().contains(expectedParcelPrice));
    }
}
