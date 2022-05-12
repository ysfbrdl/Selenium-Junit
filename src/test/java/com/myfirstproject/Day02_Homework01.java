package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_Homework01 {
    /*
Create a new class : Review1 or(Day02_Homework01)
Using ChromeDriver, Go to youtube and verify if page title is “youtube”, If not, print the correct title.
Verify if the page URL contains youtube if not, print the right url.
Then Navigate to https://www.amazon.com/
Navigate back to youtube
Refresh the page
Navigate forward to amazon
Maximize the window
Then verify if page title includes “Amazon”, If not, print the correct title.
Verify if the page URL is https://www.amazon.com/, if not print the correct url
Quit the browser
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        //Using ChromeDriver, Go to youtube and verify if page title is “youtube”, If not, print the correct title.
        driver.get("https://www.youtube.com");
        String actualData = driver.getTitle();
        String expectedData = "youtube";

        if (actualData.equals(expectedData)){
            System.out.println("PASSED from Youtube Title Test");
        }else{
            System.out.println("FAILED from Youtube Title Test");
            System.out.println("Correct Title is : " + actualData);
        }

        //Verify if the page URL contains youtube if not, print the right url.
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("youtube")){
            System.out.println("PASSED from URL test");
        }else{
            System.out.println("FAILED from Youtube URL Test");
            System.out.println("Right URL is : " + actualURL);
        }

        //Then Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //Navigate back to youtube
        driver.navigate().back();

        //Refresh the page
        driver.navigate().refresh();

        //Navigate forward to amazon
        driver.navigate().forward();

        //Maximize the window
        driver.manage().window().maximize();

        //Then verify if page title includes “Amazon”, If not, print the correct title.
        String actualTitleOfAmazon = driver.getTitle();
        if (actualTitleOfAmazon.contains("Amazon")){
            System.out.println("PASSED from Amazon Title Test");
        }else{
            System.out.println("FAILED from Amazon Title Test");
            System.out.println("Correct title is : "+ actualTitleOfAmazon);
        }

        //Verify if the page URL is https://www.amazon.com/, if not print the correct url
        String actualAmazonUrl = driver.getCurrentUrl();
        String expectedAmazonUrl = "https://www.amazon.com/";
        if(actualAmazonUrl.equals(expectedAmazonUrl)){
            System.out.println("PASSED from Amazon Url Test");
        }else{
            System.out.println("FAILED from Amazon Url Test");
            System.out.println("Correct Url is : " + actualAmazonUrl);
        }

        //Quit the browser
        Thread.sleep(2000);
        driver.quit();
    }
}
