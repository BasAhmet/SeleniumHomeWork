package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW_AutomationExercise_TestCase {
    public static void main(String[] args) {
        Util.setChromeProperty();
        WebDriver driver = new ChromeDriver();
        Util.maximize(driver);
        Util.duration(driver,15);

        //https://automationexercise.com/test_cases saydafsına gidiniz
        driver.get("https://automationexercise.com/test_cases");
        //test caseleri alınız
        int i = 1;

        WebElement testCaseHeader;
        while (true){
            testCaseHeader = driver.findElement(By.xpath("(//*[@class='panel-title'])["+ i + "]"));
            if(!(testCaseHeader.getText().equals("Feedback for Us"))){
                System.out.println(testCaseHeader.getText());
                testCaseHeader.click();
                Util.sleep(2);
                List<WebElement> liste = driver.findElements(By.xpath("//*[@id='collapse" + i + "']/ul/li"));
                for (int j = 1 ; j<liste.size()+1 ; j++) {
                    System.out.println(driver.findElement(By.xpath("//*[@id='collapse" + i + "']/ul/li[" + j + "]")).getText());
                }
                i++;
            }else{
                break;
            }
        }




        //*[@id="collapse1"]

        //driver.close();


    }
}
