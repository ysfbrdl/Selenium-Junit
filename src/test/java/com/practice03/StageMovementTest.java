package com.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StageMovementTest extends TestBase {
    @Test
    public void stageMovements() throws InterruptedException {
//      open the Url "http://automationpractice.com/index.php"
        driver.get("http://automationpractice.com/index.php");

//      When a user is on the page
        WebElement image1 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[1]")); // Find the xpath of product
        scrollIntoViewByJS(image1);  //scroll down the page to see product picture

        Actions actions = new Actions(driver);   //To be able to hover over create action object
        actions.moveToElement(image1).perform();  //Hover over the picture of product

//      Click on Add To Cart
        WebElement addToCartButton = driver.findElement(By.xpath("(//span[.='Add to cart'])[1]"));
        addToCartButton.click();

//      And verifies the product is added to the cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[1]"))); //Product successfully added to your shopping cart
        String productText = product.getText();
        Assert.assertEquals("Product successfully added to your shopping cart",productText);

//verify the color, size, quantity, price, shipping, Total Price

        WebElement colorAndSize = driver.findElement(By.id("layer_cart_product_attributes"));  //Orange, S
        Assert.assertEquals("Orange, S",colorAndSize.getText());

        WebElement quantity = driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']"));// Quantity 1
        Assert.assertEquals("1",quantity.getText());

        String price = driver.findElement(By.id("layer_cart_product_price")).getText();  //price is equal to "$16.51
        Assert.assertEquals("$16.51",price);

        WebElement shippingPrice = driver.findElement(By.xpath("//span[@class='ajax_cart_shipping_cost']")); // Shipping is equal to $2.00
        Assert.assertEquals("$2.00",shippingPrice.getText());

        WebElement totalPrice = driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']"));//  total price is equal to "$18.51"
        Assert.assertEquals("$18.51",totalPrice.getText());

//      Click on Proceed to checkout
        WebElement proceedToCheckoutButton = driver.findElement(By.linkText("Proceed to checkout"));
        proceedToCheckoutButton.click();

//      Then verify the Summary card is displayed(SELECT A CORE ELEMENT ON THAT PAGE FOR //VERIFICATION: EX SHOPPING-CART SUMMARY)
        WebElement cartSummary = driver.findElement(By.xpath("//h1[@id='cart_title']"));
        Assert.assertTrue(cartSummary.isDisplayed());

//      Then verify the product is In stock
        WebElement inStock = driver.findElement(By.xpath("//span[@class='label label-success']"));
        Assert.assertEquals("In stock",inStock.getText());

//      Then verify the Unit price matches the price that is on the Add To Card page
        String unitPrice = driver.findElement(By.xpath("(//span[@class='price'])[2]")).getText();
        Assert.assertEquals(price,unitPrice);

//      And user clicks on + sign
        WebElement plusSign = driver.findElement(By.xpath("//i[@class='icon-plus']"));
        //plusSign.click();
        clickByJS(plusSign);
        Thread.sleep(5000);

//      Then verifies the TOTAL price is 2*price+shipping ==>  2 * $16.51 + $2 = $35.02
        String totalPrice2 = driver.findElement(By.xpath("//span[@id='total_price']")).getText();
        Assert.assertEquals("$35.02",totalPrice2);

//      And click on Proceed to checkout
        WebElement proceedButton = driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]"));
        //proceedButton.click();
        clickByJS(proceedButton);

//      Then verify sign-in page displayed
        WebElement signInPage = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(signInPage.isDisplayed());

//      Then the user enters a username password and sign in
        driver.findElement(By.id("email")).sendKeys("aligel@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        WebElement submitLogin = driver.findElement(By.id("SubmitLogin"));
        //submitLogin.click();
        clickByJS(submitLogin);

//      Then Verify user is on the Address stage
        WebElement address = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(address.isDisplayed());

//      And click on Proceed to checkout
        WebElement proceedButtonAddress = driver.findElement(By.xpath("//button[@name='processAddress']"));
        //proceedButtonAddress.click();
        clickByJS(proceedButtonAddress);

//      Then verify user moves to the Shipping stage(SHIPPING)
        String shipping = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
        Assert.assertEquals("SHIPPING",shipping);

//      And click on Proceed to checkout
        WebElement proceedButtonShipping = driver.findElement(By.xpath("//button[@name='processCarrier']"));
        //proceedButtonShipping.click();
        clickByJS(proceedButtonShipping);

//      Then verify the error message: You must agree to the terms of service before continuing.
        String errorMessage = driver.findElement(By.xpath("//p[@class='fancybox-error']")).getText();
        Assert.assertEquals("You must agree to the terms of service before continuing.",errorMessage);

//      Then click on x to exit out
        WebElement closeMessage = driver.findElement(By.xpath("//a[@title='Close']"));
        //closeMessage.click();
        clickByJS(closeMessage);

//      And click on the Terms of service checkbox
        WebElement termsOfServiceCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        selectCheckbox(termsOfServiceCheckBox,true);

//      And click on Proceed to checkout
        //proceedButtonShipping.click();
        clickByJS(proceedButtonShipping);

//      Then verify a user is on the Payment stage(PLEASE CHOOSE YOUR PAYMENT METHOD)
        String payment = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
        Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD",payment);
    }
}
