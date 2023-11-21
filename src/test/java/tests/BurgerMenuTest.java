package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BurgerMenuTest extends BaseTest {

    @Test
    public void logOut() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.logOut();
        assertTrue(burgerMenuPage.returnLoginWindow());
    }

    @Test
    public void about() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.aboutButton();
        assertTrue(burgerMenuPage.checkTransitMainSite());
    }
}
