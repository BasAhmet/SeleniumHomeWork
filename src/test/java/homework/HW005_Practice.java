package homework;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW005_Practice {
    public static void main(String[] args) {
        Util.setChromeProperty();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://tr-tr.facebook.com/");

        // sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Verify.");
        }else{
            System.out.println("Title : " + actualTitle);
        }

        // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("facebook")){
            System.out.println("Verify.");
        }else{
            System.out.println("Url : " + actualUrl);
        }

        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        if(driver.getTitle().contains("Walmart.com")){
            System.out.println("Verify.");
        }else{
            System.out.println("Not Verify. " + driver.getTitle());
        }

        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // Sayfayi yenileyin
        driver.navigate().refresh();

        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // Browser’i kapatin
        driver.close();

    }
}
