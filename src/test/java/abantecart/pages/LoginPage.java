package abantecart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class LoginPage extends BaseTest
{
	Utilities util=new Utilities();
	//public WebDriver driver=util.browserSetup();

	By loginlink = By.xpath("//a[normalize-space()='Login or register']");
	public WebElement loginLink()
	{
	return driver.findElement(loginlink);
	}

	By loginname = By.id("loginFrm_loginname");
	public WebElement loginName()
	{
	return driver.findElement(loginname);
	}

	By password = By.id("loginFrm_password");
	public WebElement password()
	{
	return driver.findElement(password);
	}

	By loginbtn=By.cssSelector("button[title='Login']");
	public WebElement loginBtn()
	{
	return driver.findElement(loginbtn);
	}


}
