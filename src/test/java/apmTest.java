import helper.ActionPage;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;

public class apmTest extends Base {
    private static FormPage formPage = new FormPage();
    private static ReceiverForm receiverForm = new ReceiverForm();
    private static ActionPage actionPage = new ActionPage();

    @BeforeClass
    public static void closeAllCookies() throws InterruptedException {
        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Test
    public void clikAPMCheckbox() throws Exception {
        formPage.chooseDeliveryToAPM();
    }

    @Test
    public void clikParcelSizeA() throws Exception {
        formPage.clickA();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void clikParcelSizeB() throws Exception {
        formPage.clickB();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void clikParcelSizeC() throws Exception {
        formPage.clickC();
        // todo zrobić assert sprawdzający cenę i inne parametry.
    }

    @Test
    public void fillReceiverName() throws Exception {
        String name = "Szymon Pisarski";
        receiverForm.fillReceiverName(name);
    }

    @Test
    public void fillReceiverEmail() throws Exception {
        String email = "spiarski@inpost.pl";
        receiverForm.fillReceiverEmail(email);
        // todo zrobić weryfikacja porawności adresu e-mail?
    }

    @Test
    public void fillReceiverNumber() throws Exception {
        String email = "666999666";
        receiverForm.fillReceiverNumber(email);
        // todo zrobić weryfikacja porawności numeru?
    }

    @Test
    public void fillReceiverAPM() throws Exception {
        String apmNo = "PJ11A";
        receiverForm.fillReceiverAPMCode(apmNo);
    }
}
