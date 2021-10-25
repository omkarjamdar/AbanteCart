package abantecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class CheckoutConfirmOrderPage extends BaseTest{
	
	Utilities utilitiesObj=new Utilities();	
	//public WebDriver driver=utilitiesObj.browserSetup();;
	public By shippingadderess=By.xpath("(//address)[1]");
	public By checkout=By.xpath("//*[@id=\"main_menu_top\"]/li[4]/a");
	public By addressbook=By.xpath("/html/body/div/div[2]/div/div[1]/div/ul/li[3]/a");
	public By addressinbook=By.xpath("(//address)[1]");
	public By backbtn=By.xpath("//*[@id=\"back\"]");
	public By returnpolicylink=By.xpath("//b[normalize-space()='Return Policy']");
	public By returnpolicyclosebtn=By.xpath("//button[normalize-space()='Close']");
	public By editcartbtn=By.xpath("//a[normalize-space()='Edit Cart']");
	
	public WebElement checkOut() {
		return driver.findElement(checkout);
	}
	
	public WebElement shippingAddress()
	{
		return driver.findElement(shippingadderess);
	}
	
	public WebElement addressFromBook() {
		driver.navigate().back();
		driver.findElement(addressbook).click();
		return driver.findElement(addressinbook);
	}
	
	public WebElement backBtn() {
		return driver.findElement(backbtn);
	}
	
	public WebElement returnPolicyLink() {
		return driver.findElement(returnpolicylink);
		
	}
	
	public WebElement returnPolicyCloseBtn() {
		return driver.findElement(returnpolicyclosebtn);
	}
	
	public WebElement editCartBtn() {
		return driver.findElement(editcartbtn);
	}
	
	By checkoutbtn = By.xpath("//span[normalize-space()='Checkout']");

	public WebElement checkoutbtn() {
		return driver.findElement(checkoutbtn);
	}
	By confirmorderbtn=By.xpath("//button[@id='checkout_btn']");
	public WebElement confirmorderbtn() {
		return driver.findElement(confirmorderbtn);
	}
	//By finalmsg=By.xpath("//span[@class='subtext']");
	public String finalmsg() {
		return driver.getTitle();
	}
}
