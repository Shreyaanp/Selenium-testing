package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppWebTest extends BaseClass{

    @Test
    public void testShowAlert(){
        driver.get("http://127.0.0.1:5500/app.html");

        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();

        driver.switchTo().alert().accept();

        Assert.assertTrue(true,"Alert handled successfully");
    }
/*t
* This function is used to click a button.
* */
    @Test
    public void testChangetext(){
        driver.get("http://127.0.1:5500/app.html");

        WebElement clickToChange = driver.findElement(By.xpath("//button[text()='Change Text']"));

        clickToChange.click();

        //check if the button has been changed

        WebElement textElement = driver.findElement(By.id("changeText"));

        String Expected = "Text Changed!";

        if (textElement.getText().equals(Expected)){
            System.out.println("The Text is changed to  : Text Changed from This text will change");
        }
        else {
            System.out.println("There is an error, no text has been changed");
        }
    }

    @Test
    public void testEmptyFields(){
        driver.get("http://127.0.0.1:5500/app.html");

        // This is to check if the input is proper ?
        WebElement checkProperInput = driver.findElement(By.xpath("//button[text()='Submit']"));

        checkProperInput.click();
    }

//    @Test
//    public void testSingleFields(){
//
//        driver.get("http://127.0.0.1:5500/app.html");
//
//
//    }
}
