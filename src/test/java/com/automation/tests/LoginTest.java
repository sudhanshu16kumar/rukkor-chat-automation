package com.automation.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;


public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {

        System.out.println("=== SETUP STARTED ===");
        System.out.println("Browser parameter value: " + browser);

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.out.println("Launching Chrome...");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("edge")) {
                System.out.println("Launching Edge...");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.manage().window().maximize();
            driver.get("https://dev.app.rukkor.com/");
            loginPage = new LoginPage(driver);

            System.out.println("=== SETUP COMPLETED ===");

        } catch (Exception e) {
            System.out.println("❌ SETUP FAILED ❌");
            e.printStackTrace();   // 🔥 THIS IS THE KEY LINE
            throw e;
        }
    }



    // ✅ Scenario 1: Valid Login (User A)
    @Test
    public void validLogin_UserA() throws InterruptedException {

        loginPage.login("qa1.test@yopmail.com", "Test@123456");

        System.out.println("👉 Enter OTP manually on browser, then wait...");
        Thread.sleep(60000); // manual OTP wait

        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardLoaded(),
                "Login failed for User A");
    }

    // ✅ Scenario 1: Valid Login (User B)
    @Test
    public void validLogin_UserB() throws InterruptedException {

        loginPage.login("qa2.test@yopmail.com", "Test@123456");

        System.out.println("👉 Enter OTP manually on browser, then wait...");
        Thread.sleep(60000); // manual OTP wait

        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardLoaded(),
                "Login failed for User B");
    }

    // ⭐ BONUS: Invalid Login Scenario
    @Test
    public void invalidLogin_WrongPassword() {

        loginPage.login("qa1.test@yopmail.com", "WrongPassword123");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error message not shown for invalid login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
