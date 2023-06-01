package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW008_Practice {
    public static void main(String[] args) throws InterruptedException {
        Util.setChromeProperty();
        WebDriver driver = new ChromeDriver();
        Util.maximize(driver);
        Util.duration(driver,15);

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");
        Util.sleep(2);

        //Çıkan reklamı locate edip kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        Util.sleep(1);

        //Arama bölümünde qa aratalım
        driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']")).sendKeys("qa", Keys.ENTER);
        Util.sleep(1);

        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String expectedTitle = "qa";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement link = driver.findElement(By.xpath("(//a[@href='https://techproeducation.com/software-career-opportunities-qa/'])[2]"));
        System.out.println(link.isEnabled());
        System.out.println(link.isDisplayed());
        Util.sleep(2);

        //Carrer Opportunities In QA linkine tıklayalım
        link.click();

        //Başlığın Opportunities içerdiğini test edelim
        String actualCareerTitle = driver.getTitle();
        String expectedCareerTitle = "Opportunities";
        if(actualCareerTitle.contains(expectedCareerTitle)){
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.navigate().back();
        driver.navigate().back();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://techproeducation.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED : " + actualUrl);
        }

    }
}
