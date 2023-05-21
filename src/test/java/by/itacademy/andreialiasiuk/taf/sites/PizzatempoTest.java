package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class PizzatempoTest {
    @Test(description = "вход с пустым E-mail и пустым Пароль")
    public void testLoginBlankEmailBlankPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pizzatempoPage.baseURL);

        WebElement submitButton = driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath));
        submitButton.click();

        driver.quit();

    }

    @Test(description = "вход с некорректным E-mail (например, email)")
    public void testLoginInvalidEmail() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pizzatempoPage.baseURL);

        WebElement emailInputField = driver.findElement(By.xpath(pizzatempoPage.emailInputFieldXpath));
        emailInputField.sendKeys("invalidemail");

        WebElement submitButton = driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }

    @Test(description = "вход с пустым E-mail и любым паролем")
    public void testLoginBlankEmailRandomPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pizzatempoPage.baseURL);

        WebElement passwordInputField = driver.findElement(By.xpath(pizzatempoPage.passwordInputFieldXpath));
        passwordInputField.sendKeys("randompassword");

        WebElement submitButton = driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и пустым паролем")
    public void testLoginValidEmailBlankPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pizzatempoPage.baseURL);

        WebElement emailInputField = driver.findElement(By.xpath(pizzatempoPage.emailInputFieldXpath));
        emailInputField.sendKeys("validemail@mail.com");

        WebElement submitButton = driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath));
        submitButton.click();

        driver.quit();
    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com) и любым паролем")
    public void testLoginValidEmailRandomPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pizzatempoPage.baseURL);

        WebElement emailInputField = driver.findElement(By.xpath(pizzatempoPage.emailInputFieldXpath));
        emailInputField.sendKeys("validemail@mail.com");

        WebElement passwordInputField = driver.findElement(By.xpath(pizzatempoPage.passwordInputFieldXpath));
        passwordInputField.sendKeys("randompassword");

        WebElement submitButton = driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath));
        submitButton.click();

        driver.quit();

    }
}
