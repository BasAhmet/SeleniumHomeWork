package homework;

import org.junit.Test;
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
        actions.moveToElement(xpath("(//*[@class='list-inline-item'])[5]/a")).perform();
        actions.click().perform();

        //go to zoom tıklayınız
        xpath("//*[@class='banner-btn']").click();
    }
}
