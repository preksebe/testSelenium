package stepDefinitions;

import PageObjects.AbasProductPageObject;
import helpers.DriverManager;
import helpers.ScrollHelper;
import helpers.Sleepers;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class AbasProductPageStepDefinition {

    WebDriver driver = DriverManager.getWebDriver();

    ScrollHelper scrollHelper= new ScrollHelper();
    AbasProductPageObject abasProductPageObject = new AbasProductPageObject(driver);
    Sleepers sleeper = new Sleepers();


    @And("THe user adds a product to cart")
    public void theUserAddsAProductToCart(){
        scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getKitsFormatCard());
        abasProductPageObject.clickOnKitsFormatCard();
        scrollHelper.ScrollHorizontally(driver,abasProductPageObject.getAddtoCartBtn());
        abasProductPageObject.clickOnAddtoCartBtn();

    }
    @And("The user clicks on the cart button")
    public void theUserClicksOnTheCartButton(){
        sleeper.waitUntilDisplayed(driver,abasProductPageObject.getViewCartButton());
        abasProductPageObject.clickOnViewCartBtn();
    }
}
