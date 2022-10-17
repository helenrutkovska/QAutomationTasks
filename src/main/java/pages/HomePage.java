package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By menuAbout = By.xpath("//a[contains(@class,'menuitem') and contains(text(),'ABOUT')]");

    public void clickMenuAbout() {
        driver.findElement(menuAbout).click();
    }

}
