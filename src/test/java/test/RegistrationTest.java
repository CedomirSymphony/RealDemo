package test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
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
//        driver.get("https://demo.realworld.io/#/");
//
//        HomePage homePage = new HomePage(driver);
//        homePage.clickSignUpButtonLink();
//
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.registerNewUser();
//
//        By feedElement = By.xpath("//*[contains(text(),'Your Feed')]");
//
//        WebElement e = driver.findElement(feedElement);
////        String actualElementText = e.getText();
////        String expectedElementText = "Your Feed";
////        Assert.assertEquals(actualElementText, expectedElementText,"Expected "+expectedElementText+" and Actual is "+actualElementText);
//
//        homePage.clickUserProfile();
//        homePage.clickSettingsProfile();
//
//        ProfileSettings profileSettings = new ProfileSettings(driver);
//        profileSettings.fillProfileSettingsData();
//
//        homePage.clickSettingsProfile();
//        String userEmail = profileSettings.getEmail();
//
////        homePage.clickLogoutButton();
////        homePage.clickLoginButton();
////
////        LoginPage loginPage = new LoginPage(driver);
////        loginPage.loginUser(userEmail,"password123");
////        loginPage.clickLoginInButton();

        //log().all()


        String userJson = new JSONObject().
            put("user", new JSONObject().
                put("email", "ticapyhusa@mailinator.com").
                put("password", "xobymere")).
            toString();

        String userToken =
            given().
                body(userJson).
                contentType("application/json").
                when().
                post("https://api.realworld.io/api/users/login").
                then().
                assertThat().
                statusCode(200)
                .extract().
                path("user.token");

        driver.get("https://demo.realworld.io/#/");
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("jwtToken", userToken);

        String tokenValue = localStorage.getItem("jwtToken");

        if (tokenValue != null && tokenValue.equals(userToken)) {
            System.out.println("User is logged in!");
        } else {
            System.out.println("User is not logged in.");
        }

        driver.navigate().refresh();

        Thread.sleep(15000);

    }
}
