package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GoogleSearchTestsChicken {

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
    public void testGoogleSearchChicken(){
         String expected = "chicken";
        // Navigate to google
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));


    }

    @Test
    public void testGoogleSearchNegativeChicken(){
        String expected = "chicken";
        // Navigate to google
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Verify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));

    }


    @Test
    public void testGoogleSearchRooster(){
        String expected = "rooster";
        // Navigate to google
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));


    }

    @Test
    public void testGoogleSearchNegativeRooster(){
        String expected = "rooster";
        // Navigate to google
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Verify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));

    }






}
