package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class PizzatempoTest {
    @Test
    public void testLoginBlankEmailBlankPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");

        driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath)).click();

    }

    @Test
    public void testLoginInvalidEmail() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");

        driver.findElement(By.xpath(pizzatempoPage.emailInputFieldXpath)).sendKeys("invalidemail");

        driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath)).click();
    }

    @Test
    public void testLoginBlankEmailRandomPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");

        driver.findElement(By.xpath(pizzatempoPage.passwordInputFieldXpath)).sendKeys("randompassword");
        driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath)).click();
    }

    @Test
    public void testLoginValidEmailBlankPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");

        driver.findElement(By.xpath(pizzatempoPage.emailInputFieldXpath)).sendKeys("validemail@mail.com");
        driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath)).click();
    }

    @Test
    public void testLoginValidEmailRandomPassword() {
        PizzatempoPage pizzatempoPage = new PizzatempoPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");

        driver.findElement(By.xpath(pizzatempoPage.emailInputFieldXpath)).sendKeys("validemail@mail.com");
        driver.findElement(By.xpath(pizzatempoPage.passwordInputFieldXpath)).sendKeys("randompassword");
        driver.findElement(By.xpath(pizzatempoPage.submitButtonXpath)).click();

    }
}
