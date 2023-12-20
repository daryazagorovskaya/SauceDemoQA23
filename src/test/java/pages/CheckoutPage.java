package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Log4j2
public class CheckoutPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.name("checkout");
    private final By CHECKOUT_FIRSTNAME = By.name("firstName");
    private final By CHECKOUT_LASTNAME = By.name("lastName");
    private final By CHECKOUT_ZIPCODE = By.name("postalCode");
    private final By CHECKOUT_CONTINUE = By.name("continue");
    private final By CHECKOUT_FINISH = By.id("finish");
    private final By ORDER_MESSAGE = By.xpath("//h2[text()='Thank you for your order!']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the successful payment page")
    public void isOpened() {
        log.info("Open the successful payment page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_MESSAGE));
    }

    @Step("Checkout process")
    public void payment(String name, String lastname, String zipcode) {
        log.info("Checkout {name} {lastname} {zipcode} process");
        driver.findElement(CHECKOUT_BUTTON).click();
        driver.findElement(CHECKOUT_FIRSTNAME).sendKeys(name);
        driver.findElement(CHECKOUT_LASTNAME).sendKeys(lastname);
        driver.findElement(CHECKOUT_ZIPCODE).sendKeys(zipcode);
        driver.findElement(CHECKOUT_CONTINUE).click();
        driver.findElement(CHECKOUT_FINISH).click();
    }

    @Step("Returns an message about success order")
    public String successOrder() {
        log.info("Returns an message about success order");
        return driver.findElement(ORDER_MESSAGE).getText();
    }
}
