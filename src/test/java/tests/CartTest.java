package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    @Test(description = "Checking removed product from the cart")
    public void removeProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openCart();
        cartPage.productInCart("Sauce Labs Bike Light");
        cartPage.removeItem("Sauce Labs Bike Light");
        Assert.assertTrue(cartPage.isProductInTheCart("Sauce Labs Bolt T-Shirt"));
    }

    @Test(description = "Checking added product from the cart")
    public void addProductInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.productInCart("Sauce Labs Bike Light");
        assertEquals(productsPage.inventoryItemText(), "Sauce Labs Bike Light",
                "Wrong product has been added into the cart");
    }

    @Test(description = "Checking added product by index from the cart")
    public void addProductInTheCartByIndex() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        assertTrue(cartPage.isProductInTheCart("Sauce Labs Bike Light"));
        assertEquals(cartPage.getProductFromCart(0),
                "Sauce Labs Bike Light");
    }

    @Test(description = "Checking added product by price and name from the cart")
    public void checkProductByPriceAndName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"),
                "$9.99");
    }

    @Test(description = "Checking added product by name from the cart")
    public void checkProductByName(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        assertTrue(cartPage.getProductNames().contains("Sauce Labs Bike Light"));
    }
}
