package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TripadvisorStep {
    TripadvisorPage page;
    ChromeDriver driver;
    Utils utils;

    public TripadvisorStep(ChromeDriver driver) {
        page = new TripadvisorPage(driver);
    }

    public void keyLoginAndClickSubmit(String email, String password) {
        page.clickSignInButton();
        page.clickContinueWithEmail();
        page.sendKeysEmailInputField(email);
        page.sendKeysPasswordField(password);
        page.clickSubmitButton();
    }
}
