package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day06_Iframe extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {
//        Create a method: iframeTest
//        Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
//        Verify the Bolded text contains “Editor”
        String boldedText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));

//        Locate the text box
   // textBox is INSIDE an iframe. So I have to switch to that iframe
   //3 ways to handle frames: 1. index, 2. id, name 3. Webelement
        //1. INDEX: starts at 0
        //driver.switchTo().frame(0);

        //2. ID or NAME
        //driver.switchTo().frame("mce_0_ifr");

        //3. WEBELEMENT
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        WebElement textBox = driver.findElement(By.xpath("//p"));

//        Delete the text in the text box
        Thread.sleep(2000);
        textBox.clear(); // clear deleted the text from an input
        Thread.sleep(2000);

//        Type “This text box is inside the iframe”
        textBox.sendKeys("This text box is inside the iframe");
        Thread.sleep(2000);
//        Verify the text Elemental Selenium text is displayed on the page
        driver.switchTo().parentFrame(); // get 1 upper level using parentFrame()
        driver.switchTo().defaultContent(); // gets all the way to the root level
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
    }

    /*
    Iframe
What is an iFrame?
Iframe is used to add page, maps, YouTube videos, …
iFrame generates html within html
iFrames are common on webpages, so if your test cases fails, check if the element is inside an iframe
How you handle iFrames?
First I switch to the iFrame then I do automation. If driver is not in the right iframe, then test case fails.
How many ways you can switch to an iFrame?
3 ways:
Index, id/name, web element
How do you understand if the iframe on the page or not?
I inspect the page to see if there is an iFrame element manually. //iframe returns the number of iframe
driver.findElements(By.xpath("//iframe"));
driver.findElements(By.tagName("iframe"));
     */
}
