import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing {


//    public static void main(String[] args) {
//
//        System.out.println("hello");
//        WebDriverManager.chromedriver().setup();  // Boni garcia dependency to automate drivers setup
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://mvnrepository.com/");
//    }

    // Unit test -> devs do that, testing the smallest unit like smallest functionality
    // Integration/Functional Test -> QA does that once all unit/smallest functionalities are integrated into a one large functionality

    @Test
    public void m1(){
         Calculator calculator = new Calculator();
         long result = calculator.add(6, 4);
        Assert.assertEquals(10, result);
    }


    @Test
    public void m2(){  // unit test
        Calculator calculator = new Calculator();
        long result = calculator.add(2000000000, 2000000000);
        Assert.assertEquals(4000000000L, result);
    }









}
