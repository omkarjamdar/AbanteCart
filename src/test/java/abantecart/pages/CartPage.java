package abantecart.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class CartPage extends BaseTest{

	Utilities util;
	//public WebDriver driver;
	WebDriverWait wait;
	
public CartPage()
{
	util=new Utilities();
	//driver=util.browserSetup();
}

	
	By link= By.linkText("CART");
	By panel= By.className("contentpanel");
					   	
	By coupon=By.cssSelector("#coupon_coupon");

	By applyCoupon=By.cssSelector("#apply_coupon_btn");
	By checkout= By.xpath("(//a[@id='cart_checkout1'])[1]");
	
	
	
	public WebElement cartLink() 
	{	
		return driver.findElement(link);
	}
	public String contentPanel()
	{
		return (driver.findElement(panel).getText());
	}
	
	By qty= By.xpath("//input[@value=\"5\"]");
	public WebElement quantityBox()
	{
		return(driver.findElement(qty));
	}
	public WebElement couponBox()
	{
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
	
	By update= By.xpath("//button[@id='cart_update']");
	public WebElement updateButton()
	{
		return(driver.findElement(update));
	}
	
	By success= By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div");
	public WebElement successPanel()
	{
		return(driver.findElement(success));
	}
	
	By price= By.xpath("//tbody/tr[2]/td[6]");
	public String getPrice()
	{
		return (driver.findElement(price).getText());
	}
	public String getQuantity()
	{
	String value=	driver.findElement(qty).getAttribute("value");
	return value;
	}
	
	
	By remove= By.xpath("//tbody/tr[2]/td[7]/a[1]");
	public WebElement removeProduct()
	{
		return(driver.findElement(remove));
	}
	
	
	By unitPrice= By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]");
	By totalPrice=By.xpath("//tbody/tr[2]/td[6]");
	public Double getUnitPrice()
	{
		String value=driver.findElement(unitPrice).getText();
		value=value.substring(1);
		return Double.parseDouble(value);
	}
	public Double getTotalPrice()
	{
	Double value=Double.parseDouble(driver.findElement(totalPrice).getText().substring(1));
	return value;
	}
	
	
	By dropDownCountry=By.id("estimate_country");
	By dropDownState = By.xpath("//select[@id=\"estimate_country_zones\"]");
	
	public WebElement selectCountry()
	{
		return driver.findElement(dropDownCountry);
	}
	public WebElement selectState()
	{
		return driver.findElement(dropDownState);
	}
	
	public String getCountryName()
	{
		Select countryName=new Select(selectCountry());
		WebElement country=	 countryName.getFirstSelectedOption();
		
		return(country.getText());
	}
	public String getStateName()
	{	Select stateName= new Select(selectState());
		WebElement state=	 stateName.getFirstSelectedOption();
		return(state.getText());
	}
	public void changeCountry(String name) {
		Select countryName=new Select(selectCountry());
		countryName.selectByVisibleText(name);
	}
	
	By postCode= By.xpath("//input[@id=\"estimate_postcode\"]");
	public WebElement postalCode()
	{
		return(driver.findElement(postCode));
	}
	By estimate= By.xpath("//button[@value=\"estimate\"]");
	public WebElement estimateButton()
	{
		return(driver.findElement(estimate));
	}
	
	By shipping= By.xpath("//select[@id=\"shippings\"]");
	
	public String getShippingRateDropDown() {
		WebElement shippingRate=driver.findElement(shipping);
		Select rate= new Select(shippingRate);
		shippingRate= rate.getFirstSelectedOption();
		return (shippingRate.getText());
	}
	
	

}


