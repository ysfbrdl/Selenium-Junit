package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations_Review {
     /*
Create a new class under : BasicNavigations
Create main method
Set Path
Create chrome driver
Maximize the window
Open google home page https://www.google.com/
On the same class, Navigate to amazon home page https://www.amazon.com/
Navigate back to google
Navigate forward to amazon
Refresh the page
Close/Quit the browser
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().minimize();
        driver.navigate().back();
        driver.manage().window().maximize();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();






    }



}
