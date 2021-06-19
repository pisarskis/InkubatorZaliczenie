import helper.ActionPage;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.Base;
import pages.FormPage;

public class webTest extends Base {
    private static FormPage formPage = new FormPage();
    private static ActionPage actionPage = new ActionPage();

    @BeforeClass
    public static void shotDownCiasteczko() throws InterruptedException {
        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @Test
    public void firstTest() throws Exception {

    }
}
