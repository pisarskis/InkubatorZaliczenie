package pages;

import helper.ReceiverFormData;
import helper.SenderFormData;
import helper.WaitPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public static WebDriver driver;
    private static WaitPage waitPage;
    private static FormPage formPage;
    private static ReceiverForm receiverForm;
    private static SenderForm senderForm;
    private static SummaryPage summaryPage;
    private static PaymentPage paymentPage;
    private static EndSummaryPage endSummaryPage;
    private static ParcelTiles parcelTiles;
    private static FormPageStatics formPageStatics;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");

        formPage = new FormPage();
        receiverForm  = new ReceiverForm();
        senderForm  = new SenderForm();
        waitPage = new WaitPage();
        summaryPage = new SummaryPage();
        paymentPage = new PaymentPage();
        endSummaryPage = new EndSummaryPage();
        parcelTiles = new ParcelTiles();
        formPageStatics = new FormPageStatics();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    public static FormPage getFormPage(){
        return formPage;
    }

    public static ReceiverForm getReceiverForm(){
        return receiverForm;
    }

    public static SenderForm getSenderForm(){
        return senderForm;
    }

    public static WaitPage getWaitPage(){
        return waitPage;
    }

    public static SummaryPage getSummaryPage(){
        return summaryPage;
    }

    public static PaymentPage getPaymentPage(){ return paymentPage; }

    public static EndSummaryPage getEndSummaryPage(){
        return endSummaryPage;
    }

    public static ParcelTiles getParcelTiles(){
        return parcelTiles;
    }

    public static FormPageStatics getFormPageStatics(){
        return formPageStatics;
    }

    public static void fillAPMFormData() throws InterruptedException {
        getReceiverForm().fillReceiverName(ReceiverFormData.NAME.getValue());
        getReceiverForm().fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        getReceiverForm().fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        getReceiverForm().fillReceiverAPMCode(ReceiverFormData.APNNO.getValue());
        getSenderForm().fillSenderName(SenderFormData.NAME.getValue());
        getSenderForm().fillSenderEmail(SenderFormData.EMAIL.getValue());
        getSenderForm().fillSenderNumber(SenderFormData.PHONENO.getValue());
    }

    public static void fillC2DFormData() throws InterruptedException {
        getReceiverForm().fillReceiverName(ReceiverFormData.NAME.getValue());
        getReceiverForm().fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        getReceiverForm().fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        getReceiverForm().fillReceiverZipCode(ReceiverFormData.ZIPCODE.getValue());
        getReceiverForm().fillReceiverTown(ReceiverFormData.TOWN.getValue());
        getReceiverForm().fillReceiverStreet(ReceiverFormData.STREET.getValue());
        getReceiverForm().fillReceiverStreetNo(ReceiverFormData.STREETNO.getValue());
        getReceiverForm().fillReceiverFlatNo(ReceiverFormData.FLATNO.getValue());
        getSenderForm().fillSenderName(SenderFormData.NAME.getValue());
        getSenderForm().fillSenderEmail(SenderFormData.EMAIL.getValue());
        getSenderForm().fillSenderNumber(SenderFormData.PHONENO.getValue());
    }

    public static void fillIndividualInvoice() throws InterruptedException {
        getSenderForm().clickInvoice();
        getSenderForm().clickLegalStatusIndividualCheckbox();
        getSenderForm().clickInvoiceIndividualName(SenderFormData.NAME.getValue());
        getSenderForm().clickInvoiceIndividualEmail(SenderFormData.EMAIL.getValue());
        getSenderForm().clickInvoiceIndividualZIPCode(SenderFormData.ZIPCODE.getValue());
        getSenderForm().clickInvoiceIndividualTown(SenderFormData.TOWN.getValue());
        getSenderForm().clickInvoiceIndividualStreet(SenderFormData.STREET.getValue());
        getSenderForm().clickInvoiceIndividualBuildingNo(SenderFormData.STREETNO.getValue());
    }
}
