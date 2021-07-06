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
        protected static CartPageObject cartPageObject;

        @Before
        public void setUp() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.pearsonassessments.com/");
            driver.manage().window().maximize();
            homePageObject = new HomePageObject(driver);

            Thread.sleep(1000);

            homePageObject.closePopUps();
            homePageObject.closeCookieNotification();
            storePageObject=new StorePageObject(driver);
            abasProductPageObject= new AbasProductPageObject(driver);
            signInPageObject= new SignInPageObject(driver);
            cartPageObject=new CartPageObject(driver);

            scrollHelper = new ScrollHelper();

        }
        @Test
        public void checkAddToCardFunction() throws InterruptedException {
            homePageObject.clickOnStoreButton();
            Thread.sleep(1000);
            scrollHelper.ScrollHorizontally(driver,storePageObject.getAbasButton());
            storePageObject.clickOnABASLink();
            Thread.sleep(1000);
            scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getKitsFormatCard());
            abasProductPageObject.clickOnKitsFormatCard();
            scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getAddtoCartBtn());
            abasProductPageObject.clickOnAddtoCartBtn();
            Thread.sleep(2000);
            abasProductPageObject.clickOnViewCartBtn();
        }

        @Test
        public void checkCheckoutFunction() throws InterruptedException {
            //sign in
            homePageObject.clickOnSignInLink();
            signInPageObject.fillPasswordField();
            signInPageObject.fillUsernameField();
            signInPageObject.clickOnSignInButton();
            Thread.sleep(1000);
            //add product to cart
            homePageObject.clickOnStoreButton();
            Thread.sleep(500);
            scrollHelper.ScrollHorizontally(driver, storePageObject.getFormContinueButton());
            Thread.sleep(500);
            storePageObject.clickOnFormContinueButton();
            scrollHelper.ScrollHorizontally(driver,storePageObject.getAbasButton());
            storePageObject.clickOnABASLink();
            Thread.sleep(1000);
            scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getKitsFormatCard());
            abasProductPageObject.clickOnKitsFormatCard();
            scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getAddtoCartBtn());
            abasProductPageObject.clickOnAddtoCartBtn();
            Thread.sleep(2000);
            abasProductPageObject.clickOnViewCartBtn();
            //go to checkOut
            scrollHelper.ScrollHorizontally(driver, cartPageObject.getCheckoutButton());
            cartPageObject.clickOnCheckoutButton();
        }

        @After
        public void cleanUp() {
            driver.manage().deleteAllCookies();
            driver.close();
        }

    }
