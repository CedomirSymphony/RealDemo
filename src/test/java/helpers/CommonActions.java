package helpers;

import com.github.javafaker.Faker;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonActions {
    WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    public static final int SLEEP_PERIOD_1s = 1000; //milliseconds

    public static final int SLEEP_PERIOD_5s = 5000; //milliseconds

    public static final int SLEEP_PERIOD_30s = 30000; //milliseconds

    public void clickElement(WebElement element, String log){
        WebDriverWait wdWait = new WebDriverWait(driver,SLEEP_PERIOD_5s);
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        System.out.println("Clicked element: "+log);
    }

    public void inputText (WebElement element, String text, String log){
        WebDriverWait wdWait = new WebDriverWait(driver,SLEEP_PERIOD_30s);
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        element.clear();
        element.sendKeys(text);

        System.out.println("Typed text: "+text+" to element: "+log);
    }
    public void assertEqualsText(WebElement element, String expected, String log) throws IOException {
        Assert.assertEquals(element.getText(),expected,log);
    }
    public Faker faker = new Faker();
}
