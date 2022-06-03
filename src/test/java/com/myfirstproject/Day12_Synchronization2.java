package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day12_Synchronization2 extends TestBase {
//Create a class:Synchronization2.
//Create a method: synchronization2
//Go to https://the-internet.herokuapp.com/dynamic_loading/2
//When user clicks on the Start button
//Then verify the ‘Hello World!’ Shows up on the screen

    @Test
    public void synchronization2(){
//Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

//When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

//Then verify the ‘Hello World!’ Shows up on the screen  (With explicit wait)
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9));
        String helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4"))).getText();
        Assert.assertEquals("Hello World!",helloWorldText);
    }

}
