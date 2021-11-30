package com.utility;

import java.io.FileInputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;

public class CommonUtils {
	
	static FileInputStream fis=null;
	static Workbook wb=null;
	static Sheet sh=null;
	
	
	public static ArrayList<String> readDataOfCol(String fileName,String sheetName,int colNo) {
		ArrayList<String> expList=new ArrayList<String>();
		try {
		fis=new FileInputStream(fileName);
		wb=Workbook.getWorkbook(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		sh=wb.getSheet(sheetName);
		int row=sh.getRows();
		for(int i=1;i<row;i++) {
			expList.add(sh.getCell(colNo,i).getContents());
				}
		System.out.println(expList);
		return expList;
	}
	
	
	public static ArrayList<String> readDataOfRow(String fileName,String sheetName,int rowNo) throws Exception
	{
		ArrayList<String> expList=new ArrayList<String>();
		FileInputStream fis=new FileInputStream(fileName);
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet(sheetName);
		int col=sh.getColumns();
		for(int i=0;i<col;i++) {
			expList.add(sh.getCell(i,rowNo).getContents());
				}
		System.out.println(expList);
		return expList;
	}
	
	public static void waitBeforeBrowserClose() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
