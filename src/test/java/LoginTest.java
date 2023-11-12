import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).submit();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User isn't logged in or wrong page");
    }
    @Test
    public void emptyLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).submit();
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorMessage = error.getText();
        assertEquals(errorMessage, "Epic sadface: Username is required", "User has successfully logged in");
    }
    @Test
    public void onlyLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).submit();
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorMessage = error.getText();
        assertEquals(errorMessage, "Epic sadface: Username is required", "User has successfully logged in");
    }

    @Test
    public void onlyPasswordLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).submit();
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorMessage = error.getText();
        assertEquals(errorMessage, "Epic sadface: Username is required", "User has successfully logged in");
    }

    @Test
    public void wrongLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standart_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).submit();
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorMessage = error.getText();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "User has successfully logged in");
    }

}
