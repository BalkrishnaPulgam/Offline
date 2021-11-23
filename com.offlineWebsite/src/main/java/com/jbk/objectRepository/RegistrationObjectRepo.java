package com.jbk.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationObjectRepo {
	@FindBy(id="name")
	public WebElement name;
	@FindBy(id="mobile")
	public WebElement mobile;
	@FindBy(id="email")
	public WebElement email;
	@FindBy(id="password")
	public WebElement password;
	@FindBy(xpath="//button")
	public WebElement registerBtn;
	@FindBy(partialLinkText = "membership")
	public WebElement alreadyMemLink;

}
