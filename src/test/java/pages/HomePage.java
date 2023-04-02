package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonActions {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public By signUpButtonLink = By.xpath("//a[contains(text(),'Sign up')]");
    public By userProfile = By.xpath("//a[@class='nav-link ng-binding']");
    public By newArticle = By.cssSelector("a[ui-sref='app.editor']");
    public By settingsProfile = By.cssSelector("a[ui-sref='app.settings']");
    public By LogoutButton = By.xpath("//button[contains(text(),'logout')]");
    public By LoginButton = By.xpath("//a[contains(text(),'Sign in')]");

    public void clickSignUpButtonLink(){
        clickElement(driver.findElement(signUpButtonLink), "Kliknuo sam Sign up button link");
    }
    public void clickUserProfile(){
        clickElement(driver.findElement(userProfile),"Kliknuo sam na link userProfile");
    }
    public void clickNewArticle(){
        clickElement(driver.findElement(newArticle),"New article button clicked");
    }
    public void clickSettingsProfile(){
        clickElement(driver.findElement(settingsProfile),"Nasao sam profile settings");
    }
    public void clickLogoutButton(){ clickElement(driver.findElement(LogoutButton),"Kliknuo sam na Logout button");
    }
    public void clickLoginButton(){ clickElement(driver.findElement(LoginButton),"Kliknuo sam na Login button");
    }

}
