import helper.ActionPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import pages.Base;
import pages.FormPage;
import pages.ReceiverForm;
import pages.SenderForm;


public class C2dTest extends Base {
    private static FormPage formPage;
    private static ActionPage actionPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;


    @BeforeClass
    public static void closeAllCookies() throws InterruptedException {
        formPage = new FormPage();
        actionPage = new ActionPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();

        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Test
    public void clikC2DCheckbox() throws Exception {
        formPage.chooseDeliveryC2D();
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
    public void fillReceiverZipCode() throws Exception {
        String apmNo = "02-677";
        receiverForm.fillReceiverZipCode(apmNo);
    }

    @Test
    public void fillReceiverTown() throws Exception {
        String town = "Warszawa";

        formPage.chooseDeliveryC2D();
        fillReceiverZipCode();

        receiverForm.fillReceiverTown(town);
    }

    @Test
    public void fillReceiverStreet() throws Exception {
        String street = "Cybernetyki";

        formPage.chooseDeliveryC2D();
        fillReceiverZipCode();
        fillReceiverTown();

        receiverForm.fillReceiverStreet(street);
    }
}
