package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your order!']")));
    }

    public void payment(String name, String lastname, String zipcode) {
        driver.findElement(CHECKOUT_BUTTON).click();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Your Information']")));
        driver.findElement(CHECKOUT_FIRSTNAME).sendKeys(name);
        driver.findElement(CHECKOUT_LASTNAME).sendKeys(lastname);
        driver.findElement(CHECKOUT_ZIPCODE).sendKeys(zipcode);
        driver.findElement(CHECKOUT_CONTINUE).click();
        driver.findElement(CHECKOUT_FINISH).click();
    }

    public String successOrder() {
        return driver.findElement(ORDER_MESSAGE).getText();
    }
}
