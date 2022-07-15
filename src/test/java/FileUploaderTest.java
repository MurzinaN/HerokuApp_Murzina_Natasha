import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseTest{
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }
    final static String FILE_NAME = "sun.jpg";

    @Test
    public void uploaderTest(){
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(System.getProperty("user.dir")+"/src/main/resources/sun.jpg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, FILE_NAME, "Checking the name of the uploaded file");
    }
}
