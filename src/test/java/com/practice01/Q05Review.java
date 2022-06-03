package com.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class Q05Review {
    // go to http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button given number of times,
    // and then validates that given number of buttons was deleted

//   1.method : createButtons()
//   2.method : deleteButtonsAndValidate()
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(driver,100);
        deleteButtonsAndValidate(driver,80);
    }
    public void createButtons(WebDriver driver, int number){
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i=0; i<number; i++){
            addButton.click();
        }
    }
    public void deleteButtonsAndValidate(WebDriver driver,int deleteNumber){
        WebElement delBut = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        List<WebElement> beforeDeleteButtons = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int delButNum = beforeDeleteButtons.size();
        int counter = 0;
        for (WebElement w : beforeDeleteButtons) {
            counter++;
            if (counter>deleteNumber){
                break;
            }
            w.click();
        }
        List<WebElement> afterDeleteButtons = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int afterDeleteButtonsSize = afterDeleteButtons.size();
        Assert.assertEquals(delButNum-deleteNumber,afterDeleteButtonsSize);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
