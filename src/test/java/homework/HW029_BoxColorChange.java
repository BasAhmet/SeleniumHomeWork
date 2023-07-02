package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HW029_BoxColorChange extends TestBase {
    @Test
    public void test01() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);

        //Kutucuk Kırmızı Oldu
        xpath("//*[@id='green']/span").sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,
                Keys.TAB,
                Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN);

        //Kutucuk Sarı Oldu
        pause(2);
        xpath("//*[@id='green']/span").sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP);

        //-Sarı olduğunu test edelim
        Assert.assertEquals("rgba(255, 255, 0, 1)", xpath("//*[@id='swatch']").getCssValue("background-color"));

    }
}
