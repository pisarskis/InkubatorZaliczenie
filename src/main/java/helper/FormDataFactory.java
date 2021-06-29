package helper;

import pages.ReceiverForm;
import pages.SenderForm;

import java.util.HashMap;

public class FormDataFactory {
    private static ReceiverForm receiverForm = new ReceiverForm();
    private static SenderForm senderForm = new SenderForm();
    private static HashMap<String, String> receiverData;
    private static HashMap<String, String> senderData;

    public HashMap<String, String> getReceiverData(){
        receiverData = new HashMap<String, String>();

        receiverData.put("name", "foo");
        receiverData.put("email", "foo@foo.pl");
        receiverData.put("phoneNo", "555555555");
        receiverData.put("zipCode", "02-677");
        receiverData.put("town", "Warszawa");
        receiverData.put("street", "Cybernetyki");
        receiverData.put("streetNo", "10");
        receiverData.put("flatNo", "5");
        receiverData.put("apmNo", "PAW04A");

        return receiverData;
    }

    public HashMap<String, String> getSenderData(){
        senderData = new HashMap<String, String>();

        senderData.put("name", "bar");
        senderData.put("email", "bar@bar.pl");
        senderData.put("phoneNo", "666666666");
        senderData.put("zipCode", "30-552");
        senderData.put("town", "Kraków");
        senderData.put("street", "Wielicka");
        senderData.put("streetNo", "28");
        senderData.put("flatNo", "1");
        senderData.put("nipNo", "6793087624");

        return senderData;
    }

    public void fillAPMFormData() throws InterruptedException {
        receiverForm.fillReceiverName(getReceiverData().get("name"));
        receiverForm.fillReceiverEmail(getReceiverData().get("email"));
        receiverForm.fillReceiverNumber(getReceiverData().get("phoneNo"));
        receiverForm.fillReceiverAPMCode(getReceiverData().get("apmNo"));
        senderForm.fillSenderName(getSenderData().get("name"));
        senderForm.fillSenderEmail(getSenderData().get("email"));
        senderForm.fillSenderNumber(getSenderData().get("phoneNo"));
    }

    public void fillC2DFormData() throws InterruptedException {
        receiverForm.fillReceiverName(getReceiverData().get("name"));
        receiverForm.fillReceiverEmail(getReceiverData().get("email"));
        receiverForm.fillReceiverNumber(getReceiverData().get("phoneNo"));
        receiverForm.fillReceiverZipCode(getReceiverData().get("zipCode"));
        receiverForm.fillReceiverTown(getReceiverData().get("town"));
        receiverForm.fillReceiverStreet(getReceiverData().get("street"));
        receiverForm.fillReceiverStreetNo(getReceiverData().get("streetNo"));
        receiverForm.fillReceiverFlatNo(getReceiverData().get("flatNo"));
        senderForm.fillSenderName(getSenderData().get("name"));
        senderForm.fillSenderEmail(getSenderData().get("email"));
        senderForm.fillSenderNumber(getSenderData().get("phoneNo"));
    }

    public void fillIndividualInvoice() throws InterruptedException {
        senderForm.clickInvoice();
        senderForm.clickLegalStatusIndividualCheckbox();
        senderForm.clickInvoiceIndividualName(getSenderData().get("name"));
        senderForm.clickInvoiceIndividualEmail(getSenderData().get("email"));
        senderForm.clickInvoiceIndividualZIPCode(getSenderData().get("zipCode"));
        senderForm.clickInvoiceIndividualTown(getSenderData().get("town"));
        senderForm.clickInvoiceIndividualStreet(getSenderData().get("street"));
        senderForm.clickInvoiceIndividualBuildingNo(getSenderData().get("streetNo"));
    }
}

