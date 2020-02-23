package TestCases;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.collections4.FactoryUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker.Arguments;

import PageObjects.LoginPageObjects;
import Resource.BrowserDetails;

public class FlipKartHomePage {
	public static Logger FilpkartHomeLogs = LogManager.getLogger(FlipKartHomePage.class.getName());
	private WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws IOException {

		BrowserDetails browser = new BrowserDetails();

		FilpkartHomeLogs.info("Initialized browser");
		FilpkartHomeLogs.error("Test");
		driver=browser.InitializeBrowserName();
		

	}

	@Test
	public void NavigateToHomePage() throws IOException, InterruptedException {

		driver.get("https://flipkart.com");
		
		FilpkartHomeLogs.info("Opening the URL ");
		LoginPageObjects LogObj = new LoginPageObjects(driver);

		LogObj.CloseButton().click();
		FilpkartHomeLogs.info("X button clicked");
		System.out.println(LogObj.DealsoftheDay().getText());
		//Assert.assertTrue(false);
		FilpkartHomeLogs.isErrorEnabled();
	}

	@DataProvider
	public Object[][] GetCredentials() throws IOException {

		FileInputStream fis1 = new FileInputStream("C:\\Users\\Ramprakash\\Desktop\\FlipKart.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis1);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int i = sheet.getLastRowNum();
		int j = sheet.getRow(0).getLastCellNum();

		Object[][] credentials = new Object[i][j];

		for (int k = 0; k < sheet.getLastRowNum(); k++) {

			credentials[k][0] = sheet.getRow(k).getCell(0).getStringCellValue();
			credentials[k][1] = sheet.getRow(k).getCell(1).getStringCellValue();
		}

		return credentials;
	}

	

	@AfterTest
	public void CloseBrowser() {
		driver.close();
		driver = null;

	}

}
