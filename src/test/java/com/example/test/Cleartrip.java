package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

import static java.lang.System.exit;

public class Cleartrip extends BaseClass {

    public static void main(String[] args) {
        Cleartrip cleartrip = new Cleartrip();
        cleartrip.setUp(); // Setup WebDriver

        try {
            cleartrip.Flow1();
            cleartrip.otpp();
        } finally {
            cleartrip.tearDown(); // Close WebDriver
        }
    }

    public void Flow1() {
        Scanner input = new Scanner(System.in);
        driver.get("https://www.cleartrip.com/flights?utm_source=google&utm_medium=cpc&utm_campaign=BR_Cleartrip-Desktab&dxid=EAIaIQobChMIqqHEopychwMVbjiDAx1D0gutEAAYASAAEgKsZvD_BwE&gad_source=1&gclid=EAIaIQobChMIqqHEopychwMVbjiDAx1D0gutEAAYASAAEgKsZvD_BwE");

        // Find and fill the mobile number input field
        WebElement inputText = driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']"));
        inputText.sendKeys("9791646699");

        // Wait for the Get OTP button to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement inputOTP = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//span[text()='Get OTP']")));
        inputOTP.click();



        // Add any further actions after entering the OTP if needed
    }

    private void exit() {
    }

    public void otpp(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the OTP: ");
        String verifyOTP = input.nextLine();

        // Ensure OTP input is received
        if (verifyOTP.isEmpty()) {
            System.out.println("No OTP entered. Exiting.");
            return;
        }

        // Split the OTP into individual characters
        char[] otpChars = verifyOTP.toCharArray();

        // Find the OTP input fields and fill them using positional XPath
        for (int i = 0; i < otpChars.length; i++) {
            WebElement otpInput = driver.findElement(By.xpath("(//input[@type='text' and @style])[" + (i + 1) + "]"));
            otpInput.sendKeys(String.valueOf(otpChars[i]));
        }
    }
}
