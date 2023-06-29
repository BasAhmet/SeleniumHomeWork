package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Util {
    static String userName = "ahba8184gmailcom";
    static String password = "SRAnIvPmC-27";
    public static WebDriver setChromeProperty(int time){
        System.setProperty("chromeDriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        return driver;
    }


    public static String setChromeProperty(){
        String chromeDriver = "src/resources/drivers/chromedriver.exe";
        return System.setProperty("chromeDriver", chromeDriver);
    }
    public static void sleep(float time) {
        try {
            Thread.sleep((long) (time*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void maximize(WebDriver driver){
        driver.manage().window().maximize();
    }
    public static void duration(WebDriver driver,int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
