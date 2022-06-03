package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day12_JSExecutor extends TestBase {
    @Test
    public void jsExecutorTest() throws InterruptedException {
//      Go to url "https://www.carettahotel.com/"
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(1000);

//        1.Creating js executor object
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        2.Use js executor object to add your action

//      Scroll down to our rooms title
//                                                      //tag[@attribute='value']
//                                                      * == all, .='TEXT ON THE PAGE'
        WebElement ourRooms = driver.findElement(By.xpath("//*[.='Our Rooms']"));
        js.executeScript("arguments[0].scrollIntoView(true)",ourRooms);
        Thread.sleep(2000);

//      Scroll down to deep of page
        WebElement email = driver.findElement(By.xpath("//span[.='info@carettahotel.com']"));
        js.executeScript("arguments[0].scrollIntoView(true)",email);
        Thread.sleep(2000);

//      Scroll up to top of page
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true)",submit);
    }








}