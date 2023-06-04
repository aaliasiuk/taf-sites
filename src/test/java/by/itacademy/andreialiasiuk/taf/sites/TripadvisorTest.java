package by.itacademy.andreialiasiuk.taf.sites;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TripadvisorTest {
    TripadvisorPage tripadvisorPage;
    ChromeDriver driver;
    Utils utils;
    TripadvisorStep tripadvisorStep;

    @BeforeMethod
    public void warmUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        tripadvisorPage = new TripadvisorPage(driver);
        utils = new Utils(driver);
        tripadvisorStep = new TripadvisorStep(driver);
        tripadvisorPage.getUrl();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "вход с пустым Email и Password")
    public void testLoginWithEmptyEmailEmptyPassword() {
        tripadvisorStep.keyLoginAndClickSubmit("", "");
        Assert.assertEquals(tripadvisorPage.getRegValidationErrorText(), tripadvisorPage.errorMessageEmailFieldText);
    }

    @Test(description = "вход с некорректным Email (например, email)")
    public void testLoginWithInvalidEmail() {
        tripadvisorStep.keyLoginAndClickSubmit(utils.generateInvalidEmail(), "");
        Assert.assertEquals(tripadvisorPage.getRegValidationErrorText(), tripadvisorPage.errorMessageInvalidEmailText);
    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и пустым Password")
    public void testLoginWithValidEmailEmptyPassword() {
        tripadvisorStep.keyLoginAndClickSubmit(utils.generateEmail(), "");
        Assert.assertEquals(tripadvisorPage.getRegValidationErrorText(), tripadvisorPage.errorMessagePassowrdValidationText);
    }

    @Test(description = "вход с корректным Email и любым паролем")
    public void testLoginWithValidEmailRandomPassword() throws InterruptedException {
        tripadvisorStep.keyLoginAndClickSubmit(utils.generateEmail(), utils.generatePassword());
        Thread.sleep(3000);
        Assert.assertEquals(tripadvisorPage.getErrorMessageInvalidCredsText(), tripadvisorPage.errorMessageInvalidCredsText);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
