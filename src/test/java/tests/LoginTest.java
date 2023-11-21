package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "User isn't logged in or wrong page");
    }

    @Test
    public void emptyLogin() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Bad");
    }

    @Test
    public void onlyLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Bad");
    }

    @Test
    public void onlyPasswordLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
       assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Bad");
    }

    @Test
    public void wrongLogin() {
        loginPage.open();
        loginPage.login("standart_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Bad");
    }

}
