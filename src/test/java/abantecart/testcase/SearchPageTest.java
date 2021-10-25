package abantecart.testcase;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


import abantecart.pages.SearchPage;
import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;


public class SearchPageTest extends BaseTest{
	SearchPage searchObj=new SearchPage();
	AccountMainPageTest acc = new AccountMainPageTest();
	//Utilities util=new Utilities();	
	//WebDriver  driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		//driver=searchObj.driver;
		driver.get("http://localhost/public_html/");
		userLogin("user_test", "pass",driver);
		logger = BaseTest.log4jSetup("SearchPageTest");
		
	}
	
	public void searchPageSetup(String className)
	{
		this.logger=BaseTest.log4jSetup(className);
	}
	
	@Test(priority = 1)
	public void searchByProductName() throws InterruptedException {
	
		searchObj.searchBox().sendKeys("New Ladies High Wedge Heel Toe Thong Diamante Flip Flop Sandals",Keys.ENTER);
	}
	
	@Test(priority=2)
	public void searchByKeyword() {
		searchObj.searchBox().sendKeys("makeup",Keys.ENTER);
		JavascriptExecutor jsObj=(JavascriptExecutor)driver;
		jsObj.executeScript("window.scrollBy(0,350)","");
	}
	
	@Test(priority=3)
	public void searchByCategories() throws InterruptedException, IOException {
		logger.info("Click on searchBox");
		searchObj.searchBox().click();
		searchObj.searchCategory().click();
		searchObj.serchBtn().click();
		JavascriptExecutor jsObj=(JavascriptExecutor)driver;
		jsObj.executeScript("window.scrollBy(0,350)","");
		TakesScreenshot scrShot=((TakesScreenshot)driver);
	    File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\AbanteCart\\src\\test\\java\\abantecart\\resources\\screenshots\\searchByCategory.png"));

	}
	//on click of search button open search page
		@Test(priority=4)
		public void openSearchpage()
		{
			searchObj.searchBox().click();
			String expectedUrl="http://localhost/public_html/index.php?rt=product/search&category_id=0";
			String actualUrl=driver.getCurrentUrl();
			if(expectedUrl.equals(actualUrl))
			{
				System.out.println("Search Page is open on Click of Search Button");
			}
		}
		
		@Test(priority = 15)
		public void loggoff()
		{
			acc.logoffCheck();
		}

}
