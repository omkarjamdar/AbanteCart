package abantecart.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class BuyProductThroughWishlist extends BaseTest  {
	
	public Logger logger;
	
	@BeforeClass
	public void loggerSetup() {
		driver.get("http://localhost/public_html/");
		logger = BaseTest.log4jSetup("BuyProductThroughWishlist");
	}

	@Test(priority=1)
	public void loginCall()
	{
		Utilities util = new Utilities();
		util.userLogin("user_test","pass", driver);
	}
	@Test(priority=2)
	public void accountCall()
	{
		AccountMainPageTest acc = new AccountMainPageTest();
		acc.accountSetup("AccountMainPageTest");
		acc.wishlistContinue();
	}
	@Test(priority=3)
	public void homePageCall()
	{
		HomePageTest home = new HomePageTest();
		home.homePageloggerSetup("HomePageTest");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		home.searchBar();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	@Test(priority=4)
	public void productPageCall()
	{
		ProductPageTest Product = new ProductPageTest();
		Product.ProductPageSetup("ProductPageTest");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Product.verifyProductAddToCart();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	@Test(priority=5)
	public void cartPageCall()
	{
		CartPageTest cart = new CartPageTest();
		cart.cartpagelogSetup();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		cart.proccedToCheckout();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	@Test(priority=6)
	public void checkoutPageCall()
	{
		CheckoutConfirmOrderTest checkout = new CheckoutConfirmOrderTest();
		checkout.checkoutlogSetup("CheckoutConfirmOrderTest");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		checkout.verifyConfirmOrderBtn();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
}
