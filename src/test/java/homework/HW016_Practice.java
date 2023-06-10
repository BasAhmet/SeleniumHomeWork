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

public class HW016_Practice {
    //https://www.amazon.com/ adresine gidin.
    //-Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-Test 2
    //1.Kategori menusunden Books secenegini secin
    //2.Arama kutusuna Java yazin ve aratin
    //3.Bulunan sonuc sayisini yazdirin
    //4.Sonucun Java kelimesini icerdigini test edin
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test01() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
        WebElement kategoriMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(kategoriMenu);
        Assert.assertTrue(select.getOptions().size()==28);
    }

    @Test
    public void test02() throws InterruptedException {
        //1.Kategori menusunden Books secenegini secin
        WebElement kategoriMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(kategoriMenu);
        select.selectByIndex(5);
        Thread.sleep(2000);

        //2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        Thread.sleep(3000);

        //3.Bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] resultText = result.getText().split(" ");
        System.out.println(resultText[3]);

        //4.Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(result.getText().contains("Java"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
