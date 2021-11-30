package com.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility {
	
	static FileInputStream fis=null;
	static Workbook wb=null;
	static Sheet sh=null;
	
	public static String getCellData(String filepath, String name, int rownum, int column) {
		DataFormatter  df= new DataFormatter();
		try {
			fis=new FileInputStream(filepath);
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sh=wb.getSheet(name);
		Cell c=sh.getRow(rownum).getCell(column);
		
		return df.formatCellValue(c);
		
	}
	
	
	
	@Test
	public void test() {
		String xlpath=System.getProperty("user.dir")+"/src/test/resources/CoursesList.xls";
		String poipath=System.getProperty("user.dir")+"/src/test/resources/CoursesList.xlsx";
		
		System.out.println(getCellData(xlpath, "login", 0, 0));
		System.out.println(getCellData(poipath, "login", 1, 0));
	}
	
	
	public static int getRowCount(String filepath, String name)	{
		try {
			fis=new FileInputStream(filepath);
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sh=wb.getSheet(name);
		int rowcount=sh.getLastRowNum();	
		
		return rowcount;
	}
	
	
	
	
	
	public void getAllData(String filePath, String name) {
		DataFormatter df= new DataFormatter();
		try
		{
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh= wb.getSheet(name);
		int rows= sh.getLastRowNum();
		for(int i=0;i<=rows;i++) {
			int col= sh.getRow(i).getLastCellNum();
			for(int j=0;j<=col;j++) {		
				Cell c= sh.getRow(i).getCell(j);
				System.out.print(df.formatCellValue(c)+" ");
			}
			System.out.println();
		}
	}
	
	public String[][] getAllDataAsDP(String filePath, String name, int noOfParam) {
		String value=null;
		DataFormatter df= new DataFormatter();
		try
		{
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh= wb.getSheet(name);
		int rows= sh.getLastRowNum();
		String data[][]=new String[rows][noOfParam];//3,2
		for(int i=0;i<rows;i++) {
			for(int j=0;j<noOfParam;j++) {		
				Cell c= sh.getRow(i).getCell(j);
				 value=df.formatCellValue(c);
				data[i][j]=value;
			}	
		}
		return data;
	}
	
	
}
