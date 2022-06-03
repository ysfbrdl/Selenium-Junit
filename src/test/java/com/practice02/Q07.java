package com.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q07 extends TestBase {
// Navigate to  https://www.saucedemo.com/
// Enter the username  as standard_user
// Enter the password as   secret_sauce
// Click on login button
// Choose price low to high and verify

    @Test
    public void test() throws InterruptedException {
// Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
// Enter the username  as standard_user
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
// Enter the password as   secret_sauce
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
// Click on login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
// Choose price low to high and verify
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dropDown);
        Thread.sleep(2000);
        select.selectByVisibleText("Price (low to high)");

        String expected = "PRICE (LOW TO HIGH)";
        String actual = driver.findElement(By.className("active_option")).getText();
        Assert.assertEquals(expected,actual);

   }
}
