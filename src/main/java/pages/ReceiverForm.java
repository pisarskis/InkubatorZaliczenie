package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ReceiverForm {
    @FindBy(name = "targetAddress.name")
    private WebElement reveiverName;

    @FindBy(name = "addresseeEmail")
    private WebElement reveiverEmail;

    @FindBy(name = "phoneNumber")
    private WebElement reveiverPhoneNo;

    @FindBy(name = "targetAddress.zipCode")
    private WebElement reveiverZipCode;

    @FindBy(css = ".ng-input > input")
    private WebElement receiverAPMNoInput;

    @FindBy(css = ".ng-input > input")
    private WebElement receiverAdressTown;

    @FindBy(name = "targetAddress.buildingNo")
    private WebElement receiverStreetNo;

    @FindBy(name = "targetAddress.flatNo")
    private WebElement receiverFlatNo;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[9]/div/app-input/div/div/div/app-selectpicker/ng-select/div/div/div[2]/input")
    private WebElement receiverAdressStreet;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[5]/div/app-input/div/div/app-error/small/ul/li")
    private WebElement badEmailError;

//    Parcelbox map

    @FindBy(css = ".open-map")
    private WebElement mapButton;

    @FindBy(css = ".modal-title")
    private WebElement mModal;

    @FindBy(css = ".search-input")
    private WebElement mMSearchBar;

    @FindBy(css = ".inpost-search__list > div")
    private WebElement mMSearchResult;

    @FindBy(css = ".select-link")
    private WebElement mMParcelBoxChoseButton;

    @FindBy(css = ".details-link")
    private WebElement mMParcelBoxDetailsButton;

    @FindBy(css = "p.name")
    private WebElement mMDetailsParcelBoxNo;

    private WebElement mapModalParcelBox;

    private WebElement receiverAPMNo;

    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();


    public ReceiverForm() {
        PageFactory.initElements(Base.driver, this);
    }

    public ReceiverForm fillReceiverName(String name) throws InterruptedException {
        actionPage.writeToForm(reveiverName ,name);
        return this;
    }

    public ReceiverForm fillReceiverEmail(String email) throws InterruptedException {
        actionPage.writeToForm(reveiverEmail ,email);
        return this;
    }

    public ReceiverForm fillReceiverNumber(String mumber) throws InterruptedException {
        actionPage.writeToForm(reveiverPhoneNo ,mumber);
        return this;
    }

    public ReceiverForm fillReceiverAPMCode(String apmNo) throws InterruptedException {
        actionPage.writeToForm(receiverAPMNoInput ,apmNo);
        waitPage.waitShort();
        receiverAPMNoInput.sendKeys(Keys.ENTER);
        return this;
    }

    public ReceiverForm clickReceiverAPMCode() throws InterruptedException {
        actionPage.clickElement(receiverAPMNoInput);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm fillReceiverZipCode(String apmNo) throws InterruptedException {
        actionPage.writeToForm(reveiverZipCode ,apmNo);
        waitPage.waitShort();
        reveiverZipCode.sendKeys(Keys.ENTER);
        return this;
    }

    public ReceiverForm fillReceiverTown(String apmNo) throws InterruptedException {
        actionPage.writeToForm(receiverAdressTown ,apmNo);
        waitPage.waitShort();
        receiverAdressTown.sendKeys(Keys.ENTER);
        return this;
    }

    public ReceiverForm fillReceiverStreet(String apmNo) throws InterruptedException {
        actionPage.clickElement(receiverAdressStreet);
        actionPage.writeToForm(receiverAdressStreet ,apmNo);
        waitPage.waitShort();
        receiverAdressStreet.sendKeys(Keys.ENTER);
        return this;
    }

    public ReceiverForm fillReceiverStreetNo(String name) throws InterruptedException {
        actionPage.writeToForm(receiverStreetNo ,name);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm fillReceiverFlatNo(String name) throws InterruptedException {
        actionPage.writeToForm(receiverFlatNo ,name);
        waitPage.waitShort();
        return this;
    }

    public WebElement emailErrorMessage() {
        return badEmailError;
    }

//    Parcelbox map

    public ReceiverForm clickMapButton() throws InterruptedException {
        actionPage.clickElement(mapButton);
        waitPage.waitShort();
        return this;
    }

    public WebElement getMapModal() {
        waitPage.waitForCss(".modal-title");
        return mModal;
    }

    public ReceiverForm fillSearchBarWithData(String town) throws InterruptedException {
        waitPage.waitForCss(".modal-title");
        actionPage.writeToForm(mMSearchBar ,town);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm clickMapModalSearchResult() throws InterruptedException {
        actionPage.clickElement( mMSearchResult);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm clickMapModalParcelBox(String parcelBox) throws InterruptedException {
        mapModalParcelBox = Base.driver.findElement(By.cssSelector("[alt=\"" + parcelBox + "\"]"));
        actionPage.clickElement( mapModalParcelBox);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm clickMMParcelBoxChoseButton() throws InterruptedException {
        actionPage.clickElement(mMParcelBoxChoseButton);
        waitPage.waitShort();
        return this;
    }

    public ReceiverForm clickMMParcelBoxDetailsButton() throws InterruptedException {
        actionPage.clickElement(mMParcelBoxDetailsButton);
        waitPage.waitShort();
        return this;
    }

    public WebElement getReceiverAPMNo(String parcelBox) {
        receiverAPMNo = Base.driver.findElement(By.xpath("//*[@id=\"" + parcelBox + "\"]/div[1]/div"));
        return receiverAPMNo;
    }

    public WebElement getMMDetailsParcelBoxNo() {
        return mMDetailsParcelBoxNo;
    }
}
