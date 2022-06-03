package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_CheckboxUtil extends TestBase {
    @Test
    public void checkboxTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Thread.sleep(3000);
        selectCheckbox(checkbox1,true);
        Thread.sleep(3000);
        selectCheckbox(checkbox2,true);

//      RESULT : I should see all boxes are checked
    }

}
