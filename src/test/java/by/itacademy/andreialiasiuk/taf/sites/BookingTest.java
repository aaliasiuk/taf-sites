package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class BookingTest {
    ChromeDriver driver;
    BookingPage bookingPage;
    Utils utils;
    BookingStep bookingStep;

    @BeforeMethod
    public void warmUp() {
        driver = new ChromeDriver();
        bookingPage = new BookingPage(driver);
        utils = new Utils(driver);
        bookingStep = new BookingStep(driver);
        driver.get(bookingPage.baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(description = "вход с пустым Email")
    public void testLoginEmptyEmail() {

        WebElement closePopUpIcon = driver.findElement(By.xpath(bookingPage.closePopUpIconXpath));
        closePopUpIcon.click();

        WebElement buttonSignIn = driver.findElement(By.xpath(bookingPage.registerButtonXpath));
        buttonSignIn.click();

        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.continueWithEmailButtonXpath));
        buttonContinueWithEmail.click();


    }

    @Test(description = "вход с некорректным Email (например, email)")
    public void testLoginInvalidEmail() {

        WebElement closePopUpIcon = driver.findElement(By.xpath(bookingPage.closePopUpIconXpath));
        closePopUpIcon.click();

        WebElement emailInputField = driver.findElement(By.xpath(bookingPage.emailInputFieldXpath));
        emailInputField.sendKeys("invalid email");

        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.continueWithEmailButtonXpath));
        buttonContinueWithEmail.click();

    }

    @Test(description = "вход с корректной записью Email (например, test@mail.com)")
    public void testLoginValidEmail() {

        WebElement closePopUpIcon = driver.findElement(By.xpath(bookingPage.closePopUpIconXpath));
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
        bookingStep.keyLoginCredsAndSubmit("valid_email@mail.com","");

    }

    @Test(description = "вход с корректным Email и любым паролем")
    public void testLoginValidEmailRandomPassword() {
        bookingStep.keyLoginCredsAndSubmit("valid_email@mail.com", utils.generatePassword());

    }

    @AfterMethod
    public void tearDowns() {
        driver.quit();
    }
}
