package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfileSettings;
import pages.RegistrationPage;

public class RegistrationTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void signUp() throws InterruptedException {
        driver.get("https://demo.realworld.io/#/");

        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButtonLink();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerNewUser();

        By feedElement = By.xpath("//*[contains(text(),'Your Feed')]");

        WebElement e = driver.findElement(feedElement);
        String actualElementText = e.getText();
        String expectedElementText = "Your Feed";
        Assert.assertEquals(actualElementText, expectedElementText,"Expected "+expectedElementText+" and Actual is "+actualElementText);

        homePage.clickUserProfile();
        homePage.clickSettingsProfile();

        ProfileSettings profileSettings = new ProfileSettings(driver);
        profileSettings.fillProfileSettingsData();

        Thread.sleep(2000);

        homePage.clickSettingsProfile();
        String userEmail = profileSettings.getEmail();

        homePage.clickLogoutButton();
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(userEmail,"password123");

        Thread.sleep(3000);
    }
}
