package com.jbk.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddUserPage {
	
	public WebDriver driver;
	
	public  AddUserPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public UserPage clickOnCancle() {
		driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		return new UserPage(driver);
	}
	
	
	public boolean VerifyAddUserAlertMsg(String name,String mobile,String gmail,String course,String State,String pass) {
	
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("email")).sendKeys(gmail);
		driver.findElement(By.id("course")).sendKeys(course);
		driver.findElement(By.id("Male")).click();
		WebElement element=driver.findElement(By.xpath("//select"));
		Select sel=new Select(element);
		sel.selectByVisibleText(State);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("submit")).click();
		Alert a=driver.switchTo().alert();
		String act=a.getText();
		a.accept();
		String exp="User Added Successfully. You can not see added user.";
		Assert.assertEquals(act, exp);
		
		
		if(act.equals(exp)) {
			System.out.println("Alert Message is matching");
			return true;
		}else {
			System.out.println("Alert Message is not matching");
			return false;
			
		}
		
		}

}
