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
import com.jbk.pages.LoginPage;
import com.jbk.pages.UserPage;

public class UserPageTest {
	
	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage dp;
	public UserPage up;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		lp = new LoginPage(driver);
		up = lp.verifyValidLogin().NavigateUsersPage();
		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	@Test(priority=1)
	public void validateHeader() {
		Assert.assertTrue(up.VerifyHeader());
	}
	
	@Test(priority=2)
	public void validateBoxHeader() {
		Assert.assertTrue(up.VerifyBoxHeader());
	}
	
	@Test(priority=3)
	public void checkColumnName() throws Exception {
		
		ArrayList<String> actList=up.VerifyColumnName();
		
		ArrayList<String> excelList = new ArrayList<String>();
			
		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream("ExcelData/CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("UserPage");
	//	int count = sh.getLastRowNum();
		int count=8;

		for (int i = 0; i < count; i++) {
			Cell cell = sh.getRow(0).getCell(i);
			String text = df.formatCellValue(cell);
			System.out.println(text);
			
			excelList.add(text);
		}

		Assert.assertEquals(actList, excelList);

	}
	
	
	@Test(priority=4)
	public void validateTotalNumberOfUsers() throws Exception{
		
		ArrayList<String> actList = up.verfyTotalNumberOfUser();
		
		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream input = new FileInputStream("ExcelData/CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(input);
		Sheet sh = wb.getSheet("UserPage");
		int count = sh.getLastRowNum();

		for (int i = 1; i <= count; i++) {
			Cell cell = sh.getRow(i).getCell(1);
			String text = df.formatCellValue(cell);
			expList.add(text);
		}
		Assert.assertEquals(actList, expList);
	}
	
	
	@Test(priority=5)
	public void validateMaleUsers() {
		Assert.assertTrue(up.VerifyMaleUsers());
	}
	
	@Test(priority=6)
	public void validateFemaleUsers() throws Exception {
		Assert.assertTrue(up.VerifyFemaleUsers());
	}
	
	
	@Test(priority=7,description = "verifying that users from Maharashtra")
	public void validateStateUsers() throws Exception {
		Assert.assertTrue(up.VerifyStateUsers());
	}
	
	@Test(priority=8,description = "verifying that all users having correct gmail")
	public void validateGmailUsers() throws Exception {
		Assert.assertTrue(up.verifyGmailUsers());
	}
	
	
	
	@Test(priority=9,description = "verifying that Kiran having Java/J2EE course")
	public void validateKiranCourse() throws Exception {
		Assert.assertTrue(up.VerifyKiranCourse());
	}
	
	@Test(priority=10,description = "verifying that Sagar from Punjab")
	public void validateSagarState() throws Exception {
		Assert.assertTrue(up.VerifySagarState());
	}
	
	
	@Test(priority=11,description = "Checking invalid mobile users")
	public void InvalidMobileUsers() throws Exception {
		ArrayList<String> actList =up.CheckInvalidMobileUsers();
		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Sagar");
		expList.add("Kimaya");
		
		Assert.assertEquals(actList, expList);
	}
	
	
	@Test(priority=11)
	public void validateAddUserPageTitle() {
		Assert.assertEquals(driver.getTitle(), up.clickOnAddUserPage());
	}
	

}
