package abantecart.pages;
import java.sql.Driver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import abantecart.utility.*;

public class RegisterPage extends BaseTest {
	Utilities util = new Utilities();
	//public WebDriver driver;
	/*public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}*/
	//Utilities utility=new Utilities();
	//public WebDriver driver=utility.browserSetup();
	
	By registerlink = By.xpath("//a[normalize-space()='Login or register']");
	
	public WebElement registerLink()
	{
		return driver.findElement(registerlink);
	}
	
	By registercontinue = By.xpath("//button[@title='Continue']");
	
	public WebElement registerContinue()
	{
		return driver.findElement(registercontinue);
	}
	
	By registerfirstname = By.id("AccountFrm_firstname");
	
	public WebElement registerFirstName()
	{
		return driver.findElement(registerfirstname);
	}
	
	By registerlastname = By.id("AccountFrm_lastname");
	
	public WebElement registerLastName()
	{
		return driver.findElement(registerlastname);
	}
	
	By registeremail = By.id("AccountFrm_email");
	
	public WebElement registerEmail()
	{
		return driver.findElement(registeremail);
	}
	
	By registeraddress = By.id("AccountFrm_address_1");
	
	public WebElement registerAddress()
	{
		return driver.findElement(registeraddress);
	}
	
	By registercity = By.id("AccountFrm_city");
	
	public WebElement registerCity()
	{
		return driver.findElement(registercity);
	}
	
	By registerstate = By.id("AccountFrm_zone_id");
	
	public WebElement registerState()
	{
		return driver.findElement(registerstate);
	}
	
	/*By registerstateselect = By.id("AccountFrm_zone_id");
	
	public WebElement registerStateSelect()
	{
		return driver.findElement(registerstate);
	}*/
	
	By registerzipcode = By.id("AccountFrm_postcode");
	
	public WebElement registerZipCode()
	{
		return driver.findElement(registerzipcode);
	}
	
	By registercountry = By.id("AccountFrm_country_id");
	
	public WebElement registerCountry()
	{
		return driver.findElement(registercountry);
	}
	
	
	By registerloginname = By.id("AccountFrm_loginname");
	
	public WebElement registerLoginName()
	{
		return driver.findElement(registerloginname);
	}
	
	By registerpassword = By.id("AccountFrm_password");
	
	public WebElement registerPassword()
	{
		return driver.findElement(registerpassword);
	}
	By registerconfirmpassword = By.id("AccountFrm_confirm");
	
	public WebElement registerConfirmPassword()
	{
		return driver.findElement(registerconfirmpassword);
	}
	
	By registersubscribeyes = By.id("AccountFrm_newsletter1");
	public WebElement registerSubscribeYes()
	{
		return driver.findElement(registersubscribeyes);
	}
	
	By registersubscribeno = By.id("AccountFrm_newsletter0");
	public WebElement registerSubscribeNo()
	{
		return driver.findElement(registersubscribeno);
	}
	
	By registeragree = By.id("AccountFrm_agree");
	public WebElement registerAgree()
	{
		return driver.findElement(registeragree);
	}
	
	By registercontinuenext = By.xpath("//button[@title='Continue']");
	public WebElement registerContinueNext()
	{
		return driver.findElement(registercontinuenext);
	}
	
	/*By registerlogofflink = By.xpath("//div[@class='menu_text']");
	public WebElement registerLogofflink()
	{
		return driver.findElement(registerlogofflink);
	}
	*/
	By registerlogoff = By.xpath("//a[normalize-space()='Logoff']");
	public WebElement registerLogoff()
	{
		return driver.findElement(registerlogoff);
	}
	
	public void Logofflink()
	{
		driver.get("http://localhost/public_html/index.php?rt=account/logout");
	}
	
	//li[normalize-space()='']//a[contains(@href,'http://localhost/public_html/index.php?rt=account/logout')]

}

