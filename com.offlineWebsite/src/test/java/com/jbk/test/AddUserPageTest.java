package com.jbk.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.pages.AddUserPage;
import com.jbk.pages.LoginPage;
import com.jbk.pages.UserPage;

public class AddUserPageTest {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddUserPage aup;
	public UserPage up;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		lp = new LoginPage(driver);
		aup = lp.verifyValidLogin().NavigateUsersPage().clickOnAddUser();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void validateTitleAfterClickOnCancle() throws Exception {
		
		up=aup.clickOnCancle();
		
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
		
	}
	
	@Test
	public void VerifyAddUserAlertMsg() {
		boolean status=aup.VerifyAddUserAlertMsg("Balkrishna", "12345", "b@gmail.com", "Java", "Maharashtra", "123456");
		
		Assert.assertTrue(status);
	}

}
