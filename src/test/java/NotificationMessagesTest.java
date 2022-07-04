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
        Assert.assertFalse(driver.findElements(By.xpath("//*[contains(text(),'Action successful')]")).isEmpty(), "action success message");

    }
}
