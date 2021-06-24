package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[3]/div[2]/button")
    private WebElement payButton;

    @FindBy(css = "div.d-flex > h4")
    private WebElement parcelSize;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[1]/div/div[2]/div/div[2]/img")
    private WebElement parcelImg;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[5]/div/div[2]")
    private WebElement parcelPrice;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[3]/div/div[1]/div[1]")
    private WebElement receiverName;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[3]/div/div[1]/div[2]")
    private WebElement receiverPhoneNo;

    @FindBy(css = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[3]/div/div[1]/div[3]")
    private WebElement receiverEmail;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[4]/div/div[1]/div[1]")
    private WebElement SenderName;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[4]/div/div[1]/div[2]")
    private WebElement SenderPhoneNo;

    @FindBy(css = "/html/body/modal-container/div/div/div[2]/div[1]/div/app-parcel-form-whole-summary/div/ul/li[4]/div/div[1]/div[3]")
    private WebElement SenderEmail;

    private WebDriver driver;

    public SummaryPage () {
        PageFactory.initElements(Base.driver, this);
    }

    public WebElement getParcelSize() {
        return parcelSize;
    }

    public WebElement getParcelImg() { return parcelImg; }

    public WebElement getParcelPrice() { return parcelPrice; }

    public WebElement getReceiverName() { return receiverName; }

    public WebElement getReceiverPhoneNo() { return receiverPhoneNo; }

    public WebElement getReceiverEmail() { return receiverEmail; }

    public WebElement getSenderName() { return SenderName; }

    public WebElement getSenderPhoneNo() { return SenderPhoneNo; }

    public WebElement getSenderEmail() { return SenderEmail; }
}
