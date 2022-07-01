import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
public class DropDownTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void selectDropdownTest(){
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();
        List<String> expectedOptions = new ArrayList<String>();
        expectedOptions.add("Please select an option");
        expectedOptions.add("Option 1");
        expectedOptions.add("Option 2");
        List<String> actualOption =options.stream().map(option -> option.getText()).toList();
        Assert.assertEquals(actualOption, expectedOptions, "checking for dropdown elements");
        select.selectByValue("1");
        String expectedValue = "1";
        String selectedValue = select.getFirstSelectedOption().getAttribute("value");
        Assert.assertEquals(selectedValue, expectedValue, "value should be 1");
        select.selectByVisibleText("Option 2");
        String selectedText = driver.findElement(By.cssSelector("[selected='selected']")).getText();
        String expectedText = "Option 2";
        Assert.assertEquals(selectedText, expectedText, "visible text should be Option 2");


    }
}
