package by.itacademy.andreialiasiuk.taf.sites.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TripadvisorPage {
    ChromeDriver driver;
    private String signInButtonXpath = "//span[contains(., 'Sign in')] | //*[@id='lithium-root']/header/div/nav/div/div[2]/a[4]/span";
    private String iFrameXpath = "//iframe[@title='regcontroller']";
    private String continueWithEmailXpath = "//span[contains(., 'Continue with email')]";
    private String emailInputFieldXpath = "//*[@id='regSignIn.email']";
    private String passwordInputFieldXpath = "//*[@id='regSignIn.password']";
    private String submitButtonXpath = "//*[@id='regSignIn']/div[4]/button[1]";
    String baseURL = "https://www.tripadvisor.com/";

    private String regValidationErrorXpath = "//span[@class='ui_overlay ui_tooltip arrow_bottom regValidationError']";
    public String errorMessageEmailFieldText = "E-mail address is required";
    public String errorMessageInvalidEmailText = "E-mail address is either invalid or starts with a generic alias to which we cannot send.";
    public String errorMessagePassowrdValidationText = "Your password must be at least 10 characters. Please try again.";
    private String errorInvalidCredsXpath = "//*[@id='regErrors']";
    public String errorMessageInvalidCredsText = "Either your email or password was incorrect. Please try again or click the \"Forgot password?\" link below.";

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
        } else {
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

    public String getRegValidationErrorText() {
        WebElement errorMessageTooltip = driver.findElement(By.xpath(regValidationErrorXpath));
        return errorMessageTooltip.getText();
    }

    public String getErrorMessageInvalidCredsText() {
        WebElement errorMessageInvalidCreds = driver.findElement(By.xpath(errorInvalidCredsXpath));
        return errorMessageInvalidCreds.getText();
    }
}
