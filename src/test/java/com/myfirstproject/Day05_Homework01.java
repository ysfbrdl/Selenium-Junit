package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class Day05_Homework01 {
    /*
Create A Class: AmazonDropdown
Create A Method dropdownTest
Go to https://www.amazon.com/
Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
Print the first selected option and assert if it equals “All Departments”.
If it fails, then comment that code out and continue rest of the test case.
Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
Print the the total number of options in the dropdown
Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
BONUS: Assert if the dropdown is in Alphabetical Order
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
        dropdownTest();
    }

    public void dropdownTest() throws InterruptedException {
//  Go to https://www.amazon.com/
        driver.get("https://www.amazon.com");

//  Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdownBox = driver.findElement(By.id("searchDropdownBox"));
        dropdownBox.click();
        Select select = new Select(dropdownBox);

//  Print the first selected option and assert if it equals “All Departments”.
        WebElement firstElement = select.getFirstSelectedOption();
        System.out.println("firstElement = " + firstElement.getText());
        Assert.assertEquals("All Departments",firstElement.getText());

//  Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
//  (after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        Thread.sleep(1000);
        select.selectByIndex(3);
        Thread.sleep(1000);
        String fourthElement = select.getFirstSelectedOption().getText();
        System.out.println("fourthElement = " + fourthElement);
//        Assert.assertEquals("Amazon Devices",fourthElement);

//  Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions) {
            System.out.println(w.getText());
        }
//  Print the total number of options in the dropdown
        System.out.println("Number of dropdown elements : " + allOptions.size());

//   Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        //Assert.assertTrue(allOptions.contains("Appliances"));
        if (allOptions.contains("Appliances")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

//  BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> unsortedList = new ArrayList<>();
        allOptions.stream().forEach(t->unsortedList.add(t.getText()));

        List<String> sortedList = new ArrayList<>(unsortedList);
        sortedList.sort(Comparator.naturalOrder());

        Assert.assertEquals("Dropdown is not in alphabetical order", unsortedList,sortedList);
        }

    @After
    public void tearDown(){
        driver.quit();
    }
}
