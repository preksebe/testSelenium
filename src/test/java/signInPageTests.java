import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class signInPageTests {
    protected static WebDriver driver;
    protected static HomePageObject homePageObject;
    protected static SignInPageObject signInPageObject;
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
        homePageObject.clickOnSignInLink();
        signInPageObject = new SignInPageObject(driver);

        scrollHelper = new ScrollHelper();

    }


    @Test
    public void storeButtonFunctionality() {

        signInPageObject.clickOnStoreButton();
        Assert.assertEquals("The user has been taken to the store page", "https://www.pearsonassessments.com/store/usassessments/en/Store/c/store", driver.getCurrentUrl());
    }

    @Test
    public void checkSignInBreadCrumbText() {

        Assert.assertEquals("Sign in breadcrumb text is correct","Sign in", signInPageObject.getSignInText());
    }

    @Test
    public void forgotUserLinkFunctionality() {
        scrollHelper.ScrollHorizontally(driver,signInPageObject.getForgotUsernameAndPasswordLink());
        signInPageObject.clickOnUserAndPasswordLink();
        Assert.assertEquals("User has been taken to the password recovery page", "https://www.pearsonassessments.com/store/usassessments/en/login/pw/reset",driver.getCurrentUrl());
    }

    @Test
    public void checkPearsonLogoLinkFunctionality() {
        signInPageObject.clickOnPearsonLogo();
        Assert.assertEquals(" User has been taken to the Pearson home page","https://www.pearsonassessments.com/",driver.getCurrentUrl());
    }

    @Test
    public void checkIfEmailFieldIsFilled() {
        signInPageObject.fillEmailAddress();
        String emailText = signInPageObject.getEmailFieldText();
        Assert.assertEquals("Email field is filled with the correct adress","random@email.com", emailText);
    }

    @Test
    public void termsCheckBoxSelection() {
        scrollHelper.ScrollHorizontally(driver, signInPageObject.getTermsOfUseCheckBox());
        Assert.assertTrue("The check box is selected",signInPageObject.isCheckBoxSelected());
    }

    @Test
    public void checkSearchIconDisplay() {
        Assert.assertTrue("The search icon is displayed",signInPageObject.isSearchButtonIconDisplayed());
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }


}
