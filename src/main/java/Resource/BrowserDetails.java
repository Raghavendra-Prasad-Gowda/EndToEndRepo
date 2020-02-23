package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserDetails {
	public static Logger log = LogManager.getLogger(BrowserDetails.class.getName());
	private static WebDriver driver;
	
	
	public WebDriver InitializeBrowserName() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Udemy_Selenium\\E2EProject\\src\\main\\java\\Resource\\Configuration.txt");
		prop.load(fis);
	
		String BrowserName=System.getProperty("browser");
		//String BrowserName="Chrome";
		if (BrowserName.trim().equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramprakash\\Desktop\\chromedriver.exe");
			ChromeOptions ops=new ChromeOptions();
			ops.addArguments("headless");
			driver = new ChromeDriver(ops);

		} else if (BrowserName.trim().equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ramprakash\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser Name Should be either Chrome or Firefox");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;

	}

	public void screenshot(String Name) throws IOException {
		//System.out.println(driver);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Udemy_Selenium\\E2EProject\\Screenshots\\" + Name + ".png"));
	}

}
