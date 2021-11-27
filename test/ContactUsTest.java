import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsErrors;
import pages.ContactUsPage;

public class ContactUsTest {

    private static ChromeDriver driver;
    private String INVALID_EMAIL = "invalid_email";
    private String VALID_EMAIL = "test@test.test";

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        Dimension dem = new Dimension(1140, 900);
        driver.manage().window().setSize(dem);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Before
    public void goToContactUs() {
        new ContactUsPage(driver)
                .open();
    }

    @Test
    public void contactUsNegative_InvalidEmail() {
        new ContactUsPage(driver)
                .assertContactUsPageIsOpened("CUSTOMER SERVICE")
                .selectCustomerService()
                .clearAndInputEmail(INVALID_EMAIL)
                .unselectFields()
                .assertEmailValidationError()
                .sendForm();
        new ContactUsErrors(driver)
                .assertErrorNumber(1)
                .assertInvalidEmail();
    }


    @Test
    public void contactUsNegative_MissingMessage() {
        new ContactUsPage(driver)
                .assertContactUsPageIsOpened("CUSTOMER SERVICE")
                .selectCustomerService()
                .clearAndInputEmail(VALID_EMAIL)
                .sendForm();
        new ContactUsErrors(driver)
                .assertErrorNumber(1)
                .assertMessageBlank();
    }


    @Test
    public void contactUsNegative_SubjectNotProvided() {
        new ContactUsPage(driver)
                .assertContactUsPageIsOpened("CUSTOMER SERVICE")
                .clearAndInputEmail(VALID_EMAIL)
                .unselectFields()
                .assertEmailValidationOk()
                .clearAndInputMessage("Test message")
                .sendForm();
        new ContactUsErrors(driver)
                .assertErrorNumber(1)
                .assertSubjectNotProvided();
    }

    @Test
    public void contactUs_Success() {
        new ContactUsPage(driver)
                .assertContactUsPageIsOpened("CUSTOMER SERVICE")
                .selectCustomerService()
                .clearAndInputEmail(VALID_EMAIL)
                .unselectFields()
                .assertEmailValidationOk()
                .clearAndInputMessage("Test message")
                .sendForm()
                .assertSuccess();
    }
}
