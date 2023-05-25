package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DominosTest {
    ChromeDriver driver;
    DominosPage dominosPage;
    Utils utils;

    @BeforeTest
    public void warmUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        dominosPage = new DominosPage(driver);
        utils = new Utils(driver);
        driver.get(dominosPage.baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(description = "вход с некорректным Email (например, email) и любым паролем")
    public void loginWithInvalidEmailRandomPassword() {

        //dominosPage.closeModal();
        dominosPage.loginHomePage();
        dominosPage.sendKeysEmailField("invalidemail");
        dominosPage.sendKeysPasswordField(utils.generatePassword());
        dominosPage.clickSubmitButton();

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {

        //dominosPage.closeModal();
        dominosPage.loginHomePage();
        dominosPage.sendKeysEmailField(utils.generateEmail());
        dominosPage.sendKeysPasswordField(utils.generatePassword());
        dominosPage.clickSubmitButton();


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

