package by.itacademy.andreialiasiuk.taf.sites.tests;

import by.itacademy.andreialiasiuk.taf.sites.pages.PizzatempoPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import by.itacademy.andreialiasiuk.taf.sites.steps.PizzatempoStep;
import by.itacademy.andreialiasiuk.taf.sites.utils.Utils;


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
        Assert.assertEquals(pizzatempoPage.getPopupAlertMessage(), pizzatempoPage.alertText);
    }

    @Test(description = "вход с некорректным E-mail (например, email)")
    public void testLoginInvalidEmail() {

        pizzatempoStep.keyLoginCredsAndSubmit(utils.generateInvalidEmail(), "");
        Assert.assertEquals(pizzatempoPage.getPopupAlertMessage(), pizzatempoPage.alertText);
    }

    @Test(description = "вход с пустым E-mail и любым паролем")
    public void testLoginBlankEmailRandomPassword() {
        pizzatempoStep.keyLoginCredsAndSubmit("", utils.generatePassword());
        Assert.assertEquals(pizzatempoPage.getPopupAlertMessage(), pizzatempoPage.alertText);

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и пустым паролем")
    public void testLoginValidEmailBlankPassword() {

        pizzatempoStep.keyLoginCredsAndSubmit(utils.generateEmail(), "");
        Assert.assertEquals(pizzatempoPage.getPopupAlertMessage(), pizzatempoPage.alertText);

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {

        pizzatempoStep.keyLoginCredsAndSubmit(utils.generateEmail(), utils.generatePassword());
        Assert.assertEquals(pizzatempoPage.getPopupErrorMessage(), pizzatempoPage.loginErrorText);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
