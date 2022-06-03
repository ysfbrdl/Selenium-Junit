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

import java.time.Duration;
import java.util.List;

public class Q05 {


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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButton(driver,100);
        deleteButtonsAndValidate(driver,80);
    }

//   1.method : createButtons()
    public void createButton (WebDriver driver, int number){
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i=1; i<=number; i++){
            addButton.click();
        }
    }

//   2.method : deleteButtonsAndValidate()
    public void deleteButtonsAndValidate(WebDriver driver, int numOfDelete){
        List<WebElement> elementBefore = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeBeforeDelete = elementBefore.size();//    100

        int counter = 0;
        for (WebElement w : elementBefore){
            counter++;
            if(counter>numOfDelete){
                break;
            }
            w.click();
        }

        List<WebElement> elementAfter = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeAfterDelete = elementAfter.size();

        Assert.assertEquals(sizeBeforeDelete-numOfDelete,sizeAfterDelete);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
