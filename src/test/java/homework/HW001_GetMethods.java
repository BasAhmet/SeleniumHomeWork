package homework;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW001_GetMethods {
    public static void main(String[] args) throws InterruptedException {
        Util.setChromeProperty();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasina gidelim. https://www.amazon.com/
        String url = "https://www.amazon.com/";
        driver.get(url);

        //Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        //Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitleAmazon = driver.getTitle();
        String expectedTitleAmazon = "Amazon";
        if (actualTitleAmazon.contains(expectedTitleAmazon)) {
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        //Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        //Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrlAmazon = driver.getCurrentUrl();
        String expectedUrlAmazon = "amazon";
        if (actualUrlAmazon.contains(expectedUrlAmazon)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        //Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String actualHTMLAmazon = driver.getPageSource();
        String expectedHTMLAmazon = "Gateway";
        if(actualHTMLAmazon.contains(expectedHTMLAmazon)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        Thread.sleep(3000);

        //Sayfayi kapatin.
        driver.close();

    }
}
