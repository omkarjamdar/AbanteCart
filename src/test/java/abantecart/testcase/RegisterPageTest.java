package abantecart.testcase;
import java.io.File;
import abantecart.pages.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import abantecart.pages.*;
import abantecart.utility.BaseTest;
import abantecart.utility.ReadExcelFile;
import abantecart.utility.Utilities;
import abantecart.pages.*;
public class RegisterPageTest extends BaseTest
{
		
	   
		RegisterPage register = new RegisterPage();
		public FileInputStream input2;
		public File source2;
		public Workbook wb2;
		public XSSFSheet sheet2;
		public int length;
		public Logger logger;
		public String expectedError;
		public String message;
		public int var=1;
		public int var1=0;
		WebDriverWait wait2;
		List<String> firstname =new ArrayList<String>();
		List<String> lastname =new ArrayList<String>();
		List<String> email =new ArrayList<String>();
		List<String> address =new ArrayList<String>();
		List<String> city =new ArrayList<String>();
		List<String> zipcode = new ArrayList<String>();
		List<String> registerloginname =new ArrayList<String>();
		List<String> registerpassword =new ArrayList<String>();
		List<String> confirmpassword =new ArrayList<String>();
		List<String> state =new ArrayList<String>();
		List<String> country =new ArrayList<String>();
		public String firstnamelength;
		public String lastnamelength;
		public String emaillength;
		public String addresslength;
		public String citylength;
		public String zipcodelength;
		public String registerloginnamelength;
		public String registerpasswordlength;
		public String confirmpasswordlength;
		public String statelength;
		
		//Utilities util = new Utilities();
		
		@BeforeClass
		public void registerPageSetup() 
		{
			
			driver.get("http://localhost/public_html/");
			logger = BaseTest.log4jSetup("RegisterPageTest");
			var=1;	
		}
		public void sheetDeclare(int var)
		{
		this.var=var;
		if(var1==1)
		logger.info(var);

		}
		
		public void RegisterPageSetup(String className)
		{
			this.logger=BaseTest.log4jSetup(className);
		}
		
		@BeforeClass
		public void registerSetup()
		{	   
				    ReadExcelFile read = new ReadExcelFile();
				    List<List<String>> registration=read.registration(var);				// Fetching loginname and email using forgotPasswordCredentials method of ReadExcel File        
					firstname.addAll(registration.get(0));
					lastname.addAll(registration.get(1));
					email.addAll(registration.get(2));
					address.addAll(registration.get(3));
					city.addAll(registration.get(4));
					zipcode.addAll(registration.get(5));
					state.addAll(registration.get(6));
					country.addAll(registration.get(7));
					registerloginname.addAll(registration.get(8));
					registerpassword.addAll(registration.get(9));
					confirmpassword.addAll(registration.get(10));
		}
		@Test(priority=1)
		public void Registration() throws InterruptedException
		{
			length = firstname.size();
			
			for (int i = 0; i < length; i++) 
		{
			firstnamelength = firstname.get(i);
			lastnamelength = firstname.get(i);
			firstnamelength = lastname.get(i);
			emaillength = email.get(i);
			addresslength = address.get(i);
			citylength = city.get(i);
			zipcodelength = zipcode.get(i);
			registerloginnamelength = registerloginname.get(i);
			registerpasswordlength = registerpassword.get(i);
			confirmpasswordlength = confirmpassword.get(i);
			statelength = state.get(i);
            if(i==0 || i==1)
			{
            	//if(var==0)
            	//{
            		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            		register.registerLink().click();
            		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            	//}
            		if(var1==1)
            		logger.info("Before");
            	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            	register.registerContinue().click();
            	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            	if(var1==1)
            	logger.info("After");
			}
            register.registerFirstName().clear();
            if(i!=1)
            {
            	register.registerFirstName().click();
            	register.registerFirstName().sendKeys(firstname.get(i));
            }
            register.registerLastName().clear();
            if(lastnamelength.length()>2)
            {
            	register.registerLastName().click();
            	register.registerLastName().sendKeys(lastname.get(i));
            }
            register.registerEmail().clear();
            if(emaillength.length()>2)
            {
            	register.registerEmail().click();
            	register.registerEmail().sendKeys(email.get(i));
            }
            register.registerAddress().clear();
            if(addresslength.length()>2)
            {
            	register.registerAddress().click();	
            	register.registerAddress().sendKeys(address.get(i));
            }
            register.registerCity().clear();
            if(citylength.length()>2)
            {
            	register.registerCity().click();
            	register.registerCity().sendKeys(city.get(i));
            }
			register.registerCountry().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerCountry().sendKeys("India");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(statelength.length()>2)
			{
			register.registerState().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerState().sendKeys("Maharastra");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
			register.registerZipCode().clear();
			if(zipcodelength.length()>2)
			{
				register.registerZipCode().click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				register.registerZipCode().sendKeys(zipcode.get(i));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
			register.registerLoginName().clear();
			if(registerloginnamelength.length()>2)
			{
			register.registerLoginName().click();
			register.registerLoginName().sendKeys(registerloginname.get(i));
			}
			if(registerpasswordlength.length()>2)
			{
				register.registerPassword().click();
				register.registerPassword().sendKeys(registerpassword.get(i));
			}
			if(confirmpasswordlength.length()>2)
			{
				register.registerConfirmPassword().click();
				register.registerConfirmPassword().sendKeys(confirmpassword.get(i));
			}
			register.registerSubscribeNo().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerAgree().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerContinueNext().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(i==0)
			{
				register.Logofflink();
			}
		}
			
		}
		
		@SuppressWarnings("deprecation")
		public void Registration_Integration() throws InterruptedException
		{
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerContinue().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerFirstName().click();
        	register.registerFirstName().sendKeys(firstname.get(0));
        	register.registerLastName().click();
        	register.registerLastName().sendKeys(lastname.get(0));
        	register.registerEmail().click();
        	register.registerEmail().sendKeys(email.get(0));
        	register.registerAddress().click();	
        	register.registerAddress().sendKeys(address.get(0));
        	register.registerCity().click();
        	register.registerCity().sendKeys(city.get(0));
        	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        	register.registerCountry().click();
        	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerCountry().sendKeys("India");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerState().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerState().sendKeys("Maharastra");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			register.registerZipCode().click();
			register.registerZipCode().sendKeys(zipcode.get(0));
			register.registerLoginName().click();
			register.registerLoginName().sendKeys(registerloginname.get(0));
			register.registerPassword().click();
			register.registerPassword().sendKeys(registerpassword.get(0));
			register.registerConfirmPassword().click();
			register.registerConfirmPassword().sendKeys(confirmpassword.get(0));
			register.registerSubscribeNo().click();
			register.registerAgree().click();
			register.registerContinueNext().click();
        	
		}
	}



