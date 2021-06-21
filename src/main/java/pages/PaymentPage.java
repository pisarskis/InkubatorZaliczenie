package pages;

import helper.ActionPage;
import helper.WaitPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    ActionPage actionPage = new ActionPage();
    WaitPage waitPage = new WaitPage();

    private static String bankName;

    @FindBy(xpath = "//*[@id=\"paymenttypeMain\"]/div[7]")
    private WebElement clickAliorBank;

    @FindBy(xpath = "//*[@id=\"blikPaymentForm\"]/div[7]/button[1]/div[2]")
    private WebElement clickFinishButton;


    public PaymentPage() {
        PageFactory.initElements(Base.driver, this);
    }

    public void setBankName(String name){
        bankName = name;
    }

    public PaymentPage chooseBank() throws InterruptedException {
        clickAliorBank.click();
        waitPage.waitShort();
        return this;
    }

    public PaymentPage clickFinishButton() throws InterruptedException {
        clickFinishButton.click();
        waitPage.waitShort();
        return this;
    }

}
