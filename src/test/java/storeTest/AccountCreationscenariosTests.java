package storeTest;

import org.junit.Test;

public class AccountCreationscenariosTests  extends BaseTest {
    @Test
    public void SuccessfulAccountCreation() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        accountCreation.EnterEmail("gina@test2.com");
        accountCreation.ClickCreateAnAccount();
        accountCreation.CheckTitle("YOUR PERSONAL INFORMATION");
        accountCreation.CheckGender();
        accountCreation.EnterFirstName("Gina");
        accountCreation.EnterLastName("Rosianu");
        accountCreation.EnterPassword("1234567890");
        accountCreation.AddDayOfBirth("22");
        accountCreation.AddMonthOfBirth("9");
        accountCreation.AddYearOfBirth("2000");
        accountCreation.FirstNameForAddress("Gina");
        accountCreation.LastNameForAddress("Rosianu");
        accountCreation.EnterCompany("Endava");
        accountCreation.AddAdress("Floresti");
        accountCreation.AddCity("Flo");
        accountCreation.AddState("Alabama");
        accountCreation.AddPostcode("00000");
        accountCreation.AddMobilePhone("0770123456");
        accountCreation.ClickOnRegister();
        login.checkTitle("MY ACCOUNT");

    }

    @Test
    public void UnSuccessfulAccountCreation_ExistingEmailAddress() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        accountCreation.EnterEmail("gina@test1.com");
        accountCreation.ClickCreateAnAccount();
    }

    @Test
    public void AccountCreationUsingOnlyMandatoryFields() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        accountCreation.EnterEmail("maria@test.com");
        accountCreation.ClickCreateAnAccount();
        accountCreation.CheckTitle("YOUR PERSONAL INFORMATION");
        accountCreation.EnterFirstName("Maria");
        accountCreation.EnterLastName("Popa");
        accountCreation.EnterPassword("1234567890");
        accountCreation.FirstNameForAddress("Maria");
        accountCreation.LastNameForAddress("Popa");
        accountCreation.AddAdress("flo");
        accountCreation.AddCity("Floresti");
        accountCreation.AddState("Alaska");
        accountCreation.AddPostcode("00000");
        accountCreation.AddMobilePhone("0770123456");
        accountCreation.ClickOnRegister();
        login.checkTitle("MY ACCOUNT");
    }
    @Test
    public void NotFillingTheMandatoryFields_City() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        accountCreation.EnterEmail("maria2@test.com");
        accountCreation.ClickCreateAnAccount();
        accountCreation.CheckTitle("YOUR PERSONAL INFORMATION");
        accountCreation.EnterFirstName("Maria");
        accountCreation.EnterLastName("Popa");
        accountCreation.EnterPassword("1234567890");
        accountCreation.FirstNameForAddress("Maria");
        accountCreation.LastNameForAddress("Popa");
        accountCreation.AddAdress("Flo");
        accountCreation.AddState("Alaska");
        accountCreation.AddPostcode("00000");
        accountCreation.AddMobilePhone("0770123456");
        accountCreation.ClickOnRegister();
       // accountCreation.CheckErrorMessage("City is required.");
    }

    @Test
    public void NumericFieldsFilledWithLetters() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        accountCreation.EnterEmail("maria3@test.com");
        accountCreation.ClickCreateAnAccount();
        accountCreation.CheckTitle("YOUR PERSONAL INFORMATION");
        accountCreation.EnterFirstName("Maria");
        accountCreation.EnterLastName("Popa");
        accountCreation.EnterPassword("1234567890");
        accountCreation.FirstNameForAddress("Maria");
        accountCreation.LastNameForAddress("Popa");
        accountCreation.AddAdress("Flo");
        accountCreation.AddCity("Flo");
        accountCreation.AddState("Alaska");
        accountCreation.AddPostcode("abcde");
        accountCreation.AddMobilePhone("0770123456");
        accountCreation.ClickOnRegister();
        accountCreation.CheckErrorMessage("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
    }

    @Test
    public void IncorrectDateOfBirth() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        accountCreation.EnterEmail("gina@test2.com");
        accountCreation.ClickCreateAnAccount();
        accountCreation.CheckTitle("YOUR PERSONAL INFORMATION");
        accountCreation.CheckGender();
        accountCreation.EnterFirstName("Gina");
        accountCreation.EnterLastName("Rosianu");
        accountCreation.EnterPassword("1234567890");
        accountCreation.AddDayOfBirth("22");
        accountCreation.AddYearOfBirth("2000");
        accountCreation.FirstNameForAddress("Gina");
        accountCreation.LastNameForAddress("Rosianu");
        accountCreation.EnterCompany("Endava");
        accountCreation.AddAdress("Floresti");
        accountCreation.AddCity("Flo");
        accountCreation.AddState("Alabama");
        accountCreation.AddPostcode("00000");
        accountCreation.AddMobilePhone("0770123456");
        accountCreation.ClickOnRegister();
        accountCreation.CheckErrorMessage("Invalid date of birth");
    }

    @Test
    public void InvalidEmailAddress() {
        homePage.click_signInButton();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        accountCreation.EnterEmail("gina");
        accountCreation.ClickCreateAnAccount();
        //accountCreation.CheckErrorMessage("Invalid email address.");
    }
}
