package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions3 extends TestBase {
    /*
     * We may need to scroll the pages
     * When the page is long or element is not displayed properly because element is at the bottom of the page
     * Then we have to scroll the page
     * With Action class, we can scroll down, up, left, right
     */
    @Test
    public void scrollUpdown () throws InterruptedException {

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        //1.To scroll pages, we can use Actions class or Javascript Executor
        Actions actions = new Actions(driver);
        //2.Use actions scroll the page
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

//      ARROW DOWN
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);

//      SCROLLING UP
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);

//      ARROW UP : scrolling a little bit
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);
    }

}