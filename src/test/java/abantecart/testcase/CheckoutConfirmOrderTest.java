package abantecart.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.pages.CheckoutConfirmOrderPage;
import abantecart.utility.Utilities;

public class CheckoutConfirmOrderTest {
	public static WebDriver driver;
	Utilities util;
	static CheckoutConfirmOrderPage checkoutconfirmObj;
	public static Logger logger;
	
	public CheckoutConfirmOrderTest(WebDriver driver)
	{
		this.driver=driver;
		checkoutconfirmObj=new CheckoutConfirmOrderPage(driver);
		
		
	}
	//@BeforeClass()									Temporararily commented
	public void setup()
	{
		//checkoutconfirmObj=new CheckoutConfirmOrderPage();
		//util=new Utilities();
		driver=checkoutconfirmObj.driver;
		//driver.get("http://localhost/public_html/");
		util.userLogin("user_test", "pass",driver);
		logger = util.log4jSetup("CheckoutConfirmOrderTest");

	}
	@SuppressWarnings("deprecation")
	@Test
	public void verifyConfirmOrderBtn()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Checking checkout button is clickable
		if(verifyCheckoutBtnClickable())
		{
			checkoutconfirmObj.checkoutbtn().click();
			if(verifyConfOrderBtnClickable())
			{
				checkoutconfirmObj.confirmorderbtn().click();

				logger.info(checkoutconfirmObj.finalmsg());
				logger.info(checkoutconfirmObj.finalmsg().length());
				if(checkoutconfirmObj.finalmsg().contains("Checkout Confirmation"))
				{
					logger.info("Order placed successfully!!");
				}
				else
				{
					logger.info("Order not placed!!");
				}

			}

		}
	}
	@SuppressWarnings("deprecation")
	public static boolean verifyCheckoutBtnClickable()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			if(checkoutconfirmObj.checkoutbtn().isEnabled())
			{
				return true;
			}
			else {
				logger.info("Checkout button is not clickable");
				return false;
			}
		}catch(Exception e) {e.printStackTrace();}



		return false;

	}
	@SuppressWarnings("deprecation")
	public static boolean verifyConfOrderBtnClickable()
	{


		try {

			if(checkoutconfirmObj.confirmorderbtn().isEnabled())
			{
				return true;
			}
			else {
				logger.info("Confirm order button is not clickable");
				return false;
			}
		}catch(Exception e) {e.printStackTrace();}



		return false;

	}

}
