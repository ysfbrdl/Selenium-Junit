package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day09_ReadExcelReview {      //   workbook > worksheet > row > cell
    @Test
    public void readExcel() throws IOException {
        String path = "./src/test/java/resources/cars.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(0);
        System.out.println(cell.toString().toUpperCase());
        String r4c2 = sheet.getRow(3).getCell(1).toString();
        System.out.println("r4c2 = " + r4c2);
        int lastRowNum = sheet.getLastRowNum()+1;
        System.out.println("lastRowNum = " + lastRowNum);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println("physicalNumberOfRows = " + physicalNumberOfRows);
        Map<String,String> markModel = new HashMap<>();
        for(int rowNumber = 1; rowNumber<lastRowNum; rowNumber++){
            String mark = sheet.getRow(rowNumber).getCell(0).toString();
            String model = sheet.getRow(rowNumber).getCell(1).toString();
            markModel.put(mark,model);
        }
        System.out.println("markModel = " + markModel);
    }
}
