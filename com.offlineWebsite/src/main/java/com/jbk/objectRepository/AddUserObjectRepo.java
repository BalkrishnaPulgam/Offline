package com.jbk.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserObjectRepo {
	
	@FindBy(xpath="//span[text()='Cancel']")
	public WebElement addUserCancleBtn ;
	@FindBy(id="username")
	public WebElement username;
	@FindBy(id="mobile")
	public WebElement mobile;
	@FindBy(id="email")
	public WebElement email;
	@FindBy(id="course")
	public WebElement course;
	@FindBy(id="password")
	public WebElement password;
	@FindBy(id="Male")
	public WebElement Male;
	
	@FindBy(xpath="//select")
	public WebElement selectState;
	@FindBy(id="submit")
	public WebElement addUserSubmitBtn ;

}
