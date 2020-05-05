package com.allbirds.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProvider {

    XSSFWorkbook wb;

    public DataProvider() throws IOException {
        File src = new File ("TestData/TestData.xlsx");
        FileInputStream fis = new FileInputStream(src);
        wb = new XSSFWorkbook(fis);


    }

    public String getStringData(int sheetIndex, int row, int column){
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();

    }

    public String getStringData(String sheetName, int row, int column){
       return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();

    }

    public double getNumericData(String sheetName, int row, int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

    }

}

