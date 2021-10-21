package abantecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.Utilities;

public class ForgotPasswordPage {
	Utilities util = new Utilities();
	public WebDriver driver = util.browserSetup();

	By loginlink = By.xpath("//a[normalize-space()='Login or register']");

	public WebElement loginLink() {
		return driver.findElement(loginlink);
	}
	
	By forgotPassLink = By.xpath("//a[normalize-space()='Forgot your password?']");
	
	public WebElement forgotPasswordLink()
	{
		return driver.findElement(forgotPassLink);
	}
	
	By loginname = By.id("forgottenFrm_loginname");
	public WebElement loginname() 
	{
		return driver.findElement(loginname);
	}
	
	By emailID =By.id("forgottenFrm_email");
	public WebElement email() 
	{
		return driver.findElement(emailID);
	}
	
	By continuebtn =By.cssSelector("button[title='Continue']");
	public WebElement continueBtn() 
	{
		return driver.findElement(continuebtn);
	}
	
	By backbtn = By.xpath("//a[@title='Back']");
	public WebElement backBtn()
	{
	return driver.findElement(backbtn);
	}
}
