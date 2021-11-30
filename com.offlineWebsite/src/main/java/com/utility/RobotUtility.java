package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotUtility {
	
Robot r=null;
	
	//click enter
	public void pressEnterKey() {
		try {
			 r =  new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
	}	
	//press tab
		public void pressTabKey() {
			try {
				 r =  new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			r.keyPress(KeyEvent.VK_TAB);
		}

}
