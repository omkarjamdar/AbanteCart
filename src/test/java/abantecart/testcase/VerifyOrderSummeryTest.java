package abantecart.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.pages.VerifyOrderSummeryPage;
import abantecart.utility.BaseTest;


public class VerifyOrderSummeryTest extends BaseTest {


	VerifyOrderSummeryPage ordersummerypgbtn;
	AccountMainPageTest acc = new AccountMainPageTest();
	@BeforeClass
	public  void setup()
	{

		ordersummerypgbtn=new VerifyOrderSummeryPage();
		driver.get("http://localhost/public_html/");

		userLogin("user_test","pass",driver);
	}
	@SuppressWarnings("deprecation")
	//Method to verify Order summery tab from checkout
	@Test
	public void verifyorderSummery()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(verifyCheckoutBtnClickable()) {
			System.out.println("checkout is clickable ");
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			checkoutbtn.click();

			if(checkCartEmpty())
			{
				System.out.println("Cart is Empty");

			}

			else {

				List <WebElement> prodpricelist=ordersummerypgbtn.prodpricelist();
				List <WebElement> productls=ordersummerypgbtn.productls();
				List <WebElement> totalpricels=ordersummerypgbtn.totalpricels();
				double subtotalsum=0;
				for(int i=0;i<prodpricelist.size();i++)
				{

					double prices=splitConvertStrings(prodpricelist.get(i).getText());	
					String[] quantitystr = productls.get(i).getText().split(" x");
					System.out.println(quantitystr[0]);
					int quantity=Integer.parseInt(quantitystr[0]);
					subtotalsum=subtotalsum+(prices*quantity);
				}


				double subtotald=splitConvertStrings(totalpricels.get(0).getText());
				double flatshipratedouble=splitConvertStrings(totalpricels.get(1).getText());
				//double retaild=splitConvertStrings(totalpricels.get(2).getText());;
				Double totalsum=subtotalsum+flatshipratedouble;//+retaild;
				System.out.println("subtotalsum"+subtotalsum);
				System.out.println("totalsum"+totalsum);		
				double totald=splitConvertStrings(totalpricels.get(2).getText());

				if(subtotald==subtotalsum)
				{
					System.out.println("Subtoal is verified and accurate");

					if(totalsum==totald)
					{
						System.out.println("Total is verified and accurate");
					}
				}

			}
		}
		else
		{
			System.out.println("Checkout is not clickable");
		}


	}

	@Test(priority = 15)
	public void loggoff()
	{
		acc.logoffCheck();
	}

}





