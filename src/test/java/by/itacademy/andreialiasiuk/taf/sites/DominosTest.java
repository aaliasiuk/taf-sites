package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DominosTest {
    ChromeDriver driver;
    DominosPage dominosPage;
    Utils utils;
    DominosStep dominosStep;

    @BeforeMethod
    public void warmUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        dominosPage = new DominosPage(driver);
        utils = new Utils(driver);
        dominosStep = new DominosStep(driver);
        driver.get(dominosPage.baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "вход с некорректным Email (например, email) и любым паролем")
    public void loginWithInvalidEmailRandomPassword() {
        dominosStep.keyLoginCredsAndSubmit(utils.generateInvalidEmail(), utils.generatePassword());
        Assert.assertEquals(dominosPage.getErrorEmailMessage(), dominosPage.errorEmailMessageText);
    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {
        dominosStep.keyLoginCredsAndSubmit(utils.generateEmail(), utils.generatePassword());
        Assert.assertEquals(dominosPage.getLoginModalAttentionText(), dominosPage.loginModalAttentionText);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

