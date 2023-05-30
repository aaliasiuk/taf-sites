package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingPage {
    ChromeDriver driver;
    String closePopUpIconXpath = "//div/button[@aria-label='Dismiss sign-in info.']";
    String registerButtonXpath = "//a[contains(.,'Sign in or register')]";
    String emailInputFieldXpath = "//div/input[@type='email']";
    String continueWithEmailButtonXpath = "//div/button[@type='submit']";
    String passwordInputFieldXpath = "//*[@id='password']";
    String submitButtonXpath = "//div/button[@type='submit']";
    String baseURL = "https://www.booking.com/";

    public BookingPage (ChromeDriver newDriver){
        driver = newDriver;
    }


    public void closePopUp(){
        WebElement closePopUpIcon = driver.findElement(By.xpath(closePopUpIconXpath));
        closePopUpIcon.click();
    }
    public void clickRegisterButton(){
        WebElement registerButton = driver.findElement(By.xpath(registerButtonXpath));
        registerButton.click();
    }
    public void sendKeysEmailInputField(String str){
        WebElement emailInputField = driver.findElement(By.xpath(emailInputFieldXpath));
        emailInputField.sendKeys(str);
    }
    public void clickContinueWithEmailButton(){
        WebElement continueWithEmailButton = driver.findElement(By.xpath(continueWithEmailButtonXpath));
        continueWithEmailButton.click();
    }
    public void sendKeysPasswordInputField(String str){
        WebElement passwordInputField = driver.findElement(By.xpath(passwordInputFieldXpath));
        passwordInputField.sendKeys(str);
    }
    public void clickSubmitButton(){
        WebElement submitButton = driver.findElement(By.xpath(submitButtonXpath));
        submitButton.click();
    }

}
