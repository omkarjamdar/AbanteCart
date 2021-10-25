package abantecart.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class BuyProductByLogin extends BaseTest
{
	public Logger logger;
	
	//WebDriver driver = SetupDriver.driver;
	@BeforeClass
	public void loggerSetup() {
		driver.get("http://localhost/public_html/");
		logger = BaseTest.log4jSetup("BuyProductByLogin");
	}
	
	
	@Test(priority=1)
	public void homePageCall()
	{
		//driver.get("http://localhost/public_html/");
		HomePageTest H = new HomePageTest();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//H.homePageloggerSetup("HomePageTest");
		H.searchBar();
		logger.info("Selected A Product");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	}
	
	@Test(priority=2)
	public void productPageCall()
	{
		ProductPageTest Product = new ProductPageTest();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Product.ProductPageSetup("ProductPageTest");
		//Product.clickAddToCart("2");
		Product.verifyProductAddToCart();
		logger.info("Added product to cart with quantity");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public void cartAndLoginPageCall()
	{
		CartPageTest cart = new CartPageTest();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cart.cartpagelogSetup();
		cart.proccedToCheckout();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Successfully proceeded to checkout");
		Utilities util = new Utilities();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.userLogin("user_test", "pass", driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Successfully logged in");
	}
	
	@Test(priority=4)
	public void checkoutPageCall()
	{
		CheckoutConfirmOrderTest checkout = new CheckoutConfirmOrderTest();
		checkout.checkoutlogSetup("CheckoutConfirmOrderTest");
		checkout.verifyConfirmOrderBtn();
		logger.info("Successfully checked out");
	}
}
