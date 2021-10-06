package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyListener.class)
public class ListenerTests {


    @Test
    public void m1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dice.com/");
        Assert.assertTrue(driver.getTitle().contains("Dice.com"));

    }


    @Test
    public void m2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dice.com/");
        Assert.assertTrue(driver.getTitle().contains("dice.com"));

    }

    @Test
    public void m3(){
        throw new SkipException("cdsbhc");

    }

}
