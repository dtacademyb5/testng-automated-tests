package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLOutput;


public class GoogleSearchTestsRayBan {

    WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setupClass(){
        System.out.println("Setting up driver");
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass (alwaysRun = true)
    public void tearDown(){
        System.out.println("Generate report");
    }

    @BeforeMethod (alwaysRun = true)
    public void setupDriver(){
        driver = new ChromeDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void tearDownDriver(){
        driver.quit();
    }


    @Test
    public void testGoogleSearch(){
         String expected = "ray-ban";
        // Navigate to google
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));


    }

    @Test (groups = {"smoke"})
    public void testGoogleSearchNegative(){
        String expected = "ray-ban";
        // Navigate to google
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Verify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("chanel"));

    }






}
