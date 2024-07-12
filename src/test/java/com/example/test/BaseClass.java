package com.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * BaseClass serves as the setup and teardown class for WebDriver.
 * All test classes extend this class to inherit WebDriver initialization and cleanup methods.
 */
public class BaseClass {
    protected WebDriver driver;

    /**
     * This method is executed once before any tests in this suite run.
     * It is typically used for global setup tasks.
     */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Global setup can be done here.");
        // Example: Initialize global variables or configurations
    }

    /**
     * This method is executed once after all tests in this suite have run.
     * It is typically used for global cleanup tasks.
     */
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Global cleanup can be done here.");
        // Example: Cleanup global resources
    }

    /**
     * This method is executed before any test method belonging to the classes inside the <test> tag is run.
     * It is typically used for setup tasks specific to each test.
     */
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: Setup specific to the test tag can be done here.");
        // Example: Setup configurations specific to test
    }

    /**
     * This method is executed after all the test methods belonging to the classes inside the <test> tag have run.
     * It is typically used for cleanup tasks specific to each test.
     */
    @AfterTest
    public void afterTest() {
        System.out.println("After Test: Cleanup specific to the test tag can be done here.");
        // Example: Reset configurations specific to test
    }

    /**
     * This method is executed before the first test method in the current class is invoked.
     * It sets up the WebDriver to use the specified version of ChromeDriver.
     */
    @BeforeClass
    public void setUp() {
        System.out.println("Before Class: Setting up WebDriver.");
        // Setup WebDriver to use the specific version of ChromeDriver
        WebDriverManager.chromedriver().driverVersion("126.0.6478.126").setup();
        driver = new ChromeDriver();
    }

    /**
     * This method is executed after all the test methods in the current class have run.
     * It quits the WebDriver, closing all associated windows.
     */
    @AfterClass
    public void tearDown() {
        System.out.println("After Class: Tearing down WebDriver.");
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * This method is executed before each test method.
     * It can be used to set up preconditions specific to each test method.
     */
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Setting up preconditions for test method.");
        // Example: Open a specific page before each test method
    }

    /**
     * This method is executed after each test method.
     * It can be used to clean up after each test method.
     */
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Cleaning up after test method.");
        // Example: Log out from the application after each test method
    }
}
