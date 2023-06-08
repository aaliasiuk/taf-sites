package by.itacademy.andreialiasiuk.taf.sites.steps;

import by.itacademy.andreialiasiuk.taf.sites.pages.DominosPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosStep {
    DominosPage page;

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
