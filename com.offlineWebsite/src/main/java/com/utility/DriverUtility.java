package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class DriverUtility extends BaseClass {

	public static void waitForElement(WebElement element) {
		log.info("waiting for an element");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void switchToFrameById(String id) {
		driver.switchTo().frame(id);
	}

	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToWindow(String id) {
		driver.switchTo().window(id);
	}

}
