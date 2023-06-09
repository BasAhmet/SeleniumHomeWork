package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    /*
     TestBase class'indan obje olusturmanin onune gecmek icin bu class'i abstract yapabiliriz
     TestBase testBase new = TestBase(); yani bu sekilde obje olusturmanin onune gecmis oluruz
     Bu class'a extends yaptigimiz test class'larindan ulabiliriz
 */
    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
    public void pause(float second){
        try {
            Thread.sleep((long) (second*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //AcceptAlert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //DissmisAlert
    public void dissmisAlert(){
        driver.switchTo().alert().dismiss();
    }
    //getTextAlert
    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }
    //sendKeysAlert
    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    public void visibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    //DropDown Index
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
    public void newWindowTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }
    public void newWindowWindow(){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
    public WebElement xpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }


}
