import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BaseTest {

   protected WebDriver driver;

    @BeforeClass
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

   @AfterClass
    public void finish() {
        driver.quit();
    }
}
