package abantecart.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import abantecart.utility.Utilities;

public class Runner extends SetupDriver 
{
	
	//WebDriver driver = SetupDriver.driver;
	@Test(priority=1)
	public void caller()
	{
		driver.get("http://localhost/public_html/");
		HomePageTest H = new HomePageTest(driver);
		H.searchBar();
			
	}
	
	@Test(priority=2)
	public void caller1()
	{
		ProductPageTest Product = new ProductPageTest(driver);
		Product.verifyAddToCart();
	}
	
	@Test(priority=3)
	public void caller3()
	{
		CartPageTest cart = new CartPageTest(driver);
		cart.proccedToCheckout();
		Utilities util = new Utilities();
		util.userLogin("Shetty_3579", "asdf1234", driver);
	}
	
	@Test(priority=4)
	public void caller4()
	{
		CheckoutConfirmOrderTest checkout = new CheckoutConfirmOrderTest(driver);
		checkout.verifyConfirmOrderBtn();
	}
}
