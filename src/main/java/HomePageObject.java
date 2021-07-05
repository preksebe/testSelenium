import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends PageObject {

    @FindBy(xpath = "//button[@class=\"pmc-alert__dismiss\"]")
    private WebElement alertDismissButton;

    @FindBy(xpath = "//div[contains(@class,\"info-menu\")]//following-sibling::div[contains(@class,\"onedotcom-page-search\")]//input[@class=\"search-box-input\"]")
    private WebElement searchInputBar;

    @FindBy(xpath = "//div[contains(@class,\"custom-header\")]//a[@class=\"login-link \"]")
    private WebElement signInRegisterLink;

    @FindBy(xpath = "//div[@class=\"pop-up\"]")
    private WebElement popUpBox;

    @FindBy(xpath = "//button[@class=\"pop-up-close\"]")
    private WebElement popUpBoxCloseButton;

    @FindBy(xpath ="//div[@id=\"custom-header\"]//a[@title='Store']")
    private WebElement storePageButton;

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public void closePopUps() {
        if (popUpBox.isDisplayed()) {
            popUpBoxCloseButton.click();
        }

        if (alertDismissButton.isDisplayed()) {
            alertDismissButton.click();
        }

    }

    public void clickOnStoreButton(){
        storePageButton.click();
    }

    public void clickOnSignInLink() {
        signInRegisterLink.sendKeys(Keys.ENTER);
    }
}