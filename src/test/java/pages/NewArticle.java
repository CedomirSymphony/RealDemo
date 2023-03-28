package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewArticle extends CommonActions {

    WebDriver driver;

    public NewArticle(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public By articleTitle = By.cssSelector("input[ng-model='$ctrl.article.title']");

    public By articleDescription= By.cssSelector("input[ng-model='$ctrl.article.description']");

    public By articleBody = By.cssSelector("textarea[ng-model='$ctrl.article.body']");

    public By tagField = By.cssSelector("input[ng-model='$ctrl.tagField']");

    public By submitArticle = By.cssSelector("button[ng-click='$ctrl.submit()']");

    public By editArticle = By.cssSelector("a[ui-sref='app.editor({ slug: $ctrl.article.slug })']");

    public void inputArticleTitle() {
        inputText(driver.findElement(articleTitle), "Test Title","Added Title");
    }
    public void inputArticleDescription() {
        inputText(driver.findElement(articleDescription), "Test Description","Added Description");
    }
    public void inputArticleBody() {
        inputText(driver.findElement(articleBody), "Test Body","Added Body");
    }
    public void inputArticleTag() {
        inputText(driver.findElement(tagField), "Test Tag","Added Tag");
    }
    public void clickPublishArticleButton(){ clickElement(driver.findElement(submitArticle),"Kliknuo sam na Publish article");
    }
    public void clickEditArticleButton(){ clickElement(driver.findElement(editArticle),"Kliknuo sam na Edit article");
    }

    public void publishArticle(){
        inputArticleTitle();
        inputArticleDescription();
        inputArticleBody();
        inputArticleTag();
        clickPublishArticleButton();
    }

    public void publishAssert() {
        String submittedArticleTitle = driver.findElement(articleTitle).getAttribute("value");
        String submittedArticleDescription = driver.findElement(articleDescription).getAttribute("value");
        String submittedArticleBody = driver.findElement(articleBody).getAttribute("value");
        String submittedArticleTagField = driver.findElement(tagField).getText();

        Assert.assertEquals("Test Title", submittedArticleTitle);
        Assert.assertEquals("Test Description", submittedArticleDescription);
        Assert.assertEquals("Test Body", submittedArticleBody);
    }
}
