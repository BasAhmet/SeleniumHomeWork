package homework;

import org.junit.Test;
import utilities.TestBase;

public class HW023_Practice extends TestBase {
    @Test
    public void test01() {
        //    Google ana sayfasını aç https://www.google.com
        driver.get("https://www.google.com");
        pause(2);
        //    Aynı sayfada, Amazon ana sayfasına gidin https://www.amazon.com
        driver.get("https://www.amazon.com");
        pause(2);
        //    Google'a geri gidin
        driver.navigate().back();
        pause(2);
        //    Amazon'a ilerleyin
        driver.navigate().forward();
        pause(2);
        //    Sayfayı yenileyin
        driver.navigate().refresh();
        pause(2);
        //    Kapat Tarayıcıdan çıkın
        driver.close();
        pause(2);
        //    Konsolda "tamam" yazdırın
        System.out.println("tamam");
    }
}
