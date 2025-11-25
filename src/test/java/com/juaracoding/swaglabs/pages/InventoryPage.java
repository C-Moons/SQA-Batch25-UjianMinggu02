package com.juaracoding.swaglabs.pages;

import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPathURL() {
        String[] path = driver.getCurrentUrl().split("/");
        return "/" + path[path.length - 1];
    }
}
