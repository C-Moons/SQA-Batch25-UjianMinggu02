package com.juaracoding.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    public void openBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    public void navigateTo(String url){
        if(driver != null){
            driver.get(url);
        }
    }
    public void quitBrowser(){
        driver.quit();
    }
    public void openBrowserAndNavigateTo(String url){
        openBrowser();
        navigateTo(url);
    }
}
