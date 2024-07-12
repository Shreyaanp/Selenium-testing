package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class GeneralDataExtraction extends BaseClass {

    @Test
    public void generalDataExtraction() {
        // Open the local HTML file
        driver.get("http://127.0.0.1:5500/test.html");

        // Locate element by ID and print its text content
        WebElement elementById = driver.findElement(By.id("uniqueParagraph"));
        System.out.println("Element by ID: " + elementById.getText());

        // Locate element by Name and print its text content
        WebElement elementByName = driver.findElement(By.name("namedParagraph"));
        System.out.println("Element by Name: " + elementByName.getText());

        // Locate element by Class Name and print its text content
        WebElement elementByClassName = driver.findElement(By.className("commonClass"));
        System.out.println("Element by Class Name: " + elementByClassName.getText());

        // Locate element by Tag Name and print its text content
        WebElement elementByTagName = driver.findElement(By.tagName("button"));
        System.out.println("Element by Tag Name: " + elementByTagName.getText());

        // Locate element by Link Text and print its text content
        WebElement elementByLinkText = driver.findElement(By.linkText("Unique Example Link"));
        System.out.println("Element by Link Text: " + elementByLinkText.getText());

        // Locate element by Partial Link Text and print its text content
        WebElement elementByPartialLinkText = driver.findElement(By.partialLinkText("Partial Example Link"));
        System.out.println("Element by Partial Link Text: " + elementByPartialLinkText.getText());

        // Locate element by CSS Selector and print its text content
        WebElement elementByCssSelector = driver.findElement(By.cssSelector(".container #nestedLink"));
        System.out.println("Element by CSS Selector: " + elementByCssSelector.getText());

        // Locate element by XPath and print its text content
        WebElement elementByXPath = driver.findElement(By.xpath("//div[@id='containerDiv']//p"));
        System.out.println("Element by XPath: " + elementByXPath.getText());

        // Locate input field by ID, enter text, and print its value
        WebElement textInput = driver.findElement(By.id("textInput"));
        textInput.sendKeys("Test input");
        System.out.println("Text Input value: " + textInput.getAttribute("value"));

        // Locate select field by ID, select an option, and print the selected option
        WebElement selectInput = driver.findElement(By.id("selectInput"));
        selectInput.findElement(By.xpath("//option[@value='option2']")).click();
        WebElement selectedOption = selectInput.findElement(By.xpath("//option[@value='option2']"));
        System.out.println("Selected Option: " + selectedOption.getText());

        // Locate all list items by Class Name and print their text content
        List<WebElement> listItems = driver.findElements(By.className("listItem"));
        for (WebElement listItem : listItems) {
            System.out.println("List Item: " + listItem.getText());
        }
    }
}
