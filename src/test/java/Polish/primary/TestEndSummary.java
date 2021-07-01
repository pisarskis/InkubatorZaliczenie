package Polish.primary;

import helper.*;
import org.junit.*;
import org.junit.jupiter.api.Tag;
import pages.*;
import Polish.primary.APM.TestApmForm;

public class TestEndSummary extends Base {

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
    }

    @Before
    public void formRunThrough() throws InterruptedException {
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickA();
        fillAPMFormData();
        getFormPage().clickTermsCheckbox();
        getFormPage().clickNewsletterCheckbox();
        getFormPage().clickSendButton();
        getFormPage().clickPayButton();
        getPaymentPage().clickBank();
        getPaymentPage().clickNextButton();
    }

    public void checkRefreshButton(String expectedMessage) throws InterruptedException {
        int count = 0;
        getWaitPage().waitLong();

        while (!getEndSummaryPage().getPaymentStatus().getText().equals(expectedMessage)) {
            getEndSummaryPage().clickRefreshButton();
            count ++;

            if (count >= 5){
                expectedMessage = getEndSummaryPage().getPaymentStatus().getText();
            }
        }
    }

    @Test
    @Tag("pl")
    public void shouldMarkParcelAsPaidFor() throws Exception {
        // given
        String expectedMessage = "Twoja płatność została potwierdzona";
        String errorMessage = "";

        // when
        getPaymentPage().clickAcceptPayment();
        getWaitPage().waitShort();
        getFormPage().closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(errorMessage, expectedMessage, getEndSummaryPage().getPaymentStatus().getText());
    }

    @Test
    @Tag("pl")
    public void shouldMarkParcelPaymentAsPending() throws Exception {
        // given
        String expectedMessage = "Twoja transakcja nie została jeszcze zakończona.\n" +
                                  "To może potrwać kilka minut. Odśwież stronę,\n" +
                                  "aby sprawdzić jej status.";
        String errorMessage = "";

        // when
        getPaymentPage().clickSetPaymentAsPendingButton();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(errorMessage, expectedMessage, getEndSummaryPage().getPaymentStatus().getText());
    }

    @Test
    @Tag("pl")
    public void shouldMarkParcelPaymentAsRejected() throws Exception {
        // given
        String expectedMessage = "Ups, mamy problem.\n" +
                                 "Niestety nie udało się opłacić paczki.\n" +
                                 "Spróbuj jeszcze raz.";
        String errorMessage = "";

        // when
        getPaymentPage().clickDeclinePaymentButton();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();

        // then
        Assert.assertEquals(errorMessage, expectedMessage, getEndSummaryPage().getPaymentStatus().getText());
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }
}
