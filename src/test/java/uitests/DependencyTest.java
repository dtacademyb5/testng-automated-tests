package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class DependencyTest {

    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDownDriver(){
        driver.quit();
    }



    @Test
    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fProcess.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertTrue(false);

    }




    @Test (dependsOnMethods = {"login"})
    public void verifyCheckAll(){

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement element : elements) {
            Assert.assertTrue(element.isSelected());
        }


    }



    @Test (expectedExceptions = NullPointerException.class)
    public void exceptionTest(){

        throw new NullPointerException();
    }


    @Test (timeOut = 5)
    public void timeOutTest() throws InterruptedException {
        Thread.sleep(6000);
    }



}
