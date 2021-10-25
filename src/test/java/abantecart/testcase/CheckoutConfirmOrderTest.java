package abantecart.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.pages.CheckoutConfirmOrderPage;
import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class CheckoutConfirmOrderTest extends BaseTest{
	CheckoutConfirmOrderPage checkoutpageobj=new CheckoutConfirmOrderPage();
	AccountMainPageTest acc = new AccountMainPageTest();
	//Utilities utilitiesObj=new Utilities();	
	//WebDriver  driver;
	public Logger logger;
	public int var=0;
	
	
	@BeforeClass
	public void setup() {
		var=1;
		driver.get("http://localhost/public_html/");
		//driver=checkoutpageobj.driver;
		userLogin("user_test", "pass",driver);
		logger = BaseTest.log4jSetup("CheckoutConfirmOrderTest");
	}
	
	public void checkoutlogSetup(String className)
	{
		this.logger=BaseTest.log4jSetup(className);
	}

	//verify shippping address details matches with registered address of customer
	
	@Test(priority=1)
	public void verifyShippingDetails() {
		checkoutpageobj.checkOut().click();
		String shippingaddress=checkoutpageobj.shippingAddress().getText().replace(",", "");
		String addressinbook=checkoutpageobj.addressFromBook().getText().replace(",","");
		driver.navigate().back();
		checkoutpageobj.checkOut().click();
		if(addressinbook.indexOf(shippingaddress)!=-1)
		{
			if(var==1)
			logger.info("Shipping address and Registered Address is matched!");
		}
		else {
			if(var==1)
			logger.info("Shipping address and Registered Address not matched!");
		}
		}
	
	//Verify back button is clickable and navigate to payment information
	@Test(priority=2)
	public void verifyBackBtn() {
		checkoutpageobj.checkOut().click();
		String expectedurl="http://localhost/public_html/index.php?rt=checkout/payment&mode=edit";
		String actualurl="";
		if(checkoutpageobj.backBtn().isEnabled()) {
			checkoutpageobj.backBtn().click();
			actualurl=driver.getCurrentUrl();
			if(actualurl.equals(expectedurl)) {
				if(var==1)
				logger.info("navigated successfully to paymnet information");
			}
			else {
				if(var==1)
				logger.info("Not Navigated to payment Information!");
			}
		}
		else {
			if(var==1)
			logger.info("Back button is not enabled/clickable");
		}
		driver.navigate().back();
	}
	
	
	@Test (priority=3)
	public void verifyReturnPolicy() {
		checkoutpageobj.checkOut().click();
		if(checkoutpageobj.returnPolicyLink().isDisplayed()&& checkoutpageobj.returnPolicyLink().isEnabled()) {
			if(var==1)
			logger.info("return ploicy link is present and clickable");
			checkoutpageobj.returnPolicyLink().click();
			if(var==1)
			logger.info("Opened the model of return policy "+driver.switchTo().activeElement().getText());
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.switchTo().activeElement();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			checkoutpageobj.returnPolicyCloseBtn().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(var==1)
			logger.info("Close the model of return policy");

		}
		else {
			if(var==1)
			logger.info("Return policy links is not active");
		}
	}
	
	
	//Verify Edit cart button from checkout
	@Test(priority=4)
	public void verifyEditcart() {
		String expectedurl="http://localhost/public_html/index.php?rt=checkout/cart";
		String actualurl="";
		checkoutpageobj.checkOut().click();
		
		if(checkoutpageobj.editCartBtn().isDisplayed() &&checkoutpageobj.editCartBtn().isEnabled()) {
			logger.info("Edit cart button is present and clickable");
			checkoutpageobj.editCartBtn().click();
			actualurl=driver.getCurrentUrl().toString();
			Assert.assertEquals(expectedurl,actualurl);
			if(expectedurl.equals(actualurl))
			{
				if(var==1)
				logger.info("successfully navigate to cart page!");
			}
			else {
				if(var==1)
				logger.info("Navigation is not done properly");
			}	
		}
	}
	
	public boolean verifyCheckoutBtnClickable()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			if(checkoutpageobj.checkoutbtn().isEnabled())
			{
				return true;
			}
			else {
				if(var==1)
				logger.info("Checkout button is not clickable");
				return false;
			}
		}catch(Exception e) {e.printStackTrace();}



		return false;

	}


public void verifyConfirmOrderBtn()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Checking checkout button is clickable
	if(verifyCheckoutBtnClickable())
	{
		checkoutpageobj.checkoutbtn().click();
		if(verifyCheckoutBtnClickable())
		{
			checkoutpageobj.confirmorderbtn().click();
			if(var==1)
			logger.info(checkoutpageobj.finalmsg());
			if(var==1)
			logger.info(checkoutpageobj.finalmsg().length());
			if(checkoutpageobj.finalmsg().contains("Checkout Confirmation"))
			{
				if(var==1)
				logger.info("Order placed successfully!!");
			}
			else
			{
				if(var==1)
				logger.info("Order not placed!!");
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

