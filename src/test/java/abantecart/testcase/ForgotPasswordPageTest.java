package abantecart.testcase;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import abantecart.pages.ForgotPasswordPage;
import abantecart.utility.BaseTest;
import abantecart.utility.ReadExcelFile;
import abantecart.utility.Utilities;

public class ForgotPasswordPageTest extends BaseTest
{
	//WebDriver driver;
	ForgotPasswordPage forgotObj = new ForgotPasswordPage();
	//Utilities util = new Utilities();
	String actualError = "";
	public int length;
	WebDriverWait wait;
	List<String> loginname = new ArrayList<String>();
	List<String> email = new ArrayList<String>();
	Logger logger;
	public int var=0;
	public String loginlength;
	public String emaillength;



	@BeforeClass
	public void setup() 
	{
		var=1;
		driver.get("http://localhost/public_html/");
		//driver = forgotObj.driver;
		ReadExcelFile a= new ReadExcelFile();                                                       
		List<List<String>>  credentials=a.forgotPasswordCredentials(0);				// Fetching loginname and email using forgotPasswordCredentials method of ReadExcel File        
		loginname.addAll(credentials.get(0));
		email.addAll(credentials.get(1));
		length=loginname.size();
		logger =BaseTest.log4jSetup("ForgotPasswordPageTest");
	}
	
	public void ForgotPasswordSetup(String className)
	{
		this.logger=BaseTest.log4jSetup(className);
	}
	
	@Test
	public void forgotPassword() 
	{
		String message;																// Entering loginname and email
		String expectedError;
		actualError = "Success: Password reset link has been sent to your e-mail address. ";
		forgotObj.loginLink().click();
		for (int i = 0; i < length; i++) 
		{
			 loginlength=loginname.get(i);
			 emaillength=email.get(i);

			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			forgotObj.forgotPasswordLink().click();
			if(loginlength.length()>2)
			{
				forgotObj.loginname().sendKeys(loginname.get(i));
			}
			if(emaillength.length()>2)
			{
				forgotObj.email().sendKeys(email.get(i));
			}
			forgotObj.continueBtn().click();
			expectedError = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div[1]")).getText();
			expectedError=expectedError.substring(1);
			message= (expectedError.length() == actualError.length()) ? "Wrong name or password" : "SuccessFully Sent" ;
			if(var==1)
			logger.info(message+" For "+loginname.get(i));
			WebElement close = driver.findElement(By.className("close"));
			close.click();
			if(expectedError.length() != actualError.length())
				forgotObj.backBtn().click() ;										// If loginame or password is wrong then click on back button
		}

	}
}