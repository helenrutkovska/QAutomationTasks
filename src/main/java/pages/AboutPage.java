package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage {
    private WebDriver driver;

    public AboutPage(WebDriver driver){
        this.driver = driver;
    }

    private By online = By.xpath("//div[@class='online_stat'][1]");
    private By inGame = By.xpath("//div[@class='online_stat'][2]");
    private By menuStore = By.xpath("//a[contains(@class,'menuitem') and contains(text(),'STORE')]");

    public Integer getOnlinePlayers() {
        String numberOnline = driver.findElement(online).getText().replaceAll("[^\\.0-9]","");
        int playersOnline = Integer.parseInt(numberOnline);
        return playersOnline;
    }

    public Integer getInGamePlayers() {
        String numberPlayers = driver.findElement(inGame).getText().replaceAll("[^\\.0-9]","");
        int playersInGame = Integer.parseInt(numberPlayers);
        return playersInGame;
    }

    public void clickMenuStore() {
        driver.findElement(menuStore).click();
    }
}
