package abantecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.Utilities;

public class CheckoutConfirmOrderPage {

	public WebDriver driver;
	public CheckoutConfirmOrderPage(WebDriver driver)
	{
		this.driver=driver;
	}

	Utilities util = new Utilities();
	//public WebDriver driver = util.browserSetup();
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
