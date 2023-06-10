package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HW015_Practice {
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın.
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void test01() throws InterruptedException {
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        //4.Tüm dropdown değerleri(value) yazdırın
        select.getOptions().forEach(t-> System.out.println(t.getText()));
        Thread.sleep(3000);

        //5.Dropdown’un boyutunu bulun
        System.out.println(driver.findElement(By.xpath("//*[@id='dropdown']")).getSize());
        Thread.sleep(3000);

        //Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        if(select.getOptions().size()==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        Thread.sleep(3000);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
