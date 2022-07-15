import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }
    final static String EXPECTED_TEXT = "You selected a context menu";

    @Test
    public void contextMenuAlertTextTest(){
        WebElement boxElement = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(boxElement).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        driver.switchTo().defaultContent();
        Assert.assertEquals(alertText, EXPECTED_TEXT, "Alert text should be 'You selected a context menu'");
    }
}
