package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HW017_Practice {
    //1.http://zero.webappsecurity.com/ Adresine gidin
    //2.Sign in butonuna basin
    //3.Login kutusuna “username” yazin
    //4.Password kutusuna “password.” yazin
    //5.Sign in tusuna basin(not: navigate.Back yapınız)
    //6.Pay Bills sayfasina gidin
    //7.“Purchase Foreign Currency” tusuna basin
    //8.“Currency” drop down menusunden Eurozone’u secin
    //9.“amount” kutusuna bir sayi girin
    //10.“US Dollars” in secilmedigini test edin
    //11.“Selected currency” butonunu secin
    //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test01() throws InterruptedException {
        //2.Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3.Login kutusuna “username” yazin -----> 4.Password kutusuna “password.” yazin -----> 5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        driver.navigate().back();
        Thread.sleep(2000);

        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(2000);

        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();
        Thread.sleep(2000);

        //8.“Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropDown = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(currencyDropDown);
        select.selectByValue("EUR");
        Thread.sleep(2000);

        //9.“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("10000");
        Thread.sleep(2000);

        //10.“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.xpath("(//*[@class='radio inline'])[2]")).isSelected());
        Thread.sleep(2000);


        //11.“Selected currency” butonunu secin -----> 12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("(//*[@class='radio inline'])[3]")).sendKeys(Keys.SPACE,Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER);
        Thread.sleep(2000);

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='alert_content']")).getText().equals("Foreign currency cash was successfully purchased."));
        Thread.sleep(2000);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
