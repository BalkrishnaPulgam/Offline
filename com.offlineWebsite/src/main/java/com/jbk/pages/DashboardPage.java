package com.jbk.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.objectRepository.DashboardObjectRepo;

public class DashboardPage extends DashboardObjectRepo {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyHeader() {
		String act = headerText.getText();
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
		List<WebElement> list = menuList;
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

	public boolean verifyCourses() throws Exception {

		List<WebElement> list = coursesList;

		ArrayList<String> expList = new ArrayList<String>();

		for (WebElement webElement : list) {
			String text = webElement.getText();
			expList.add(text);
		}

		ArrayList<String> excelList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\CoursesList.xlsx");
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

		List<WebElement> list = subCourses;
		for (WebElement webElement : list) {
			String text = webElement.getText();
			actList.add(text);
		}

		ArrayList<String> excelList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\CoursesList.xlsx");
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
		usersLink.click();
		return new UserPage(driver);

	}

	public OperatorsPage NavigateOperatorsPage() {
		operatorsLink.click();
		return new OperatorsPage(driver);

	}

	public UsefulLinksPage NavigateUsefulLinksPage() {
		usefulLink.click();
		return new UsefulLinksPage(driver);
	}

	public DownloadsPage NavigateDownloadsPage() {
		downloadsLink.click();
		return new DownloadsPage(driver);
	}

	public LoginPage NavigateLogoutPage() {
		logoutLink.click();
		return new LoginPage(driver);
	}

}
