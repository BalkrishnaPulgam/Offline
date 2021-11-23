package com.jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserObjectRepo {
	@FindBy(xpath="//h1")
	public WebElement headerText;
	@FindBy(xpath="//h3")
	public WebElement boxHeaderText;
	@FindBy(xpath="//tr//th")
	public List<WebElement> columnName;
	@FindBy(xpath="//tr//td[6]")
	public List<WebElement> genList;
	@FindBy(xpath="//tr//td[2]")
	public List<WebElement> userNames;
	@FindBy(xpath="//tr//td[7]")
	public List<WebElement> stateNames;
	@FindBy(xpath="//tr//td[3]")
	public List<WebElement> gmailList;
	@FindBy(xpath="//tr//td[5]")
	public List<WebElement> courseList;
	@FindBy(xpath="//tr//td[4]")
	public List<WebElement> mobList;
	
	@FindBy(xpath="//button[text()='Add User']")
	public WebElement addUserBtn;

}
