package com.jbk.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.objectRepository.OperatorsObjectRepo;

public class OperatorsPage extends OperatorsObjectRepo {

	public WebDriver driver;

	public OperatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean onlyWhatsAppFaculties() {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> person = personList;
		List<WebElement> wayToConnect = wayOfConnectList;
		int a = 0;
		for (WebElement element : wayToConnect) {
			if (element.getText().contains("Whats App Only")) {
				String text = person.get(a).getText();
				actList.add(text);
			}
			a++;
		}

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Kiran");
		expList.add("Darshit");

		if (actList.equals(expList)) {
			System.out.println("TestCase Passed.");
			return true;
		} else {
			System.out.println("TestCase Failed");
			return false;
		}

	}

	public boolean phoneCallFaculties() {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> person = personList;
		List<WebElement> wayToConnect = wayOfConnectList;
		int a = 0;
		for (WebElement element : wayToConnect) {
			if (element.getText().contains("Phone Call")) {
				String text = person.get(a).getText();
				actList.add(text);
			}
			a++;
		}

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Neelam");
		expList.add("Seema");
		expList.add("Varsha");

		if (actList.equals(expList)) {
			System.out.println("TestCase Passed.");
			return true;
		} else {
			System.out.println("TestCase Failed");
			return false;
		}

	}

	public boolean technicalFaculties() {
		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> person = personList;
		List<WebElement> facultyjob = forList;

		int a = 0;
		for (WebElement element : facultyjob) {
			if (element.getText().contains("Technical")) {
				String text = person.get(a).getText();
				System.out.println("Actual: " + text);
				actList.add(text);
			}
			a++;
		}

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Kiran");
		expList.add("Neelam");
		expList.add("Darshit");

		if (actList.equals(expList)) {
			System.out.println("TestCase Passed.");
			return true;
		} else {
			System.out.println("TestCase Failed");
			return false;
		}

	}
	
	
	public boolean facultyAvaiOnSatAndSun() {
		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> person = personList;
		List<WebElement> facultytime = FacultyTiming;

		int a = 0;
		for (WebElement element : facultytime) {
			if (element.getText().contains("Saturday-Sunday")) {
				String text = person.get(a).getText();
				System.out.println("Actual: " + text);
				actList.add(text);
			}
			a++;
		}

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Darshit");

		if (actList.equals(expList)) {
			System.out.println("TestCase Passed.");
			return true;
		} else {
			System.out.println("TestCase Failed");
			return false;
		}

	}
	
	public boolean facultyAvaiFrom09amTo06pm() {
		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> person = personList;
		List<WebElement> facultytime = FacultyTiming;

		int a = 0;
		for (WebElement element : facultytime) {
			if (element.getText().contains("09:00 AM to 06:00 PM ")) {
				String text = person.get(a).getText();
				System.out.println("Actual: " + text);
				actList.add(text);
			}
			a++;
		}

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Neelam");
		expList.add("Seema");
		expList.add("Varsha");

		if (actList.equals(expList)) {
			System.out.println("TestCase Passed.");
			return true;
		} else {
			System.out.println("TestCase Failed");
			return false;
		}

	}

}
