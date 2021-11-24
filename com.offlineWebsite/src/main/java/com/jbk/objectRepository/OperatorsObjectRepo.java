package com.jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OperatorsObjectRepo {
	
	@FindBy(xpath="//tr//td[2]")
	public List<WebElement> personList;
	@FindBy(xpath="//tr//td[3]")
	public List<WebElement> forList;
	@FindBy(xpath="//tr//td[4]")
	public List<WebElement> wayOfConnectList;
	@FindBy(xpath="//tr//td[5]")
	public List<WebElement> contactList;
	@FindBy(xpath="//tr//td[6]")
	public List<WebElement> FacultyTiming;

}
