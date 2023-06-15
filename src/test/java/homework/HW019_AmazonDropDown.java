package homework;

import utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HW019_AmazonDropDown extends TestBase {


    @Test
    public void test01() {
        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        // başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        for (int i = 1; i < 6; i++) {
            dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
            selectIndex(dropDownMenu,i);
            driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
            System.out.println(driver.getTitle());
        }
        pause(2);
    }
}
