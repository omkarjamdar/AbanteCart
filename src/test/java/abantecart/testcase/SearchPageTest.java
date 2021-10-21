package abantecart.testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.pages.SearchPage;
import abantecart.utility.Utilities;

public class SearchPageTest {
	SearchPage searchObj=new SearchPage();
	Utilities utilitiesObj=new Utilities();	
	WebDriver  driver;
	public Logger logger;
	
	
	@BeforeClass
	public void setup() {
		driver=searchObj.driver;
		utilitiesObj.userLogin("user_test", "pass",driver);
		logger = utilitiesObj.log4jSetup("SearchPageTest");
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
		searchObj.searchBox().click();
		searchObj.searchCategory().click();
		searchObj.serchBtn().click();
		JavascriptExecutor jsObj=(JavascriptExecutor)driver;
		jsObj.executeScript("window.scrollBy(0,350)","");
		TakesScreenshot scrShot=((TakesScreenshot)driver);
	    File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\AbanteCart\\src\\test\\java\\abantecart\\resources\\screenshots\\searchByCategory.png"));

	}
	
	
}
