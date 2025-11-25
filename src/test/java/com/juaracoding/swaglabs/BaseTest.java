package com.juaracoding.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        openBrowser("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    public void openBrowser(String url){
        driver.get(url);
    }


}
