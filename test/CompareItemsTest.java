import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LandingPage;
import pages.ProductComparisonPage;
import pages.SearchResultsPage;

public class CompareItemsTest {

    private static ChromeDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        Dimension dem = new Dimension(1140, 900);
        driver.manage().window().setSize(dem);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void compareItemsFeatures() {
        new LandingPage(driver).open()
                .clearAndInputItemName("shirt")
                .clickOnSearchIcon();
        new SearchResultsPage(driver)
                .addItemToCompare();
        new LandingPage(driver)
                .clearAndInputItemName("blouse")
                .clickOnSearchIcon();
        new SearchResultsPage(driver)
                .addItemToCompare()
                .clickOnCompareButton();
        new ProductComparisonPage(driver)
                .assertProductComparisonPageIsOpened("PRODUCT COMPARISON");
    }

}
