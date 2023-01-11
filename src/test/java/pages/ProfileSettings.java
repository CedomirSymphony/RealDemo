package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileSettings extends CommonActions {

    WebDriver driver;

    public ProfileSettings(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public By URLProfilePicture = By.xpath("//input[starts-with(@placeholder, 'URL')]");

    public By UserName = By.xpath("//input[contains(@placeholder, 'Username')]");

    public By Bio = By.xpath("//textarea[contains(@placeholder, 'Short bio about you')]");

    public By Email = By.xpath("//input[contains(@placeholder, 'Email')]");

    public By Password = By.xpath("//input[contains(@placeholder, 'Password')]");

    public By UpdateProfileButton = By.xpath("//button[contains(text(),'Update')]");

    public void inputURLProfilePicture() {
        inputText(driver.findElement(URLProfilePicture),"www.urlcheda.com","URLProfilePicture is input");
    }
    public void inputUserName() {
        inputText(driver.findElement(UserName),faker.name().firstName(),"Username is input");
    }
    public void inputBio() {
        inputText(driver.findElement(Bio),"This is fake Bio","Bio is input");
    }
    public By inputEmail() {
        inputText(driver.findElement(Email),faker.name().firstName()+"@cheda.com","Email is input");
        return null;
    }
    public void inputPassword() {
        inputText(driver.findElement(Password),faker.name().firstName()+"Password","Password is input");
    }
    public void clickUpdateProfileButton(){ clickElement(driver.findElement(UpdateProfileButton),"Kliknuo sam na Update profile");
    }

}
