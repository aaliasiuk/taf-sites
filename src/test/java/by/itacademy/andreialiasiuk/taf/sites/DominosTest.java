package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DominosTest {

    @Test(description = "вход с некорректным Email (например, email) и любым паролем")
    public void loginWithInvalidEmailRandomPassword() {
        DominosPage dominosPage = new DominosPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dominos.by/");

        WebElement closeModalIcon = driver.findElement(By.xpath(dominosPage.closeModalIconXpath));
        closeModalIcon.click();

        WebElement loginButtonHomePage = driver.findElement(By.xpath(dominosPage.loginButtonHomePageXpath));
        loginButtonHomePage.click();

        WebElement emailInputField = driver.findElement(By.xpath(dominosPage.emailInputFieldXpath));
        emailInputField.sendKeys("invalidemail");

        WebElement passwordInputField = driver.findElement(By.xpath(dominosPage.passwordInputFieldXpath));
        passwordInputField.sendKeys("randompassword");

        WebElement submitButton = driver.findElement(By.xpath(dominosPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {
        DominosPage dominosPage = new DominosPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dominos.by/");

        WebElement closeModalIcon = driver.findElement(By.xpath(dominosPage.closeModalIconXpath));
        closeModalIcon.click();

        WebElement loginButtonHomePage = driver.findElement(By.xpath(dominosPage.loginButtonHomePageXpath));
        loginButtonHomePage.click();

        WebElement emailInputField = driver.findElement(By.xpath(dominosPage.emailInputFieldXpath));
        emailInputField.sendKeys("valid_email@mail.com");

        WebElement passwordInputField = driver.findElement(By.xpath(dominosPage.passwordInputFieldXpath));
        passwordInputField.sendKeys("randompassword");

        WebElement submitButton = driver.findElement(By.xpath(dominosPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }
}

