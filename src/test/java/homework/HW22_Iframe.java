package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class HW22_Iframe extends TestBase {
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        driver.switchTo().frame("emoojis");
        xpath("(//a[@class='mdl-tabs__tab'])[1]").click();

        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojies = driver.findElements(By.xpath("//*[@id='nature']/div"));
        emojies.forEach(t-> System.out.println(t.getText()));

        // Parent iframe e geri donun
        driver.switchTo().defaultContent();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        String xpathText = "(//input[@type='text'])";
        xpath(xpathText + "[1]").sendKeys("Ahmet");
        pause(1);
        xpath(xpathText + "[2]").sendKeys("Gülücük");
        pause(1);
        xpath(xpathText + "[3]").sendKeys("Doğal");
        pause(1);
        xpath(xpathText + "[4]").sendKeys("Poğaça");
        pause(1);
        xpath(xpathText + "[5]").sendKeys("Aktivite");
        pause(1);
        xpath(xpathText + "[6]").sendKeys("Mekan");
        pause(1);
        xpath(xpathText + "[7]").sendKeys("Obje");
        pause(1);
        xpath(xpathText + "[8]").sendKeys("Sembol");
        pause(1);
        xpath(xpathText + "[9]").sendKeys("Bayrak");
        pause(1);
        xpath(xpathText + "[10]").sendKeys("Ctrl+1");
        pause(1);
        xpath(xpathText + "[11]").sendKeys("Ctrl+2");
        pause(3);

        // Apply button a basiniz
        xpath("//*[@id='send']").click();
    }

}
