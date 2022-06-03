package com.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q02 extends TestBase {

// 1. Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
// 2. Click "CLICK ME" of JavaScript Alert
// 3. Get the pop-up text
// 4. Verify that message is "I am an alert box!"
// 5. Accept pop up


    @Test
    public void alertTest() throws InterruptedException {
// 1. Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        Thread.sleep(2000);
// 2. Click "CLICK ME" of JavaScript Alert
        driver.findElement(By.xpath("//span[@id='button1']//p")).click();
        Thread.sleep(2000);
// 3. Get the pop-up text
        String alertText = driver.switchTo().alert().getText();
// 4. Verify that message is "I am an alert box!"
        Assert.assertEquals("I am an alert box!",alertText);
        Thread.sleep(2000);
// 5. Accept pop up
        driver.switchTo().alert().accept();

    }
}
