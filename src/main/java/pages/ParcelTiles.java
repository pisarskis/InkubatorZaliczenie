package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParcelTiles {

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[1]/label/div/app-parcel-options/div/div/div/p[1]/span[1]/img")
    private WebElement parcelATileImg;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[1]/label/div/app-parcel-options/div/div/div/p[1]/span[2]")
    private WebElement parcelATileDimensions;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[1]/label/div/app-parcel-options/div/div/div/p[2]")
    private WebElement parcelATilePrice;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[2]/label/div/app-parcel-options/div/div/div/p[1]/span[1]/img")
    private WebElement parcelBTileImg;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[2]/label/div/app-parcel-options/div/div/div/p[1]/span[2]")
    private WebElement parcelBTileDimensions;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[2]/label/div/app-parcel-options/div/div/div/p[2]")
    private WebElement parcelBTilePrice;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[3]/label/div/app-parcel-options/div/div/div/p[1]/span[1]/img")
    private WebElement parcelCTileImg;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[3]/label/div/app-parcel-options/div/div/div/p[1]/span[2]")
    private WebElement parcelCTileDimensions;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[1]/app-dynamic-form/form/app-section[2]/div/app-input[2]/div/div/div/app-input-radio/span[3]/label/div/app-parcel-options/div/div/div/p[2]")
    private WebElement parcelCTilePrice;

    public ParcelTiles() {
        PageFactory.initElements(Base.driver, this);
    }

    public WebElement getParcelATileImg() {
        return parcelATileImg;
    }

    public WebElement getParcelATileDimensions() {
        return parcelATileDimensions;
    }

    public WebElement getParcelATilePrice() {
        return parcelATilePrice;
    }

    public WebElement getParcelBTileImg() {
        return parcelBTileImg;
    }

    public WebElement getParcelBTileDimensions() {
        return parcelBTileDimensions;
    }

    public WebElement getParcelBTilePrice() {
        return parcelBTilePrice;
    }

    public WebElement getParcelCTileImg() {
        return parcelCTileImg;
    }

    public WebElement getParcelCTileDimensions() {
        return parcelCTileDimensions;
    }

    public WebElement getParcelCTilePrice() {
        return parcelCTilePrice;
    }
}
