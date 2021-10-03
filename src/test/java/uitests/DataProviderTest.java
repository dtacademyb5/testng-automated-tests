package uitests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {




    @Test (dataProvider = "getData")
    public void testGoogleSearchChicken(String searchTerm){

        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();


        driver.get("https://www.google.com/");
        //Search for a term
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        // Varify that title contains that term
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchTerm));

        driver.quit();

    }


    @DataProvider
    public Object[][] getData(){

        return new Object[][]{
                {"roses"},
                {"mouse"},
                {"读写汉字 - 学中文"},
                {"Владимир Путин"},
                {"$#@#$@#%^^^"}
        };
    }



    @Test (dataProvider = "getData2")
    public void tesdataProvider(String firstName, String last, String address, String card, String email){
        System.out.println(firstName);
        System.out.println(last);
        System.out.println(address);
        System.out.println(card);
        System.out.println(email);
        System.out.println("-----------------------------------------");

    }


    @DataProvider
    public Object[][] getData2(){
        Faker faker =  new Faker();
        return new Object[][]{
                {faker.name().firstName(), faker.name().lastName(), faker.address().fullAddress(), faker.business().creditCardNumber(), faker.internet().emailAddress()},
                {faker.name().firstName(), faker.name().lastName(), faker.address().fullAddress(), faker.business().creditCardNumber(), faker.internet().emailAddress()},
                {faker.name().firstName(), faker.name().lastName(), faker.address().fullAddress(), faker.business().creditCardNumber(), faker.internet().emailAddress()}

        };
    }



    // How to generate test data?
     //  0. If the data is something small like a password, I can generate it myself
    // 1. Use a test data library, mock data library such as Faker
    // 2. Use a third party service to generate data in excel or csv file.
    //    Mockaroo



    @Test
    public void tesFaker(){

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
    }




}
