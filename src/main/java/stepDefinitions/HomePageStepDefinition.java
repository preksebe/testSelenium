package stepDefinitions;

import PageObjects.HomePageObject;
import helpers.DriverManager;
import helpers.Sleepers;
import io.cucumber.java.en.When;
import io.cucumber.java8.Sl;
import org.openqa.selenium.WebDriver;

public class HomePageStepDefinition {
    WebDriver driver = DriverManager.getWebDriver();
    HomePageObject homePageObject = new HomePageObject(driver);
    Sleepers sleeper = new Sleepers();


    @When("the user clicks on the store button")
    public void theUserCLicksOnTheStoreButton()
    {
        sleeper.waitUntilDisplayed(driver,homePageObject.getStorePageButton());
        homePageObject.clickOnStoreButton();
    }

}
