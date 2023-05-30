package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.zip.Checksum;

public class TripadvisorPage {
    ChromeDriver driver;
    String signInButtonXpath = "//span[contains(., 'Sign in')] | //*[@id='lithium-root']/header/div/nav/div/div[2]/a[4]/span";
    String iFrameXpath = "//iframe[@title='regcontroller']";
    String continueWithEmailXpath = "//span[contains(., 'Continue with email')]";
    String emailInputFieldXpath = "//*[@id='regSignIn.email']";
    String passwordInputFieldXpath = "//*[@id='regSignIn.password']";
    String submitButtonXpath = "//*[@id='regSignIn']/div[4]/button[1]";
    String baseURL = "https://www.tripadvisor.com/";

    public TripadvisorPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public void getUrl() {
        driver.get(baseURL);
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath(signInButtonXpath));
        signInButton.click();
    }

    public void switchToIframe() {
        WebElement iFrame = driver.findElement(By.xpath(iFrameXpath));
        driver.switchTo().frame(iFrame);
    }

    public void clickContinueWithEmail() {
        if (driver.findElements(By.xpath(iFrameXpath)).size() > 0) {
            try {
                switchToIframe();
                WebElement clickContinueWithEmailButton = driver.findElement(By.xpath(continueWithEmailXpath));
                clickContinueWithEmailButton.click();
            } catch (NoSuchElementException e) {
                System.out.println("no iframe");
            }
        }
        else {
            WebElement clickContinueWithEmailButton = driver.findElement(By.xpath(continueWithEmailXpath));
            clickContinueWithEmailButton.click();
        }
    }


    public void sendKeysEmailInputField(String str) {
        WebElement emailInputField = driver.findElement(By.xpath(emailInputFieldXpath));
        emailInputField.sendKeys(str);
    }

    public void sendKeysPasswordField(String str) {
        WebElement passwordInputField = driver.findElement(By.xpath(passwordInputFieldXpath));
        passwordInputField.sendKeys(str);

    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath(submitButtonXpath));
        submitButton.click();
    }

}
