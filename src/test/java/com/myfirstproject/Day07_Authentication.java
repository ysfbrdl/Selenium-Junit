package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day07_Authentication extends TestBase {
//    Auth are used for security reason
//    One way to auth is to use below syntax:
//    https://username:password@URL
//    username : admin
//    password : admin
//    url      :  the-internet.herokuapp.com/basic_auth
//    URL FOR AUTH:
//    https://admin:admin@the-internet.herokuapp.com/basic_auth
//            driver.get(“https://admin:admin@the-internet.herokuapp.com/basic_auth”);
//    This will auth the page
    @Test
    public void basicAuthentication(){

//        driver.get("https://USERNAME:PASSWORD@URL");
//        below will type admin for username and password on the link the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//        Verify teh congratulations message
        String message = driver.findElement(By.xpath("//p")).getText();

//        Assertion
        Assert.assertTrue(message.contains("Congratulations"));

    }
}
