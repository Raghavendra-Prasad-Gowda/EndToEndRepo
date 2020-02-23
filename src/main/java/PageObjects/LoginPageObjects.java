package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	private WebDriver driver;
	
	//Constructor
	public LoginPageObjects(WebDriver driver1){
		this.driver=driver1;
	}
	
	
	//UserName Object
	private By UserName=By.xpath("//div[@class='_39M2dM JB4AMj']  //input[@type='text']");
	
	//Password Object
	private By Password=By.xpath("//div[@class='_39M2dM JB4AMj']  //input[@type='password']");
	
	//Login Button
	private By Login=By.xpath("//div[@class='_1avdGP']  //button[@type='submit']");
	
	//Close Button
	private By Close=By.xpath("//div[@class='_3Njdz7']  //button[@class='_2AkmmA _29YdH8']");
	
	//Heading
	private By DealsoftheDayText=By.xpath("(//h2[@class='puxlXr'])[1]");
	
	//TestObject For Google Search Button
	private By GoogleSearchButton= By.xpath("(//input[@class='gNO89b'])[2]");
	
	
	//Methods to return the Objects
	public WebElement UserNameFeild() {
		return driver.findElement(UserName);
	}
	
	public WebElement PasswordFeild() {
		return driver.findElement(Password);
	}
	
	public WebElement LoginButton() {
		return driver.findElement(Login);
	}
	
	public WebElement CloseButton() {
		return driver.findElement(Close);
	}
	
	
	public WebElement DealsoftheDay() {
		return driver.findElement(DealsoftheDayText);
	}
	
	public WebElement GoogleSearch() {
		return driver.findElement(GoogleSearchButton);
	}
	
}
