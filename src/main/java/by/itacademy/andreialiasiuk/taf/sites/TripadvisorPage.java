package by.itacademy.andreialiasiuk.taf.sites;

public class TripadvisorPage {
    String signInButtonXpath = "//span[contains(., 'Sign in')] | //*[@id='lithium-root']/header/div/nav/div/div[2]/a[4]/span";
    String continueWithEmailXpath = "//span[contains(., 'Continue with email')]";
    String emailInputFieldXpath = "//*[@id='regSignIn.email']";
    String passwordInputFieldXpath = "//*[@id='regSignIn.password']";
    String submitButtonXpath = "//*[@id='regSignIn']/div[4]/button[1]";
    String baseURL = "https://www.tripadvisor.com/";
}
