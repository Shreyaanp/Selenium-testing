package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleDynamic extends BaseClass {
    @Test
    public void handleDynamicElement() {
        driver.get("https://shreyaanp.github.io/Registercheck/");
        driver.manage().window().maximize();

        // Wait for the registration form to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

        nameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("john.doe@example.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SecurePassword123");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait for the dynamic message element to be visible
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id, 'message-')]")));
        String successMessage = message.getText();

        if (successMessage.contains("Registration successful")) {
            System.out.println("Registration Test Passed");
        } else {
            System.out.println("Registration Test Failed");
        }
    }
}
