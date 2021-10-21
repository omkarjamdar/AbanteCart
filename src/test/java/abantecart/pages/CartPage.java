package abantecart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abantecart.utility.Utilities;

public class CartPage {

	Utilities util;
	public WebDriver driver;
	WebDriverWait wait;
	
public CartPage(WebDriver driver)
{
	this.driver=driver;
	
}
	
	By link= By.linkText("CART");
	By panel= By.className("contentpanel");
	By qty= By.cssSelector("input[name='quantity[116:9b9ef07a257e0fcf2db57360b3b1675b]']");
	By coupon=By.cssSelector("#coupon_coupon");
	//By coupon = (By) wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#coupon_coupon")));

	By applyCoupon=By.cssSelector("#apply_coupon_btn");
	By checkout= By.id("cart_checkout1");
	//driver.findElement(By.xpath()).click();
	By update= By.xpath("\"//button[@id='cart_update']\"");
	By success= By.className("alert.alert-success");
	
	public WebElement cartLink() 
	{	
		return driver.findElement(link);
	}
	public String contentPanel()
	{
		return (driver.findElement(panel).getText());
	}
	public WebElement quantityBox()
	{
//		wait = new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(qty));
		return(driver.findElement(qty));
	}
	public WebElement couponBox()
	{
		//WebElement w=  wait.until(ExpectedConditions.elementToBeClickable(coupon));
		return(driver.findElement((coupon)));
	}
	public WebElement applyCouponButton()
	{
		return(driver.findElement(applyCoupon));
	}
	public WebElement checkoutButton()
	{
		return(driver.findElement(checkout));
	}
	public WebElement updateButton()
	{
		return(driver.findElement(update));
	}
	public WebElement successPanel()
	{
		return(driver.findElement(success));
	}
}


