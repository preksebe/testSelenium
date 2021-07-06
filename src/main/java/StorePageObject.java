import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StorePageObject extends PageObject {
    @FindBy(xpath = "href=\"/store/usassessments/en/Store/Professional-Assessments/Cognition-%26-Neuro/Activity-Measure-for-Post-Acute-Care/p/P100003000.html\"")
    private WebElement AMPAC_ProductLink;

    @FindBy(xpath="//a[@href=\"/store/usassessments/en/Store/Professional-Assessments/Behavior/Brief/Adaptive-Behavior-Assessment-System-%7C-Third-Edition/p/100001262.html\"]")
    private WebElement abasProductLink;

    @FindBy(xpath = "//div[@class=\"pagination-bar-results\"]/span")
    private WebElement paginationBarResults;

    @FindBy(xpath = "//div[@class=\"sort-refine-bar\"]//label[@class=\"control-label \"]/text()")
    private WebElement sortByText;

    @FindBy(xpath = "//a[@href='/store/usassessments/en/Store/c/store?q=%26%26relevance%26%26category%26%26cognition-neuro']")
    private WebElement cognitionAndNeuroLink;

    @FindBy(xpath = "//a[text()=\"Academic Learning\"]/following-sibling::span")
    private WebElement academicLearningNrOfProducts;

    @FindBy(xpath = "//button[@id=\"contextSwitchFormSubmit\"]")
    private WebElement formContinueButton;



    public StorePageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getAbasButton(){
        return abasProductLink;
    }

    public void clickOnFormContinueButton(){
        if(formContinueButton.isDisplayed()) {
            formContinueButton.click();
        }
    }

    public WebElement getFormContinueButton() {
            return formContinueButton;

    }
    public void scrollToFormButton(WebDriver driver, ScrollHelper scrollHelper){
        if(formContinueButton.isDisplayed()){
            scrollHelper.ScrollHorizontally(driver,formContinueButton);
        }
    }
    public void clickOnABASLink(){
        abasProductLink.click();
    }
}
