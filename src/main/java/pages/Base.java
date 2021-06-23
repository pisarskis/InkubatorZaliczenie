package pages;

import helper.WaitPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public static WebDriver driver;
    private static WaitPage waitPage;
    private static FormPage formPage;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        waitPage = new WaitPage();
        formPage = new FormPage();
        driver.manage().window().maximize();

        driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        waitPage.waitLong();
    }

    @After
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        waitPage.waitLong();
        formPage.closeCookiesPopup();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
