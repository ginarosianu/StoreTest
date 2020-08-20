package storeTest;

import org.junit.Test;

public class PlaceAnOrderTests extends BaseTest {
    @Test
    public void ShopByCategories_PayByBankWire() {
        //user already has an account
        homePage.DisplayHomePage();
        order.ClickOnWomenCategory();
        order.CheckTitle("Women");
        order.ChooseAddress();
        order.ClickAddToCart();
        order.ProceedToCheckout();
        order.ProceedToCheckout2();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("gina.rosianu@gmail.ro");
        login.EnterPassword("1234567890");
        login.click_signInButton();
        order.ProceedToCheckout3();
        order.AgreeTheTerms();
        order.ProceedToCheckout4();
        order.PayByBankWire();
        order.Confirmation();
        order.CheckTitle2("ORDER CONFIRMATION");
    }

    @Test
    public void ShopByCategories_PayByCheck() {
        //user already has an account
        homePage.DisplayHomePage();
        order.ClickOnWomenCategory();
        order.CheckTitle("Women");
        order.ChooseAddress();
        order.ClickAddToCart();
        order.ProceedToCheckout();
        order.ProceedToCheckout2();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("gina.rosianu@gmail.ro");
        login.EnterPassword("1234567890");
        login.click_signInButton();
        order.ProceedToCheckout3();
        order.AgreeTheTerms();
        order.ProceedToCheckout4();
        order.PayByCheck();
        order.Confirmation();
        order.CheckTitle2("ORDER CONFIRMATION");
    }

    @Test
    public void IncreasingNumberOfProductsInTheCart() {
        homePage.DisplayHomePage();
        order.EnterWhatYouWantToSearch("Dress");
        order.PressSearchButton();
        order.ChooseAddress();
        order.ClickAddToCart();
        order.ProceedToCheckout();
        order.IncreasingButton();
    }

    @Test
    public void DecreasingNumberOfProductsInTheCart() {
        homePage.DisplayHomePage();
        order.EnterWhatYouWantToSearch("Dress");
        order.PressSearchButton();
        order.ChooseAddress();
        order.ClickAddToCart();
        order.ProceedToCheckout();
        order.DecreasingButton();
    }

    @Test // failed because filtering is not working => bug#1
    public void FilterProducts_ByDresses() {
        homePage.DisplayHomePage();
        order.ClickOnWomenCategory();
        order.CheckTitle("Women");
        order.FilterByDresses();
        //check if makes sort...??
    }

    @Test  // failed because sorting is not working => bug#2
    public void ShopBy_SortingCriteria() {
        homePage.DisplayHomePage();
        order.ClickOnWomenCategory();
        order.CheckTitle("Women");
        order.Sorting("price:desc");
    }

    @Test
    public void SearchProduct() {
        homePage.DisplayHomePage();
        order.EnterWhatYouWantToSearch("Dress");
        order.PressSearchButton();
    }


    @Test
    public void UpdateAddress() {
        //user has an account
        homePage.DisplayHomePage();
        order.EnterWhatYouWantToSearch("Dress");
        order.PressSearchButton();
        order.ChooseAddress();
        order.ClickAddToCart();
        order.ProceedToCheckout();
        order.ProceedToCheckout2();
        authenticationPage.checkPageTitle("AUTHENTICATION");
        login.EnterEmail("gina.rosianu@gmail.ro");
        login.EnterPassword("1234567890");
        login.click_signInButton();
        order.checkAddressTitle("ADDRESSES");
        order.PressUpdateButton();
        accountCreation.AddAdress("Main Address");
        order.ClickOnSave();
        order.checkAddressTitle("ADDRESSES");
    }

    @Test
    public void EmptyCart() {
        homePage.DisplayHomePage();
        order.EmptyCartClick();
        order.CheckEmptyCartError("Your shopping cart is empty.");
    }


}
