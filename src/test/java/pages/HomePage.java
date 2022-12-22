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

    public By yourFeedTab = By.xpath("");
    public void clickSignUpButtonLink(){
        clickElement(driver.findElement(signUpButtonLink), "Kliknuo sam Sign up button link");
    }
}
