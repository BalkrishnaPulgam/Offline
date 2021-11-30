package com.jbk.test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.jbk.pages.LoginPage;
import com.jbk.pages.RegistrationPage;

public class RegistrationPageTest extends BaseClass{
	
	public WebDriver driver;
	public RegistrationPage rp;
	public LoginPage lp;
	
	@BeforeMethod
	public void setup() {
		driver=initialization();
		rp=loadLoginPage().clickOnRegistrationLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void checkAlreadyMembershipLink() {
		
		lp=rp.clickOnAlreadyMembership();
		
		String act = driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | Log in";
		System.out.println("Expected Browser Title: "+exp);
		
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=2)
	public void checkRegisteredAlertMsg() {
	
		boolean status=	rp.registrationForm("krishna", "123456", "b@gmail.com", "123456");
		Assert.assertTrue(status);
	}

}
