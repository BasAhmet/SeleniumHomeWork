package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW009_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Util.setChromeProperty(15);

        int addElementClick = 100;
        int deleteElementClick = 90;

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < addElementClick; i++) {
            addButton.click();
            Util.sleep(0.5F);
        }

        // 100 defa basıldığını test ediniz
        List<WebElement> deleteButtons1 = driver.findElements(By.xpath("//*[@id='elements']/button"));
        if(deleteButtons1.size() == 100){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED : " + deleteButtons1.size());
        }

        // 90 defa delete butonuna basınız
        for (int i = 0; i < 90; i++) {
            driver.findElement(By.xpath("//*[@id='elements']/button")).click();
            Util.sleep(0.5F);
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButtons2 = driver.findElements(By.xpath("//*[@id='elements']/button"));
        if(deleteButtons2.size() == 10){
            System.out.println("Test PASSED.");
        }else {
            System.out.println("Test FAILED : " + deleteButtons2.size());
        }

        // Sayfayı kapatınız
        driver.close();
    }
}
