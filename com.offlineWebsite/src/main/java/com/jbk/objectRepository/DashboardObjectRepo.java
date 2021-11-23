package com.jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardObjectRepo {
	@FindBy(xpath = "//h1")
	public WebElement headerText;
	@FindBy(xpath = "//li//span")
	public List<WebElement> menuList;
	@FindBy(xpath = "//h3")
	public List<WebElement> coursesList;
	@FindBy (xpath="//h3//following::p")
	public List<WebElement>subCourses;
	@FindBy(linkText = "Users")
	public WebElement usersLink;
	@FindBy(linkText = "Operators")
	public WebElement operatorsLink;
	@FindBy(linkText = "Useful Links")
	public WebElement usefulLink;
	@FindBy(linkText = "Downloads")
	public WebElement downloadsLink;
	@FindBy(linkText = "Logout")
	public WebElement logoutLink;

}
