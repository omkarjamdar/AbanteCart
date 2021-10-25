package abantecart.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.pages.HomePage;
import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class HomePageTest extends BaseTest {
	
	HomePage homeObj =new HomePage();
	//WebDriver driver;
	public Logger logger;
	//JavascriptExecutor js;//= homeObj.driver;
	//Utilities util;
	public int var=0;

	@BeforeClass
	public void homePageSetup()
	{
	var=1;
	driver.get("http://localhost/public_html/");
	homeObj = new HomePage();
	//util = new Utilities();
	logger = BaseTest.log4jSetup("HomePageTest");
	}

	public void homePageloggerSetup(String className)
	{
	//this.logger=BaseTest.log4jSetup(className);
	homeObj = new HomePage();
	}

	@Test
	public void searchBar() {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	homeObj.selectProductNav();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//logger.info("Selected A Product");
	// util.scoller(0, 1100, driver);
	// homeObj.searchClick().click();
	// logger.info("Search Bar");
	//homeObj.selectProductNav();
	//Assert.assertTrue(false);
	}

	public void headlessChromeTabTitle() {
	ChromeOptions options = new ChromeOptions();

	//add the headless argument
	options.addArguments("headless");

	//pass the options parameter in the Chrome driver declaration
	WebDriver driver = new ChromeDriver(options);
	if(var==1)
	logger.info("Title of the page is -> " + driver.getTitle());
	
	}

	}

