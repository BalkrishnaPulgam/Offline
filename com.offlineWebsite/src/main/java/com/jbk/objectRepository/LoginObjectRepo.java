package com.jbk.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjectRepo {
	@FindBy(tagName="img")
	public WebElement image;
	@FindBy(id="email")
	public WebElement email;
	@FindBy(id="password")
	public WebElement pass;
	@FindBy(xpath="//button")
	public WebElement button;
	@FindBy(id="password_error")
	public WebElement passError;
	@FindBy(id="email_error")
	public WebElement emailError;
	@FindBy(tagName="b")
	public WebElement headingText;
	@FindBy(tagName="h4")
	public WebElement courseText;
}
