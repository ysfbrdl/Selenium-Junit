package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day03_Locators {
    /*
    * How many locators are there in selenium?
    * 8
    * What are they?
    * id, name, className, tagName, linkText, partialLinkText, xpath, css
    * What is findElement() method?
    * To locate the elements. Return type is WebElement
    * Which locator do you prefer?
     * I prefer id, cause id is unique, easy to locate, and a little faster that xpath or css
     * If there is no id, then i use other unique elements such as name, class,...
     * If no appropriate locator is there, then I write dynamic xpath
     */

    @Test
    public void locators(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//Create a class : Locators
//Create test method locators
//user goes to
        driver.get("http://a.testaddressbook.com/sign_in");

//Locate the elements of email textbox, password textbox, and signin button
//Enter below username and password then click sign in button
//Username :  testtechproed@gmail.com
//Password : Test1234!

        //Email
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");

        //Password
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");

        //Click on sign in button
        driver.findElement(By.name("commit")).click();                   //1.way
        //        ALTERNATIVELY we can first locate the element then click
        WebElement signInButton = driver.findElement(By.name("commit")); //2.way
        signInButton.click();                                            //2.way


//Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
//Verify the Addresses and Sign Out  texts are displayed
//Find the number of total link on the page
//Sign out from the page




    }
}
