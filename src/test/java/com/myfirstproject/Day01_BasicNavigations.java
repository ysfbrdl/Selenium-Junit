package com.myfirstproject;

import org.openqa.selenium.WebDriver;             //These are coming from dependencies
import org.openqa.selenium.chrome.ChromeDriver;   //These are coming from dependencies

public class Day01_BasicNavigations {
    /*
Create a new class under : BasicNavigations
Create main method
Set Path
Create chrome driver
Maximize the window
Open google home page https://www.google.com/.
On the same class, Navigate to amazon home page https://www.amazon.com/
Navigate back to google
Navigate forward to amazon
Refresh the page
Close/Quit the browser
     */
    public static void main(String[] args) {
        //Set Path
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        //Create chrome driver
        WebDriver driver = new ChromeDriver(); //these drivers come from selenium library

        //Maximize the window
        driver.manage().window().maximize();

        //Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        //On the same class, Navigate to amazon home page https://www.amazon.com/
        //1.way
        //driver.get("https://www.amazon.com/");
        //2.way
        driver.navigate().to("https://www.amazon.com/");
        //What is the difference between get and navigate?
        //get() is easier to use. it is shorter
        //get() is a little faster
        //get() takes only String parameter
        //navigate().to() accept String or URL as parameter
        //navigate() has more options: ex. go back, refresh, forward

        //Navigate back to google
        driver.navigate().back();

        //Navigate forward to amazon
        driver.navigate().forward();

        //Refresh the page
        driver.navigate().refresh();

        //Close/Quit the browser
        //1.way
        //driver.close();
        //2.way
        driver.quit();//stronger
        //What is the difference between close and quit?
        //First both closes the driver(browser).
        //close() --> closes ONLY the current active driver
        //quit()  --> closes ALL browsers that is open during that test run



    }
}
