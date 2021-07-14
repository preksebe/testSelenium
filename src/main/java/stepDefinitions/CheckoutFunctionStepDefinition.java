package stepDefinitions;

import PageObjects.*;
import helpers.DriverManager;
import helpers.ScrollHelper;
import helpers.Sleepers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CheckoutFunctionStepDefinition {
    WebDriver driver= DriverManager.getWebDriver();
    StorePageStepDefinition storePageStepDefinition= new StorePageStepDefinition();
    CartPageObject cartPageObject= new CartPageObject(driver);
    ScrollHelper scrollHelper = new ScrollHelper();
    AbasProductPageStepDefinition abasProductPageStepDefinition = new AbasProductPageStepDefinition();
    HomePageStepDefinition homePageStepDefinition = new HomePageStepDefinition();
    Sleepers sleeper = new Sleepers();


    @And("the user added One product to the card")
    public void theUserAddedOneProductToTheCard() throws InterruptedException {
        homePageStepDefinition.theUserCLicksOnTheStoreButton();
        sleeper.waitUntilLoaded(driver);

        storePageStepDefinition.theUserClicksOnTHeAbasLink();
        sleeper.waitUntilLoaded(driver);

        abasProductPageStepDefinition.theUserAddsAProductToCart();
    }

    @And("the user goes on the cart page")
    public void theUserGoesOnTheCartPage() {
        abasProductPageStepDefinition.theUserClicksOnTheCartButton();

    }

    @When("the user clicks on the checkout button")
    public void theUserClicksOnTheCheckoutButton() {
        sleeper.waitUntilLoaded(driver);
        scrollHelper.ScrollHorizontally(driver, cartPageObject.getCheckoutButton());
        cartPageObject.clickOnCheckoutButton();
        sleeper.wait5Seconds(driver);
    }

    @Then("the user is taken to the account selection page")
    public void theUserIsTakenToTheAccountSelectionPage() {
        if (driver.getCurrentUrl().equals("https://www.pearsonassessments.com/store/usassessments/en/digital-accounts"))
        {
            System.out.println("the user is on the Account selection page");
        }
        else
        {
            System.out.println("the test failed on the Account selection page");

        }
    }


    @Then("the user is taken to the billing Address page")
    public void theUserIsTakenToTheBillingAddressPage() {
        if(driver.getCurrentUrl().equals("")){
            System.out.println("the user is on the Billing address page");
        }
        else
        {
            System.out.println("the test failed on the billing address page");

        }
    }




    @Then("the user is ready for checkout")
    public void theUserIsReadyForCheckout() {
        System.out.println("hooray");
    }


}
