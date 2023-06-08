package by.itacademy.andreialiasiuk.taf.sites.utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    ChromeDriver driver;

    public Utils(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public String generateInvalidEmail() {
        Faker faker = new Faker();
        return faker.internet().domainName();
    }

    public String generatePassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }
}
