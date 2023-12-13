package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
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
        log.info("Logout BurgerMenu page");
        driver.findElement(BURGER_MENU).click();
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Check transit to login window")
    public boolean returnLoginWindow() {
        log.info("Check transit to login window");
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Step("Testing a button click 'about'")
    public void aboutButton() {
        log.info("Testing a button click 'about'");
        driver.findElement(BURGER_MENU).click();
        driver.findElement(ABOUT_BUTTON).click();
    }

    @Step("Check transit to main site")
    public boolean checkTransitMainSite() {
        log.info("Check transit to main site");
         driver.get(SAUCE_LABS_URL);
        return true;
    }
}
