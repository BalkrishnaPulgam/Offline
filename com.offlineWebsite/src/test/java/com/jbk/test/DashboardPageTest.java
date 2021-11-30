package com.jbk.test;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.jbk.pages.DashboardPage;
import com.jbk.pages.DownloadsPage;
import com.jbk.pages.LoginPage;
import com.jbk.pages.OperatorsPage;
import com.jbk.pages.UserPage;

public class DashboardPageTest extends BaseClass{

	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage dp;
	public UserPage up;
	public OperatorsPage op;
	public DownloadsPage dlp;

	@BeforeMethod
	public void setup() {
		driver=initialization();
		dp = loadLoginPage().verifyValidLogin();
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
		Assert.assertTrue(dp.verifyMenu());
	}

	@Test(priority = 3)
	public void checkCourseList() throws Exception {
		Assert.assertTrue(dp.verifyCourses());

	}

	@Test(priority = 4)
	public void checkSubCourseList() throws Exception {
		Assert.assertTrue(dp.verifySubCourses());

	}

	@Test(priority = 5)
	public void checkUsersLinkMenu() {
		up = dp.NavigateUsersPage();
		String act = driver.getTitle();
		System.out.println("Actual Browser Title: " + act);
		String exp = "JavaByKiran | User";
		System.out.println("Expected Browser Title: " + exp);
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 6)
	public void checkOperatorsLinkMenu() {
		op = dp.NavigateOperatorsPage();
		String act = driver.getTitle();
		System.out.println("Actual Browser Title: " + act);
		String exp = "JavaByKiran | Operators";
		System.out.println("Expected Browser Title: " + exp);
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 7)
	public void checkDownloadsLinkMenu() {
		dlp = dp.NavigateDownloadsPage();
		String act = driver.getTitle();
		System.out.println("Actual Browser Title: " + act);
		String exp = "JavaByKiran | Downloads";
		System.out.println("Expected Browser Title: " + exp);
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 8)
	public void checkLogoutLinkMenu() {
		lp = dp.NavigateLogoutPage();
		String act = driver.getTitle();
		System.out.println("Actual Browser Title: " + act);
		String exp = "JavaByKiran | Log in";
		System.out.println("Expected Browser Title " + exp);
		Assert.assertEquals(act, exp);
		Assert.assertEquals(act, exp);

	}

}
