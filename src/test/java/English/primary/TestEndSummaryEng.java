package English.primary;

import English.primary.APM.TestApmFormEng;
import helper.ReceiverFormData;
import helper.SenderFormData;
import helper.WaitPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import pages.*;

@Tag("en")
public class TestEndSummaryEng extends Base {

    @BeforeClass
    public static void closeAllCookies() throws Exception {
        getFormPage().closeCookiesPopup();
        getFormPage().closeBottomCookiesPopup();
        getFormPage().clickLanguageSelector();
        getFormPage().closeCookiesPopup();
    }

    @After
    public void refreshPage() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
    }

    private void formRunThrough() throws InterruptedException {
        getFormPage().chooseDeliveryToAPM();
        getFormPage().clickA();
        fillAPMFormData();
        getFormPage().clickTermsCheckboxEngish();
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
    @Tag("en")
    public void shouldMarkParcelAsPaidFor() throws Exception {
        // given
        String expectedMessage = "Your payment was confirmed";

        // when
        formRunThrough();
        getPaymentPage().clickAcceptPayment();
        getWaitPage().waitShort();
        getFormPage().closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(expectedMessage, getEndSummaryPage().getPaymentStatus().getText());
    }

    @Test
    @Tag("en")
    public void shouldMarkParcelPaymentAsPending() throws Exception {
        // given
        String expectedMessage = "Your transaction has not been concluded – this may take a few minutes. Refresh the page to check its status.";

        // when
        formRunThrough();
        getPaymentPage().clickSetPaymentAsPendingButton();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();
        checkRefreshButton(expectedMessage);

        // then
        Assert.assertEquals(expectedMessage, getEndSummaryPage().getPaymentStatus().getText());
    }

    @Test
    @Tag("en")
    public void shouldMarkParcelPaymentAsRejected() throws Exception {
        // given
        String expectedMessage = "Oops, we have a problem. Your payment did not succeed. Try again.";

        // when
        formRunThrough();
        getPaymentPage().clickDeclinePaymentButton();
        getWaitPage().waitLong();
        getFormPage().closeCookiesPopup();

        // then
        Assert.assertEquals(expectedMessage, getEndSummaryPage().getPaymentStatus().getText());
    }
}
