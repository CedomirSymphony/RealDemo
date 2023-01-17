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
    public By inputLoginUserName = By.cssSelector("input[ng-model='$ctrl.formData.email']");
    public By inputLoginPassword = By.cssSelector("input[ng-model='$ctrl.formData.password']");
    public By loginInButton = By.cssSelector("button[ng-bind='$ctrl.title']");

//    public void inputLoginUserName(){
//        inputText(driver.findElement(inputLoginUserName),"userEmail","Username is added");
//    }
//    public void inputLoginPassword(){
//        inputText(driver.findElement(inputLoginPassword),"password123","Password is input");
//    }
//    public void clickLoginInButton() {
//        clickElement(driver.findElement(loginInButton), "Log in button is selected");
//    }
//    public void fillLoginForm(){
//        inputLoginUserName();
//        inputLoginPassword();
//        clickLoginInButton();
//    }
    public void loginUser(String username, String password){
        inputText(driver.findElement(inputLoginUserName),username,"Username is added");
        inputText(driver.findElement(inputLoginPassword),password,"Password is input");
        clickElement(driver.findElement(loginInButton), "Log in button is selected");
    }
}
