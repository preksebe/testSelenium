import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageObject extends PageObject{

    @FindBy(xpath = "//select[@id=\"address.country\"]")
    private WebElement countryDropdown;

    @FindBy(xpath = "//select[@id=\"address.country\"]//option[@value=\"US\"]")
    private WebElement countryDropdownUS;

    @FindBy(xpath = "//select[@id=\"address.title\"]")
    private WebElement titleDropdown;

    @FindBy(xpath="//select[@id=\"address.title\"]//option[@value=\"phd\"]")
    private WebElement getTitleDropdownPhd;

    @FindBy(xpath = "//input[@id=\"address.firstName\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id=\"address.surname\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id=\"address.line1\"]")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@id=\"address.townCity\"]")
    private WebElement cityInput;

    @FindBy(xpath = "//select[@id=\"address.region\"]")
    private WebElement stateDropdown;

    @FindBy(xpath = "//select[@id=\"address.region\"]//option[@value=\"US-AL\"]")
    private WebElement stateDropdownAlabama;

    @FindBy(xpath="//input[@id=\"address.postcode\"]")
    private WebElement zipInput;

    @FindBy(xpath = "//button[@id=\"addressSubmit\"]")
    private WebElement addressSubmitButton;

    @FindBy(xpath = "//button[@id=\"deliveryMethodSubmit\"]")
    private WebElement deliveryMethodSubmitButton;

    @FindBy(xpath="//input[@id=\"card_accountNumber\"]")
    private WebElement cardNumberInput;

    @FindBy(xpath="//select[@id=\"ExpiryMonth\"]")
    private WebElement expiryMonthDropdown;

    @FindBy(xpath ="//select[@id=\"ExpiryMonth\"]//option[@value=\"1\"]")
    private WebElement expiryMonthDropdownVal1;

    @FindBy(xpath="//select[@id=\"ExpiryYear\"]")
    private WebElement expiryYearDropdown;

    @FindBy(xpath="//select[@id=\"ExpiryYear\"]//option[@value=\"2022\"]")
    private WebElement expiryYearDropdownVal2022;

    @FindBy(xpath = "//input[@id=\"card_cvNumber\"]")
    private WebElement cvvFieldInput;

    @FindBy(xpath="//input[@id=\"Terms1\"]/following-sibling::span[@class=\"c-checkbox__check\"]")
    private WebElement termsAndCondCheckbox;



    public CheckoutPageObject(WebDriver driver) {
        super(driver);
    }

    public void fillStreetInput(){
        streetAddressInput.clear();
        streetAddressInput.sendKeys("801 Tom Martin Dr. Birmingham, AL 35211");
    }

    public void fillCity(){
        cityInput.clear();
        cityInput.sendKeys("Birmingham");
    }


    public void fillZipCode(){
        zipInput.clear();
        zipInput.sendKeys("35211");
    }

    public void selectCountryDropdown(){
        countryDropdown.click();
        countryDropdownUS.click();
    }

    public void selectTitleDropdown(){
        titleDropdown.click();
        getTitleDropdownPhd.click();
    }

    public void clickOnAddressSubmit(){
        addressSubmitButton.click();
    }

    public void fillFirstName(){
        firstNameInput.clear();
        firstNameInput.sendKeys("ion");
    }

    public void fillLastName(){
        lastNameInput.clear();
        lastNameInput.sendKeys("Ionescu");
    }

    public void selectState(){
        stateDropdown.click();
        stateDropdownAlabama.click();
    }

    public void clickOnShippmentSubmit(){
        deliveryMethodSubmitButton.click();
     }

    public void fillCardNumber(){
        cardNumberInput.clear();
        cardNumberInput.sendKeys("111111111111111");
    }
    public void selectExpiryDate(){
        expiryMonthDropdown.click();
        expiryMonthDropdownVal1.click();
    }

    public void selectExpiryYear(){
        expiryYearDropdown.click();
        expiryYearDropdownVal2022.click();
    }

    public void fillSecurityCode(){
        cvvFieldInput.clear();
        cvvFieldInput.sendKeys("111");
    }

    public void checkTermsAndConditions(){
        termsAndCondCheckbox.click();
    }

    public WebElement getStateDropdown(){
        return stateDropdownAlabama;
    }

    public WebElement getZipInput(){
        return zipInput;
    }

    public WebElement getAddressSubmitButton(){
        return addressSubmitButton;
    }

    public WebElement getTermsAndCondCheckbox(){
        return termsAndCondCheckbox;
    }



}
