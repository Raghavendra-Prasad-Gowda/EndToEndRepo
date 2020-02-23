package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;
import Resource.BrowserDetails;

public class DemoTestCase2 {

	public static Logger TestLogs1 = LogManager.getLogger(DemoTestCase2.class.getName());
	private static WebDriver driver;
	@BeforeTest
	public void OpenBrowser() throws IOException {
		
		BrowserDetails bd=new BrowserDetails();
	    driver=bd.InitializeBrowserName();
	}

	@Test
	public void DemoTest1() {
		TestLogs1.info("TC1");
		
	}

	@Test
	public void DemoTest2() {
		TestLogs1.info("TC2");
	driver.get("https://google.com");
		
		
	
	}

	@Test
	public void DemoTest3() {
		TestLogs1.info("TC3");
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.close();
		driver=null;
		TestLogs1.info("Browser Close");
	}

}
