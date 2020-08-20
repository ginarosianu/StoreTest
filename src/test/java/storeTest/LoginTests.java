package storeTest;

import org.junit.Test;

public class LoginTests extends BaseTest {
    @Test
    public void shouldLogin() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
       // authenticationPage.enterEmailAddress("gina.rosianu@gmail.ro");
        }

    @Test
    public void SuccessfulLogin() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("gina.rosianu@gmail.ro");
        login.EnterPassword("1234567890");
        login.click_signInButton();
        login.checkTitle("MY ACCOUNT");

    }

    @Test
    public void WrongPassword() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("gina.rosianu@gmail.ro");
        login.EnterPassword("aaaaa");
        login.click_signInButton();
        login.checkErrorMessage("Authentication failed.");
    }

    @Test
    public void WrongEmailAddress() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("gina.rosianu");
        login.EnterPassword("1234567890");
        login.click_signInButton();
        login.checkErrorMessage("Invalid email address.");
    }

    @Test
    public void WrongEmailAddressAndPassword() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("gina.rosianu");
        login.EnterPassword("0000");
        login.click_signInButton();
        login.checkErrorMessage("Invalid email address.");
    }

    @Test
    public void BlankEmailAddressAndPassword() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("");
        login.EnterPassword("");
        login.click_signInButton();
        login.checkErrorMessage("An email address required.");
    }

    @Test
    public void SuccessfulChangePassword() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.clickForgotPass();
        login.checkPageTitle("FORGOT YOUR PASSWORD?");
        login.EnterEmail("gina.rosianu@gmail.ro");
        login.clickRetrievePassword();
        login.checkConfirmationMessage("A confirmation email has been sent to your address: gina.rosianu@gmail.ro");
    }
    @Test
    public void UnSuccessfulChangePassword() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.clickForgotPass();
        login.checkPageTitle("FORGOT YOUR PASSWORD?");
        login.clickRetrievePassword();
        login.checkErrorMessage2("Invalid email address.");
    }
    // Enter username
    // Enter password
    // Click login/signin
    // Verify page title
    // Verify login is made with correct email/username
}
