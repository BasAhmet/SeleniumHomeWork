package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class HW021_Alert extends TestBase {
    @Test
    public void test01() {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//*[@id='OKTab']/button")).click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        pause(1);
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        pause(1);
        driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
        pause(1);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        pause(1);

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        pause(1);
        driver.findElement(By.xpath("//*[@id='Textbox']/button")).click();
        pause(1);

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Ahmet");
        pause(1);
        driver.switchTo().alert().accept();
        pause(1);

        //-Çıkan mesajı konsola yazdırınız
        String message = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println(message);
        pause(1);

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertTrue(message.equals("Hello Ahmet How are you today"));
    }
}
