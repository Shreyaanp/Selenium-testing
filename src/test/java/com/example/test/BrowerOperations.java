package com.example.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

public class BrowerOperations extends BaseClass{

    @Test
    public void BrowserOperation(){
        // Launch browser and open a URL
        driver.get("https://www.google.com/");
        System.out.println("Browser launched and navigated to Google.");

        //Maximise the window
        driver.manage().window().maximize();
        System.out.println("The browser was turned to maximum size");

        //Minimise the window
        driver.manage().window().minimize();
        System.out.println("The browser was minimized");

        //Get the current size of the window
        /*
        * Here we have used dimension as a constructor
        * creates an object Dimension with the property (int width, int height)
        * Dimension size = driver.manage().window().getSize();
        * returns size.getWidth(), size.getHeight()
        * */
        Dimension size = driver.manage().window().getSize();
        System.out.println("The size of the window: " + size);

        //Set the browser Size to new size
        driver.manage().window().setSize(new Dimension(1024, 768));
        System.out.println("Changes the size of the window");

        /*
        * position.getX(), position.getY()
        * it is used here as it returns coordinate of x and y
        * specifically getX and getY methods;
        * not compactible with Dimension
        * */
        //Get the current position of the webpage
       Point position =  driver.manage().window().getPosition();
       System.out.println("This is the current position of the page" + position);
    }
}
