package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class PizzatempoTest {
    ChromeDriver driver;
    PizzatempoPage pizzatempoPage;
    Utils utils;
    PizzatempoStep pizzatempoStep;


    @BeforeMethod
    public void warmUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pizzatempoPage = new PizzatempoPage(driver);
        utils = new Utils(driver);
        pizzatempoStep = new PizzatempoStep(driver);
        driver.get(pizzatempoPage.baseURL);
    }

    @Test(description = "вход с пустым E-mail и пустым Пароль")
    public void testLoginBlankEmailBlankPassword() {

        pizzatempoStep.keyLoginCredsAndSubmit("", "");
    }

    @Test(description = "вход с некорректным E-mail (например, email)")
    public void testLoginInvalidEmail() {

        pizzatempoStep.keyLoginCredsAndSubmit("invalidemail", "");
    }

    @Test(description = "вход с пустым E-mail и любым паролем")
    public void testLoginBlankEmailRandomPassword() {
        pizzatempoStep.keyLoginCredsAndSubmit("", utils.generatePassword());

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и пустым паролем")
    public void testLoginValidEmailBlankPassword() {

        pizzatempoStep.keyLoginCredsAndSubmit(utils.generateEmail(), "");

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {

        pizzatempoStep.keyLoginCredsAndSubmit(utils.generateEmail(), utils.generatePassword());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
