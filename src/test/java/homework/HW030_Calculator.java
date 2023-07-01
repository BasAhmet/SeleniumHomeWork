package homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HW030_Calculator extends TestBase {
    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Faker faker = new Faker();
        String sayi1 = String.valueOf(faker.number().numberBetween(1,9));
        String sayi2 = String.valueOf(faker.number().numberBetween(1,10));

        Actions actions = new Actions(driver);
        WebElement sayi1Basamak1 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi1 + "]");
        actions.moveToElement(sayi1Basamak1).click().perform();
        pause(1);
        WebElement sayi1Basamak2 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi2 + "]");
        actions.moveToElement(sayi1Basamak2).click().perform();
        pause(1);

        String operator = String.valueOf(faker.number().numberBetween(1,4));
        WebElement oper = xpath("(//*[@class='operator btn btn-outline-success'])[" + operator + "]");
        actions.moveToElement(oper).click().perform();
        pause(1);

        String sayi3 = String.valueOf(faker.number().numberBetween(1,9));
        String sayi4 = String.valueOf(faker.number().numberBetween(1,10));

        WebElement sayi2Basamak1 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi3 + "]");
        actions.moveToElement(sayi2Basamak1).click().perform();
        pause(1);
        WebElement sayi2Basamak2 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi4 + "]");
        actions.moveToElement(sayi2Basamak2).click().perform();
        pause(1);

        actions.moveToElement(xpath("//*[@class='btn btn-outline-warning']")).click().perform();

        //Sonucu konsola yazdırıp
        pause(6);
        System.out.println("İşlem sonucu = " + xpath("//*[@class='screen']").getText());

        //Sonucun doğrulamasını yapalım
        int birinciSayi = Integer.parseInt(sayi1Basamak1.getText() + sayi1Basamak2.getText());
        int ikinciSayi = Integer.parseInt(sayi2Basamak1.getText() + sayi2Basamak2.getText());
        if (oper.getText().equals("+")){
            String result = String.valueOf(birinciSayi + ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }if (oper.getText().equals("-")){
            String result = String.valueOf(birinciSayi - ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }if (oper.getText().equals("x")){
            String result = String.valueOf(birinciSayi * ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }if (oper.getText().equals("÷")){
            String result = String.valueOf(birinciSayi / ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }
    }
}
