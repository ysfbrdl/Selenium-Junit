package com.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q02Review {

// Create chrome driver
// Maximize the window
// Open google home page https://www.google.com/.
// Wait for 3 seconds
// Go to the "https://www.sahibinden.com"
// Get the title and URL of the page
// Check if the title contains the word "auto" print console "Title contains auto" or "Title does not contain auto"
// Check if the URL contains the word "auto" print console "URL contains auto" or "URL does not contain auto"
// Then go to "https://www.gittigidiyor.com"
// Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
// Back to the previous webpage, sahibinden.com
// Refresh the page
// Navigate to gittigidiyor.com
// Wait for 3 seconds
// Close the browser
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.navigate().to("https://www.sahibinden.com");
        String amazonTitle = driver.getTitle();
        String amazonUrl = driver.getCurrentUrl();
        if (amazonTitle.contains("auto")){
            System.out.println("sahibinden Title contains auto");
        }else{
            System.out.println("sahibinden Title does not contain auto");
        }
        if (amazonUrl.contains("auto")){
            System.out.println("sahibinden URL contains auto");
        }else{
            System.out.println("sahibinden URL does not contain auto");
        }
        driver.get("https://www.gittigidiyor.com");
        String gittiGidiyorTitle = driver.getTitle();
        if (gittiGidiyorTitle.contains("site")){
            System.out.println("Title contains site");
        }else{
            System.out.println("Title does not contain site");
        }
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
