package homework;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW006_Practice {
    public static void main(String[] args) {
        Util.setChromeProperty();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//      Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Verify.");
        }else{
            System.out.println(actualTitle);
        }

//      Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("youtube")){
            System.out.println("Verify.");
        }else{
            System.out.println(actualUrl);
        }

//      Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//      Youtube sayfasina geri donun
        driver.navigate().back();

//      Sayfayi yenileyin
        driver.navigate().refresh();

//      Amazon sayfasina donun
        driver.navigate().forward();

//      Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

//      Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
        actualTitle = driver.getTitle();
        if (actualTitle.contains("Amazon")){
            System.out.println("Verify.");
        }else{
            System.out.println(actualTitle);
        }

//      Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        actualUrl = driver.getCurrentUrl();
        if(actualUrl.equals("https://www.amazon.com/")){
            System.out.println("Verify.");
        }else{
            System.out.println(actualUrl);
        }

//      Sayfayi kapatin
        driver.close();

    }
}
