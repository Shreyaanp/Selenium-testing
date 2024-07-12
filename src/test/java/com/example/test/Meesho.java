package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Meesho extends BaseClass{
    @Test
    public void register() {
        driver.get("https://www.opencart.com/index.php?route=account/register");
        driver.manage().window().maximize();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement userName = driver.findElement(By.xpath("//*[@id='input-username']"));
        userName.sendKeys("pshreyaan");
        WebElement fName = driver.findElement(By.xpath("//*[@id='input-firstname']"));
        fName.sendKeys("shreyaan");
        WebElement lName = driver.findElement(By.xpath("//*[@id='input-lastname']"));
        lName.sendKeys("pradhan");
        WebElement eMail = driver.findElement(By.xpath("//*[@id='input-email']"));
        eMail.sendKeys("shreyaan.work@gmail.com");
        WebElement country = driver.findElement(By.xpath("//*[@id='input-country']"));
        country.click();
        country.sendKeys(Keys.ARROW_DOWN);
        country.sendKeys(Keys.RETURN);

        WebElement password = driver.findElement(By.xpath("//*[@id='input-password']"));
        password.sendKeys("Testing@Selemium123");
        
        WebElement Submit = driver.findElement(By.xpath("//*[@id='button-register']/button[2]"));
        Submit.click();
        WebElement check = driver.findElement(By.xpath("//*[@id='register']/div/div[1]/h3"));

//        if(check.equals("Welcome to OpenCart, your account has been created")){
//            System.out.println("Success");
//
//        }
//        else {
//            System.out.println("Failed");
//        }
        
    }
    
}
