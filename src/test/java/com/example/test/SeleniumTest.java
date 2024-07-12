package com.example.test;

import org.testng.annotations.Test;

public class SeleniumTest extends BaseClass {

    @Test
    public void getTitle() {
        // Open the Google homepage
        driver.get("https://www.google.com");

        // Print the title of the page
        System.out.println("Title: " + driver.getTitle());
    }
}
