package com.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.*;

public class Q04 {
// ...Exercise4...
// Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculate under Micro Apps
// Type any number in the first input
// Type any number in the second input
// Click on Calculate
// Get the result
// Print the result
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
// Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
// Type any number in the first input
        WebElement firstBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        firstBox.sendKeys("20");
// Type any number in the second input
        WebElement secondBox = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        secondBox.sendKeys("35");
// Click on Calculate
        driver.findElement(By.xpath("//input[@id='calculate']")).click();
// Verify the result
        String answer = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        assertEquals("55",answer);
        Thread.sleep(5000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }




}
