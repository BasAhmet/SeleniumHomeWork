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
import java.util.List;

public class HW014_Practice {
    /*
    - Before methodu ile drive'i olusturup ayarlamalari yapiniz
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - After methodu ile sayfayı kapatalım
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        // Before methodu ile drive'i olusturup ayarlamalari yapiniz
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // ebay sayfasına gidiniz
        driver.get("http://www.ebay.com");
    }

    @Test
    public void test01() throws InterruptedException {
        //    - electronics bölümüne tıklayınız
        driver.findElement(By.className("hl-cat-nav__js-tab")).click();

        //    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> images = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 0; i < images.size(); i++) {
            images = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            images.get(i).click();
            Thread.sleep(3000);

            //    - Her sayfanın sayfa başlığını yazdıralım
            System.out.println((i+1) + ". Sayfa Başlığı : " + driver.getTitle());

            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        //    - After methodu ile sayfayı kapatalım
        driver.close();
    }
}
