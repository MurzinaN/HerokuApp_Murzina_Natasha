import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TablesTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/tables");
    }
    @Test
    public void SortableDataTablesTest(){
        WebElement dataTable = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        String actualText = dataTable.getText();
        String expectedText = "Smith";
        Assert.assertEquals(actualText, expectedText, "text from first table 1 row 1 cell");
        dataTable = driver.findElement(By.xpath("//table//tr[2]//td[3]"));
        actualText = dataTable.getText();
        expectedText = "fbach@yahoo.com";
        Assert.assertEquals(actualText, expectedText, "text from first table 2 row 3 cell");
        dataTable = driver.findElement(By.xpath("//table//tr[4]//td[5]"));
        actualText = dataTable.getText();
        expectedText = "http://www.timconway.com";
        Assert.assertEquals(actualText, expectedText, "text from first table 4 row 5 cell");
        dataTable = driver.findElement(By.xpath("//table[@id='table2']//tr[1]//td[@class='last-name']"));
        actualText = dataTable.getText();
        expectedText = "Smith";
        Assert.assertEquals(actualText, expectedText, "text from second table 1 row 1 cell");
        dataTable = driver.findElement(By.xpath("//table[@id='table2']//tr[2]//td[@class='email']"));
        actualText = dataTable.getText();
        expectedText = "fbach@yahoo.com";
        Assert.assertEquals(actualText, expectedText, "text from second table 2 row 3 cell");
        dataTable = driver.findElement(By.xpath("//table[@id='table2']//tr[4]//td[@class='web-site']"));
        actualText = dataTable.getText();
        expectedText = "http://www.timconway.com";
        Assert.assertEquals(actualText, expectedText, "text from second table 4 row 5 cell");

    }
}
