package abantecart.testcase;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import abantecart.pages.VerifyCartWithCheckoutPage;
import abantecart.utility.BaseTest;
public class VerifyCartWithCheckoutTest extends BaseTest {



	VerifyCartWithCheckoutPage cartcheckobj;
	AccountMainPageTest acc = new AccountMainPageTest();

	@BeforeClass()
	public void setup()
	{
		cartcheckobj=new VerifyCartWithCheckoutPage();

		driver.get("http://localhost/public_html/");
		userLogin("user_test", "pass",driver);

	}
	//Method to check cart product with checkout
	@Test
	public  void verifyCartWithCheckout()
	{

		int flag=1;
		List<WebElement> cartprodwebelelist = null;
		List<String> cartproductlist=new ArrayList<String>();
		//Checking Cart is clickable
		if(verifyCartBtnClickable())
		{
			System.out.println("cart is clickable ");
			cartbtn.click();
			if(checkCartEmpty())
			{
				System.out.println("Cart is Empty");

			}
			else
			{
				cartprodwebelelist=driver.findElements(By.cssSelector(".table tr td:nth-child(2) a"));
				for(int i=0;i<cartprodwebelelist.size();i++)
				{

					cartproductlist.add(cartprodwebelelist.get(i).getText());

					System.out.println(cartproductlist.get(i));
				}
			}
		}
		else {

			System.out.println("Cart is not clickable");
		}

		if(verifyCheckoutBtnClickable()) {
			System.out.println("checkout is clickable ");
			checkoutbtn.click();
			if(checkCartEmpty())
			{
				System.out.println("Cart is Empty");

			}
			else {
				//Check cart products with order summary present on checkout page 
				for(int i=0;i<cartcheckobj.checkoutprodlist().size();i++)
				{
					String ordersummeryelement=cartcheckobj.checkoutprodlist().get(i).getText();
					if(!cartproductlist.contains(ordersummeryelement))
					{
						System.out.println(ordersummeryelement+"..............not matches to cart element");
						flag=0;
						break;
					}

				}
				if(flag==1)
				{
					System.out.println("Cart and Checkout elements are same");
				}

				else {

					System.out.println("Checkout is not clickable");
				}


			}
		}
	}
	
	@Test(priority = 15)
	public void loggoff()
	{
		acc.logoffCheck();
	}
}
