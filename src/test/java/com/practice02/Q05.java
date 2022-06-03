package com.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q05 extends TestBase {
//Signup For Facebook by using Actions class
//Go to Facebook
//Click on Create New Account
//fill all the boxes by using keyboard actions

    @Test
    public void signUpFacebook() {
//Go to Facebook
        driver.get("https://www.facebook.com");
//Click on Create New Account
        driver.findElement(By.linkText("Create New Account")).click();
//fill all the boxes by using keyboard actions
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
        actions.click(nameBox)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("alican") //password
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("25")
                .sendKeys(Keys.TAB)
                .sendKeys("Apr")
                .sendKeys(Keys.TAB)
                .sendKeys("1982")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
