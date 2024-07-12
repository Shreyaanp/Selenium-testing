package com.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;

public class BrowserActions extends BaseClass {

    @Test
    public void takeScreenshot() throws IOException {
        driver.get("https://www.google.com/");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        Files.copy(srcFile.toPath(), Paths.get("./screenshot.png"));
        System.out.println("Screenshot taken and saved as screenshot.png");
    }

    @Test
    public void scrollTillElement() {
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.id("someElementId"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolled to the element with id 'someElementId'.");
    }

    @Test
    public void handlePopup() {
        driver.get("https://www.google.com/");
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com/');");
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to popup window.");
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Switched back to the main window.");
    }

    @Test
    public void handleAlert() {
        driver.get("https://www.google.com/");
        ((JavascriptExecutor) driver).executeScript("alert('Test Alert');");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        System.out.println("Alert accepted.");
    }

    @Test
    public void handleWindows() {
        driver.get("https://www.google.com/");
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com/', '_blank');");
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window.");
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Switched back to the main window.");
    }

    @Test
    public void handleFrames() {
        driver.get("https://www.google.com/");
        driver.switchTo().frame("frameName");
        WebElement frameElement = driver.findElement(By.id("frameElementId"));
        System.out.println("Interacted with the element inside the frame.");
        driver.switchTo().defaultContent();
        System.out.println("Switched back to the main content.");
    }

    @Test
    public void performMouseActions() {
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.id("elementId"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        System.out.println("Performed mouse actions on the element.");
    }

    @Test
    public void performKeyboardActions() {
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox).click().sendKeys("Selenium WebDriver").sendKeys(Keys.RETURN).perform();
        System.out.println("Performed keyboard actions on the search box.");
    }
}
