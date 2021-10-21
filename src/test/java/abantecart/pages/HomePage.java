package abantecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import abantecart.testcase.SetupDriver;
import abantecart.utility.Utilities;

public class HomePage extends SetupDriver{
	
	Utilities util=new Utilities();
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;	
	}
	
	By searchclick = By.xpath("//a[contains(text(),'Designer Men Casual Formal Double Cuffs Grandad Ba')]");
	public WebElement selectClick()
	{
	
	return driver.findElement(searchclick);
	}
	
	public void selectProductNav() {
			
			// Find element using locator and store into WebElement
			WebElement elementToHover = driver.findElement(By.linkText("Apparel & accessories"));
	
			// Find element using locator and store into WebElement
			WebElement elementToClick = driver.findElement(By.xpath("//a[contains(text(),'Shoes')]"));
			
			
			// Create object of Action class
			Actions action = new Actions(driver);
	
			// Perform moveToElement operation using action (object) on element.
			action.moveToElement(elementToHover).click(elementToClick).build().perform();
			// Find element using locator and store into WebElement
			WebElement productToClick = driver.findElement(By.linkText("New Ladies High Wedge Heel Toe Thong Diamante Flip Flop Sandals"));
			productToClick.click();
		}

	public void selectSpecialOffers() {
		
		// Find element using locator and store into WebElement
		WebElement elementToHover = driver.findElement(By.linkText("Home"));

		// 1 Find element using locator and store into WebElement
		WebElement elementToClick = driver.findElement(By.xpath("//a[contains(text(),'Specials')]"));
		
		
		// 2 Create object of Action class
		Actions action = new Actions(driver);

		// 3 Perform moveToElement operation using action (object) on element.
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
		// 4 | click | id=sort | 
	    driver.findElement(By.id("sort")).click();
	    // 5 | select | id=sort | label=Price Low > High
	      WebElement dropdown = driver.findElement(By.id("sort"));
	      dropdown.findElement(By.xpath("//option[. = 'Price Low > High']")).click();
		
	}   
}