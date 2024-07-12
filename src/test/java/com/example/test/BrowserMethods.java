package com.example.test;

import org.testng.annotations.Test;

public class BrowserMethods extends BaseClass{

    @Test
    public void browserMethods(){
        driver.get("https://www.google.com/");
        System.out.println("Title of webpage : " + driver.getTitle());
        System.out.println("CurrentUrl of webpage : " + driver.getCurrentUrl());
        System.out.println("Window Handle of webpage : " + driver.getWindowHandle());
//        System.out.println("source of webpage : " + driver.getPageSource());
    }
}
