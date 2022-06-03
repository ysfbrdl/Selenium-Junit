package com.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q03 extends TestBase {
// go to amazon homepage
// hover mouse over the hello,signIn element at the top right
// Click on the Create a List link in the menu that opens
// and verify that title is equal to "Your List"


    @Test
    public void amazonTest() {
// go to amazon homepage
        driver.get("https://www.amazon.com/");
// hover mouse over the hello,signIn element at the top right
        Actions actions = new Actions(driver);
        WebElement helloElement = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(helloElement).perform();
        // Click on the Create list link in the menu that opens
        WebElement listElement = driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(listElement).perform();
        // and verify that title is equal to "Your List"
        Assert.assertEquals("Your List",driver.getTitle());

    }
}
