package com.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q06 {

    //Verfy that we have pom.xml file in our project => please try in 4 min

    @Test
    public void test() {

        String homeDirectory = System.getProperty("user.home"); // homeDirectory--> C:\Users\yusuf
        String pathOfFile = homeDirectory + "\\IdeaProjects\\myseleniumproject\\pom.xml";
        System.out.println(pathOfFile);// C:\Users\yusuf\IdeaProjects\myseleniumproject\pom.xml
//        And verify if that file exist on your computer or not
        boolean isFileExist = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isFileExist);//Pass is exist, Fail is not exist
    }
}
