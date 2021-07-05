import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutFunctionTest {
        protected static WebDriver driver;
        protected static HomePageObject homePageObject;
        protected static SignInPageObject signInPageObject;
        protected static AbasProductPageObject abasProductPageObject;
        protected static StorePageObject storePageObject;
        protected static ScrollHelper scrollHelper;

        @Before
        public void setUp() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.pearsonassessments.com/");
            driver.manage().window().maximize();
            homePageObject = new HomePageObject(driver);

            Thread.sleep(1000);

            homePageObject.closePopUps();
            storePageObject=new StorePageObject(driver);
            abasProductPageObject= new AbasProductPageObject(driver);

            scrollHelper = new ScrollHelper();

        }
        @Test
        public void checkAddToCardFunction() throws InterruptedException {
            homePageObject.clickOnStoreButton();
            Thread.sleep(1000);
            scrollHelper.ScrollHorizontally(driver,storePageObject.getAbasButton());
            storePageObject.closeCookieNotification();
            storePageObject.clickOnABASLink();
            Thread.sleep(1000);
            scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getKitsFormatCard());
            abasProductPageObject.clickOnKitsFormatCard();
            scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getAddtoCartBtn());
            abasProductPageObject.clickOnAddtoCartBtn();
            Thread.sleep(2000);
            abasProductPageObject.clickOnViewCartBtn();
        }


        @After
        public void cleanUp() {
            driver.manage().deleteAllCookies();
            driver.close();
        }

    }
