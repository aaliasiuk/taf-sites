package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosPage {
    private ChromeDriver driver;
    private String closeModalIconXpath = "//body/div[4]/div[2]/button";
    private String loginButtonHomePageXpath = "//button[@aria-controls='login-modal']";
    private String emailInputFieldXpath = "//*[@id='Email']";
    private String passwordInputFieldXpath = "//*[@id='Password']";
    private String submitButtonXpath = "//*[@id='login-modal']//button[@data-quid='sign-in-button']";
    String baseURL = "https://www.dominos.com/";

    private String errorEmailMessageId = "error-Email";
    public String errorEmailMessageText = "Please enter a valid email address.";
    private String loginModalAttentionXpath = "//*[@id='login-modal']/div/p";
    public String loginModalAttentionText = "We could not locate a Pizza Profile with that e-mail and password combination. Please make sure you are using the e-mail address associated with your Domino's Pizza Profile.";

    public DominosPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public void closeModal() {
        WebElement closeModalIcon = driver.findElement(By.xpath(closeModalIconXpath));
        closeModalIcon.click();
    }

    public void loginHomePage() {
        WebElement loginButtonHomePage = driver.findElement(By.xpath(loginButtonHomePageXpath));
        loginButtonHomePage.click();
    }

    public void sendKeysEmailField(String str) {
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

    public String getErrorEmailMessage() {
        WebElement errorEmailMessage = driver.findElement(By.id(errorEmailMessageId));
        return errorEmailMessage.getText();
    }

    public String getLoginModalAttentionText() {
        WebElement loginModalAttention = driver.findElement(By.xpath(loginModalAttentionXpath));
        return loginModalAttention.getText();
    }

}
