package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BrowserWait extends BaseClass {

    @Test
    public void testImplicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set implicit wait
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q")); // Will wait up to 10 seconds if element is not immediately found
        searchBox.sendKeys("Selenium WebDriver" + Keys.RETURN);
        System.out.println("Performed search with implicit wait.");
    }

//    @Test
//    public void testExplicitWait() {
//        driver.get("https://www.google.com/");
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))); // Wait for search box to be visible
//
//        searchBox.sendKeys("Selenium WebDriver" + Keys.RETURN);
//        System.out.println("Performed search with explicit wait.");
//    }

//    @Test
//    public void testFluentWait() {
//        driver.get("https://www.google.com/");
//
//        FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(15,1))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException during polling
//
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))); // Wait for search box to be visible
//
//        searchBox.sendKeys("Selenium WebDriver" + Keys.RETURN);
//        System.out.println("Performed search with fluent wait.");
//    }
}
