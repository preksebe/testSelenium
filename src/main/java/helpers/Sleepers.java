package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Sleepers {

    public void waitUntilDisplayed(WebDriver driver, WebElement webElement){
        if(webElement != null){
           new WebDriverWait(driver,
                   5,1000).until(ExpectedConditions.visibilityOf(webElement));
        }
    }

    public void wait5Seconds(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void waitUntilLoaded(WebDriver driver){
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }



}
