import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputsTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/inputs");
    }
    @Test
    public void inputsValues(){
        WebElement inputValue = driver.findElement(By.tagName("input"));
        inputValue.sendKeys("abc");
        String actualLettersValue = inputValue.getAttribute("value");
        String expectedLettersValue = "";
        SoftAssert asert = new SoftAssert();
        asert.assertEquals(actualLettersValue, expectedLettersValue, "on display should be abc");
        asert.assertAll();
        inputValue.clear();
        inputValue.sendKeys("123");
        String actualNumbersValue = inputValue.getAttribute("value");
        String expectedNumbersValue = "123";
        Assert.assertEquals(actualNumbersValue, expectedNumbersValue, "on display should be 123");
        inputValue.sendKeys(Keys.ARROW_UP);
        inputValue.sendKeys(Keys.ARROW_UP);
        inputValue.sendKeys(Keys.ARROW_UP);
        String actualNumbersValueArrowUp = inputValue.getAttribute("value");
        String expectedNumbersValueArrowUp = "126";
        Assert.assertEquals(actualNumbersValueArrowUp, expectedNumbersValueArrowUp, "on display should be 126");
        inputValue.sendKeys(Keys.ARROW_DOWN);
        inputValue.sendKeys(Keys.ARROW_DOWN);
        String actualNumbersValueArrowDown = inputValue.getAttribute("value");
        String expectedNumbersValueArrowDown = "124";
        Assert.assertEquals(actualNumbersValueArrowDown, expectedNumbersValueArrowDown, "on display should be 124");

    }

}
