package abantecart.testcase;


import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import abantecart.pages.CartPage;
import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class CartPageTest extends BaseTest {

	CartPage cartobj= new CartPage();
	WebDriverWait wait;
	//Utilities util;
	public Logger logger;
	public int var=0;
	//WebDriver driver;
	
	
	
	@BeforeClass
	public void setup()
	{
		var=1;
		driver.get("http://localhost/public_html/");
		//driver=cartobj.driver;
		//util=new Utilities();
		userLogin("user_test", "pass",driver);
		logger = BaseTest.log4jSetup("CartPageTest");
	}
	
	public void cartpagelogSetup()
	{
		cartobj= new CartPage();
		//logger = BaseTest.log4jSetup(className);
	}
	
	
	
	@Test(priority=0, description="Check cart empty or not !")
	public void checkCart()
	{

		cartobj.cartLink().click();
		String check= cartobj.contentPanel();										//check get text from contentPanel

		if(check.contains("cart is empty")){
			if(var==1)
			logger.info("Cart is empty");}
		else{
			if(var==1)
			logger.info("Products in Cart");}
	}
	
	  @Test(priority=1,description="Verify Change in Quantity")
		public void changeQuantity() 
		{ 
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,400)");								     //Scrolling
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			cartobj.quantityBox().click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			cartobj.quantityBox().clear(); 												 //clear Quantity
			logger.info(cartobj.getQuantity());
		 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	cartobj.quantityBox().sendKeys("5");  
		 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	cartobj.updateButton().click();												 // updated quantity
		 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 	if(var==1)
		 		logger.info(cartobj.getQuantity());									//check for updated quantity
		 	
		}
	  
	  @Test(priority=2,description="Verify Change in Quantity and Price")
		public void changeQuantityAndPrice() 
		{
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,400)");										// scrolled
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			cartobj.quantityBox().click(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			cartobj.quantityBox().clear(); 			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Double price=cartobj.getUnitPrice();	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				// fetch unit price
			
			if(var==1)
			logger.info(price);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			cartobj.quantityBox().sendKeys("5");  
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	//if unit price * value = total
			cartobj.updateButton().click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Double totalPrice=cartobj.getTotalPrice();										//check for updated totalPrice
					
			
		}
	  @Test(priority=3,description="Verify Coupon has been Appiled !!")
		public void applyCoupon() 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,450)");										//scrolled
			
			
			cartobj.couponBox().sendKeys("2222");
			cartobj.applyCouponButton().click();											// coupon applied
			//wait
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String check=cartobj.successPanel().getText();									//check for Success Panel
			if(var==1)
			logger.info(check);
		}
	  
		@Test(priority=4,description="Verify Change in Country, Deselects State Value")
		public void changeCountry() 
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");	
		
		if(var==1)
		{logger.info(cartobj.getCountryName());										//Check name of Country
		logger.info(cartobj.getStateName());}											//check name of State
				
		cartobj.changeCountry("India");
		
		if(var==1)
		{logger.info(cartobj.getCountryName());										//check updated name
		logger.info(cartobj.getStateName());}
		
		
		}
	  
	@Test(priority=5,description="Verify Estimation with change in ZIP code")
	public void estimation()
	{
		cartobj.postalCode().clear();;														//clear postal code
		
		cartobj.postalCode().sendKeys("112332");											//send postal code
		
		cartobj.estimateButton().click();													
		
		String value= cartobj.getShippingRateDropDown();									//check estimated value
		if(var==1)
		logger.info(value);
	}

	
	@Test(priority=6,description="Verify Proceed to Checkout")
	public void proccedToCheckout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;			
		js.executeScript("window.scrollBy(0,750)");								
				cartobj.checkoutButton().click();											//procced to checkout
		if(var==1)
		logger.info("Successfully proceeded to checkout");
		
	}

// 	@Test(priority=2)
//	public void removeproduct()
//	{
//		cartobj.removeProduct().click();
//	}
//	
//	@AfterTest
//	public void afterTest()
//	{
//		driver.quit();
//	}
	
	

	}

