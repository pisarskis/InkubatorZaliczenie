package pages;

import helper.WaitPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public static WebDriver driver;
    private static WaitPage waitPage;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        waitPage = new WaitPage();
        driver.manage().window().maximize();
        driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
