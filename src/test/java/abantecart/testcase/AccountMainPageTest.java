package abantecart.testcase;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import abantecart.utility.*;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import abantecart.pages.AccountMainPage;
import abantecart.utility.Utilities;
import junit.framework.Assert;

//@Listeners(abantecart.utility.Listeners.class)
public class AccountMainPageTest extends BaseTest
{
	AccountMainPage account = new AccountMainPage();
	//WebDriver driver;
	Utilities util = new Utilities();
	public String expectedError;
	public String message;
	//Login_Flow login = new Login_Flow();
	public FileInputStream input2;
	public File source2;
	public Workbook wb2;
	public XSSFSheet sheet2;
	public Logger logger; 
    //public String username, password;
	WebDriverWait wait2;
	List<String> Fname=new ArrayList<String>();
	List<String> Lname =new ArrayList<String>();
	List<String> Email =new ArrayList<String>();
	List<String> currentpassword =new ArrayList<String>();
	List<String> newpassword =new ArrayList<String>();
	List<String> confirmpassword =new ArrayList<String>();
	public String city,fname,lname,address,city2;
	public double zipcode,zipcode2;
	
	
	
	@BeforeClass
		public void accountSetup1()
		{
			//driver=account.driver;
			// Calling the utilities class and fetching data from excel file
		
			try
			{
					source2 = new File(util.accountFile);
					input2 = new FileInputStream(source2);
					wb2 = new XSSFWorkbook(input2);
					sheet2 = (XSSFSheet) wb2.getSheetAt(0);
					
					/*Fname.add("Ajit");
					Fname.add("Ajit");
					Fname.add("");
					Lname.add("Shetty");
					Lname.add("Shetty");
					Lname.add("Shetty");
					Email.add("ajitshetty2000@gmail.com");
					Email.add("ajitshettygmail.com");
					Email.add("ajitshetty123@gmail.com");
					currentpassword.add("asdf1234");
					currentpassword.add("dmlw@1234");
					currentpassword.add("dmlw@1234");
					newpassword.add("dmlw1234");
					newpassword.add("asdf1234");
					newpassword.add("asdf1234");
					confirmpassword.add("dmlw1234");
					confirmpassword.add("asdf1234");
					confirmpassword.add("asdf@1234");*/
					for(int i=0;i<=2;i++)
					{
						
					    Fname.add(sheet2.getRow(i).getCell(0).getStringCellValue());
						Lname.add(sheet2.getRow(i).getCell(1).getStringCellValue());
						Email.add(sheet2.getRow(i).getCell(2).getStringCellValue());
							
					}
					for(int j=3;j<=5;j++)
					{
						currentpassword.add(sheet2.getRow(j).getCell(0).getStringCellValue());
						newpassword.add(sheet2.getRow(j).getCell(1).getStringCellValue());
						confirmpassword.add(sheet2.getRow(j).getCell(2).getStringCellValue());
					}
					
					city=sheet2.getRow(6).getCell(0).getStringCellValue();
					zipcode=sheet2.getRow(6).getCell(1).getNumericCellValue();
					fname=sheet2.getRow(7).getCell(0).getStringCellValue();
					lname=sheet2.getRow(7).getCell(1).getStringCellValue();
					address=sheet2.getRow(7).getCell(2).getStringCellValue();
					city2=sheet2.getRow(7).getCell(3).getStringCellValue();
					zipcode2=sheet2.getRow(7).getCell(4).getNumericCellValue();
					
					
					util.userLogin("Shetty_3579", "asdf1234",driver);
					logger = util.log4jSetup("AccountMainPageTest");
					
					
					
					//System.out.println(Sheet.getLastRowNum());
					
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}


	

		
	@Test(priority=1)								// Checking whether on clicking Edit_Account Info Redirection is done
	public void editInfoCheck()
	{
		account.editInfoLink().click();
		account.logoff().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
   
	@Test(priority=2)
	public void editWithCorrectData()			// Editing account info with correct information
	{
	   String actualError=actualError = "Oops, there is an error with information provided!";
	   util.userLogin("Shetty_3579","asdf1234", driver);
	   account.editInfoLink().click();
	   account.editInfoFname().click();
	   account.editInfoFname().clear();
	   account.editInfoFname().sendKeys(Fname.get(0));
	   account.editInfoLname().click();
	   account.editInfoLname().clear();
	   account.editInfoLname().sendKeys(Lname.get(0));
	   account.editInfoEmail().click();
	   account.editInfoEmail().clear();
	   account.editInfoEmail().sendKeys(Email.get(0));
	   account.editInfoContinue().click();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
	   expectedError=expectedError.substring(1);
	   message= (expectedError.length() == actualError.length()) ? "Wrong Information" : "SuccessFully Edited" ;
	   System.out.println(message);
	   logger.info(message+" For "+Fname.get(0));
	}
	
	@Test(priority=3)
	public void editWithWrongEmail()				// Editing account info with wrong email
	{
		String actualError=actualError = "Oops, there is an error with information provided!";
	   account.editInfoLink().click();
	   account.editInfoFname().click();
	   account.editInfoFname().clear();
	   account.editInfoFname().sendKeys(Fname.get(1));
	   account.editInfoLname().click();
	   account.editInfoLname().clear();
	   account.editInfoLname().sendKeys(Lname.get(1));
	   account.editInfoEmail().click();
	   account.editInfoEmail().clear();
	   account.editInfoEmail().sendKeys(Email.get(1));
	   account.editInfoContinue().click();
	   account.accountLink().click();
	   expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
	   expectedError=expectedError.substring(1);
	   message= (expectedError.length() == actualError.length()) ? "Wrong Information Provided" : "SuccessFully Edited" ;
	   System.out.println(message);
	   logger.info(message+" For "+Fname.get(1));
	  
	}
	
	@Test(priority=4)
	public void editWithNoFname() throws InterruptedException				// Editing account info without passing firstname 
	{
		String actualError=actualError = "Oops, there is an error with information provided!";
	   account.editInfoLink().click();
	   Thread.sleep(3000);
	   //account.editInfoFname().click();
	   account.editInfoFname().clear();
	   Thread.sleep(3000);
	   //account.editInfoFname().sendKeys(Fname.get(2));
	   account.editInfoLname().click();
	   Thread.sleep(3000);
	   account.editInfoLname().clear();
	   account.editInfoLname().sendKeys(Lname.get(2));
	   account.editInfoEmail().click();
	   account.editInfoEmail().sendKeys(Email.get(2));
	   account.editInfoEmail().clear();
	   account.editInfoContinue().click();
	   expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
	   expectedError=expectedError.substring(1);
	   message= (expectedError.length() == actualError.length()) ? "Wrong Information Provided" : "SuccessFully Edited" ;
	   System.out.println(message);
	   logger.info(message+" For "+Fname.get(2));
	}
	
	@Test(priority=5)
	public void changePasswordWithCorrectData()		// Changing Password by passing correct information
	{

		String actualError=actualError = "Oops, there is an error with information provided!";
        account.accountLink().click();
		account.changePassword().click();
		account.changePasswordCurrentPass().click();
		account.changePasswordCurrentPass().sendKeys(currentpassword.get(0));
		account.changePasswordNewPass().click();
		account.changePasswordNewPass().sendKeys(newpassword.get(0));
		account.changePasswordConfirmPass().click();
		account.changePasswordConfirmPass().sendKeys(confirmpassword.get(0));
		account.changePasswordContinue().click();
		expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
		expectedError=expectedError.substring(1);
		message= (expectedError.length() == actualError.length()) ? "Wrong Information" : "SuccessFully Edited" ;
		System.out.println(message);
		logger.info(message);
	}
	
	@Test(priority=6)
	public void changePasswordWithWrongCurrentPass()	// Changing Password by passing incorrect current password
	{
		String actualError=actualError = "Oops, there is an error with information provided!";
		account.accountLink().click();
		account.changePassword().click();
		account.changePasswordCurrentPass().click();
		account.changePasswordCurrentPass().sendKeys(currentpassword.get(1));
		account.changePasswordNewPass().click();
		account.changePasswordNewPass().sendKeys(newpassword.get(1));
		account.changePasswordConfirmPass().click();
		account.changePasswordConfirmPass().sendKeys(confirmpassword.get(1));
		account.changePasswordContinue().click();
		expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
		expectedError=expectedError.substring(1);
		message= (expectedError.length() == actualError.length()) ? "Wrong Information" : "SuccessFully Edited" ;
		System.out.println(message);
		logger.info(message);
	}
	
	@Test(priority=7)
	public void changePasswordWithWrongConfirmPassword()	// Changing Password by passing different new and confirm password
	{
		String actualError=actualError = "Oops, there is an error with information provided!";
		account.changePasswordCurrentPass().click();
		account.changePasswordCurrentPass().sendKeys(currentpassword.get(2));
		account.changePasswordNewPass().click();
		account.changePasswordNewPass().sendKeys(newpassword.get(2));
		account.changePasswordConfirmPass().click();
		account.changePasswordConfirmPass().sendKeys(confirmpassword.get(2));
		account.changePasswordContinue().click();
		expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
		expectedError=expectedError.substring(1);
		message= (expectedError.length() == actualError.length()) ? "Wrong Information" : "SuccessFully Edited" ;
		System.out.println(message);
		logger.info(message);
	}
	
	@Test(priority=8)
	public void addressBook()
	{
		account.accountLink().click();
		account.manageAddressBook().click();
		logger.info("Successfully redirected to Address Book");
	}
	
	@Test(priority=9)
	public void addressBookEdit()
	{
		String actualError=actualError = "Oops, there is an error with information provided!";
		account.accountLink().click();
		account.manageAddressBook().click();
		account.manageAddressBookEdit().click();
		account.manageAddressBookEditCity().click();
		account.manageAddressBookEditCity().clear();
		account.manageAddressBookEditCity().sendKeys(city);
		//account.manageAddressBookEditState().click();
		//account.manageAddressBookEditPostCode().click();
		//account.manageAddressBookEditPostCode().clear();
		//account.manageAddressBookEditPostCode().sendKeys(zipcode);
		//account.manageAddressBookEditCountry().click();
		account.manageAddressBookEditContinue().click();
		expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
		expectedError=expectedError.substring(1);
		message= (expectedError.length() == actualError.length()) ? "Wrong Information" : "SuccessFully Edited" ;
		System.out.println(message);
		logger.info(message);
	}
	
	@Test(priority=10)
	public void addressBookNew() throws InterruptedException
	{
		String actualError=actualError = "Oops, there is an error with information provided!";
		account.manageAddressBooknew().click();
		account.manageAddressbookNewFname().click();
		account.manageAddressbookNewFname().sendKeys(fname);
		account.manageAddressBookNewLname().click();
		account.manageAddressBookNewLname().sendKeys(lname);
		account.manageAddressBookNewAddress().click();
		account.manageAddressBookNewAddress().sendKeys(address);
		account.manageAddressBookNewCity().click();
		account.manageAddressBookNewCity().sendKeys(city2);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		account.manageAddressBookNewCountry().click();
		account.manageAddressBookNewCountry().sendKeys("India");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		account.manageAddressBookNewState().click();
		account.manageAddressBookNewState().sendKeys("Maharashtra");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		account.manageAddressBookNewZipcode().click();
		account.manageAddressBookNewZipcode();
		//account.manageAddressBookNewZipcode().sendKeys(zipcode2);
		account.manageAddressBookNewContinue().click();	
		account.accountLink().click();
		expectedError = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
		expectedError=expectedError.substring(1);
		message= (expectedError.length() == actualError.length()) ? "Wrong Information" : "SuccessFully Added" ;
		System.out.println(message);
		logger.info(message);
	}
	
	@Test(priority=11)
	public void wishlistCheck()
	{
		account.wishList().click();
		account.accountLink().click();
		logger.info("Successfully redirected to Wishlist");
	}
	
	@Test(priority=12)
	public void wishlistContinue()
	{
		account.wishList().click();
		account.wishListContinue().click();
		driver.get("http://localhost/public_html/index.php?rt=account/account");
		logger.info("Successfully redirected to Product Page");
	}
	
	
	/*public void wishlistAddToCartFromWishlist()
	{
		account.wishList().click();
		//account.wishListContinue().click();
		account.clickAddToCart();
		driver.get("http://localhost/public_html/index.php?rt=account/account");
	}
	
	@Test
	public void wishlistDeleteItemFromWishlist()
	{
		
		account.wishList().click();
		account.wishListDeleteItem().click();
	}*/
	
	
	@Test(priority=13)
	public void orderHistoryCheck()
	{
		account.accountLink1().click();
		account.orderHistory().click();
		account.accountLink1().click();
		logger.info("Successfully redirected to Order History");
		
	}
	
	@Test(priority=14)
	public void transactionHistoryCheck()
	{
		
		account.transactionHistory().click();
		account.accountLink().click();
		logger.info("Successfully redirected to Transaction History");
	}
	
	@Test(priority=15)
	public void downloadCheck()
	{
		account.downloads().click();
		account.accountLink().click();
		logger.info("Successfully redirected to Downloads");
	}
	
	@Test(priority=16)
	public void logoffCheck()
	{
		account.logoff().click();
		logger.info("Successfully Logged off");
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=17)
	public void logoffCheck1()
	{
		System.out.println("Hi");
		Assert.assertTrue(false);
	}
}
