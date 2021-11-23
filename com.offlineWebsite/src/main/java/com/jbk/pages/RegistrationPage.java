package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.jbk.objectRepository.RegistrationObjectRepo;

public class RegistrationPage extends RegistrationObjectRepo{
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public LoginPage clickOnAlreadyMembership() {
		alreadyMemLink.click();
		return new LoginPage(driver);
		
	}
	
	
	public boolean registrationForm(String entername,String entermobile,String enteremail,String enterpassword) {
		name.clear();
		mobile.clear();
		email.clear();
		password.clear();
		
		name.sendKeys(entername);
		mobile.sendKeys(entermobile);
		email.sendKeys(enteremail);
		password.sendKeys(enterpassword);
		registerBtn.click();
		String act=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String exp="User registered successfully.";
		
		if(act.equals(exp)) {
			System.out.println("User registered successfully.");
			return true;
		}else {
			System.out.println("User not registered successfully.");
			return false;
		}
		
	}
	
	
	

}
