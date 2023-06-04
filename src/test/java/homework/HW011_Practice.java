package homework;

import org.openqa.selenium.WebDriver;

public class HW011_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Util.setChromeProperty(15);

        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com/");

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String actualTitleTeknosa = driver.getTitle();
        String actualUrlTeknosa = driver.getCurrentUrl();
        System.out.println(actualTitleTeknosa);
        System.out.println(actualUrlTeknosa);

        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        String expectedTitleTeknosa = "Teknoloji";
        if (actualTitleTeknosa.contains(expectedTitleTeknosa)) {
            System.out.println("Title Teknoloji kelmesini içeriyor.");
        }else{
            System.out.println("Test FAILED : " + actualTitleTeknosa);
        }

        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        String expectedUrlTeknosa = "teknosa";
        if (actualUrlTeknosa.contains(expectedUrlTeknosa)) {
            System.out.println("URL teknosa kelimesini iceriyor");
        }else{
            System.out.println("Test FAILED : " + actualUrlTeknosa);
        }
        Thread.sleep(2000);

        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com/");

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String actualTitleMeduna = driver.getTitle();
        System.out.println("Title : " + actualTitleMeduna);
        String actualUrlMedunna = driver.getCurrentUrl();
        System.out.println("Url : " + actualUrlMedunna);

        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        String expectedTitleMedunna = "MEDUNNA";
        if (actualTitleMeduna.contains(expectedTitleMedunna)) {
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }

        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        String expectedUrlMedunna = "medunna";
        if (actualUrlMedunna.contains(expectedUrlMedunna)) {
            System.out.println("Test PASSED.");
        }else{
            System.out.println("Test FAILED.");
        }
        Thread.sleep(2000);

        // teknosa adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(1000);

        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);

        // medunna adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(1000);

        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);

        // pencereyi kapat
        driver.close();

    }
}











