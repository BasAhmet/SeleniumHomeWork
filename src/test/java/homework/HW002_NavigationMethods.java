package homework;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class HW002_NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        Util.setChromeProperty();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Util.sleep(2);

        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        String url1 = "https://www.youtube.com/";
        driver.get(url1);
        Util.sleep(2);

        //Amazon sayfasina gidelim. https://www.amazon.com/
        String url2 = "https://www.amazon.com/";
        driver.get(url2);
        Util.sleep(2);

        //Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        Util.sleep(2);

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Util.sleep(2);

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Util.sleep(2);

        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();
        driver.quit();
    }

}
