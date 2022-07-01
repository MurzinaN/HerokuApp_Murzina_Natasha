import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NotificationMessagesTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }
    @Test
    public void notificationMessagesTextTest(){
        WebElement clickHere = driver.findElement(By.xpath("//*[text()='Click here']"));
        clickHere.click();
        WebElement notificationMessage = driver.findElement(By.id("flash-messages"));
        String actualText = notificationMessage.getText();
        String expectedText = "Action successful";
        Assert.assertEquals(actualText, expectedText, "action success message");

    }
}
