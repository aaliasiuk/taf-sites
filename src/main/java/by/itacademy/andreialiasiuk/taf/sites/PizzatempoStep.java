package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoStep {
    PizzatempoPage page;
    ChromeDriver driver;
    Utils utils;

    public PizzatempoStep(ChromeDriver driver) {
        page = new PizzatempoPage(driver);
    }
    public void keyLoginCredsAndSubmit(String email, String password){
        page.sendKeysEmailInputField(email);
        page.sendKeysPasswordInputField(password);
        page.clickSubmitButton();

    }
}
