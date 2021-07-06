
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageObject extends PageObject {
    @FindBy(xpath = "//ul[contains(@class,\"item__list__cart\")]/li[1]//div[@class=\"item__ISBN\"][1]")
    private WebElement firstCartItemCode;

    @FindBy(xpath = "//label[@for=\"js-voucher-code-text\"]/following-sibling::em")
    private WebElement promotionCodeDescriptionText;

    @FindBy(xpath = "//div[@class=\"js-cart-totals row\"]//div[contains(@class,\"cart-totals-right\")]")
    private WebElement itemsSubtotalCartPriceText;

    @FindBy(xpath = "//div[@class=\"js-cart-totals row\"]//div[contains(@class,\"js-total-price\")]")
    private WebElement cartTotalPriceText;

    @FindBy(xpath = "//div[@class=\"js-cart-totals row\"]//div[contains(@class,\"notice\")]/em")
    private WebElement itemsSubtotalNoticeText;

    @FindBy(xpath = "//button [contains(@class,\"btn--continue-checkout\")]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//label[@for=\"context-unit-9407ccea16ec46499c4ba98671663a8e\"]")
    private WebElement accountSelectorLabel;

    @FindBy(xpath = "//button[@id = \"digitalAccountFormSubmit\"]")
    private WebElement checkoutContinueButton;

    public CartPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public WebElement getAccountSelectorLabel(){
        return accountSelectorLabel;
    }

    public void clickOnAccountSelectorLabel(){
        accountSelectorLabel.click();
    }

    public WebElement getContinueCheckoutButton(){
        return checkoutContinueButton;
    }

    public void clickOnContinueCheckout(){
        checkoutContinueButton.click();
    }

    public WebElement getCheckoutButton(){
        return checkoutButton;
    }
}
