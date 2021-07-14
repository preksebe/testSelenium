package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageObject extends PageObject {

    @FindBy(xpath = "//div[@id='site-logo']/a[@title='Pearson logo']")
    private WebElement pearsonLogo;

    @FindBy(className = "search-box-icon")
    private WebElement searchBoxIcon;

    @FindBy(xpath = "//ol[@class=\"c-breadcrumb__list show-children--all\"]/li[text()=\"Sign in\"]")
    private WebElement breadcrumbSignInText;

    @FindBy(xpath = "//ul[@class=\"nav__links nav__links--account \"]//a[@href=\"/store/usassessments/en/Store/c/store\"]")
    private WebElement navigationBarStoreButton;

    @FindBy(xpath = "//a[@class='pull-right forgotten-username']")
    private WebElement forgotUsernameAndPasswordLink;

    @FindBy(id = "emailID")
    private WebElement emailAddressRegisterInput;

    @FindBy(xpath = "//input[@id=\"acceptTermsOfUse\"]")
    private WebElement termsOfUseCheckBox;

    @FindBy(xpath = "//label[@class=\"c-checkbox \"]/span[@class=\"c-checkbox__check\"]")
    private WebElement termsOfUseCheckText;

    @FindBy(xpath = "//div[contains(@class,\"create-account-holder\")]//button")
    private WebElement createAccountSubmitButton;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath="//input[@id=\'password\']")
    private WebElement passwordField;

    @FindBy(xpath="//div[contains(@class,\"sign-in-holder\")]//button")
    private WebElement signInButton;


    public SignInPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickOnPearsonLogo() {
        pearsonLogo.click();
    }

    public WebElement getForgotUsernameAndPasswordLink(){
        return forgotUsernameAndPasswordLink;
    }

    public void fillEmailAddress() {
        emailAddressRegisterInput.sendKeys("random@email.com");

    }
    public void fillUsernameField(){
        usernameField.clear();
        usernameField.sendKeys("vladut.antal@youngculture.com");
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void fillPasswordField(){
        passwordField.clear();
        passwordField.sendKeys("Francisc1234");
    }

    public String getEmailFieldText() {
        return emailAddressRegisterInput.getAttribute("value");
    }

    public void clickOnUserAndPasswordLink() {
        forgotUsernameAndPasswordLink.click();
    }

    public boolean isCheckBoxSelected() {
        termsOfUseCheckText.click();
        return termsOfUseCheckBox.isSelected();
    }

    public WebElement getTermsOfUseCheckBox() {
        return termsOfUseCheckBox;
    }


    public String getSignInText() {
        return breadcrumbSignInText.getText();
    }

    public boolean isSearchButtonIconDisplayed() {

        return searchBoxIcon.isDisplayed();

    }

    public void clickOnStoreButton() {
        navigationBarStoreButton.click();
    }

}
