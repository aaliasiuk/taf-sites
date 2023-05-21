package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TripadvisorTest {
    @Test
    public void testLoginWithEmptyEmailEmptyPassword() {
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tripadvisor.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath)).click();

        driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath)).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath)).click();
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='regSignIn']/div[4]/button[1]")));
        element.click();*/
        driver.quit();
    }

    @Test
    public void testLoginWithInvalidEmail() {
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tripadvisor.com/");

        driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath)).click();

        driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath)).click();

        driver.findElement(By.xpath(tripadvisorPage.emailInputFieldXpath)).sendKeys("invalidemail");

        driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath));

        driver.quit();
    }

    @Test
    public void testLoginWithValidEmailEmptyPassword() {
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tripadvisor.com/");

        driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath)).click();

        driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath)).click();

        driver.findElement(By.xpath(tripadvisorPage.emailInputFieldXpath)).sendKeys("validemail@mail.com");

        driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath));

        driver.quit();

    }
    @Test
    public void testLoginWithValidEmailRandomPassword(){
        TripadvisorPage tripadvisorPage = new TripadvisorPage();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tripadvisor.com/");

        driver.findElement(By.xpath(tripadvisorPage.signInButtonXpath)).click();

        driver.findElement(By.xpath(tripadvisorPage.continueWithEmailXpath)).click();

        driver.findElement(By.xpath(tripadvisorPage.emailInputFieldXpath)).sendKeys("validemail@mail.com");

        driver.findElement(By.xpath(tripadvisorPage.passwordInputFieldXpath)).sendKeys("randompassword");

        driver.findElement(By.xpath(tripadvisorPage.submitButtonXpath)).click();

        driver.quit();

    }
}
