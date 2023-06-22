package homework;

import org.junit.Test;
import utilities.TestBase;

public class HW026_Practice extends TestBase {
    @Test
    public void test01() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        pause(3);

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        //- Çizimden sonra clear butonuna basınız
        xpath("//*[@class='button clear']").click();
        pause(2);

        //- Sayfayi kapatiniz
        //driver.close();

    }
}
