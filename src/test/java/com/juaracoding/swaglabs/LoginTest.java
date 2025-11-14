package com.juaracoding.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    @Parameters({ "username", "password" })
    public void loginSuccessWithValidCredentialTest(String username, String password) throws InterruptedException {
        openBrowserAndNavigateTo("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();

        String[] path = driver.getCurrentUrl().split("/");
        String expected = "/inventory.html";
        String actual = "/" + path[path.length - 1];

        Assert.assertEquals(actual, expected);
        quitBrowser();
    }

    @Test(priority = 2)
    @Parameters({ "invalidUsername", "password" })
    public void loginFailedWithInvalidUsernameTest(String invalidUsername, String password)
            throws InterruptedException {
        openBrowserAndNavigateTo("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys(invalidUsername);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();

        WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actual = errorMessageElement.getText();
        String expected = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(actual, expected);
        quitBrowser();
    }
}
