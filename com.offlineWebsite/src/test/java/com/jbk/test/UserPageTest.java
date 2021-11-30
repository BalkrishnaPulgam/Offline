package com.jbk.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.jbk.pages.AddUserPage;
import com.jbk.pages.UserPage;

public class UserPageTest extends BaseClass{

	public WebDriver driver;
	public UserPage up;
	public AddUserPage aup;

	@BeforeMethod
	public void setup() {
		driver=initialization();
		up = loadLoginPage().verifyValidLogin().NavigateUsersPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void validateHeader() {
		Assert.assertTrue(up.VerifyHeader());
	}

	@Test(priority = 2)
	public void validateBoxHeader() {
		Assert.assertTrue(up.VerifyBoxHeader());
	}

	@Test(priority = 3)
	public void checkColumnName() throws Exception {
		boolean status = up.VerifyColumnName();
		Assert.assertTrue(status);

	}

	@Test(priority = 4)
	public void validateTotalNumberOfUsers() throws Exception {
		boolean status = up.verfyTotalNumberOfUser();
		Assert.assertTrue(status);
	}

	@Test(priority = 5)
	public void validateMaleUsers() {
		Assert.assertTrue(up.VerifyMaleUsers());
	}

	@Test(priority = 6)
	public void validateFemaleUsers() throws Exception {
		Assert.assertTrue(up.VerifyFemaleUsers());
	}

	@Test(priority = 7, description = "verifying that users from Maharashtra")
	public void validateStateUsers() throws Exception {
		Assert.assertTrue(up.VerifyStateUsers());
	}

	@Test(priority = 8, description = "verifying that all users having correct gmail")
	public void validateGmailUsers() throws Exception {
		Assert.assertTrue(up.verifyGmailUsers());
	}

	@Test(priority = 9, description = "verifying that Kiran having Java/J2EE course")
	public void validateKiranCourse() throws Exception {
		Assert.assertTrue(up.VerifyKiranCourse());
	}

	@Test(priority = 10, description = "verifying that Sagar from Punjab")
	public void validateSagarState() throws Exception {
		Assert.assertTrue(up.VerifySagarState());
	}

	@Test(priority = 11, description = "Checking invalid mobile users")
	public void InvalidMobileUsers() throws Exception {
		Assert.assertTrue(up.CheckInvalidMobileUsers());
	}

	@Test(priority = 11)
	public void validateAddUserPageTitle() {
		aup = up.clickOnAddUser();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Add User");
	}

}
