package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchByID extends BaseClass{
    @Test
    /*
    * Here first you need to run the test.html in live server
    * */
    public void getDataByID(){
        driver.get("http://127.0.0.1:5500/test.html");
        WebElement elementById = driver.findElement(By.id("uniqueParagraph"));

        System.out.println("the data by id : " + elementById.getText());

    }
}
