package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class HW007_Practice_Search {
    public static void main(String[] args) throws InterruptedException {
        Util.setChromeProperty();
        WebDriver driver = new ChromeDriver();
        Util.maximize(driver);
        Util.duration(driver,15);

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonuç yazısını konsola yazdırınız
        List<WebElement> resultText = driver.findElements(By.className("sg-col-inner"));
        System.out.println(resultText.get(0).getText());

        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
        List<WebElement> linkList = driver.findElements(By.tagName("h2"));
        List<String> iphoneLink = new ArrayList<>();
        for (WebElement w : linkList) {
            iphoneLink.add(w.findElement(By.tagName("a")).getAttribute("href"));
        }

        for (int i = 0; i < 5; i++) {
            driver.get(iphoneLink.get(i));
            System.out.println((i+1) + ".Ürünün Sayfa Başlığı : " + driver.getTitle());
            System.out.println("*********************************");
        }
        driver.close();
    }
}
