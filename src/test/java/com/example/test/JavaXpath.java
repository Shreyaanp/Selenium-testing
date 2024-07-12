package com.example.test;

import org.testng.annotations.Test;

public class JavaXpath extends BaseClass{

    @Test
    public void Test() {

        /**
         * XPath in Selenium
         *
         * XPath Types:
         * 1. Absolute XPath:
         *    - Starts from the root node and goes down to the desired element.
         *    - Syntax: /html/body/div[1]/div[2]/div/div[1]/a
         *    - Example: /html/body/div/div[2]/div/a
         *
         * 2. Relative XPath:
         *    - Starts from any node and goes down to the desired element.
         *    - Syntax: //tagname[@attribute='value']
         *    - Example: //a[@id='link']
         *
         * XPath Keywords:
         * 1. `.` (dot): Current node.
         *    - Example: .
         *
         * 2. `/`: Immediate child node.
         *    - Example: /div/span
         *
         * 3. `//`: Any descendant node.
         *    - Example: //span
         *
         * 4. `/..`: Parent node.
         *    - Example: //span/..
         *
         * 5. `@`: Attribute.
         *    - Example: //input[@id='username']
         *
         * 6. `*`: Any value or node.
         *    - Example: //div/*

         * XPath Functions:
         * 1. text()
         *    - Matches elements based on their text content.
         *    - Syntax: //tagname[text()='text']
         *    - Example: //button[text()='Submit']
         *
         * 2. starts-with()
         *    - Matches elements whose attribute values start with a specified substring.
         *    - Syntax: //tagname[starts-with(@attribute, 'substring')]
         *    - Example: //input[starts-with(@id, 'user')]
         *
         * 3. contains()
         *    - Matches elements whose attribute values or text content contain a specified substring.
         *    - Syntax: //tagname[contains(@attribute, 'substring')]
         *    - Example: //input[contains(@id, 'name')]
         *    - Syntax for text: //tagname[contains(text(), 'substring')]
         *    - Example for text: //div[contains(text(), 'Partial Text')]
         *
         * 4. position()
         *    - Matches elements based on their position in a list of sibling elements.
         *    - Syntax: //tagname[position()=index]
         *    - Example: //ul/li[position()=2]
         *
         * 5. last()
         *    - Matches the last element in a list of sibling elements.
         *    - Syntax: //tagname[last()]
         *    - Example: //ul/li[last()]
         *
         * Examples and Use Cases:
         *
         * 1. Absolute XPath Example:
         *    WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div/a"));
         *
         * 2. Relative XPath Example:
         *    WebElement element = driver.findElement(By.xpath("//a[@id='link']"));
         *
         * 3. Using Text Example:
         *    WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
         *
         * 4. Using Contains Example (Attribute):
         *    WebElement usernameField = driver.findElement(By.xpath("//input[contains(@id, 'name')]"));
         *
         * 5. Using Contains Example (Text):
         *    WebElement message = driver.findElement(By.xpath("//div[contains(text(), 'Success')]"));
         *
         * 6. Using Starts-with Example:
         *    WebElement usernameField = driver.findElement(By.xpath("//input[starts-with(@id, 'user')]"));
         *
         * 7. Using Position Example:
         *    WebElement secondItem = driver.findElement(By.xpath("//ul/li[position()=2]"));
         *
         * 8. Using Last Example:
         *    WebElement lastItem = driver.findElement(By.xpath("//ul/li[last()]"));
         *
         * 9. Using Attributes Example:
         *    WebElement inputField = driver.findElement(By.xpath("//input[@id='username']"));
         *
         * Combination Example:
         * - Locate the second span element within a div that contains the class "item":
         *   WebElement element = driver.findElement(By.xpath("//div/span[contains(@class, 'item') and position()=2]"));
         *
         * Notes:
         * - Absolute XPath is not recommended as it is prone to break if the structure of the webpage changes.
         * - Relative XPath is more robust and flexible.
         * - Using functions like text(), contains(), starts-with(), position(), and last() allows for more dynamic and reliable XPath expressions.
         * - Always prefer using attributes and relative paths to make the locators more stable.
         * - Combine multiple XPath functions and axes to create precise and resilient locators.
         */


    }

}
