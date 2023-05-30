package homework;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW003_ManageWindow {
    public static void main(String[] args) throws InterruptedException {
        Util.setChromeProperty();
        ChromeDriver driver = new ChromeDriver();

        //Amazon soyfasina gidelim. https://www.amazon.com/
        String url = "https://www.amazon.com/";
        driver.get(url);

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfa Konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfa Boyutu : " + driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Util.sleep(3);
        driver.manage().window().maximize();

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Konum : " + driver.manage().window().getPosition());
        System.out.println("Boyut : " + driver.manage().window().getSize());

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Full Konum : " + driver.manage().window().getPosition());
        System.out.println("Full Boyut : " + driver.manage().window().getSize());

        //Sayfayi kapatin
        driver.close();

    }


}
