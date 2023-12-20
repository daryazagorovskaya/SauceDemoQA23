package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Verifying successful login")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "User isn't logged in or wrong page");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standart_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
        };
    }
    @Test(dataProvider = "loginData")
    public void negativeLogin(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), expectedError, "Wrong error message is show");
    }

    @Test(description = "Checking input with empty values")
    public void emptyLogin() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Bad");
    }

    @Test(description = "Login check only with login")
    public void onlyLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Bad");
    }

    @Test(description = "Login check only with password")
    public void onlyPasswordLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
       assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Bad");
    }

    @Test(description = "Login check only with wrong values")
    public void wrongLogin() {
        loginPage.open();
        loginPage.login("standart_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Bad");
    }
}
