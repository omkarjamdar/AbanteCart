package abantecart.testcase;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import abantecart.pages.HomePage;
import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class HomePageTest extends BaseTest {
	
	HomePage homeObj; 
	WebDriver driver;
	public Logger logger;
	public Map<String, Object> vars;
	JavascriptExecutor js;
    		
	Utilities util = new Utilities();
	
	public HomePageTest(WebDriver driver)
	{
		this.driver=driver;
		homeObj = new HomePage(driver);
		logger = util.log4jSetup("HomePageTest");
	}
	
	//Test to verify whether page loaded with correct url and tab title
	@Test
	public void showNavigationLinks(){
	    Actions action = new Actions(driver);

	    String[] submenus = {"Home", "Apparel & accessories", "Makeup" , "Skincare" , "Fragrance" , "Men", "Hair Care","Books"};
	    try {
	    for(int i=0;i<submenus.length;i++)
	    {
	        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(submenus[i]));
	        Assert.assertTrue(driver.getTitle().contains(submenus[i].toLowerCase()));

	        WebElement we = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
	        wait(2000);
	        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[contains(.,'"+submenus[i]+"')]"))).click().build().perform();
	        wait(3000);
	        
	        logger.info("Loaded "+submenus[i]+" page with correct url and tab title!!");
	    }}
	    catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//End to End Scenario test case of selecting product
	@Test
	public void selectProductEndTest() {
	
		homeObj.selectProductNav();
		logger.info("Successfully selected the product");

	}
	
	//Selecting product on homepage only
	
	@Test
	public void selectProduct() {
		
		util.scoller(0, 1100, driver);			
		homeObj.selectClick().click();		
		logger.info("Successfully selected the product");

	}
	

	//Test case to Verify the banner slider prevArrow is clickable
	
	@Test
	public void clickBannerArrow() {
		      @SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 30);
		      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".prevArrow")));
		  
		      List<WebElement> elements = driver.findElements(By.cssSelector(".prevArrow"));
		      assert(elements.size() > 0);
		      WebElement element = driver.findElement(By.cssSelector(".oneByOneSlide"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).clickAndHold().perform();
		      @SuppressWarnings("deprecation")
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
		      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".prevArrow")));
		      driver.findElement(By.cssSelector(".prevArrow")).click();
		      logger.info("Successfully clicked the previous arrow on the banner");
		}
	
	//Test case to Verify whether we get tab title in headless browser mode 

	@Test
	public void headlessChromeTabTitle() {
		ChromeOptions options = new ChromeOptions();
        
        //add the headless argument
        options.addArguments("headless");
        
        //pass the options parameter in the Chrome driver declaration
        WebDriver driver = new ChromeDriver(options);
        logger.info("Title of the page is -> " + driver.getTitle());
	}
	
	//Test to verify drop-down menu of currency
	public void dropdownMenuCurrency() {
	
	int count = 0;
	//Expected values in dropdown
    String[] values = {"€ Euro", "£ Pound Sterling", "$ US Dollar"};
    WebElement dropdownElement = driver.findElement(By.className("dropdown-menu currency"));
    Select select = new Select(dropdownElement);
	//select.getoptions() returns all options belonging to select tag
    List<WebElement> options = select.getOptions();
    for (WebElement option : options) {
        for (int i = 0; i < values.length; i++) {
            if (option.getText().equals(values[i])) {
                count++;
            }
        }
    }
    if (count == values.length) {
        logger.info("Dropdown Menu of currency values matched..");
    } else {
        logger.info("Dropdown Menu of currency values not matched");
    }
	}
	
	
	//Test to Verify the Sort by functinality working properly.
	@Test
	public void sortBy() {
		homeObj.selectSpecialOffers();
		
		for(var index=0; index < grid.rows.length;index++)
		{
		  var cells = grid.rows[index].cells;
		  for(var index1=0; index1 < cells.length; index1++) 
		  {
		  //do something
		  }
		}
	}
	
}
