package com.jbk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.jbk.objectRepository.LoginObjectRepo;

public class LoginPage extends LoginObjectRepo {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLogo() {
		Boolean status = image.isDisplayed();
		if (status == true) {
			System.out.println("image is present");
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyingHeadingText() {

		String act = headingText.getText();
		System.out.println("Actual: " + act);
		String exp = "Java By Kiran";
		System.out.println("Expected: " + exp);
		if (act.equals(exp)) {
			System.out.println("Heading text is matching");
			return true;
		} else {
			System.out.println("Not match");
			return false;
		}
	}

	public String verifyBrowserTitle() {
		return driver.getTitle();

	}

	public DashboardPage verifyValidLogin() {
		email.clear();
		pass.clear();
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		button.click();

		return new DashboardPage(driver);

	}

	public boolean verifyCoursesText() {
		String act = courseText.getText();
		System.out.println("Actual: " + act);
		String exp = "JAVA | SELENIUM | PYTHON";
		System.out.println("Expected: " + exp);
		if (act.equals(exp)) {
			System.out.println("Course Text is Match");
			return true;
		} else {
			System.out.println("Not match");
			return false;
		}

	}

	public boolean verifyPasswordSuggestion() {
		email.clear();
		pass.clear();
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("12345");
		button.click();
		String act = passError.getText();
		System.out.println("Actual Suggestion :" + act);
		String exp = "Please enter password 123456";
		System.out.println("Expected Suggestion :" + exp);

		if (act.equals(exp)) {
			System.out.println("Password suggestion is matching");
			return true;
		} else {
			System.out.println("Password suggestion is not matching");
			return false;
		}

	}

	public boolean verifyEmailSuggestion() {
		email.clear();
		pass.clear();
		email.sendKeys("kiran@gmail.com1");
		pass.sendKeys("123456");
		button.click();
		String act = emailError.getText();
		System.out.println("Actual Suggestion :" + act);
		String exp = "Please enter email as kiran@gmail.com";
		System.out.println("Expected Suggestion :" + exp);

		if (act.equals(exp)) {
			System.out.println("Email suggestion is matching");
			return true;
		} else {
			System.out.println("Email suggestion is not matching");
			return false;
		}

	}

	public RegistrationPage clickOnRegistrationLink() {
		driver.findElement(By.partialLinkText("Register")).click();
		return new RegistrationPage(driver);

	}

}
