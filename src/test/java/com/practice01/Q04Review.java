package com.practice01;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Q04Review {
// Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculate under Micro Apps
// Type any number in the first input
// Type any number in the second input
// Click on Calculate
// Get the result
// Assert the result
WebDriver driver;
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
}
@Test
    public void test(){
    driver.manage().window().maximize();
    driver.get("https://testpages.herokuapp.com/styled/index.html");
    driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
    driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("100");
    driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("50");
    driver.findElement(By.xpath("//input[@id='calculate']")).click();
    String result = driver.findElement(By.xpath("//span[@id='answer']")).getText();
    Assert.assertEquals("150",result);
}
@After
    public void tearDown(){
    driver.quit();
}
}

