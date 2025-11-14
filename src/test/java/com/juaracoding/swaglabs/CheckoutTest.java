package com.juaracoding.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckoutTest {

    private WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    @Parameters({ "username", "password", "firstname", "lastname", "code" })
    public void checkoutSuccessTest(String username, String password, String firstname, String lastname, String code)
            throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys(firstname);
        Thread.sleep(1000);
        driver.findElement(By.id("last-name")).sendKeys(lastname);
        Thread.sleep(1000);
        driver.findElement(By.id("postal-code")).sendKeys(code);
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(500);
        driver.findElement(By.id("finish")).click();

        String[] path = driver.getCurrentUrl().split("/");
        String expected = "/checkout-complete.html";
        String actual = "/" + path[path.length - 1];

        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}