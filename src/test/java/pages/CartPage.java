package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class CartPage extends BasePage {

    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']";
    private final String PRODUCT_NAME_IN_CART = "//div[@class='cart_item_label']/descendant::div[text()='%s']";
    private final String REMOVE_BUTTON = "//div[text()='%s']/following::button[@class='btn btn_secondary btn_small cart_button']";
    private final By INVENTORY_ITEM = By.cssSelector(".inventory_item_name");
    private final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::div[@class='cart_item']//*[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening checkout page")
    public void isOpened() {
        log.info("Opening checkout page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

    @Step("Check if product in the cart by name")
    public String productInCart(String item) {
        log.info("Check if product in the cart by name");
         By productInCart = By.xpath(String.format(PRODUCT_NAME_IN_CART, item));
         return driver.findElement(productInCart).getText();
    }

    @Step("Removing a product by name")
    public void removeItem(String item) {
        log.info("Removing a product by name");
        By removeItem = By.xpath(String.format(REMOVE_BUTTON, item));
         driver.findElement(removeItem).click();
    }

    @Step("Check if product in the cart")
    public boolean isProductInTheCart(String product) {
        log.info("Check if product in the cart");
       return driver.findElement(By.xpath(String.format("//*[text()='%s']", product))).isDisplayed();
    }

    @Step("Search for a product by index")
    public String getProductFromCart(int index) {
        log.info("Search for a product by index");
        return driver.findElements(INVENTORY_ITEM).get(index).getText();
    }

    @Step("Search for a product by name")
    public ArrayList <String> getProductNames() {
        log.info("Search for a product by name");
       List<WebElement> allProductsElements = driver.findElements(INVENTORY_ITEM);
       ArrayList<String> names = new ArrayList<>();
       for (WebElement product : allProductsElements) {
           names.add(product.getText());
       }
        return names;
    }

    @Step("Check price by product name")
    public String getProductPrice(String product) {
        log.info("Check price by product name");
       return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, product))).getText();
    }
}
