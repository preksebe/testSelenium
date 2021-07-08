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
        protected static CheckoutPageObject checkoutPageObject;


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
            checkoutPageObject= new CheckoutPageObject(driver);

            scrollHelper = new ScrollHelper();

            Thread.sleep(1000);
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
            Thread.sleep(2000);
            Thread.sleep(2000);
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
            Thread.sleep(500);
            System.out.println("Nu mai las laptopul deblocat niciodata");
            //select Account and continue to checkout address field
            scrollHelper.ScrollHorizontally(driver, cartPageObject.getAccountSelectorLabel());
            cartPageObject.clickOnAccountSelectorLabel();
            scrollHelper.ScrollHorizontally(driver, cartPageObject.getContinueCheckoutButton());
            cartPageObject.clickOnContinueCheckout();

            //fill checkout info
            Thread.sleep(500);
            checkoutPageObject.selectCountryDropdown();
            Thread.sleep(500);
            checkoutPageObject.selectTitleDropdown();
            checkoutPageObject.fillFirstName();
            checkoutPageObject.fillLastName();
            checkoutPageObject.fillStreetInput();
            checkoutPageObject.fillCity();
            scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getStateDropdown());
            Thread.sleep(500);

            checkoutPageObject.selectState();

            scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getZipInput());

            checkoutPageObject.fillZipCode();

            scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getAddressSubmitButton());
            checkoutPageObject.clickOnAddressSubmit();

            Thread.sleep(1000);

            checkoutPageObject.clickOnShippmentSubmit();

            Thread.sleep(1000);

            checkoutPageObject.fillCardNumber();
            checkoutPageObject.selectExpiryDate();
            checkoutPageObject.selectExpiryYear();
            checkoutPageObject.fillSecurityCode();

            scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getTermsAndCondCheckbox());

            Thread.sleep(500);

            checkoutPageObject.checkTermsAndConditions();




        }

        @After
        public void cleanUp() {
            driver.manage().deleteAllCookies();
            driver.close();
        }

    }
