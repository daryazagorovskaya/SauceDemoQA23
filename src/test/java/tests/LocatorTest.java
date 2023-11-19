package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LocatorTest extends BaseTest {

    @Test
    public void sauceDemo() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("password"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-backpack']"));
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike')]"));
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-bike')]"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item']//button"));
        driver.findElement(By.xpath("//div[@class='cart_item_label']/descendant::div[text()='Sauce Labs Onesie']"));
        driver.findElement(By.xpath("//a[@id='item_0_title_link']/child::div[text()='Sauce Labs Bike Light']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']//parent::a[@id='item_0_title_link']"));
        driver.findElement(By.xpath("//button[@data-test='remove-test.allthethings()-t-shirt-(red)']" +
                "/following::div[@class='inventory_item_price']"));
        driver.findElement(By.xpath("//div[@class='form_group']/preceding::input[@id='user-name']"));

        driver.findElement(By.cssSelector(".form_group"));
        driver.findElement(By.cssSelector("#user-name"));
        driver.findElement(By.cssSelector("div.inventory_item_price"));
        driver.findElement(By.cssSelector("[id='add-to-cart-sauce-labs-backpack']"));
        driver.findElement(By.cssSelector("div.pricebar"));
        driver.findElement(By.cssSelector("[class='inventory_item_price']"));
        driver.findElement(By.cssSelector("[class~=btn_small]"));
        driver.findElement(By.cssSelector("[class|='footer_copy']"));
        driver.findElement(By.cssSelector("a[id^='logout_sidebar_link']"));
        driver.findElement(By.cssSelector("a[href$='.labs']"));
        driver.findElement(By.cssSelector("li[class*='_twitte']"));
    }
}





