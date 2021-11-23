package com.jbk.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.jbk.objectRepository.AddUserObjectRepo;

public class AddUserPage extends AddUserObjectRepo {
	
	public WebDriver driver;
	
	public  AddUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public UserPage clickOnCancle() {
		addUserCancleBtn.click();
		return new UserPage(driver);
	}
	
	
	public boolean VerifyAddUserAlertMsg(String entername,String entermobile,String entergmail,String entercourse,String enterState,String pass) {
	
		username.sendKeys(entername);
		mobile.sendKeys(entermobile);
		email.sendKeys(entergmail);
		course.sendKeys(entercourse);
		Male.click();
		WebElement element=selectState;
		Select sel=new Select(element);
		sel.selectByVisibleText(enterState);
		password.sendKeys(pass);
		addUserSubmitBtn.click();
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
