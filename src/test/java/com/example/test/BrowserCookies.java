package com.example.test;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserCookies extends BaseClass {

    @Test
    public void addBrowserCookies() {
        driver.get("https://www.google.com/");

        // Create Cookie
        Cookie cookie = new Cookie("CookieName", "CookieValue");

        // Add Cookie to the Current Domain
        driver.manage().addCookie(cookie);

        // Verify the cookie has been added
        Cookie retrievedCookie = driver.manage().getCookieNamed("CookieName");
        System.out.println("Cookie added: " + retrievedCookie);
    }

    @Test
    public void deleteBrowserCookies() {
        driver.get("https://www.google.com/");

        // Create Cookie (for deletion test)
        Cookie cookie = new Cookie("CookieName", "CookieValue");
        driver.manage().addCookie(cookie);

        // Delete the cookie by name
        driver.manage().deleteCookieNamed("CookieName");

        // Verify the cookie has been deleted
        Cookie retrievedCookie = driver.manage().getCookieNamed("CookieName");
        System.out.println("Cookie deleted: " + (retrievedCookie == null));
    }

    @Test
    public void addingBrowserCookiesBulk() {
        driver.get("https://www.google.com/");

        driver.manage().addCookie(new Cookie("Cookie1", "Cookie1 Value"));
        driver.manage().addCookie(new Cookie("Cookie2", "Cookie2 Value"));

        Cookie retrieve1 = driver.manage().getCookieNamed("Cookie1");
        Cookie retrieve2 = driver.manage().getCookieNamed("Cookie2");

        String message = (retrieve1 != null && retrieve1.getName().equals("Cookie1") &&
                retrieve2 != null && retrieve2.getName().equals("Cookie2"))
                ? "Cookies added successfully"
                : "Error in adding cookies";

        System.out.println(message);
    }

    @Test
    public void addBrowserCookiesWithPathAndExpiry() {
        driver.get("https://www.google.com/");

        /*
         * 5 days from Now :
         * Date expiryDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(5));
         *
         * 2 Weeks from Now :
         * Date expiryDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(14));
         *
         * 1 Month from Now :
         * Date expiryDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30));
         *
         * 1 hour from Now :
         * Date expiryDate = new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1));
         *
         * 1 Minute from Now :
         * Date expiryDate = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1));
         *
         * 30 Seconds from Now :
         * Date expiryDate = new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(30));
         *
         * */
        // for 5 minutes
        Date expiryDate = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));

        Cookie cookie = new Cookie.Builder(
                "CookieName",
                "CookieValue"
        )
                .path("/")
                .expiresOn(expiryDate)
                .build();

        // Add the cookie to the current domain
        driver.manage().addCookie(cookie);

        Cookie retrieve = driver.manage().getCookieNamed("CookieName");
        System.out.println("CookieName data: " + retrieve);

        /*
         * Get all the cookies
         * Set<Cookie> allCookies = driver.manage().getCookies();
         * System.out.println("All Cookies:");
         * for (Cookie c : allCookies) {
         *     System.out.println("name -" + c);
         * }
         * */
    }

    @Test
    public void modifyBrowserCookie() {
        driver.get("https://www.google.com/");

        driver.manage().addCookie(new Cookie("TestCookie", "Cookies Value"));
        System.out.println("Cookie: " + driver.manage().getCookieNamed("TestCookie"));

        // Modifying the cookie from Cookies Value to New cookie value
        Cookie updatedCookie = new Cookie("TestCookie", "New Cookie value");
        driver.manage().addCookie(updatedCookie); // Add the updated cookie back
        System.out.println("New Cookie: " + driver.manage().getCookieNamed("TestCookie"));

        // New test
        driver.manage().addCookie(new Cookie("testCookie", "test 123"));

        // Delete a specific cookie
        driver.manage().deleteCookieNamed("testCookie");
        System.out.println("Cookie deleted: " + (driver.manage().getCookieNamed("testCookie") == null));

        // Add multiple cookies
        driver.manage().addCookie(new Cookie("cookie1", "value1"));
        driver.manage().addCookie(new Cookie("cookie2", "value2"));

        // Delete all cookies
        driver.manage().deleteAllCookies();
        System.out.println("All cookies deleted: " + driver.manage().getCookies().isEmpty());
    }
}
