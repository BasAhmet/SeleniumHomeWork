package homework;

import org.openqa.selenium.WebDriver;

public class HW010_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Util.setChromeProperty(15);

        // "https://www.amazon.com/" adresine gidiniz.
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        // "https://www.n11.com/" adresine gidiniz.
        driver.get("https://www.n11.com/");
        Thread.sleep(2000);

        // amazon adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(2000);

        // n11 adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(2000);

        // sayfayi yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(2000);

        // pencereyi kapat
        driver.close();
        Thread.sleep(2000);

        // Konsola "HER ŞEY YOLUNDA" yazdir
        System.out.println("HER ŞEY YOLUNDA");
    }
}
