package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TakeScreenshotOnFailureListener {

    WebDriver driver;



    @BeforeMethod(alwaysRun = true)
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod()
    public void tearDownDriver(ITestResult testResult) throws IOException {
       if(testResult.getStatus() == ITestResult.FAILURE){
           File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(screenshotAs, new File("failure.png"));
       }

        driver.quit();
    }


    @Test
    public void testGoogleSearch() throws IOException {

      // Example of reading from properties file

//        FileInputStream fis = new FileInputStream("configuration.properties");
//        Properties properties = new Properties();
//        properties.load(fis);
//        System.out.println(properties.getProperty("url"));
//        System.out.println(properties.getProperty("password"));



        String expected = "ray-ban";
        // Navigate to google
        String urlValue = ConfigReader.getProperty("url");
        driver.get(urlValue);
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(expected, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expected));


    }

    @Test()
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
