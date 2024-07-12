package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class BrowserNavigation extends BaseClass {

    @Test
    public void openGoogleHomePage() {
        driver.get("https://www.google.com/");
        System.out.println("Success HomePage");
    }

    @Test
    public void refreshPage() {
        driver.get("https://www.google.com/");
        driver.navigate().refresh();
        System.out.println("Refreshed the page");
    }

    @Test
    public void navigateToDifferentPage() {
        driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com/intl/en-US/gmail/about/");
        System.out.println("Navigated to Gmail" + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("navigated back to  : " + driver.getCurrentUrl());
    }

    @Test
    public void searchAndNavigateBack() {
        driver.get("https://www.google.com/");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Apples" + Keys.RETURN);
        System.out.println("The page title is : " + driver.getCurrentUrl());

        //returning back to the homepage

        driver.navigate().back();
        System.out.println("Back to homepage : " + driver.getCurrentUrl());
    }

    @Test
    public void searchWithAutoSuggest() throws InterruptedException {
        driver.get("https://www.google.com/");
        /*
         * here we can even do this //*[@name = "q"] by path
         * */
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("QA automation");
        Thread.sleep(2000);// cause of exception
        searchBar.sendKeys(Keys.ARROW_DOWN);
        searchBar.sendKeys(Keys.RETURN);
        System.out.println("Performed the search with Auto Suggest" + driver.getCurrentUrl());

    }

    @Test
    public void searchForImages() {
        driver.get("https://www.google.com/");
        WebElement searchbar = driver.findElement(By.name("q"));
        searchbar.sendKeys("Selenium" + Keys.RETURN);

        WebElement clickOnImageLink = driver.findElement(By.id("hdtb-sc"));
        clickOnImageLink.click();

        List<WebElement> imageList = driver.findElements(By.xpath("//*[@jsname='dTDiAc']"));
        System.out.println("the length of output : " + imageList.size());
    }

    @Test
    public void openMultipleTabs() {
        driver.get("https://www.google.com/");
        System.out.println("Google is Opened");

        /*
        * casting driver to Chrome Driver
        * The new tab driver instance is specified as the chrome driver
        * executeScript executes javascript code
        * */
        ((ChromeDriver) driver).executeScript("window.open('https://www.google.com/', '_blank');");
        System.out.println("New tab opened");

        //get all the window handles
        Set<String> windowHandles = driver.getWindowHandles();
        String originalHandle = driver.getWindowHandle();

        String newTabHandle = "";

        for(String h : windowHandles){
            if(!h.equals(originalHandle)){
                newTabHandle = h;
                break;
            }
        }
        driver.switchTo().window(newTabHandle);
        System.out.println("Switched to new window" + driver.getCurrentUrl());





    }

    

}
