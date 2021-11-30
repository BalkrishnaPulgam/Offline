package com.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.base.BaseClass;

public class AlertUtility extends BaseClass{
	
	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void AcceptAlert() {
		getAlert().accept();
	}

	public void DismissAlert() {
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void DismissAlertIfPresent() {
		if (!isAlertPresent())
			return;
		DismissAlert();
	}

	public void AcceptPrompt(String text) {
		if (!isAlertPresent())
			return;
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
	}

}
