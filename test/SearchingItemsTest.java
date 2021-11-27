import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LandingPage;
import pages.SearchResultsPage;

public class SearchingItemsTest {

    private static ChromeDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testSearchingItems() {
        new LandingPage(driver).open()
                .clearAndInputItemName("shirt")
                .clickOnSearchIcon();
        new SearchResultsPage(driver)
                .assertProductListingHeaderText("SHIRT");
    }
}
