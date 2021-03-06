package com.jbk.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.jbk.pages.OperatorsPage;


public class OperatorsPageTest extends BaseClass{
	
	public WebDriver driver;
	public OperatorsPage op;
	
	@BeforeMethod
	public void setup() {
		driver=initialization();
		op=loadLoginPage().verifyValidLogin().NavigateOperatorsPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority=1,description = "verifying that only Whats App user faculties.")
	public void onlyWhatsAppFaculty() {
		assertTrue(op.onlyWhatsAppFaculties());
	}
	
	@Test(priority=2,description = "verifying that PhoneCall faculties.")
	public void PhoneCallFaculty() {
		assertTrue(op.phoneCallFaculties());
	}
	
	@Test(priority=3,description = "verifying that faculties available on Saturday-Sunday")
	public void SatSunFaculties() {
		assertTrue(op.facultyAvaiOnSatAndSun());
	}
	
	@Test(priority=4,description = "verifying that faculties available from 09:00 AM to 06:00 PM")
	public void facultiesFrom09To06() {
		assertTrue(op.facultyAvaiFrom09amTo06pm());
	}
	
	@Test(priority=5,description = "verifying that technical faculties from Operators")
	public void techFaculties() {
		assertTrue(op.technicalFaculties());
	}

}
