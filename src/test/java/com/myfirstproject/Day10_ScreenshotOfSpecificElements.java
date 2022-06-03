package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Day10_ScreenshotOfSpecificElements extends TestBase {
    @Test
    public void screenshotTest() throws IOException {
        driver.get("https://www.google.com");
        WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        File logoImage = googleLogo.getScreenshotAs(OutputType.FILE);

//        Saving the image to  the path
//        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File finalPath = new File("./test-output/elements/googleLogo.png");
        FileUtils.copyFile(logoImage,finalPath);
//        getting screenshot of sign in element
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='gb_1 gb_2 gb_7d gb_7c']"));
        File signInImage = signInButton.getScreenshotAs(OutputType.FILE);
        File signInPath = new File("./test-output/elements/signIn.png");
        FileUtils.copyFile(signInImage,signInPath);

    }

}
