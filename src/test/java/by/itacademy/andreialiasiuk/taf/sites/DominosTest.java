package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DominosTest {

    @Test(description = "вход с некорректным Email (например, email) и любым паролем")
    public void loginWithInvalidEmailRandomPassword() {
        DominosPage dominosPage = new DominosPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dominos.by/");

        driver.findElement(By.xpath(dominosPage.closeModalIconXpath)).click();
        driver.findElement(By.xpath(dominosPage.loginButtonHomePageXpath)).click();
        driver.findElement(By.xpath(dominosPage.emailInputFieldXpath)).sendKeys("invalidemail");
        driver.findElement(By.xpath(dominosPage.passwordInputFieldXpath)).sendKeys("randompassword");
        driver.findElement(By.xpath(dominosPage.submitButtonXpath)).click();
    }
    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword(){
        DominosPage dominosPage = new DominosPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dominos.by/");

        driver.findElement(By.xpath(dominosPage.closeModalIconXpath)).click();
        driver.findElement(By.xpath(dominosPage.loginButtonHomePageXpath)).click();
        driver.findElement(By.xpath(dominosPage.emailInputFieldXpath)).sendKeys("valid_email@mail.com");
        driver.findElement(By.xpath(dominosPage.passwordInputFieldXpath)).sendKeys("randompassword");
        driver.findElement(By.xpath(dominosPage.submitButtonXpath)).click();
    }
}

