package abantecart.testcase;


import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import abantecart.pages.CartPage;
import abantecart.utility.Utilities;

public class CartPageTest {

	CartPage cartobj;
	WebDriverWait wait;
	Utilities util;
	WebDriver driver;
	public Logger logger;
	public String expectedError;
	public String message;
	
	public CartPageTest(WebDriver driver)
	{
		this.driver = driver;
		cartobj= new CartPage(driver);
		//driver=cartobj.driver;					Temporary Commented
		
	}
	
	
	//@BeforeClass
	public void setup()
	{
		//cartobj= new CartPage(driver);
		driver=cartobj.driver;
		util=new Utilities();
		util.userLogin("user_test", "pass",driver);
		logger = util.log4jSetup("CartPageTest");
	}
	@Test(priority=0)
	public void checkCart()
	{

		cartobj.cartLink().click();
		String check= cartobj.contentPanel();
				
//		(check.contains("cart is empty")) ? System.out.print("Cart is empty") : System.out.print("Products in Cart");
//		
		if(check.contains("cart is empty"))
		{
			logger.info("Cart is empty");
		}
		else
		{
			logger.info("Products in Cart");
		}
		 
	}
	@Test(priority=1)
	public void changeQuantity() throws InterruptedException
	{ 
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//util.scoller(0, 400, driver);
		cartobj.quantityBox().click(); 
	 	cartobj.quantityBox().clear(); 
	 	cartobj.quantityBox().sendKeys("5");
	 	Thread.sleep(3000);
	 	cartobj.updateButton().click();
	 	Thread.sleep(3000);
	 	logger.info("5 quantities selected");
	}
	@Test(priority=2)
	public void applyCoupon() throws InterruptedException
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//util.scoller(0, 500, driver);
		System.out.print("Scrolled");
		Thread.sleep(1000);
		cartobj.couponBox().sendKeys("2222");
		cartobj.applyCouponButton().click();
		Thread.sleep(3000);
		logger.info("Coupon Applied Successfully");
		
//		String check= cartobj.successPanel().getText();
//		System.out.print(check);
//		
	}
	@Test(priority=3)
	public void proccedToCheckout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		cartobj.checkoutButton().click();
		logger.info("Proceeded to Checkout");
		
	}

	
	
	
	
	
		

	}

