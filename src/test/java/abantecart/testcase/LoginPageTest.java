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
import abantecart.pages.LoginPage;
import abantecart.utility.BaseTest;
import abantecart.utility.ReadExcelFile;
import abantecart.utility.Utilities;

public class LoginPageTest extends BaseTest{
	LoginPage loginobj = new LoginPage();
	//public WebDriver driver;
	int length;
	WebDriverWait wait;
	List<String> username = new ArrayList<String>();
	List<String> password = new ArrayList<String>();
	Logger logger;
	Utilities util=new Utilities();
	public int var=0;
	public String loginNamelength;
	public String passwordlength;
	
	@BeforeClass(alwaysRun=true)
	public void loginSetup() {
		
		var=1;
		driver.get("http://localhost/public_html/");
		//driver = loginobj.driver;	
		ReadExcelFile a= new ReadExcelFile();                                                       
		List<List<String>>  credentials=a.loginCredentials(0);				// Fetching login name and password using loginCredentials method of ReadExcel File        
		username.addAll(credentials.get(0));
		password.addAll(credentials.get(1));
		length=username.size();
	    logger = util.log4jSetup("LoginPageTest");
	}
	
	public void loginpageSetup(String className)
	{
		this.logger=BaseTest.log4jSetup(className);
	}

	@Test(priority = 1)
	public void loginTest() 
	{
		String actual_url="http://localhost/public_html/index.php?rt=account/account";     			// Account page URL
		
		for (int i = 0; i < length; i++) 
		{
			loginNamelength=username.get(i);
			passwordlength=password.get(i);
			loginobj.loginLink().click();
			if(loginNamelength.length()>2)
			{
				loginobj.loginName().click();
				loginobj.loginName().sendKeys(username.get(i));	
			}
			
			if(passwordlength.length()>2)
			{
			loginobj.password().click();							// Entering the loginame and password
			loginobj.password().sendKeys(password.get(i));
			}
			loginobj.loginBtn().click();
			
			String expected_url=driver.getCurrentUrl();
			
			if (actual_url.equalsIgnoreCase(expected_url))                                        // checking actual url and expected url if matches then click on logout
			
			{
				if(var==1)
				logger.info("Successful login for : "+username.get(i));
				WebElement logout = driver.findElement(By.xpath("//a[@href='http://localhost/public_html/index.php?rt=account/logout'][normalize-space()='']"));
				logout.click();	
			}
			else
			{
				if(var==1)
				logger.info("Unsuccessful login for : "+username.get(i));
			}
		}
	}

	
}
