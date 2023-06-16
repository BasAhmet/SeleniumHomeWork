package homework;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class HW020_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //Yeni bir class olusturun: WindowHandle
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        newWindowTab();
        driver.get("https://www.techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        newWindowWindow();
        driver.get("https://www.walmart.com");

        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com/"));
    }
}
