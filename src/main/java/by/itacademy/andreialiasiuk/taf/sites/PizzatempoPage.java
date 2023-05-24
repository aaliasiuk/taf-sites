package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String emailInputFieldXpath = "//input[@name='astroauth_login']";
    private String passwordInputFieldXpath = "//input[@name='astroauth_pass']";
    private String submitButtonXpath = "//input[@name='astroauth_submit']";
    String baseURL = "https://www.pizzatempo.by/";


    //methods
    public PizzatempoPage(ChromeDriver newDriver){
        driver = newDriver;
    }
    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath(submitButtonXpath));
        submitButton.click();
    }

    public void sendKeysEmailInputField(String str) {
        WebElement emailInputField = driver.findElement(By.xpath(emailInputFieldXpath));
        emailInputField.sendKeys(str);
    }

    public void sendKeysPasswordInputField(String str){
        WebElement passwordInputField = driver.findElement(By.xpath(passwordInputFieldXpath));
        passwordInputField.sendKeys(str);
    }
}
