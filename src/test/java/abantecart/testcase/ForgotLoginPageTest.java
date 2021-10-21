package abantecart.testcase;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.pages.ForgotLoginPage;
import abantecart.utility.ReadExcelFile;
import abantecart.utility.Utilities;

public class ForgotLoginPageTest 
{
	WebDriver driver;
	ForgotLoginPage forgotLoginObj = new ForgotLoginPage();
	Utilities util = new Utilities();
	String actualError = "";
	public int length;
	WebDriverWait wait;
	List<String> lastname = new ArrayList<String>();
	List<String> email = new ArrayList<String>();
	Logger logger;

	@BeforeClass
	public void setup() 
	{
		driver = forgotLoginObj.driver;
		ReadExcelFile a= new ReadExcelFile();                                                       
		List<List<String>>  credentials=a.forgotLoginCredentials(0);				// Fetching lastname and email using forgotLoginCredentials method of ReadExcel File        
		lastname.addAll(credentials.get(0));
		email.addAll(credentials.get(1));
		length=lastname.size();
		logger = util.log4jSetup("LoginPageTest");
	}

	@Test()
	public void forgotPassword() 
	{
		forgotLoginObj.loginLink().click();
		String expectedError;
		String message;
		for (int i = 0; i < length; i++) 
		{
			forgotLoginObj.forgotLoginLink().click();								// Entering lastname and email
			forgotLoginObj.lastname().sendKeys(lastname.get(i));
			forgotLoginObj.email().sendKeys(email.get(i));
			forgotLoginObj.continueBtn().click();

			actualError = "Error: No records found matching information your provided, please check your information and try again! ";
		    expectedError = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div[1]")).getText();
		    expectedError=expectedError.substring(1);
	
		    message = (expectedError.length() == actualError.length()) ? "Wrong name or password" : "Successfully Sent"  ;
		    logger.info(message+" for "+lastname.get(i));
		    WebElement close = driver.findElement(By.className("close"));
		
		    close.click();
		    if(expectedError.length() == actualError.length())
			forgotLoginObj.backBtn().click() ;
		
		}
	}
}
