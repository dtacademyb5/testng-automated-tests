package uitests;


import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParametrizedTestXmlFile {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        System.out.println("Setting up driver");
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Generate report");
    }

    @BeforeMethod
    public void setupDriver(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDownDriver(){
        driver.quit();
    }







    @Test
    @Parameters({"link","term", "year"})
    public void testGoogleSearchChicken(String url, String searchTerm, int year){
//        String expected = "chicken";
        // Navigate to google

        System.out.println(year);
        driver.get(url);
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchTerm));


    }
}
