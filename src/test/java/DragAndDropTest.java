import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
    }
    @Test
    public void DragAndDropABTest(){
        WebElement cubeA = driver.findElement(By.id("column-a"));
        WebElement cubeB = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(cubeA, cubeB).build().perform();
        //actions.clickAndHold(cubeA).moveToElement(cubeA).release(cubeB).build().perform();
    }
}
