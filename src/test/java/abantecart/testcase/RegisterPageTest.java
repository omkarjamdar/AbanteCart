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
		/*public RegisterPageTest(WebDriver driver)
		{
			this.driver=driver;
			
		}*/
		//Login_Flow login = new Login_Flow();
		//public WebDriver driver;
		public FileInputStream input2;
		public File source2;
		public Workbook wb2;
		public XSSFSheet sheet2;
		public int length;
		public Logger logger;
		public String expectedError;
		public String message;
	    //public String username, password;
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
		Utilities util = new Utilities();
		
		@BeforeClass
		public void registerSetup()
		{
			// Calling the utilities class and fetching data from excel file
			
				//driver = register.driver;
					/*source2 = new File(util.registerFile);
					input2 = new FileInputStream(source2);
					wb2 = new XSSFWorkbook(input2);
					sheet2 = (XSSFSheet) wb2.getSheetAt(0);
					length=sheet2.getLastRowNum() + 1;
					System.out.println(length);

					for(int i=0;i<sheet2.getLastRowNum()+1;i++)
					{
						firstname.add(sheet2.getRow(i).getCell(0).getStringCellValue());
						lastname.add(sheet2.getRow(i).getCell(1).getStringCellValue());
						email.add(sheet2.getRow(i).getCell(2).getStringCellValue());
						address.add(sheet2.getRow(i).getCell(3).getStringCellValue());
						city.add(sheet2.getRow(i).getCell(4).getStringCellValue());
						zipcode.add(sheet2.getRow(i).getCell(5).getNumericCellValue());
						state.add(sheet2.getRow(i).getCell(6).getStringCellValue());
						country.add(sheet2.getRow(i).getCell(7).getStringCellValue());
						registerloginname.add(sheet2.getRow(i).getCell(8).getStringCellValue());
						registerpassword.add(sheet2.getRow(i).getCell(9).getStringCellValue());
						confirmpassword.add(sheet2.getRow(i).getCell(10).getStringCellValue());
						
						
						//util.userLogin("Shetty_3579", "asdf1234",driver);					
					}*/
				    ReadExcelFile read = new ReadExcelFile();
				    List<List<String>> registration=read.registration(0);				// Fetching loginname and email using forgotPasswordCredentials method of ReadExcel File        
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
					logger = util.log4jSetup("RegisterPageTest");
					System.out.print(country);

					
					 //driver.get("http://localhost/public_html/");
					
					//System.out.println(Sheet.getLastRowNum());
					
		}		

		
			
		/*public void Sample()
		{
			register.registerLink().click();
			register.registerContinue().click();
			register.registerFirstName().click();
			register.registerFirstName().sendKeys("Ajit");
			register.registerLastName().click();
			register.registerLastName().sendKeys("Rai");
			register.registerEmail().click();
			register.registerEmail().sendKeys("ajitshetty6667@gmail.com");
			register.registerAddress().click();
			register.registerAddress().sendKeys("Vishrambhag");
			register.registerCity().click();
			register.registerCity().sendKeys("Sangli");
			register.registerState().click();
			register.registerState().sendKeys("Florida");
			//Select se = new Select(register.registerState());
			//se.selectByVisibleText("Maharastra");
			register.registerZipCode().click();
			register.registerZipCode().sendKeys("416416");
			//register.registerCountry().click();
			//Select se1 = new Select(register.registerCountry());
			//se1.selectByVisibleText("India");
			register.registerLoginName().click();
			register.registerLoginName().sendKeys("AjitShetty1234");
			register.registerPassword().click();
			register.registerPassword().sendKeys("ajit@1234");
			register.registerConfirmPassword().click();
			register.registerConfirmPassword().sendKeys("ajit@1234");
			register.registerSubscribeNo().click();
			register.registerAgree().click();
			register.registerContinueNext().click();
		}*/

		@Test(priority=1)
		public void Registration() throws InterruptedException
		{
			length = firstname.size();
			
			for (int i = 0; i < length; i++) 
		{
            if(i==0 || i==1)
			{
            	register.registerLink().click();
            	register.registerContinue().click();
			}
            register.registerFirstName().clear();
            if(i!=1)
            {
            	register.registerFirstName().click();
            	register.registerFirstName().sendKeys(firstname.get(i));
            }
            register.registerLastName().clear();
            if(i!=2)
            {
            	register.registerLastName().click();
            	register.registerLastName().sendKeys(lastname.get(i));
            }
            register.registerEmail().clear();
            if(i!=3)
            {
            	register.registerEmail().click();
            	register.registerEmail().sendKeys(email.get(i));
            }
            register.registerAddress().clear();
            if(i!=4)
            {
            	register.registerAddress().click();	
            	register.registerAddress().sendKeys(address.get(i));
            }
            register.registerCity().clear();
            if(i!=5)
            {
            	register.registerCity().click();
            	register.registerCity().sendKeys(city.get(i));
            }
			register.registerCountry().click();
			register.registerCountry().sendKeys("India");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			if(i!=6)
			{
			register.registerState().click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			register.registerState().sendKeys("Maharastra");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
			register.registerZipCode().clear();
			if(i!=7)
			{
				register.registerZipCode().click();
				register.registerZipCode().sendKeys(zipcode.get(i));
			}
			register.registerLoginName().clear();
			if(i!=9)
			{
			register.registerLoginName().click();
			register.registerLoginName().sendKeys(registerloginname.get(i));
			}
			if(i!=10)
			{
				register.registerPassword().click();
				register.registerPassword().sendKeys(registerpassword.get(i));
			}
			if(i!=11)
			{
				register.registerConfirmPassword().click();
				register.registerConfirmPassword().sendKeys(confirmpassword.get(i));
			}
			register.registerSubscribeNo().click();
			register.registerAgree().click();
			register.registerContinueNext().click();
			if(i==0)
			{
				register.Logofflink();
			}
		}
			
		}
	}



