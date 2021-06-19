package pages;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");

        // todo odpowiednio skonfigurować sleepa.
        TimeUnit.SECONDS.sleep(10);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


}
