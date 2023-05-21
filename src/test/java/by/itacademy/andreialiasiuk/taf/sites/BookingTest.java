package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class BookingTest {
    @Test(description = "вход с пустым Email")
    public void testLoginEmptyEmail() {
        BookingPage bookingPage = new BookingPage();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement closePopUpIcon = driver.findElement(By.xpath("//div/button[@aria-label='Dismiss sign-in info.']"));
        closePopUpIcon.click();
        WebElement buttonSignIn = driver.findElement(By.xpath(bookingPage.registerButtonXpath));
        buttonSignIn.click();
        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.continueWithEmailButtonXpath));
        buttonContinueWithEmail.click();

    }

    @Test(description = "вход с некорректным Email (например, email)")
    public void testLoginInvalidEmail() {
        BookingPage bookingPage = new BookingPage();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement closePopUpIcon = driver.findElement(By.xpath("//div/button[@aria-label='Dismiss sign-in info.']"));
        closePopUpIcon.click();

        WebElement emailInputField = driver.findElement(By.xpath(bookingPage.emailInputFieldXpath));
        emailInputField.sendKeys("invalid email");
        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.continueWithEmailButtonXpath));
        buttonContinueWithEmail.click();

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com)")
    public void testLoginValidEmail() {
        BookingPage bookingPage = new BookingPage();
        ChromeDriver driver = new ChromeDriver();
        //FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement closePopUpIcon = driver.findElement(By.xpath("//div/button[@aria-label='Dismiss sign-in info.']"));
        closePopUpIcon.click();
        WebElement buttonSignIn = driver.findElement(By.xpath(bookingPage.registerButtonXpath));
        buttonSignIn.click();
        WebElement emailInputField = driver.findElement(By.xpath(bookingPage.emailInputFieldXpath));
        emailInputField.sendKeys("valid_email@mail.com");
        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.continueWithEmailButtonXpath));
        buttonContinueWithEmail.click();
    }

    @Test(description = "вход с корректным Email и пустым паролем")
    public void testLoginValidEmailEmptyPassword() {
        BookingPage bookingPage = new BookingPage();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement closePopUpIcon = driver.findElement(By.xpath("//div/button[@aria-label='Dismiss sign-in info.']"));
        closePopUpIcon.click();

        WebElement buttonSignIn = driver.findElement(By.xpath(bookingPage.registerButtonXpath));
        buttonSignIn.click();
        WebElement emailInputField = driver.findElement(By.xpath(bookingPage.emailInputFieldXpath));
        emailInputField.sendKeys("valid_email@mail.com");
        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.continueWithEmailButtonXpath));
        buttonContinueWithEmail.click();

        WebElement submitButton = driver.findElement(By.xpath("//*[@id='root']//form/div[2]/button"));
        submitButton.click();
    }

    @Test(description = "вход с корректным Email и любым паролем")
    public void testLoginValidEmailRandomPassword(){
        BookingPage bookingPage = new BookingPage();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement closePopUpIcon = driver.findElement(By.xpath("//div/button[@aria-label='Dismiss sign-in info.']"));
        closePopUpIcon.click();

        WebElement buttonSignIn = driver.findElement(By.xpath(bookingPage.registerButtonXpath));
        buttonSignIn.click();
        WebElement emailInputField = driver.findElement(By.xpath(bookingPage.emailInputFieldXpath));
        emailInputField.sendKeys("valid_email@mail.com");
        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.continueWithEmailButtonXpath));
        buttonContinueWithEmail.click();

        WebElement passwordInputField = driver.findElement(By.xpath(bookingPage.passwordInputFieldXpath));
        passwordInputField.sendKeys("anypassword");

        WebElement submitButton = driver.findElement(By.xpath((bookingPage.submitButtonXpath)));
        submitButton.click();

    }
}
