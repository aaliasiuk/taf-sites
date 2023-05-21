package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TripadvisorTest {
    @Test(description = "вход с пустым Email и Password")
    public void testLoginWithEmptyEmailEmptyPassword() {
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(tripadvisorPage.baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement signInButton = driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath));
        signInButton.click();

        WebElement continueWithEmailButton = driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath));
        continueWithEmailButton.click();

        WebElement submitButton = driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }

    @Test(description = "вход с некорректным Email (например, email)")
    public void testLoginWithInvalidEmail() {
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(tripadvisorPage.baseURL);

        WebElement signInButton = driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath));
        signInButton.click();

        WebElement continueWithEmailButton = driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath));
        continueWithEmailButton.click();

        WebElement emailInputField = driver.findElement(By.xpath(tripadvisorPage.emailInputFieldXpath));
        emailInputField.sendKeys("invalidemail");

        WebElement submitButton = driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и пустым Password")
    public void testLoginWithValidEmailEmptyPassword() {
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(tripadvisorPage.baseURL);

        WebElement signInButton = driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath));
        signInButton.click();

        WebElement continueWithEmailButton = driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath));
        continueWithEmailButton.click();

        WebElement emailInputField = driver.findElement(By.xpath(tripadvisorPage.emailInputFieldXpath));
        emailInputField.sendKeys("validemail@mail.com");

        WebElement submitButton = driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath));
        submitButton.click();

        driver.quit();

    }

    @Test(description = "вход с корректным Email и любым паролем")
    public void testLoginWithValidEmailRandomPassword() {
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(tripadvisorPage.baseURL);

        WebElement signInButton = driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath));
        signInButton.click();

        WebElement continueWithEmailButton = driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath));
        continueWithEmailButton.click();

        WebElement emailInputField = driver.findElement(By.xpath(tripadvisorPage.emailInputFieldXpath));
        emailInputField.sendKeys("validemail@mail.com");

        WebElement passwordInputField = driver.findElement(By.xpath(tripadvisorPage.passwordInputFieldXpath));
        passwordInputField.sendKeys("randompassword");

        WebElement submitButton = driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }
}
