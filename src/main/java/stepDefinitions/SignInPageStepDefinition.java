package stepDefinitions;

import PageObjects.HomePageObject;
import PageObjects.SignInPageObject;
import helpers.DriverManager;
import helpers.Sleepers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInPageStepDefinition {

    WebDriver driver= DriverManager.getWebDriver();
    HomePageObject homePageObject= new HomePageObject(driver);
    SignInPageObject signInPageObject = new SignInPageObject(driver);
    Sleepers sleeper = new Sleepers();
    @Given("The user is on pearson assessments")
    public void theUserIsOnPearsonAssessments() {
        driver.get("https://www.pearsonassessments.com/");
        sleeper.waitUntilLoaded(driver);
    }

    @When("The user clicks on the sign in Button")
    public void theUserClicksOnTheSignInLink() {
        homePageObject.clickOnSignInLink();
        sleeper.waitUntilLoaded(driver);
    }

    @Then("The user is taken to the login page")
    public void theUserIsTakenToTheLoginPage() {
        if(driver.getCurrentUrl().equals("https://www.pearsonassessments.com/store/usassessments/en/login"))
        {
            System.out.println("The user is on the login page");
        }
        else {
            System.out.println("The test failed on the login page");
        }}

    @When("The user inputs the login data")
    public void theUserInputsTheLoginData() {

        signInPageObject.fillPasswordField();
        signInPageObject.fillUsernameField();
    }

    @And("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        signInPageObject.clickOnSignInButton();
    }

    @Then("The user is logged into pearson assessments")
    public void theUserIsLoggedIntoPearsonAssessments() {
        if(driver.getCurrentUrl().equals("https://www.pearsonassessments.com/"))
        {
            System.out.println("The user is logged in");
        }
        else
        {
            System.out.println("The test failed after login");

        }
    }

    @And("The user closes the popups")
    public void theUserClosesThePopups() {
        homePageObject.closePopUps();
        homePageObject.closeCookieNotification();
    }

    @And("The user maximises the window")
    public void theUserMaximisesTheWindow() {
        driver.manage().window().maximize();
    }

    @And("The user is signed in")
    public void theUserIsSignedIn() {
        driver.manage().window().maximize();
        theUserClosesThePopups();
        theUserClicksOnTheSignInLink();
        theUserInputsTheLoginData();
        theUserClicksOnTheLoginButton();
    }
}
