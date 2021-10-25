package abantecart.testcase;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;



public class LoginThroughBuyProduct extends BaseTest
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
	public void productPage()
	{
	ProductPageTest Product = new ProductPageTest();
	Product.verifyProductAddToCart();
	}

	@Test(priority=3)
	public void cartPage()
	{
		CartPageTest cart = new CartPageTest();
		cart.proccedToCheckout();

	}

	@Test(priority=4)
	public void checkoutPage()
	{
		CheckoutConfirmOrderTest checkout = new CheckoutConfirmOrderTest();
		checkout.checkoutlogSetup("CheckoutConfirmOrderTest");
		checkout.verifyConfirmOrderBtn();
	}
}