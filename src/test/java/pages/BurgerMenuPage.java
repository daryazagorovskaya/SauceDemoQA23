package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenuPage extends BasePage{

    private final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private final By BURGER_MENU = By.id("react-burger-menu-btn");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ABOUT_BUTTON = By.id("about_sidebar_link");
    final String SAUCE_LABS_URL = "https://saucelabs.com/";


    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        driver.findElement(BURGER_MENU).click();
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public boolean returnLoginWindow() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public void aboutButton() {
        driver.findElement(BURGER_MENU).click();
        driver.findElement(ABOUT_BUTTON).click();
    }

    public boolean checkTransitMainSite() {
         driver.get(SAUCE_LABS_URL);
        return true;
    }
}
