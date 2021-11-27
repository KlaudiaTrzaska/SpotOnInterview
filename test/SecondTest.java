import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.LandingPage;
import pages.SearchResultsPage;

public class SecondTest {


    private static ChromeDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        Dimension dem = new Dimension(1140,900);
        driver.manage().window().setSize(dem);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void searchForItemsAddToTheCartAndGoToCheckoutSection() {
        new LandingPage(driver).open()
                .clearAndInputItemName("dress")
                .clickOnSearchIcon();
        new SearchResultsPage(driver)
                .assertDressName("Printed Dress")
                .clickOnAddToCartButton()
                .assertSuccessMessageWhenProductIsAddedToTheCart()
                .clickOnContinueShoppingButton();
        new LandingPage(driver)
                .clearAndInputItemName("shirt")
                .clickOnSearchIcon();
        new SearchResultsPage(driver)
                .assertShirtName("Faded Short Sleeve T-shirts")
                .clickOnAddToCartButton()
                .assertSuccessMessageWhenProductIsAddedToTheCart()
                .clickOnProceedToCheckoutButton();
        new CartPage(driver)
                .assertProductQuantityEquals(2)
                .changeShirtQuantity(2)
                .deleteDressFromCart()
                .assertPrintedSummerDressNotPresent()
                .assertProductQuantityEquals(2);

    }
}
