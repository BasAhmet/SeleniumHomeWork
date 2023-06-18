package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HW025_Click extends TestBase {
    @Test
    public void test01() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = xpath("//*[@class='dropdown hover']");
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();
        pause(2);

        // 3- Link 1" e tiklayin
        xpath("//*[@class='dropdown-content']").click();
        pause(2
        );
        // 4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        pause(2);

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        pause(2);

        // 6- “Click and hold" kutusuna basili tutun
        actions.sendKeys(Keys.PAGE_DOWN);
        pause(2);
        WebElement clickAndHold = xpath("//*[@id='click-box']");
        actions.clickAndHold(clickAndHold).perform();

        // 7- “Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
        pause(2);
        actions.release(clickAndHold).perform();
        pause(2);

        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClick = xpath("//h2");
        actions.doubleClick(doubleClick).perform();
        pause(2);
        Assert.assertTrue(xpath("//*[@class='div-double-click double']").isDisplayed());
        pause(2);

    }
}
