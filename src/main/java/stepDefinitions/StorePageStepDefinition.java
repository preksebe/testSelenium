package stepDefinitions;

import PageObjects.StorePageObject;
import helpers.DriverManager;
import helpers.ScrollHelper;
import helpers.Sleepers;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.beans.IntrospectionException;

public class StorePageStepDefinition {

    WebDriver driver= DriverManager.getWebDriver();
    StorePageObject storePageObject= new StorePageObject(driver);
    ScrollHelper scrollHelper = new ScrollHelper();
    Sleepers sleeper = new Sleepers();


    @And("The user clicks on the ABAS link")
    public void theUserClicksOnTHeAbasLink() throws InterruptedException
    {
        sleeper.waitUntilDisplayed(driver,storePageObject.getFormContinueButton());
        storePageObject.clickOnFormContinueButton(driver,scrollHelper);
        scrollHelper.ScrollHorizontally(driver,storePageObject.getAbasButton());
        storePageObject.clickOnABASLink();
    }
}
