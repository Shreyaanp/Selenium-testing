package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class Nykaa extends BaseClass{

    @Test
    public void titleVerification() {

        driver.get("https://www.meesho.com/");
        System.out.println("The page Title : "  + driver.getTitle() );
    }


    @Test
    public void Verification() {

        driver.get("https://www.meesho.com/");

        String currentTitle = driver.getCurrentUrl();

        WebElement clickOnWomen = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div[3]/div[5]/span"));

        clickOnWomen.click();

        System.out.println("clicked on the Screen");

        if(!(currentTitle.equals(driver.getCurrentUrl()))){
            System.out.println("Verified working link. title : " +driver.getCurrentUrl() );
        }
        else {
            System.out.println("Error");
        }

    }




}
