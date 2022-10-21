package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.HomePage;
import utils.WebDriverSetup;


public class PageTest {

    WebDriverSetup wds = new WebDriverSetup();
    WebDriver driver = wds.driverSettings();

    @Test
    public void openMyWebsite() throws Exception {

        driver.get("https://store.steampowered.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Steam";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @BeforeMethod
    public void beforeMethod() {

        driver.manage().window().maximize();

        driver.get("https://store.steampowered.com");

        HomePage testHomePage = new HomePage(driver);
        testHomePage.clickMenuAbout();

        AboutPage testAboutPage = new AboutPage(driver);
        String actualTitleAP = driver.getTitle();
        String expectedTitleAP = "Steam, The Ultimate Online Game Platform";
        Assert.assertEquals(actualTitleAP, expectedTitleAP);
        Assert.assertTrue(testAboutPage.getOnlinePlayers() > testAboutPage.getInGamePlayers(), "Number of in-game players is less than number of players online");

        testAboutPage.clickMenuStore();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Steam";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}