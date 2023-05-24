package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DominosTest {
    ChromeDriver driver;
    DominosPage dominosPage;

    @BeforeTest
    public void warmUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        dominosPage = new DominosPage(driver);
        driver.get(dominosPage.baseURL);

    }

    @Test(description = "вход с некорректным Email (например, email) и любым паролем")
    public void loginWithInvalidEmailRandomPassword() {

        dominosPage.closeModal();
        dominosPage.loginHomePage();
        dominosPage.sendKeysEmailField("invalidemail");
        dominosPage.sendKeysPasswordField("randompassword");
        dominosPage.clickSubmitButton();

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {

        dominosPage.closeModal();
        dominosPage.loginHomePage();
        dominosPage.sendKeysEmailField("valid_email@mail.com");
        dominosPage.sendKeysPasswordField("randompassword");
        dominosPage.clickSubmitButton();


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

