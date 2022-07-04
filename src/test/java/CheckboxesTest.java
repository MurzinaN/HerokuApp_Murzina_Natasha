import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void CheckboxesElementTest(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        Assert.assertFalse(checkboxes.get(0).isSelected(),"first checkbox unchecked");
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(), "first checkbox checked");
        Assert.assertTrue(checkboxes.get(1).isSelected(), "second checkbox checked");
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected(), "second checkbox unchecked");

    }
}
