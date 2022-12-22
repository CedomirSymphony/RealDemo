package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends CommonActions {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public By inputUserNameField = By.xpath("//input[@placeholder='Username']");
    public By inputUserEmailField = By.xpath("//input[@placeholder='Email']");
    public By inputUserPasswordField = By.xpath("//input[@placeholder='Password']");
    public By signUpButton = By.className("btn");

    public void inputUserNameField() {
        inputText(driver.findElement(inputUserNameField),"Cedaaaaa","Uneto je ime");
    }
    public void inputUserEmailField() {
        inputText(driver.findElement(inputUserEmailField),"Cedaaaaa@rrererreee.com","Unet je email");
    }
    public void inputUserPasswordField() {
        inputText(driver.findElement(inputUserPasswordField),"password123","Unet je password");
    }
    public void clickSignUpButton() {
        clickElement(driver.findElement(signUpButton), "Kliknuo sam Sign up button");
    }
}
