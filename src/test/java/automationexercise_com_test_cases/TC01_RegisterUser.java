package automationexercise_com_test_cases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TC01_RegisterUser extends TestBase {
    @Test
    public void test01() {
        //    1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //    3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());

        //    4. Click on 'Signup / Login' button
        xpath("//*[@class='fa fa-lock']").click();

        //    5. Verify 'New User Signup!' is visible
        Assert.assertEquals("New User Signup!", xpath("(//h2)[3]").getText());

        //    6. Enter name and email address
        //    7. Click 'Signup' button
        Faker faker = new Faker();
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        System.out.println(email);
        xpath("//*[@name='name']").sendKeys((fName+" "+lName), Keys.TAB, email, Keys.ENTER);

        //    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", xpath("(//h2)[1]").getText());

        //    9. Fill details: Title, Name, Email, Password, Date of birth
        xpath("(//*[@class='top'])[1]").sendKeys(Keys.SPACE);
        xpath("//*[@id='password']").sendKeys("Ahmet123");

        Select day = new Select(xpath("//*[@id='days']"));
        day.selectByIndex(1);
        Select month = new Select(xpath("//*[@id='months']"));
        month.selectByVisibleText("March");
        Select year = new Select(xpath("//*[@id='years']"));
        year.selectByVisibleText("1984");

        //    10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkBox1 = xpath("(//*[@class='checkbox'])[1]");
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox1).click().perform();

        //    11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox2 = xpath("(//*[@class='checkbox'])[2]");
        actions.moveToElement(checkBox2).click().perform();

        //    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //    13. Click 'Create Account button'
        xpath("//*[@id='first_name']").sendKeys(fName,
                Keys.TAB,
                lName,
                Keys.TAB,
                faker.company().name(),
                Keys.TAB,
                faker.address().fullAddress());
        Select country = new Select(xpath("//*[@id='country']"));
        country.selectByIndex(faker.number().numberBetween(0,6));
        xpath("//*[@id='state']").sendKeys(faker.address().state(),
                Keys.TAB,
                faker.address().city(),
                Keys.TAB,
                faker.address().zipCode(),
                Keys.TAB,
                faker.phoneNumber().cellPhone(),
                Keys.TAB,Keys.ENTER);

        //    14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals("ACCOUNT CREATED!", xpath("(//h2)[1]").getText());

        //    15. Click 'Continue' button
        xpath("//*[@class='btn btn-primary']").sendKeys(Keys.ENTER);
        pause(3);

        //    16. Verify that 'Logged in as username' is visible
            //driver.switchTo().frame(8);       Reklam handle edilecek
            //driver.switchTo().frame(0);
            //xpath("//*[@id='dismiss-button']").click();
        Assert.assertTrue(xpath("(//a)[11]").getText().contains(fName + " " + lName));
/*
        //    17. Click 'Delete Account' button
        xpath("(//a)[6]").click();

        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertEquals("ACCOUNT DELETED!", xpath("(//h2)[1]").getText());
        xpath("//*[@class='btn btn-primary']").click();
*/
    }
}
