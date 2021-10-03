package uitests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParametrizedCrossBrowserTest {











    @Test
    @Parameters("browser")
    public void testGoogleSearchChicken(String browser){
        WebDriver driver = null;

        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;

        }



        String searchTerm = "chicken";
        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchTerm));

        driver.quit();


    }
}
