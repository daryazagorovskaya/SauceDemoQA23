package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']";
    private final String PRODUCT_NAME_IN_CART = "//div[@class='cart_item_label']/descendant::div[text()='%s']";
    private final String REMOVE_BUTTON = "//div[text()='%s']/following::button[@class='btn btn_secondary btn_small cart_button']";
    private final By INVENTORY_ITEM = By.cssSelector(".inventory_item_name");
    private final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::div[@class='cart_item']//*[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

    public String productInCart(String item) {
         By productInCart = By.xpath(String.format(PRODUCT_NAME_IN_CART, item));
         return driver.findElement(productInCart).getText();
    }

    public void removeItem(String item) {
        By removeItem = By.xpath(String.format(REMOVE_BUTTON, item));
         driver.findElement(removeItem).click();
    }

    public boolean isProductInTheCart(String product) {
       return driver.findElement(By.xpath(String.format("//*[text()='%s']", product))).isDisplayed();
    }

    public String getProductFromCart(int index){
        return driver.findElements(INVENTORY_ITEM).get(index).getText();
    }

    public ArrayList <String> getProductNames() {
       List<WebElement> allProductsElements = driver.findElements(INVENTORY_ITEM);
       ArrayList<String> names = new ArrayList<>();
       for (WebElement product : allProductsElements) {
           names.add(product.getText());
       }
        return names;
    }

    public String getProductPrice(String product) {
       return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, product))).getText();
    }
}
