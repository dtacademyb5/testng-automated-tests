package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SoftAseertDeno  {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)  // alwaysRun must be set to true for all Before and After Annotations when running group tests
    public void setupClass(){
        System.out.println("Setting up driver");
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        System.out.println("Generate report");
    }

    @BeforeMethod(alwaysRun = true)
    public void setupDriver(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
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
        // Verify that title contains that term
        String actualTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(actualTitle.contains(expected+"sbav"));

        softAssert.assertTrue(driver.getCurrentUrl().contains(expected));

        softAssert.assertEquals("dchs", "svcds");

        softAssert.assertAll();


    }
}
