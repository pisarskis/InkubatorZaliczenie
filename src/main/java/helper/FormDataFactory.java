package helper;

import pages.ReceiverForm;
import pages.SenderForm;

import java.util.HashMap;

public class FormDataFactory {
    private static ReceiverForm receiverForm = new ReceiverForm();
    private static SenderForm senderForm = new SenderForm();

    public void fillAPMFormData() throws InterruptedException {
        receiverForm.fillReceiverName(ReceiverFormData.NAME.getValue());
        receiverForm.fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        receiverForm.fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        receiverForm.fillReceiverAPMCode(ReceiverFormData.APNNO.getValue());
        senderForm.fillSenderName(SenderFormData.NAME.getValue());
        senderForm.fillSenderEmail(SenderFormData.EMAIL.getValue());
        senderForm.fillSenderNumber(SenderFormData.PHONENO.getValue());
    }

    public void fillC2DFormData() throws InterruptedException {
        receiverForm.fillReceiverName(ReceiverFormData.NAME.getValue());
        receiverForm.fillReceiverEmail(ReceiverFormData.EMAIL.getValue());
        receiverForm.fillReceiverNumber(ReceiverFormData.PHONENO.getValue());
        receiverForm.fillReceiverZipCode(ReceiverFormData.ZIPCODE.getValue());
        receiverForm.fillReceiverTown(ReceiverFormData.TOWN.getValue());
        receiverForm.fillReceiverStreet(ReceiverFormData.STREET.getValue());
        receiverForm.fillReceiverStreetNo(ReceiverFormData.STREETNO.getValue());
        receiverForm.fillReceiverFlatNo(ReceiverFormData.FLATNO.getValue());
        senderForm.fillSenderName(SenderFormData.NAME.getValue());
        senderForm.fillSenderEmail(SenderFormData.EMAIL.getValue());
        senderForm.fillSenderNumber(SenderFormData.PHONENO.getValue());
    }

    public void fillIndividualInvoice() throws InterruptedException {
        senderForm.clickInvoice();
        senderForm.clickLegalStatusIndividualCheckbox();
        senderForm.clickInvoiceIndividualName(SenderFormData.NAME.getValue());
        senderForm.clickInvoiceIndividualEmail(SenderFormData.EMAIL.getValue());
        senderForm.clickInvoiceIndividualZIPCode(SenderFormData.ZIPCODE.getValue());
        senderForm.clickInvoiceIndividualTown(SenderFormData.TOWN.getValue());
        senderForm.clickInvoiceIndividualStreet(SenderFormData.STREET.getValue());
        senderForm.clickInvoiceIndividualBuildingNo(SenderFormData.STREETNO.getValue());
    }
}


