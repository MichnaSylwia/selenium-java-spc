import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class ValidLogInTest extends BaseTest {

    @Test
    public void validLogTest() {
        System.setProperty("webserver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://spc-app.azurewebsites.net");
        driver.manage().window().maximize();
        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("test@test.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("Test1!");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        WebElement welcomeElm = driver.findElement(By.cssSelector(".profile_info>h2"));

        Assert.assertTrue(welcomeElm.isDisplayed());
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"));

        driver.quit();


    }

  /*  @Test
    public void validLogInTest(){
        TO DO
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail("test@test.com");
        loginPage.typePassword("Test1!");
        HomePage homePage = loginPage.submitLogin();

        Assert.assertTrue(homePage.welcomeElm.isDisplayed(), "Welcome element is not shown.");
        */
}


