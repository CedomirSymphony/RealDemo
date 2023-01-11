package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonActions {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public By inputLoginUserName = By.xpath("//input[contains(@placeholder, 'Username')]");
    public By inputLoginPassword = By.xpath("//input[@placeholder='Password']");
    public By loginInButton = By.xpath("//button[contains(text(),'Sign in')]");

    public void inputLoginUserName(){
        inputText(driver.findElement(inputLoginUserName),"Lewis@cheda.com","Username is added");
    }
    public void inputLoginPassword(){
        inputText(driver.findElement(inputLoginPassword),"password123","Password is input");
    }
    public void clickLoginInButton() {
        clickElement(driver.findElement(loginInButton), "Log in button is selected");
    }
}
