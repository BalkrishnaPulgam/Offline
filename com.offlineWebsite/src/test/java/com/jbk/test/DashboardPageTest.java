package com.jbk.test;

import java.io.FileInputStream;
import java.util.ArrayList;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.pages.DashboardPage;
import com.jbk.pages.DownloadsPage;
import com.jbk.pages.LoginPage;
import com.jbk.pages.OperatorsPage;
import com.jbk.pages.UserPage;

public class DashboardPageTest {

	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage dp;
	public UserPage up;
	public OperatorsPage op;
	public DownloadsPage dlp;
	

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		lp = new LoginPage(driver);
		dp = lp.verifyValidLogin();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void validateHeadingText() {
		boolean status = dp.VerifyHeader();
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void checkMenuList() {
		ArrayList<String> actList = dp.verifyMenu();

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Dashboard");
		expList.add("Users");
		expList.add("Operators");
		expList.add("Useful Links");
		expList.add("Downloads");
		expList.add("Logout");
		Assert.assertEquals(actList, expList);
	}

	@Test(priority = 3)
	public void checkCourseList() {
		ArrayList<String> actList=dp.verifyCourses();
		
		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Selenium");
		expList.add("Java / J2EE");
		expList.add("Python");
		expList.add("Php");
		
		Assert.assertEquals(actList, expList);

	}
	
	@Test(priority = 4)
	public void checkSubCourseList() throws Exception{
		
		ArrayList<String> actList=dp.verifySubCourses();
		
		ArrayList<String> excelList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream("ExcelData/CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();

		for (int i = 0; i <= count; i++) {
			Cell cell = sh.getRow(i).getCell(0);
			String text = df.formatCellValue(cell);
			excelList.add(text);
		}
		
		Assert.assertEquals(actList, excelList);
		
	}
	
	
	@Test(priority=5)
	public void checkUsersLinkMenu() {
		up=dp.NavigateUsersPage();
		String act=driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | User";
		System.out.println("Expected Browser Title: "+exp);
		Assert.assertEquals(act, exp);
	}
	
	
	@Test(priority=6)
	public void checkOperatorsLinkMenu() {
		op=dp.NavigateOperatorsPage();
		String act=driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | Operators";
		System.out.println("Expected Browser Title: "+exp);
		Assert.assertEquals(act, exp);
		
	}
	
	@Test(priority=7)
	public void checkDownloadsLinkMenu() {
		dlp=dp.NavigateDownloadsPage();
		String act=driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | Downloads";
		System.out.println("Expected Browser Title: "+exp);
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=8)
	public void checkLogoutLinkMenu() {
		lp=dp.NavigateLogoutPage();
		String act=driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | Log in";
		System.out.println("Expected Browser Title "+exp);
		Assert.assertEquals(act, exp);
		Assert.assertEquals(act, exp);
		
	}

}
