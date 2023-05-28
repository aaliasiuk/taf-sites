package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String emailInputFieldName = "astroauth_login";
    private String passwordInputFieldName = "astroauth_pass";
    private String submitButtonName = "astroauth_submit";
    String baseURL = "https://www.pizzatempo.by/";


    //methods
    public PizzatempoPage(ChromeDriver newDriver) {

        driver = newDriver;
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.name(submitButtonName));
        submitButton.click();
    }

    public void sendKeysEmailInputField(String str) {
        WebElement emailInputField = driver.findElement(By.name(emailInputFieldName));
        emailInputField.sendKeys(str);
    }

    public void sendKeysPasswordInputField(String str) {
        WebElement passwordInputField = driver.findElement(By.name(passwordInputFieldName));
        passwordInputField.sendKeys(str);
    }
}
