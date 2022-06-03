package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_Screenshots extends TestBase {



    @Test
    public void screenshotTest() throws IOException {
        driver.get("https://www.google.com");
//      Create a reusible method
        takeScreenShot();

//      Locating input, typing tesla cybertruck and clicking enter
        driver.findElement(By.name("q")).sendKeys("tesla cyber truck" + Keys.ENTER);
        takeScreenShot();
    }

    /*
    *How to do capture screenshot in your automation framework? / How do you get screenshot in selenium?
    * I use getScreenshot as method to capture the screenshot.
    * Actually we have a reusable methods to capture the screenshot
     */


}
