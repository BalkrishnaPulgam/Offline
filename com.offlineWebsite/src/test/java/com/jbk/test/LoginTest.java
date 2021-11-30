package com.jbk.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.jbk.pages.DashboardPage;
import com.jbk.pages.LoginPage;
import com.jbk.pages.RegistrationPage;

public class LoginTest extends BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage dp;
	public RegistrationPage rp;

	@BeforeMethod
	public void setup() {
		driver = initialization();
		lp = loadLoginPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void ValidateTitle() {
		String title = lp.verifyBrowserTitle();
		Assert.assertEquals(title, "JavaByKiran | Log in");

	}

	@Test(priority = 2)
	public void validateImage() {
		Assert.assertEquals(lp.verifyLogo(), true);
	}

	@Test(priority = 3)
	public void ValidateHeadingText() {
		Assert.assertTrue(lp.verifyingHeadingText());
	}

	@Test(priority = 4)
	public void validatePasswordSuggestion() {
		Assert.assertTrue(lp.verifyPasswordSuggestion());
	}

	@Test(priority = 5)
	public void validateEmailSuggestion() {
		Assert.assertTrue(lp.verifyEmailSuggestion());
	}

	@Test(priority = 6)
	public void validateCourseText() {
		Assert.assertTrue(lp.verifyCoursesText());
	}

	@Test(priority = 7)
	public void checkRegistrationLink() {
		rp = lp.clickOnRegistrationLink();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
	}

	@Test(priority = 8)
	public void verifyValidLogin() {
		dp = lp.verifyValidLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

}
