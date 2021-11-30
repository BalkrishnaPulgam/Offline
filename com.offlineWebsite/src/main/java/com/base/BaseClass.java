package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import com.jbk.pages.LoginPage;

public class BaseClass {

	public static WebDriver driver = null;
	FileInputStream fis = null;
	
	
	public static Logger log=Logger.getLogger(BaseClass.class);

	public String readProperty(String key) {
		log.info("reading a value for a property: "+key);
		Properties prop = new Properties();

		try {
			log.info("initializing property file");
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			log.error("invalid property file path");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(prop.getProperty(key)!=null) {
			log.info("proerty value found in the file with key as: "+key+" and value is: "+prop.getProperty(key));
			return prop.getProperty(key);
		}else {
			return "proper value not found for"+key;
		}

	}

	public void launchApplication() {
		log.info("Launching an Application..");
		driver.get(readProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(readProperty("pageload")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(readProperty("pageload")), TimeUnit.SECONDS);
	}

	public WebDriver initialization() {
		if (readProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readProperty("chromeDriverfilePath"));
			driver = new ChromeDriver();
			log.info("Chrome Browser initialized...");
			launchApplication();
		}
		if (readProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readProperty("geckoDriverfilePath"));
			driver = new FirefoxDriver();
			log.info("Firefox Browser initialized...");
			launchApplication();

		}
		return driver;
	}

	public LoginPage loadLoginPage() {
		LoginPage lp = new LoginPage(driver);
		return lp;
	}

	public String getScreenshot(String testCaseName) {
		log.info("test case failed and taking screenshot");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm--ss");
		String name = testCaseName + "--" + sdf.format(new Date());
		String path = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + name + ".jpj";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("screenshot saved in the project directory");
		return path;
	}

}
