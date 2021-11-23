package com.jbk.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.objectRepository.UserObjectRepo;

public class UserPage extends UserObjectRepo{

	WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyHeader() {
		String actText = headerText.getText();
		String expTest = "Users";

		if (actText.equals(expTest)) {
			System.out.println("Header text is matching.");
			return true;
		} else {
			System.out.println("Header text is not matching.");
			return false;
		}

	}

	public boolean VerifyBoxHeader() {
		String actText = boxHeaderText.getText();
		String expTest = "User List";
		if (actText.equals(expTest)) {
			System.out.println("BoxHeader text is matching.");
			return true;
		} else {
			System.out.println("BoxHeader text is not matching.");
			return false;
		}

	}

	public boolean VerifyColumnName() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> actText = columnName;
		for (WebElement webElement : actText) {
			String text = webElement.getText();
			actList.add(text);
		}

		ArrayList<String> excelList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("UserPage");

		int count = 8;

		for (int i = 0; i < count; i++) {
			Cell cell = sh.getRow(0).getCell(i);
			String text = df.formatCellValue(cell);
			System.out.println(text);

			excelList.add(text);
		}
		if (actList.equals(excelList)) {
			System.out.println("TestCase passed-Column names are matching.");
			return true;
		} else {
			System.out.println("TestCase failed-Column names are not matching.");
			return false;
		}

	}

	public boolean verfyTotalNumberOfUser() throws Exception {
		List<WebElement> userList = userNames;

		ArrayList<String> actList = new ArrayList<String>();

		for (int i = 0; i < userList.size(); i++) {

			String text = userList.get(i).getText();
			actList.add(text);

		}

		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(input);
		Sheet sh = wb.getSheet("UserPage");
		int count = sh.getLastRowNum();

		for (int i = 1; i <= count; i++) {
			Cell cell = sh.getRow(i).getCell(1);
			String text = df.formatCellValue(cell);
			expList.add(text);
		}
		if (actList.equals(expList)) {
			System.out.println("TestCase passed");
			return true;
		} else {
			System.out.println("TestCase failed");
			return false;
		}

	}

	public boolean VerifyMaleUsers() {

		List<WebElement> genderList = genList;
		List<WebElement> userList = userNames;

		ArrayList<String> actList = new ArrayList<String>();
		actList.add("Kiran");
		actList.add("Sagar");

		ArrayList<String> expList = new ArrayList<String>();

		for (int i = 0; i < genderList.size(); i++) {
			if (genderList.get(i).getText().equals("Male")) {
				String name = userList.get(i).getText();
				System.out.println(name);
				expList.add(name);
			}
		}

		if (actList.equals(expList)) {
			System.out.println("Male users are matching");
			return true;
		} else {
			System.out.println("Male users are not matching");
			return false;
		}

	}

	public boolean VerifyFemaleUsers() throws Exception {

		List<WebElement> genderList = genList;
		List<WebElement> userList = userNames;

		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream input =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(input);
		Sheet sh = wb.getSheet("FemaleUsers");
		int count = sh.getLastRowNum();

		for (int i = 0; i <= count; i++) {
			Cell cell = sh.getRow(i).getCell(0);
			String text = df.formatCellValue(cell);
			expList.add(text);
		}

		ArrayList<String> actList = new ArrayList<String>();

		for (int i = 0; i < genderList.size(); i++) {
			if (genderList.get(i).getText().equals("Female")) {
				String text = userList.get(i).getText();
				actList.add(text);
			}
		}

		if (actList.equals(expList)) {
			System.out.println("Female users are matching");
			return true;
		} else {
			System.out.println("Female users are not matching");
			return false;
		}
	}

	public boolean VerifyStateUsers() throws Exception {

		List<WebElement> state = stateNames;
		List<WebElement> users = userNames;

		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\CoursesList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("UserPage");
		int count = sh.getLastRowNum();

		for (int i = 0; i <= count; i++) {

			Cell cell = sh.getRow(i).getCell(6);
			String text = df.formatCellValue(cell);

			if (text.contains("Maharashtra")) {
				Cell cell1 = sh.getRow(i).getCell(1);
				String text1 = df.formatCellValue(cell1);

				expList.add(text1);
			}
		}

		ArrayList<String> actList = new ArrayList<String>();

		for (int i = 0; i < state.size(); i++) {
			if (state.get(i).getText().equals("Maharashtra")) {
				String text = users.get(i).getText();
				actList.add(text);
			}
		}

		if (actList.equals(expList)) {
			System.out.println("Maharashtra state users are matching");
			return true;
		} else {
			System.out.println("Maharashtra state users are not matching");
			return false;
		}

	}

	public boolean verifyGmailUsers() throws Exception {

		ArrayList<String> expList = new ArrayList<String>();
		expList.add("kiran@gmail.com");
		expList.add("sagar@gmail.com");
		expList.add("monica@gmail.com");
		expList.add("kimaya@gmail.com");

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> gmail = gmailList;

		for (int i = 0; i < gmail.size(); i++) {
			String mail = gmail.get(i).getText();
			if (mail.contains("@gmail.com")) {
				actList.add(mail);
			}
		}
		System.out.println("valid gmail users: " + actList);

		if (actList.equals(expList)) {
			System.out.println("all users having correct gmail");
			return true;
		} else {
			System.out.println("some users having incorrect gmail");
			return false;
		}

	}

	public boolean VerifyKiranCourse() throws Exception {

		List<WebElement> courses = courseList;
		List<WebElement> users =userNames;

		ArrayList<String> actList = new ArrayList<String>();

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getText().equals("Kiran")) {
				String text = courses.get(i).getText();
				System.out.println(text);
				actList.add(text);
			}
		}

		ArrayList<String> expList = data(System.getProperty("user.dir")+"\\src\\test\\resources\\CoursesList.xlsx", "UserPage", 1, 4, "Kiran");

		if (actList.equals(expList)) {
			System.out.println("Kiran having Java/J2EE course");
			return true;
		} else {
			System.out.println("Test Case:Failed");
			return false;
		}

	}

	public boolean VerifySagarState() throws Exception {
		List<WebElement> state = stateNames;
		List<WebElement> users = userNames;

		ArrayList<String> actList = new ArrayList<String>();

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getText().equals("Sagar")) {
				String text = state.get(i).getText();
				System.out.println(text);
				actList.add(text);
			}
		}

		ArrayList<String> expList = data(System.getProperty("user.dir")+"\\src\\test\\resources\\CoursesList.xlsx", "UserPage", 1, 6, "Sagar");

		if (actList.equals(expList)) {
			System.out.println("Test case:Passed-Sagar from Punjab");
			return true;
		} else {
			System.out.println("Test Case:Failed");
			return false;
		}

	}

	public boolean CheckInvalidMobileUsers() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();

		List<WebElement> users = userNames;
		List<WebElement> mobile = mobList;

		for (int i = 0; i < mobile.size(); i++) {
			String mob = mobile.get(i).getText();
			char[] c = mob.toCharArray();
			int lenght = c.length;

			if (lenght < 10) {
				String text = users.get(i).getText();
				actList.add(text);
			}
		}
		
		ArrayList<String> expList = new ArrayList<String>();
		expList.add("Sagar");
		expList.add("Kimaya");
		
		System.out.println("invalid mobile users: " + actList);
		
		if (actList.equals(expList)) {
			System.out.println("Test case:Passed");
			return true;
		} else {
			System.out.println("Test Case:Failed");
			return false;
		}

	}

	public AddUserPage clickOnAddUser() {
		addUserBtn.click();
		return new AddUserPage(driver);
	}

	public ArrayList<String> data(String filePath, String SheetName, int refColNumber, int OutputColNumber, String txt)
			throws Exception {
		ArrayList<String> expList = new ArrayList<String>();

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();

		for (int i = 0; i <= count; i++) {

			Cell cell = sh.getRow(i).getCell(refColNumber);
			String text = df.formatCellValue(cell);

			if (text.contains(txt)) {
				Cell cell1 = sh.getRow(i).getCell(OutputColNumber);
				String text1 = df.formatCellValue(cell1);
				System.out.println(text1);
				expList.add(text1);
			}
		}
		return expList;
	}

}
