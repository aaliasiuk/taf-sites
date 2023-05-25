package by.itacademy.andreialiasiuk.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    ChromeDriver driver;
    String[] chars = {" ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\"", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~"};
    String[] domain = {"@gmail.com", "@mail.ru", "@yandex.ru"};

    String resultChars = "";
    String resultDomain = "";

    public Utils(ChromeDriver newDriver) {

        driver = newDriver;
    }

    public String generateEmail() {
        for (int i = 0; i < 8; i++) {
            int j;
            j = (int) Math.floor(Math.random() * chars.length);
            resultChars = resultChars.concat(chars[j]);
        }
        for (int i = 0; i < 1; i++) {
            int j;
            j = (int) Math.floor(Math.random() * domain.length);
            resultDomain = resultDomain.concat(domain[j]);
        }
        return resultChars + resultDomain;
    }

    public String generatePassword() {
        for (int i = 0; i < 7; i++) {
            int j;
            j = (int) Math.floor(Math.random() * chars.length);
            resultChars = resultChars.concat(chars[j]);
        }
        return resultChars;
    }
}
