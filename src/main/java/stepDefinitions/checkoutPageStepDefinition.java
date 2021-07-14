package stepDefinitions;

import PageObjects.CheckoutPageObject;
import helpers.Clicker;
import helpers.DriverManager;
import helpers.ScrollHelper;
import helpers.Sleepers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class checkoutPageStepDefinition {
    WebDriver driver= DriverManager.getWebDriver();

    CheckoutPageObject checkoutPageObject= new CheckoutPageObject(driver);
    ScrollHelper scrollHelper = new ScrollHelper();
    Sleepers sleeper = new Sleepers();
    Clicker clicker = new Clicker();


    @When("the user fills the billing address")
    public void theUserFillsTheBillingAddress() throws InterruptedException {
        checkoutPageObject.checkAddNewAddresRadioBtn();

        sleeper.wait5Seconds(driver);

        checkoutPageObject.selectCountryDropdown();

        sleeper.wait5Seconds(driver);

        checkoutPageObject.selectTitleDropdown();
        checkoutPageObject.fillFirstName();
        checkoutPageObject.fillLastName();
        checkoutPageObject.fillStreetInput();
        checkoutPageObject.fillCity();
        scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getStateDropdown());

        sleeper.wait5Seconds(driver);

        checkoutPageObject.selectState();

        scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getZipInput());

        checkoutPageObject.fillZipCode();

        scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getAddressSubmitButton());
        checkoutPageObject.clickOnAddressSubmit();

        sleeper.waitUntilLoaded(driver);

    }
    @And("the user clicks on the Submit Address NEXT button")
    public void theUserClicksOnTheSubmitAddressNEXTButton() {

        checkoutPageObject.clickOnShippmentSubmit();
    }


    @And("the user clicks on the SHipping Method NEXT button")
    public void theUserClicksOnTheSHippingMethodNEXTButton() {
    }


    @And("the credit card info modal appears")
    public void theCreditCardInfoModalAppears() {
    }

    @And("the user fills in the credit card info")
    public void theUserFillsInTheCreditCardInfo() {
        checkoutPageObject.fillCardNumber();
        checkoutPageObject.selectExpiryDate();
        checkoutPageObject.selectExpiryYear();
        checkoutPageObject.fillSecurityCode();
    }

    @And("the user checks the terms and conditions checkbox")
    public void theUserChecksTheTermsAndConditionsCheckbox() {
        scrollHelper.ScrollHorizontally(driver, checkoutPageObject.getTermsAndCondCheckbox());
        clicker.clickWIthJS(checkoutPageObject.getTermsAndCondCheckbox(), driver);

    }

    @Then("The place order button is clickable")
    public void thePlaceOrderButtonIsClickable() {
        Assert.assertTrue("THe use", checkoutPageObject.isButtonEnabled());
    }
}
