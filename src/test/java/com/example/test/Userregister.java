package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Userregister extends BaseClass {
    @Test
    public void register() {
        driver.get("https://shreyaanp.github.io/Registercheck/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("John Doe");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("john.doe@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SecurePassword123");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement message = driver.findElement(By.id("message"));
        String successMessage = message.getText();
        if(successMessage.contains("Registration successful")) {
            System.out.println("Registration Test Passed");
        } else {
            System.out.println("Registration Test Failed");
        }
    }
}
