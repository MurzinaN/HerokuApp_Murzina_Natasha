import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/typos");
    }
    @Test
    public void typoInTextTest(){
        WebElement text = driver.findElement(By.xpath("//p[text()[contains(.,'Sometimes')]]"));
        String actualText = text.getText();
        String expectedText = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(actualText, expectedText, "checking for a typo");
    }
}
