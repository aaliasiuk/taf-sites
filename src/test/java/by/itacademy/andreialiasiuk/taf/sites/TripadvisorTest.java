package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TripadvisorTest {
    TripadvisorPage tripadvisorPage;
    ChromeDriver driver;
    Utils utils;


    @BeforeTest
    public void warmUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        tripadvisorPage = new TripadvisorPage(driver);
        utils = new Utils(driver);
        tripadvisorPage.getUrl();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "вход с пустым Email и Password")
    public void testLoginWithEmptyEmailEmptyPassword() {

        tripadvisorPage.clickSignInButton();

        tripadvisorPage.clickContinueWithEmail();

        tripadvisorPage.clickSubmitButton();
    }

    @Test(description = "вход с некорректным Email (например, email)")
    public void testLoginWithInvalidEmail() {
        tripadvisorPage.clickSignInButton();
        tripadvisorPage.clickContinueWithEmail();
        tripadvisorPage.sendKeysEmailInputField("invalidemail");
        tripadvisorPage.clickSubmitButton();
    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и пустым Password")
    public void testLoginWithValidEmailEmptyPassword() {
        tripadvisorPage.clickSignInButton();
        tripadvisorPage.clickContinueWithEmail();
        tripadvisorPage.sendKeysEmailInputField(utils.generateEmail());
        tripadvisorPage.clickSubmitButton();

    }

    @Test(description = "вход с корректным Email и любым паролем")
    public void testLoginWithValidEmailRandomPassword() {
        tripadvisorPage.clickSignInButton();
        tripadvisorPage.clickContinueWithEmail();
        tripadvisorPage.sendKeysEmailInputField(utils.generateEmail());
        tripadvisorPage.sendKeysPasswordField(utils.generatePassword());
        tripadvisorPage.clickSubmitButton();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
