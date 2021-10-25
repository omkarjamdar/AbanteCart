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
import abantecart.utility.BaseTest;
import abantecart.utility.ReadExcelFile;
import abantecart.utility.Utilities;

public class ForgotLoginPageTest extends BaseTest
{
	//WebDriver driver;
	ForgotLoginPage forgotLoginObj = new ForgotLoginPage();
	//Utilities util = new Utilities();
	String actualError = "";
	public int length;
	WebDriverWait wait;
	List<String> lastname = new ArrayList<String>();
	List<String> email = new ArrayList<String>();
	Logger logger;
	public int var=0;
	public String lastNamelength;
	public String emaillength;

	@BeforeClass(alwaysRun=true)
	public void setup() 
	{
		System.out.println("hi");
		var=1;
		driver.get("http://localhost/public_html/");
		//driver = forgotLoginObj.driver;
		ReadExcelFile a= new ReadExcelFile();                                                       
		List<List<String>>  credentials=a.forgotLoginCredentials(0);				// Fetching lastname and email using forgotLoginCredentials method of ReadExcel File        
		lastname.addAll(credentials.get(0));
		email.addAll(credentials.get(1));
		length=lastname.size();
		logger = BaseTest.log4jSetup("LoginPageTest");
	}
	
	public void forgotLoginSetup(String className)
	{
		this.logger=BaseTest.log4jSetup(className);
	}

	@Test(groups={"Functional"}, priority=1)
	public void forgotPassword() 
	{
		forgotLoginObj.loginLink().click();
		String expectedError;
		String message;
		for (int i = 0; i < length; i++) 
		{
			lastNamelength=lastname.get(i);
			emaillength=email.get(i);
			forgotLoginObj.forgotLoginLink().click();								// Entering lastname and email
			
			if(lastNamelength.length()>2)
			{	
			forgotLoginObj.lastname().sendKeys(lastname.get(i));
			}
			if(emaillength.length()>2)
			{	
			forgotLoginObj.email().sendKeys(email.get(i));
			}
			forgotLoginObj.continueBtn().click();

			actualError = "Success: Your login name reminder has been sent to your e-mail address. ";
		    expectedError = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div[1]")).getText();
		    expectedError=expectedError.substring(1);
	
		    message = (expectedError.length() == actualError.length()) ? "Wrong name or password" : "Successfully Sent"  ;
		    if(var==1)
		    logger.info(message+" for "+lastname.get(i));
		    WebElement close = driver.findElement(By.className("close"));
		
		    close.click();
		    if(expectedError.length() != actualError.length())
			forgotLoginObj.backBtn().click() ;
		
		}
	}
}
