package uitests.googleSearchTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GoogleSearchTestsChicken {

    WebDriver driver;

    @BeforeClass (alwaysRun = true)  // alwaysRun must be set to true for all Before and After Annotations when running group tests
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


    @Test (groups = {"smoke"})
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


    @Test (groups = {"smoke", "login"})
    public void TC0001_SPR2_UI_988(){
        String expected = "rooster";
        // Navigate to google
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));


    }

    @Test (groups = "login")
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
