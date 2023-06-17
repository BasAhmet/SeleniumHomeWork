package homework;

import org.apache.commons.compress.archivers.StreamingNotSupportedException;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class HW024_Practice extends TestBase {
    @Test
    public void test01() {
        //  1-"sahibinden.com" adresine gidelim
        driver.get("https://www.sahibinden.com");

        //  2-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String sahibindenTitle = driver.getTitle();
        String sahibindenUrl = driver.getCurrentUrl();

        //  3-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(sahibindenTitle.contains("Oto"));
        Assert.assertFalse(sahibindenUrl.contains("Oto"));
        pause(2);

        //  4-Ardindan "n11.com" adresine gidelim
        driver.get("https://www.n11.com/");

        //  5-bu adresin basligini alalim ve "Hayat" kelismesini icerip icermedigini kontrol edelim
        String n11Title = driver.getTitle();
        Assert.assertTrue(n11Title.contains("Hayat"));
        pause(2);

        //  6-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        pause(2);

        //  7-sayfayi yenileyelim
        driver.navigate().refresh();
        pause(2);

        //  8-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        pause(2);
        driver.close();
        pause(2);

        //  9-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();

    }
}
