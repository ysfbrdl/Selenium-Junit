package com.myfirstproject;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Day08_FileExist {
    @Test
    public void isExistTest(){  //This is advance and stabil way
//        Pick a file on your desktop
//        My file: logo.jpeg on the desktop
//        I will check if the file exist
        String homeDirectory = System.getProperty("user.home"); // homeDirectory--> C:\Users\yusuf

        String pathOfFile = homeDirectory+"\\OneDrive\\Masaüstü\\logo.jpeg";   //Windows
        System.out.println(pathOfFile);// C:\Users\yusuf\OneDrive\Masaüstü\logo.jpeg
//        And verify if that file exist on your computer or not
        boolean isFileExist = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isFileExist);//Pass is exist, Fail is not exist
    }
    @Test
    public void secondWay(){
        String filePath ="C:\\Users\\yusuf\\OneDrive\\Masaüstü\\logo.jpeg";
//      If there is a file whose name is logo.jpeg on desktop, then this pass; else this fails
        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);
    }
}