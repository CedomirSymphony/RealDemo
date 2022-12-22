package test;

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
import pages.RegistrationPage;

public class RegistrationTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Users/cedomirlukic/IdeaProjects/POM1/src/main/resources/chromedriver");

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
        registrationPage.inputUserNameField();
        registrationPage.inputUserEmailField();
        registrationPage.inputUserPasswordField();
        registrationPage.clickSignUpButton();

        WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Your Feed')]"));
        String actualElementText = e.getText();
        String expectedElementText = "Your Feed";
        Assert.assertEquals(actualElementText, expectedElementText,"Expected "+expectedElementText+" and Actual is "+actualElementText);
    }
}
