package automationexercise_com_test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class TC02_LoginUserWithCorrectEmailPassword extends TestBase {
    @Test
    public void test01() {
        //    1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //    3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());

        //    4. Click on 'Signup / Login' button
        xpath("(//*[@id='header']//a)[5]").click();

        //    5. Verify 'Login to your account' is visible
        Assert.assertEquals("Login to your account", xpath("(//h2)[1]").getText());

        //    6. Enter correct email address and password
        //    7. Click 'login' button
        //anya.kozey@hotmail.com
        //Ahmet123
        xpath("(//*[@name='email'])[1]").sendKeys("anya.kozey@hotmail.com",
                Keys.TAB,
                "Ahmet123",
                Keys.TAB,Keys.ENTER);


        //    8. Verify that 'Logged in as username' is visible
        Assert.assertEquals("Cedric Hickle", xpath("//*[@id='header']//b").getText());

        //    9. Click 'Delete Account' button
        xpath("(//*[@id='header']//a)[6]").click();

        //    10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
