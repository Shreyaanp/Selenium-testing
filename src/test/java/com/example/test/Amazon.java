package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Amazon extends BaseClass{
    @Test
    public void signIn(){
        driver.get("https://www.amazon.in/");

//        WebElement SignIn =  driver.findElement(By.id("nav-link-accountList"));
//        SignIn.click();
//
//        WebElement Email_Mobile = driver.findElement(By.id("ap_email_login"));
//
//        Email_Mobile.sendKeys("9791646699");
//
//        WebElement sendotp = driver.findElement(By.className("a-button-input"));
//
//        sendotp.click();
        WebElement ClickButton = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[1]/div[1]/a"));

        ClickButton.click();


    }
}
