package com.myfirstproject;

import org.junit.*;

public class Day03_Assertions {

    @Test
    public void assertions(){
        /*
        * ****** ASSERTIONS ******
        * it means
        * if expected = actual
        * if assertion fails we see red error
        * if assertion pass we see green checkmark
        *
        * What is difference between Assertion and Verification?
         * -When assertion fails, test stops execution. Assertion means Hard Assert
         * -Verification means, test continue to execute even after verification fails
         * In TestNG there is SoftAssert. It means verification.
         * -In verification, we can mark more than one result as failed or passed
         */

        //1.assertEquals ("MESSAGE WHEN FAILS", "EXPECTED", "ACTUAL")
//        Assert.assertEquals("TEST CASE IS FAILed","Java","Javascript");
//          org.junit.ComparisonFailure: TEST CASE IS FAILed
//          Expected :Java
//          Actual   :Javascript

        Assert.assertEquals(5,5);

        //2. asssertTrue(BOOLEAN)
//        Assert.assertTrue("JAVA".contains("E"));
//      java.lang.AssertionError

        Assert.assertTrue("SELENIUM".contains("E")); //PASS

        //3. assertFalse(BOOLEAN)
        Assert.assertFalse("JAVA".contains("E")); //PASS

        Assert.assertFalse("SELENIUM".contains("E")); //FAIL

    }
}
