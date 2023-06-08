package by.itacademy.andreialiasiuk.taf.sites.steps;

import by.itacademy.andreialiasiuk.taf.sites.pages.PizzatempoPage;
import by.itacademy.andreialiasiuk.taf.sites.utils.Utils;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoStep {
    PizzatempoPage page;

    public PizzatempoStep(ChromeDriver driver) {
        page = new PizzatempoPage(driver);
    }

    public void keyLoginCredsAndSubmit(String email, String password) {
        page.sendKeysEmailInputField(email);
        page.sendKeysPasswordInputField(password);
        page.clickSubmitButton();
    }
}
