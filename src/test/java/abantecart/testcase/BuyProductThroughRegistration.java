package abantecart.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.utility.BaseTest;

public class BuyProductThroughRegistration extends BaseTest{
	public Logger logger;
	@BeforeClass
	public void loggerSetup() {
		driver.get("http://localhost/public_html/");
		logger = BaseTest.log4jSetup("BuyProductThroughRegistration");
	}
	
	@Test(priority=1)
	public void homePageCall()
	{
		//driver.get("http://localhost/public_html/");
		HomePageTest H = new HomePageTest();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		H.homePageloggerSetup("HomePageTest");
		H.searchBar();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	}
	
	@Test(priority=2)
	public void productPageCall()
	{
		ProductPageTest Product = new ProductPageTest();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Product.ProductPageSetup("ProductPageTest");
		//Product.clickAddToCart("2");
		Product.verifyProductAddToCart();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public void cartPageCall()
	{
		CartPageTest cart = new CartPageTest();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cart.cartpagelogSetup();
		cart.proccedToCheckout();
	}
	
	@Test(priority=4)
	public void registerPageCall() throws InterruptedException
	{
		RegisterPageTest reg = new RegisterPageTest();
		reg.sheetDeclare(2);
		reg.registerSetup();
		reg.Registration_Integration();
	}
	
	@Test(priority=5)
	public void checkoutPageCall()
	{
		CheckoutConfirmOrderTest checkout = new CheckoutConfirmOrderTest();
		checkout.checkoutlogSetup("CheckoutConfirmOrderTest");
		checkout.verifyConfirmOrderBtn();
	}
	
	

}
