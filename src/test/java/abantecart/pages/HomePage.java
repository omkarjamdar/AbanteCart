package abantecart.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import abantecart.testcase.SetupDriver;
import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class HomePage extends BaseTest{
	
	Utilities util=new Utilities();
	//public WebDriver driver;

	/*public HomePage(WebDriver driver)
	{
	this.driver=driver;
	}*/

	By searchclick = By.xpath("//a[contains(text(),'Designer Men Casual Formal Double Cuffs Grandad Ba')]");
	public WebElement searchClick()
	{

	return driver.findElement(searchclick);
	}

	By currencyCode = By.xpath("//span[contains(text(),'Euro')]");
	public WebElement currency()
	{

	return driver.findElement(currencyCode);
	}

	public void selectProductNav() {

	// Find element using locator and store into WebElement
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement elementToHover = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/nav[1]/ul[1]/li[2]/a[1]"));
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// Find element using locator and store into WebElement
	WebElement elementToClick = driver.findElement(By.xpath("//a[contains(text(),'Shoes')]"));
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


	// Create object of Action class
	Actions action = new Actions(driver);



	// Perform moveToElement operation using action (object) on element.
	action.moveToElement(elementToHover).click(elementToClick).build().perform();
	// Find element using locator and store into WebElement
	WebElement productToClick = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]"));
	productToClick.click();
	}

}
