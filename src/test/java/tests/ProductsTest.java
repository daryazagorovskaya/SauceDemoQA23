package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest  extends BaseTest {

    @Test(description = "Product buy verification", retryAnalyzer = Retry.class )
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        assertEquals(productsPage.inventoryItemText(), "Sauce Labs Bike Light",
                "Wrong product has been added into the cart");

    }

    @Test(description = "Product buy verification")
    public void buyProduct2() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openCart();
        assertEquals(productsPage.inventoryItemText(), "Sauce Labs Bolt T-Shirt",
                "Wrong product has been added into the cart");
    }
}
