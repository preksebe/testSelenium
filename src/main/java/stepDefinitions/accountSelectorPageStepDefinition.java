package stepDefinitions;

import PageObjects.CartPageObject;
import helpers.DriverManager;
import helpers.ScrollHelper;
import helpers.Sleepers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java8.Ca;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class accountSelectorPageStepDefinition {
    WebDriver driver= DriverManager.getWebDriver();
    ScrollHelper scrollHelper = new ScrollHelper();
    CartPageObject cartPageObject = new CartPageObject(driver);
    Sleepers sleeper = new Sleepers();
    @When("The user selects myAccount")
    public void theUserSelectsMyAccount() {
        sleeper.waitUntilLoaded(driver);
        scrollHelper.ScrollHorizontally(driver, cartPageObject.getAccountSelectorLabel());
        cartPageObject.clickOnAccountSelectorLabel();
    }

    @And("the user clicks on the NEXT button")
    public void theUserClicksOnTheAccountSelectorNEXTButton() {
        scrollHelper.ScrollHorizontally(driver, cartPageObject.getContinueCheckoutButton());
        cartPageObject.clickOnContinueCheckout();
    }
}
