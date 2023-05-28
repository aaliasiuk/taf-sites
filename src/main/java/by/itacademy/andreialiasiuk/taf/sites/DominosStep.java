package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class DominosStep {
    DominosPage page;
    ChromeDriver driver;

    public DominosStep(ChromeDriver driver) {
        page = new DominosPage(driver);
    }

    public void keyLoginCredsAndSubmit(String email, String password) {
        page.loginHomePage();
        page.sendKeysEmailField(email);
        page.sendKeysPasswordField(password);
        page.clickSubmitButton();
    }
}
