package pages;

import io.qameta.allure.Step;
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

    @Step("Logout BurgerMenu page")
    public void logOut() {
        driver.findElement(BURGER_MENU).click();
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Check transit to login window")
    public boolean returnLoginWindow() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Step("Testing a button click 'about'")
    public void aboutButton() {
        driver.findElement(BURGER_MENU).click();
        driver.findElement(ABOUT_BUTTON).click();
    }

    @Step("Check transit to main site")
    public boolean checkTransitMainSite() {
         driver.get(SAUCE_LABS_URL);
        return true;
    }
}
