package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

    @FindBy(linkText = "Zapłać")
    private WebElement payButton;

    private WebDriver driver;

    public SummaryPage () {
        PageFactory.initElements(Base.driver, this);
    }




}
