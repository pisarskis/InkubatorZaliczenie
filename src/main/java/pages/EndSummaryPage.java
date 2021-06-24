package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndSummaryPage {
    @FindBy(xpath = "//*[@id=\"publicPage\"]/div[2]/app-summary/section[1]/div[1]/div/lib-mat-with-text/div/div[2]/span")
    private WebElement paymentStatus;

    @FindBy(css = "div.parcel-summary-container > button")
    private WebElement refreshButton;

    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    public EndSummaryPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public WebElement getPaymentStatus() {
        return paymentStatus;
    }

    public EndSummaryPage clickRefreshButton() {
        actionPage.clickElement(refreshButton);
        return this;
    }
}
