package by.itacademy.andreialiasiuk.taf.sites.steps;

import by.itacademy.andreialiasiuk.taf.sites.pages.BookingPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingStep {
    BookingPage page;
    ChromeDriver driver;

    public BookingStep(ChromeDriver driver) {
        page = new BookingPage(driver);

    }

    public void keyLoginCredsAndSubmit(String email, String password) {
        page.closePopUp();
        page.clickRegisterButton();
        page.sendKeysEmailInputField(email);
        page.clickContinueWithEmailButton();
        page.sendKeysPasswordInputField(password);
        page.clickSubmitButton();

    }
}
