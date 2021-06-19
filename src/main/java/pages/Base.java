package pages;

import helper.WaitPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    private static WaitPage waitPage;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        waitPage = new WaitPage();
        driver.manage().window().maximize();

//      Kod pisany poza siecią firmową, bez dostęppu do oneclicka
        driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
//        driver.get("https://inpost.pl/SzybkieNadania/");

        // todo odpowiednio skonfigurować sleepa.
        waitPage.waitLong();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


}
