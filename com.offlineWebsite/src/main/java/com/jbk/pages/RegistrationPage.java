package com.jbk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver ) {
		this.driver=driver;
	}
	
	
	
	public LoginPage clickOnAlreadyMembership() {
		driver.findElement(By.partialLinkText("membership")).click();
		return new LoginPage(driver);
		
	}
	
	
	public boolean registrationForm(String name,String mobile,String email,String password) {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
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
