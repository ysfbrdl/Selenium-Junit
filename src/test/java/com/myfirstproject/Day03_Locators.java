package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Day03_Locators {
    /*
    * How many locators are there in selenium?
    * 8
    * What are they?
    * id, name, className, tagName, linkText, partialLinkText, xpath, css
    * What is findElement() method?
    * To locate the elements. Return type is WebElement
    * Which locator do you prefer?
     * I prefer id, cause id is unique, easy to locate, and a little faster than xpath or css
     * If there is no id, then I use other unique elements such as name, class,...
     * If no appropriate locator is there, then I write dynamic xpath
     */

    @Test
    public void locators(){
        //    Prerequisites
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//Create a class : Locators
//Create test method locators
//user goes to "http://a.testaddressbook.com/sign_in"
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
        driver.findElement(By.name("commit")).click();                     //1.way
        //        ALTERNATIVELY we can first locate the element then click
//        WebElement signInButton = driver.findElement(By.name("commit")); //2.way
//        signInButton.click();                                            //2.way

//Then verify that the expected user id is testtechproed@gmail.com (USE getText() method to get the text from the page)
        //1.Way
        WebElement idElement = driver.findElement(By.className("navbar-text"));
        System.out.println(idElement.getText());//testtechproed@gmail.com
        String idElementText = idElement.getText();
        assertEquals("testtechproed@gmail.com",idElementText);
        //2.Way   Alternativly but this below code is not so clear. So we should write understandable codes.
        Assert.assertEquals("testtechproed@gmail.com",driver.findElement(By.className("navbar-text")).getText());






//Verify the Addresses and Sign Out  texts are displayed
        //Addresses is a link. So I can use linkText or partialLinkText
        driver.findElement(By.linkText("Addresses"));
        // We can copy and paste link text from webpage to use partialLinkText() method.
        WebElement addresses = driver.findElement(By.partialLinkText("Addresses"));  //same
        Assert.assertTrue(addresses.isDisplayed());  //isDisplayed() is used to verify an element is displayed on the page. It returns
                                                     //true if element is exist, it returns false if element is not exist on the page
//        driver.findElement(By.partialLinkText("Addresse"));   //same
//        driver.findElement(By.partialLinkText("resses"));     //same
//        driver.findElement(By.partialLinkText("Add"));        //same

//and Sign Out  texts are displayed
        WebElement signOut = driver.findElement(By.partialLinkText("Sign out"));
        Assert.assertTrue(signOut.isDisplayed());



//Find the number of total link on the page
   //number of link = number of tag
   List<WebElement> allLinks = driver.findElements(By.tagName("a")); //returns all elements whose tag is "a"
   int numberOfLinks = allLinks.size();
        System.out.println("Number of links : " + numberOfLinks);

//Sign out from the page
        driver.findElement(By.linkText("Sign out")).click();

//**After sign out we must do verification to make sure you sign out successfully
//  if user singed out successfully, it means the url is sign in url : http://a.testaddressbook.com/sign_in
        //1.Way
//        boolean isSignedOut1 = driver.getCurrentUrl().equals("http://a.testaddressbook.com/sign_in");
//        Assert.assertTrue(isSignedOut1);
        //2.way
        boolean isSignedOut2 = driver.getCurrentUrl().contains("sign_in");
        Assert.assertTrue(isSignedOut2);

//       ALTERNATIVELY, we can use a unique element on the sign in page
//        boolean isSignOut1 = driver.findElement(By.name("commit")).isDisplayed();
//        Assert.assertTrue(isSignOut1);


        /*
         * What is the difference between linkText and partialLinkText?
         *
         * Similarities : both accept the full text of a name of link
         * They both should be used only links
         *
         * Differences: linkText looks for EXACT text
         * partialLinkText looks for PART OF A text
         *
         * Note: When using partialLinkText, BE CAREFUL!!!!
         * if there is other partial matches, it returns the first partial link
         * Best practice is use linkText
         * If you use partialLinkText, use enough words
         *
         * When is partialLinkText is use full?
         * - if link text is too long
         * - if there is a space before or after the text



         */









    }
}
