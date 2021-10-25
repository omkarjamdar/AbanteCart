package abantecart.utility;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class BaseTest
{
public static WebDriver driver;
public  WebElement checkoutbtn;
public  WebElement cartbtn;
public  WebElement editshippingbtn;

@BeforeSuite(alwaysRun=true)
public void launchBrowser()
{
System.out.println("ssssss");
System.setProperty("webdriver.chrome.driver", "D:/resource/chromedriver/chromedriver.exe");
driver=new ChromeDriver();
driver.manage().window().maximize();
//driver.get("http://localhost/public_html/");

}
public void userLogin(String username,String password,WebDriver driver)
{
driver.findElement(By.xpath("//a[normalize-space()='Login or register']")).click();
driver.findElement(By.id("loginFrm_loginname")).click();
driver.findElement(By.id("loginFrm_loginname")).sendKeys(username);
driver.findElement(By.id("loginFrm_password")).click();
driver.findElement(By.id("loginFrm_password")).sendKeys(password);
driver.findElement(By.cssSelector("button[title='Login']")).click();
}

public static Logger log4jSetup(String ClassName)
{
Logger logger = Logger.getLogger(ClassName);
PropertyConfigurator.configure("Log4j.properties");
return logger;
}

public static void scoller(int x,int y,WebDriver driver)
{
JavascriptExecutor js= (JavascriptExecutor)driver;
js.executeScript("window.scrollBy("+x+","+y+")");
}

@SuppressWarnings("deprecation")
public  boolean verifyCheckoutBtnClickable()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	try {
		checkoutbtn=driver.findElement(By.xpath("//span[normalize-space()='Checkout']"));
		//Click on checkout
		if(checkoutbtn.isEnabled())
		{
			return true;
		}
		else {
			return false;
		}
	}catch(Exception e) {e.printStackTrace();}



	return false;

}
//Verify that Cart button is clickable
@SuppressWarnings("deprecation")
public  boolean verifyCartBtnClickable()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	try {
		cartbtn=driver.findElement(By.xpath("//span[normalize-space()='Cart']"));
		//Click on checkout
		if(cartbtn.isEnabled())
		{
			return true;
		}
		else {
			return false;
		}
	}catch(Exception e) {e.printStackTrace();}



	return false;

}
@SuppressWarnings("deprecation")
public  boolean verifyEditbtnclickable()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	try {
		editshippingbtn=driver.findElement(By.xpath("//a[normalize-space()='Edit Shipping']"));
		//Click on checkout
		if(editshippingbtn.isEnabled())
		{
			return true;
		}
		else {
			return false;
		}
	}catch(Exception e) {e.printStackTrace();}



	return false;

}



public double splitConvertStrings(String prices)
{
	prices=prices.substring(1);
	double pricedouble=Double.parseDouble(prices);
	return pricedouble;
}



public boolean checkCartEmpty()
{

	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String carturl="http://localhost/public_html/index.php?rt=checkout/cart";
	if(driver.getCurrentUrl().equalsIgnoreCase(carturl))
	{
		
		
		return true;
	}
	else
	{
		System.out.println("Cart is not Empty");
		return false;
	}


}
/*@AfterSuite
public void closingBrowser()
{
driver.close();
}*/
}