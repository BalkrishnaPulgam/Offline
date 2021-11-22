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

	public ArrayList<String> verifyMenu() {

		ArrayList<String> actList = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//li//span"));
		for (WebElement webElement : list) {
			String text = webElement.getText();
			actList.add(text);

		}
		return actList;
	}

	public ArrayList<String> verifyCourses() {

		List<WebElement> list = driver.findElements(By.xpath("//h3"));

		ArrayList<String> expList = new ArrayList<String>();

		for (WebElement webElement : list) {
			String text = webElement.getText();
			expList.add(text);
		}

		return expList;

	}

	public ArrayList<String> verifySubCourses() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> list = driver.findElements(By.xpath("//h3//following::p"));
		for (WebElement webElement : list) {
			String text = webElement.getText();
			actList.add(text);
		}
		return actList;

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
