import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbasProductPageObject extends PageObject{

    @FindBy(xpath = "//li[@class='preferred-format__card']/button[@value=\"KITS\"]")
    private WebElement kitsFormatCard;

    @FindBy(xpath = "//input[@value=\"0158009150\"]/following-sibling::button")
    private WebElement firstProductAddToCartBtn;

    @FindBy(xpath="//div[@class='c-modal-actions']/a")
    private WebElement viewCartButton;

    public AbasProductPageObject(WebDriver driver) {
        super(driver);
    }


    public void clickOnKitsFormatCard(){
       kitsFormatCard.click();
    }

    public void clickOnAddtoCartBtn(){
        firstProductAddToCartBtn.click();
    }
    public WebElement getKitsFormatCard(){
        return kitsFormatCard;
    }
    public WebElement getAddtoCartBtn(){
        return  firstProductAddToCartBtn;
    }

    public void clickOnViewCartBtn(){
        viewCartButton.click();
    }
}
