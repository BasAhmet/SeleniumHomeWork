package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW018_GoogleSearch {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //Before methodunda http://www.google.com adresine gidin
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //After method'u ile başlıkları yazdırınız
    //AfterClass ile browser'ı kapatınız

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        //Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    //Üç farklı test methodu ile;
    @Test
    public void test01() throws InterruptedException {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        String search = "The God Father";
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys(search, Keys.ENTER);
        Thread.sleep(2000);
        String[] result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("'" + search + "'" + " için çıkan sonuç sayısı : " + result[1]);
        Thread.sleep(2000);
    }

    @Test
    public void test02() throws InterruptedException {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        String search = "Lord of the Rings";
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys(search, Keys.ENTER);
        Thread.sleep(2000);

        //google bir önceki arama ve aramayı birleştirip görsel getirdi arama sonuç sayısı vermedi
        //bunu kapatmak için bu if bloğunu kullanıp istenmeyeni kapattım

        if(driver.findElement(By.xpath("//*[@class='reBFM z1asCe GNeCNe']")).isDisplayed()){
            driver.findElement(By.xpath("//*[@class='reBFM z1asCe GNeCNe']")).click();
        }


        String[] result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("'" + search + "'" + " için çıkan sonuç sayısı : " + result[1]);
        Thread.sleep(2000);
    }

    @Test
    public void test03() throws InterruptedException {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        String search = "Kill Bill";
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys(search, Keys.ENTER);
        Thread.sleep(2000);
        String[] result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("'" + search + "'" + " için çıkan sonuç sayısı : " + result[1]);
        Thread.sleep(2000);
    }

    @After
    public void tearDown() throws Exception {
        //After method'u ile başlıkları yazdırınız
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
