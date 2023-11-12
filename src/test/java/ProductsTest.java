import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest  extends BaseTest {

    @Test
    public void buyProduct(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).submit();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']/ancestor::*[@class=" +
                "'inventory_item']//button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String product = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(product, "Sauce Labs Bike Light", "Wrong product has been added into the cart");
    }
}
