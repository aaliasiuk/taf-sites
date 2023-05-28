package by.itacademy.andreialiasiuk.taf.sites;

import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    ChromeDriver driver;

    public Utils(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public String generateEmail() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        return email;
    }
    public String generateInvalidEmail(){
        Faker faker = new Faker();
        String invalidEmail = faker.internet().domainName();
        return invalidEmail;
    }

    public String generatePassword() {
        Faker faker = new Faker();
        String password = faker.internet().password();
        return password;
    }
}
