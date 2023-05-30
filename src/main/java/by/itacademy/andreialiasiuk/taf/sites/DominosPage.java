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

    public void clickSubmitButton(){
        WebElement submitButton = driver.findElement(By.xpath(submitButtonXpath));
        submitButton.click();
    }

}
