package com.myfirstproject;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_RadioButton {
    WebDriver driver;
    @Before
    public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://www.facebook.com/");
    }
    @Test
    public void radio() throws InterruptedException {
        Faker faker  = new Faker();

//        Complete the following task.
//        Go to https://www.facebook.com/

//        TEST CASE:
//        Click on Create new account
        driver.findElement(By.linkText("Create New Account")).click();
//        Enter first name
        String fName = faker.name().firstName();
        driver.findElement(By.name("firstname")).sendKeys(fName);    // With fake name
//        Enter last name
        String fLastname = faker.name().lastName();
        driver.findElement(By.name("lastname")).sendKeys(fLastname);// With fake lastname
//        Enter mobile number or email
        String fEmail = faker.internet().emailAddress();
        driver.findElement(By.name("reg_email__")).sendKeys(fEmail);// With fake name
        System.out.println("fEmail = " + fEmail);
        Thread.sleep(1000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(fEmail); //mail confirmation
//        Enter new password
        String fPassword = faker.internet().password();
        driver.findElement(By.name("reg_passwd__")).sendKeys(fPassword);// With fake password
        System.out.println("fPassword = " + fPassword);
//        Enter birthday(LATER)
//        10/Jan/2000
        //1.way
        WebElement dayElement = driver.findElement(By.id("day"));
        Select select1 = new Select(dayElement);
        select1.selectByVisibleText("10");
        WebElement monthElement = driver.findElement(By.id("month"));
        Select select2 = new Select(monthElement);
        select2.selectByVisibleText("Jan");
        WebElement yearElement = driver.findElement(By.id("year"));
        Select select3 = new Select(yearElement);
        select3.selectByVisibleText("2000");

        //2.way
//        //        Jan / 10 / 2000
////        1. Locate the dropdown element
//        WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
////        2. Create select object
//        Select selectMonth = new Select(monthElement);
////        3. Select Jan
//        selectMonth.selectByVisibleText("Jan");
////        DAY
//        WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
//        Select selectDay = new Select(dayElement);
//        selectDay.selectByVisibleText("10");
////        YEAR
//        WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
//        Select selectYear = new Select(yearElement);
//        selectYear.selectByVisibleText("2000");

//        Enter gender
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
//        Click Sign Up
        driver.findElement(By.name("websubmit")).click();

    }
}
