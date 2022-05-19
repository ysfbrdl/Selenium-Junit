package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        //We should install and set the drivers and their paths
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe"); // You should update driver a couple of mounth later
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

}
