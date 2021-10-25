package abantecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class AccountMainPage extends BaseTest
{
	Utilities util=new Utilities();	
//	public WebDriver driver=util.browserSetup();

	
	
	/*public void Account_Tab()
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost/public_html/");
		driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a")).click();
		driver.findElement(By.name("loginname")).sendKeys("Shetty_3579");
		driver.findElement(By.name("password")).sendKeys("asdf1234");
		driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button")).click();	
	}*/
	
	// Edit Account Information Functionality
	By editinfolink =  By.xpath("//a[@data-original-title='Edit account details']");
	//a[contains(text(),'Login or register')]
	
	public WebElement editInfoLink()
	{
		return driver.findElement(editinfolink);	
	}
	
	By editinfofname = By.id("AccountFrm_firstname");
	
	public WebElement editInfoFname()
	{
		return driver.findElement(editinfofname);
	}
	
	By editinfolname = By.id("AccountFrm_lastname");
	
	public WebElement editInfoLname()
	{
		return driver.findElement(editinfolname);
	}
	
	By editinfoemail = By.id("AccountFrm_email");
	
	public WebElement editInfoEmail()
	{
		return driver.findElement(editinfoemail);
	}
	
	By editinfocontinue = By.xpath("//button[@title='Continue']");
	
	public WebElement editInfoContinue()
	{
		return driver.findElement(editinfocontinue);
	}
	
	// Change Password Functionality
	By changepassword = By.xpath("//i[@class='fa fa-key']");
	public WebElement changePassword()
	{
		return driver.findElement(changepassword);
	}
	
	By changepasswordcurrentpass = By.id("PasswordFrm_current_password");
	public WebElement changePasswordCurrentPass()
	{
		return driver.findElement(changepasswordcurrentpass);
	}
	
	By changepasswordnewpass = By.id("PasswordFrm_password");
	public WebElement changePasswordNewPass()
	{
		return driver.findElement(changepasswordnewpass);
	}
	
	By changepasswordconfirmpass = By.id("PasswordFrm_confirm");
	public WebElement changePasswordConfirmPass()
	{
		return driver.findElement(changepasswordconfirmpass);
	}
	
	By changepasswordcontinue = By.xpath("//button[@title='Continue']");
	public WebElement changePasswordContinue()
	{
		return driver.findElement(changepasswordcontinue);
	}
	
	
	// Manage Address Book Functionality
	By manageaddressbook = By.xpath("//a[@data-toggle='tooltip']//i[@class='fa fa-book']");
	public WebElement manageAddressBook()
	{
		return driver.findElement(manageaddressbook);
	}
	
	By manageaddressbookedit = By.xpath("//button[@title='Edit']");
	public WebElement manageAddressBookEdit()
	{
		return driver.findElement(manageaddressbookedit);
	}
	
	By manageaddressbookeditcity = By.id("AddressFrm_city");
	public WebElement manageAddressBookEditCity()
	{
		return driver.findElement(manageaddressbookeditcity);
	}
	
	By manageaddressbookeditstate = By.id("//select[@id='AddressFrm_zone_id']");
	public WebElement manageAddressBookEditState()
	{
		return driver.findElement(manageaddressbookeditstate);
	}
	
	By manageaddressbookeditpostCode = By.id("AddressFrm_postcode");
	public WebElement manageAddressBookEditPostCode()
	{
		return driver.findElement(manageaddressbookeditpostCode);
	}
	
	By manageaddressbookeditcountry = By.id("//select[@id='AddressFrm_country_id']");
	public WebElement manageAddressBookEditCountry()
	{
		return driver.findElement(manageaddressbookeditcountry);
	}
	
	By manageaddressbookeditcontinue = By.xpath("//button[@title='Continue']");
	public WebElement manageAddressBookEditContinue()
	{
		return driver.findElement(manageaddressbookeditcontinue);
	}
	
	By manageaddressbooknew = By.xpath("//a[@title='New Address']");
	public WebElement manageAddressBooknew()
	{
		return driver.findElement(manageaddressbooknew);
	}
	
	By manageaddressbooknewfname = By.id("AddressFrm_firstname");
	public WebElement manageAddressbookNewFname()
	{
		return driver.findElement(manageaddressbooknewfname);
	}
	
	By manageaddressbooknewlname = By.id("AddressFrm_lastname");
	public WebElement manageAddressBookNewLname()
	{
		return driver.findElement(manageaddressbooknewlname);
	}
	
	By manageaddressbooknewaddress = By.id("AddressFrm_address_1");
	public WebElement manageAddressBookNewAddress()
	{
		return driver.findElement(manageaddressbooknewaddress);
	}
	
	By manageaddressbooknewcity = By.id("AddressFrm_city");
	public WebElement manageAddressBookNewCity()
	{
		return driver.findElement(manageaddressbooknewcity);
	}
	
	By manageaddressbooknewstate = By.id("AddressFrm_zone_id");
	public WebElement manageAddressBookNewState()
	{
		return driver.findElement(manageaddressbooknewstate);
	}
	
	By manageaddressbooknewzipcode = By.id("AddressFrm_zone_id");
	public WebElement manageAddressBookNewZipcode()
	{
		return driver.findElement(manageaddressbooknewzipcode);
	}
	
	By manageaddressbooknewcountry = By.id("AddressFrm_country_id");
	public WebElement manageAddressBookNewCountry()
	{
		return driver.findElement(manageaddressbooknewcountry);
	}
	
	By manageaddressbooknewcontinue = By.xpath("//button[@title='Continue']");
	public WebElement manageAddressBookNewContinue()
	{
		return driver.findElement(manageaddressbooknewcontinue);
	}
	
	
	
	// Wishlist Functionality
	By wishlist = By.xpath("//a[@data-original-title='My wish list']");
	public WebElement wishList()
	{
		return driver.findElement(wishlist);
	}
	
	By wishlistcontinue = By.xpath("//a[@class='btn btn-default mr10']");
	public WebElement wishListContinue()
	{
		return driver.findElement(wishlistcontinue);
	}
	
	By wishlistaddtocart = By.xpath("//a[@class=\"btn.btn-sm.btn-primary\"]");
	public WebElement wishListAddToCart()
	{
		return driver.findElement(wishlistaddtocart);
	}
	
	By wishlistdelete = By.xpath("//*[@id=\"maincontainer\"]/div/div[1]/div/div/div/table/tbody/tr[3]/td[6]/a[2]");
	public WebElement wishListDeleteItem()
	{
		return driver.findElement(wishlistdelete);
	}
	
	//By addToCart = By.cssSelector(".cart");
	public void clickAddToCart() {
		/*selectSize();
		selectColor();
		selectQty(quantity);*/
		driver.get("http://localhost/public_html/index.php?rt=product/product&amp;product_id=121");
		
	}
	 
	// Order History Functionality
	By orderhistorylink = By.xpath("//a[@data-toggle='tooltip']//i[@class='fa fa-briefcase']");
	public WebElement orderHistory()
	{
		return driver.findElement(orderhistorylink);
	}
	
	// Transaction History Functionality
	By transactionhistorylink = By.xpath("//a[@data-toggle='tooltip']//i[@class='fa fa-money']");
	public WebElement transactionHistory()
	{
		return driver.findElement(transactionhistorylink);
	}
	
	// Downloads Functionality
	By downloadslink = By.xpath("//a[@data-toggle='tooltip']//i[@class='fa fa-cloud-download']");
	public WebElement downloads()
	{
		return driver.findElement(downloadslink);
	}
	
	
	By accountlink = By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Account']");
	public WebElement accountLink()
	{
		return driver.findElement(accountlink);
	}
	
	By accountlink1 = By.xpath("//a[normalize-space()='Account']");
	public WebElement accountLink1()
	{
		return driver.findElement(accountlink1);
	}
	
	// Logoff Functionality
	By logofflink = By.xpath("//a[normalize-space()='Logoff']");
	public WebElement logoff()
	{
		return driver.findElement(logofflink);
	}
	
	public void Logout()
	{
		
	}
}
