import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/frames");
    }
    final static String EXPECTED_TEXT = "Your content goes here.";
    @Test
    public void iframeTest(){
        WebElement iframeLink = driver.findElement(By.xpath("//a[@href='/iframe']"));
        iframeLink.click();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(0);
        String actualText = driver.findElement(By.cssSelector("#tinymce p")).getText();
        Assert.assertEquals(actualText, EXPECTED_TEXT, "Text should be 'Your content goes here.'");
        driver.switchTo().defaultContent();
    }
}
