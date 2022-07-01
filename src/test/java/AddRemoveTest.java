import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class AddRemoveTest extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addRemoveElementTest(){
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.get(0).click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Integer actualSize = deleteButtons.size();
        Integer expectedSize = 1;
        Assert.assertEquals(actualSize, expectedSize, "there should be 1 button on the display");

    }
}
