package abantecart.testcase;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;



public class LoginThroughLatestProduct extends BaseTest
{
	public Logger logger;

	@BeforeClass
	public void loggerSetup() 
	{
		driver.get("http://localhost/public_html/");
		logger = BaseTest.log4jSetup("LoginThroughBuyProduct");
	}

	@Test(priority=1)
	public void login()
	{
	Utilities util = new Utilities();
	util.userLogin("user_test", "pass", driver);
	driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	HomePageTest H = new HomePageTest();
	H.homePageloggerSetup("HomePageTest");
	H.searchBar();
	}

	@Test(priority=2)
	public void productPageCall()
	{
		ProductPageTest Product = new ProductPageTest();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Product.ProductPageSetup("ProductPageTest");
		//Product.clickAddToCart("2");
		Product.verifyLatestProductAdd();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Product.cartadd();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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