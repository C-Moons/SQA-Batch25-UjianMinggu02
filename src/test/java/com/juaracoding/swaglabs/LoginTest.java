package com.juaracoding.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private String baseUrl = "https://www.saucedemo.com/";

    @BeforeTest
    public void setup() {
        // Membuat objek profil Firefox secara programatik.
        // Cara ini lebih andal karena tidak bergantung pada profil eksternal.
        FirefoxProfile profile = new FirefoxProfile();

        // (Opsional) Anda bisa mengatur berbagai preferensi Firefox di sini.
        // Contoh: menonaktifkan notifikasi, menerima sertifikat, dll.
        // profile.setPreference("dom.webnotifications.enabled", false);
        // profile.setAcceptUntrustedCertificates(true);

        // Buat objek FirefoxOptions dan atur profil yang baru dibuat.
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        // Atur lokasi biner Firefox secara eksplisit untuk mengatasi error.
        // options.setBinary("/snap/firefox/7298/usr/lib/firefox/firefox");
        // options.setBinary("/snap/bin/firefox");
        options.setBinary("/usr/bin/firefox");
        // options.addArguments("--no-sandbox");

        // Inisialisasi WebDriver dengan opsi yang sudah disesuaikan.
        // Pastikan geckodriver sudah ada di PATH sistem Anda atau set path-nya di sini.
        // System.setProperty("webdriver.gecko.driver", "path/to/your/geckodriver");
        driver = new FirefoxDriver(options);
    }

    @Test
    @Parameters({ "username", "password", "firstname", "lastname", "code" })
    public void testOpenUrlWithProfile(String username, String password, String firstname, String lastname, String code) throws InterruptedException {
        driver.get(baseUrl);
        System.out.println("Berhasil membuka URL: " + driver.getTitle());
        // Di sini Anda bisa menambahkan langkah-langkah tes login
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        
        String[] path = driver.getCurrentUrl().split("/");
        String expected = "/inventory.html";
        String actual = "/" + path[path.length - 1];

        Assert.assertEquals(actual, expected);
    }
    // public void loginSuccessWithValidCredentialTest(String username, String
    // password) throws InterruptedException {
    // // driver.get("https://www.saucedemo.com/");
    // }

    @AfterTest
    public void tearDown() {
        // if (driver != null) {
        // driver.quit();
        // }
    }
}