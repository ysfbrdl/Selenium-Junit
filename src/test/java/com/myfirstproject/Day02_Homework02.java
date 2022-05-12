package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_Homework02 {
    /*
Create a new class : Homework1 or (Day02_Homework02)
Using ChromeDriver, Go to facebook and verify if page title is “facebook”, If not, print the correct title.
Verify if the page URL contains facebook  if not, print the right url.
Then Navigate to https://www.walmart.com/
Verify if the walmart page title includes “Walmart.com”
Navigate back to facebook
Refresh the page
Maximize the window
Close the browser
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Using ChromeDriver, Go to facebook and verify if page title is “facebook”, If not, print the correct title.
        driver.navigate().to("https://www.facebook.com");
        String actualFacebookPageTitle = driver.getTitle();
        String expectedFacebookPageTitle = "facebook";
        if(actualFacebookPageTitle.equals(expectedFacebookPageTitle)){
            System.out.println("PASSED From Facebook page title test");
        }else{
            System.out.println("FAILED From Facebook page title test");
            System.out.println("Correct Facebook page title is : " + actualFacebookPageTitle);
            System.out.println("--------------------------------------------");
        }

        //Verify if the page URL contains facebook  if not, print the right url.
        String actualFacebookUrl = driver.getCurrentUrl();
        if(actualFacebookUrl.contains("facebook")){
            System.out.println("PASSED From Facebook Url test");
        }else{
            System.out.println("FAILED From Facebook Url test");
            System.out.println("Correct Facebook Url is : " + actualFacebookUrl);
            System.out.println("--------------------------------------------");
        }

        //Then Navigate to https://www.walmart.com/
        driver.navigate().to("https://www.walmart.com/");

        //Verify if the walmart page title includes “Walmart.com”
        String actualWalmartPageTitle = driver.getTitle();
        if(actualWalmartPageTitle.contains("Walmart.com")){
            System.out.println("PASSED From Walmart Page Title Test");
        }else{
            System.out.println("FAILED Walmart Page Title Test");
            System.out.println("Correct Walmart Page Title is : " + actualFacebookUrl);
            System.out.println("--------------------------------------------");
        }

        //Navigate back to facebook
        driver.navigate().back();

        //Refresh the page
        driver.navigate().refresh();

        //Maximize the window
        driver.manage().window().maximize();

        //Close the browser
        driver.quit();
    }
}
