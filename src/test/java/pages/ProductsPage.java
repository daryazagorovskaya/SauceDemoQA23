package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final By CART_LINK = By.id("shopping_cart_container");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final String ITEM_IN_THE_CART = "//div[text()='%s']";

    private final By INVENTORY_ITEM_NAME = By.cssSelector(".inventory_item_name");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening products page")
    public void open() {
        log.info("Opening {BASE_URL}");
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("Returns title")
    public String getTitle() {
        log.info("Getting title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    @Step("Add product to cart")
    public void addToCart(String product) {
        log.info("Add product to cart of pattern");
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    @Step("Opening cart")
    public void openCart() {
        log.info("Opening cart");
        driver.findElement(CART_LINK).click();
    }

    @Step("Returns name of product")
    public String inventoryItemText() {
        log.info("Returns name of product");
        return driver.findElement(INVENTORY_ITEM_NAME).getText();
    }
}
