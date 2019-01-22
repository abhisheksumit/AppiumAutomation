package com.wfs.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	
	public static XSSFSheet ExcelWSheet;
	 
	public static XSSFWorkbook ExcelWBook;

    public static XSSFCell Cell;

    public static XSSFCell Row; 
    
    private static String userName;
    
    private  static String passWord;
  	
    public void setCredentials() throws IOException{
    	
    	FileInputStream ExcelFile= new FileInputStream(".//testData//DataSheet.xlsx");
		
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet("Sheet1");
		
	    Row = ExcelWSheet.getRow(1).getCell(0);
	    userName=Row.getStringCellValue();
	
	    Cell = ExcelWSheet.getRow(1).getCell(1);
	    passWord=Cell.getStringCellValue();
		
    	
    }
    
    public static String getUserName(){
    	return userName;
    }
    public static String getPassword(){
    	return passWord;
    }

}
