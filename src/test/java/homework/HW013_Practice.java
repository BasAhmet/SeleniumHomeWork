package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW013_Practice {
    /*
    https://www.facebook.com adresine gidin
    Cookies’i kabul edin
    “Create an Account” button’una basin
    “radio buttons” elementlerini locate edin
    Secili degilse cinsiyet butonundan size uygun olani secin
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");

    }

    @Test
    public void test01() throws InterruptedException {
        // Cookies’i kabul edin
        System.out.println("Cookies Çıkmadı");

        // “Create new Account” button’una basin
        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();

        // “radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[1]"));
        WebElement male = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[2]"));
        WebElement custom = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[3]"));

        // Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        male.click();
        Thread.sleep(3000);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }














}
