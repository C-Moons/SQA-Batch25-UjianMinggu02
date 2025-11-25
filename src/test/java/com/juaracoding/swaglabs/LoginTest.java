package com.juaracoding.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.swaglabs.pages.InventoryPage;
import com.juaracoding.swaglabs.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1, enabled = true)
    @Parameters({ "username", "password" })
    public void loginSuccessWithValidCredentialTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login(username, password);

        Assert.assertEquals(inventoryPage.getPathURL(), "/inventory.html");
    }

    @Test(priority = 2, enabled = true)
    @Parameters({ "invalidUsername", "password" })
    public void loginFailedWithInvalidUsernameTest(String invalidUsername, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(invalidUsername, password);

        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expected);
    }

    @Test(priority = 3, enabled = true)
    @Parameters({ "username", "invalidPassword" })
    public void loginFailedWithInvalidPasswordTest(String username, String invalidPassword) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, invalidPassword);

        String expected = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(loginPage.getErrorMessage(), expected);
    }

    /*
     * Test Case ID: TC-LOGIN-004
     * Judul: Login gagal dengan username dan password kosong
     * Skenario: Pengguna tidak memasukkan username dan password, lalu menekan
     * tombol login.
     */
    @Test(priority = 4, enabled = true)
    @Parameters({ "username", "invalidPassword" })
    public void loginFailedWithPasswordUsernameBlankTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonLogin();
        String expected = "Epic sadface: Username is required";

        Assert.assertEquals(loginPage.getErrorMessage(), expected);
    }

    /*
     * Test Case ID: TC-LOGIN-005
     * Judul: Login gagal dengan password kosong
     * Skenario: Pengguna hanya memasukkan username, lalu menekan tombol login.
     */
    @Test(priority = 5, enabled = true)
    @Parameters({ "username"})
    public void loginFailedWithPasswordBlankTest(String username) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, "");
        String expected = "Epic sadface: Password is required";

        Assert.assertEquals(loginPage.getErrorMessage(), expected);
    }
}
