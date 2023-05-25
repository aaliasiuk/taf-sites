package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PizzatempoTest {
    ChromeDriver driver;
    PizzatempoPage pizzatempoPage;
    Utils utils;


    @BeforeMethod
    public void warmUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        pizzatempoPage = new PizzatempoPage(driver);
        utils = new Utils(driver);
        driver.get(pizzatempoPage.baseURL);
    }

    @Test(description = "вход с пустым E-mail и пустым Пароль")
    public void testLoginBlankEmailBlankPassword() {

        pizzatempoPage.clickSubmitButton();
    }

    @Test(description = "вход с некорректным E-mail (например, email)")
    public void testLoginInvalidEmail() {

        pizzatempoPage.sendKeysEmailInputField("invalidemail");

        pizzatempoPage.clickSubmitButton();
    }

    @Test(description = "вход с пустым E-mail и любым паролем")
    public void testLoginBlankEmailRandomPassword() {

        pizzatempoPage.sendKeysPasswordInputField(utils.generateEmail());

        pizzatempoPage.clickSubmitButton();

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и пустым паролем")
    public void testLoginValidEmailBlankPassword() {

        pizzatempoPage.sendKeysEmailInputField(utils.generateEmail());

        pizzatempoPage.clickSubmitButton();

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {
        pizzatempoPage.sendKeysEmailInputField(utils.generateEmail());

        pizzatempoPage.sendKeysPasswordInputField(utils.generatePassword());

        pizzatempoPage.clickSubmitButton();

    }


}
