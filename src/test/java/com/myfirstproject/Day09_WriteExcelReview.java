package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day09_WriteExcelReview {
    @Test
    public void writeExcel() throws IOException {
        String path = "./src/test/java/resources/cars.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cellR1C3 = row.createCell(2);
        cellR1C3.setCellValue("FUEL TYPE");
        sheet.getRow(1).createCell(2).setCellValue("gasoline");
        sheet.getRow(2).createCell(2).setCellValue("diesel");
        sheet.getRow(3).createCell(2).setCellValue("gas");
        sheet.getRow(4).createCell(2).setCellValue("diesel");
        sheet.getRow(5).createCell(2).setCellValue("gasoline");
        sheet.getRow(6).createCell(2).setCellValue("gasoline");
        sheet.getRow(7).createCell(2).setCellValue("gas");
        sheet.getRow(8).createCell(2).setCellValue("diesel");
        sheet.getRow(9).createCell(2).setCellValue("gas");
        sheet.getRow(10).createCell(2).setCellValue("diesel");

        // Write and save
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //close the file
        fileInputStream.close();
        fileOutputStream.close();
    }
}
