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
        inputText(driver.findElement(inputUserNameField),faker.name().firstName()+"che","Name is input");
    }
    public void inputUserEmailField() {
        inputText(driver.findElement(inputUserEmailField),faker.name().firstName()+"@cheda.com","Email is input");
    }
    public void inputUserPasswordField() {
        inputText(driver.findElement(inputUserPasswordField),"password123","Password is input");
    }
    public void clickSignUpButton() {
        clickElement(driver.findElement(signUpButton), "Sign up button is selected");
    }
}
