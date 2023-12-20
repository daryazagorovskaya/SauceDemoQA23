package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BurgerMenuTest extends BaseTest {

    @Test(description = "Checking out of your account")
    public void logOut() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.logOut();
        assertTrue(burgerMenuPage.returnLoginWindow());
    }

    @Test(description = "Checking the transition to the 'About' section")
    public void about() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.aboutButton();
        assertTrue(burgerMenuPage.checkTransitMainSite());
    }
}
