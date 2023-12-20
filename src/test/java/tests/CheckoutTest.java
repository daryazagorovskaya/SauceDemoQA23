package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "Verifying successful payment")
    public void ExecuteSuccessCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openCart();
        checkoutPage.payment("Darya", "Zagorovskaya", "12345");
        checkoutPage.isOpened();
        Assert.assertEquals(checkoutPage.successOrder(), "Thank you for your order!", "Test is failed");
    }
}
