package com.jbk.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean VerifyHeader() {
		String act = driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Actual: " + act);
		String exp = "Dashboard Courses Offered";
		System.out.println("Expected: " + exp);

		if (act.equals(exp)) {
			System.out.println("Heading text is matching");
			return true;
		} else {
			System.out.println("Heading text is not matching");
			return false;
		}

	}

	public boolean verifyMenu() {

		ArrayList<String> actList = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//li//span"));
		for (WebElement webElement : list) {
			String text = webElement.getText();
			actList.add(text);

		}

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Dashboard");
		expList.add("Users");
		expList.add("Operators");
		expList.add("Useful Links");
		expList.add("Downloads");
		expList.add("Logout");
		
		if (actList.equals(expList)) {
			System.out.println("Menu list is matching");
			return true;
		} else {
			System.out.println("Menu list is not matching");
			return false;
		}

	}

	public boolean verifyCourses () throws Exception {

		List<WebElement> list = driver.findElements(By.xpath("//h3"));

		ArrayList<String> expList = new ArrayList<String>();

		for (WebElement webElement : list) {
			String text = webElement.getText();
			expList.add(text);
		}
		
		ArrayList<String> excelList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

	//	FileInputStream fis = new FileInputStream("ExcelData/CoursesList.xlsx");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\sre\\test\\resources\\CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DashboardPage");
		int count = sh.getLastRowNum();

		for (int i = 1; i <= count; i++) {
			Cell cell = sh.getRow(i).getCell(0);
			String text = df.formatCellValue(cell);
			System.out.println(text);
			
			excelList.add(text);
		}
		if (expList.equals(excelList)) {
			System.out.println("Coruses list is matching");
			return true;
		} else {
			System.out.println("Coruses list is not matching");
			return false;
		}

	}

	public boolean verifySubCourses() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> list = driver.findElements(By.xpath("//h3//following::p"));
		for (WebElement webElement : list) {
			String text = webElement.getText();
			actList.add(text);
		}

		ArrayList<String> excelList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream("ExcelData/CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DashboardPage");
		int count = sh.getLastRowNum();

		for (int i = 1; i <= count; i++) {
			Cell cell = sh.getRow(i).getCell(1);
			String text = df.formatCellValue(cell);
			System.out.println(text);
			excelList.add(text);
		}
		if (actList.equals(excelList)) {
			System.out.println("SubCourses is matching");
			return true;
		} else {
			System.out.println("SubCourses is not matching");
			return false;
		}

	}

	public UserPage NavigateUsersPage() {
		driver.findElement(By.linkText("Users")).click();
		return new UserPage(driver);

	}

	public OperatorsPage NavigateOperatorsPage() {
		driver.findElement(By.linkText("Operators")).click();
		return new OperatorsPage(driver);

	}

	public UsefulLinksPage NavigateUsefulLinksPage() {
		driver.findElement(By.linkText("Useful Links")).click();
		return new UsefulLinksPage(driver);
	}

	public DownloadsPage NavigateDownloadsPage() {
		driver.findElement(By.linkText("Downloads")).click();
		return new DownloadsPage(driver);
	}

	public LoginPage NavigateLogoutPage() {
		driver.findElement(By.linkText("Logout")).click();
		return new LoginPage(driver);
	}

}
