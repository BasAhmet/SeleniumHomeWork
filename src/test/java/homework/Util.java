package homework;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Util {
    public static String setChromeProperty(){
        String chromeDriver = "src/resources/drivers/chromedriver.exe";
        return System.setProperty("chromeDriver", chromeDriver);
    }
    public static void sleep(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }
    public static void maximize(WebDriver driver){
        driver.manage().window().maximize();
    }
    public static void duration(WebDriver driver,int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
