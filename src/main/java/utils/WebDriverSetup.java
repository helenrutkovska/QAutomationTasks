package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSetup {
    public WebDriver driverSettings() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
