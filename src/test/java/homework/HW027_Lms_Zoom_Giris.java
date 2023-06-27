package homework;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HW027_Lms_Zoom_Giris extends TestBase {
    @Test
    public void test01() {
        //https://lms.techproeducation.com/ adresine gidiniz
        driver.get("https://lms.techproeducation.com/");

        //siteye login olun
        xpath("//*[@class='banner-btn bdrs3']").click();
        WebElement userName = xpath("//*[@id='username']");
        WebElement password = xpath("//*[@id='password']");
        userName.sendKeys(Util.userName);
        password.sendKeys(Util.password);
        xpath("//*[@id='loginbtn']").click();

        //outomation engineer linkine tıklayınız
        Actions actions = new Actions(driver);
        actions.moveToElement(xpath("(//*[@class='list-inline-item'])[5]")).perform();
        actions.click().perform();

        //go to zoom tıklayınız
        xpath("//*[@class='banner-btn']").click();

        //açılan yeni pencereye geçiniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        pause(2);

        //çıkan alert e tıklayınız
        actions = new Actions(driver);
        actions.sendKeys(Keys.SPACE).perform();
    }

}
