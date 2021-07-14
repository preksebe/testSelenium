package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver webDriver;
    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

}