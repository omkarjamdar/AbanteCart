package abantecart.pages;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.Utilities;



public class ProductPage {
	
	Utilities util=new Utilities();
	public WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	By prodName = By.cssSelector(".bgnone");
	By addToCart = By.cssSelector(".cart");
	By btnSize = By.cssSelector("input#option344750");
	By prdColor = By.cssSelector("option[value='752']");
	By txtprdQty = By.name("quantity");
	By btbWishlist = By.cssSelector("a.wishlist_add");
	By thumbnail = By.cssSelector(".thumbnails.mainimage.smallimage li");
	
	
	
	By latestPrd = By.cssSelector("ul.side_prd_list li");
	By breadCrumb = By.cssSelector(".breadcrumb li");
	
	By txtSearch = By.cssSelector("input.pull-left.input-medium.search-query.dropdown-toggle");
//	By prdSelectName = By.linkText("Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie");
	By prdSelectName = By.xpath("//a[@title='Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie']");
	
	public void open(String url) {
		driver.get(url);
	}
	//METHODS
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	public String getProductName() {
		
		return driver.findElement(prodName).getText();
	}
	
	public void selectSize() {
		driver.findElement(btnSize).click();
		
	}
	public void selectColor() {
		driver.findElement(prdColor).click();
		
	}
	public void selectQty(String arg) {
		driver.findElement(txtprdQty).clear();
		driver.findElement(txtprdQty).sendKeys(arg);
	}
	
	public void clickThumbnailImage() {
		
		List<WebElement> myElements = driver.findElements(thumbnail);
		for(WebElement element : myElements) {
		  element.click();
		 
		}
		
	}
	
	public void searchProduct(String product) {
		driver.findElement(txtSearch).sendKeys(product);
		driver.findElement(txtSearch).sendKeys(Keys.ENTER);
		driver.findElement(prdSelectName).click();
		
	}
	
	
	public boolean isLatestProductSection() {
		List<WebElement> myElements = driver.findElements(latestPrd);
		for(WebElement element : myElements) {
		  if(!(element.getTagName().isEmpty())) {
			  continue;
		  }
		  else {
			  return false;
		  }
		 
		}
		
		return true;
	}
	
	public void verifyBreadcrump() throws InterruptedException {
		List<WebElement> myElements = driver.findElements(breadCrumb);
//		ListIterator listIterator = myElements.listIterator(myElements.size());
//		while (listIterator.hasPrevious()) {
//		    
//		}
		
		Collections.reverse(myElements);
		for (int i = 1; i < myElements.size(); i++) {
			 
			myElements.get(i).click();
			Thread.sleep(3000);
        }
//		for(WebElement element : myElements) {
//			
//			  element.click();
//			 Thread.sleep(3000);
//			}
//		
		
	}
	
	//Flow method main business
	public void clickAddToCart(String quantity) {
		/*selectSize();
		selectColor();
		selectQty(quantity);*/
		driver.findElement(addToCart).click();
		
	}
	
	public void multipleAddToCart(String quantity,String product) {
		clickAddToCart(quantity);
		searchProduct(product);
		driver.findElement(addToCart).click();
	}
	
	
	public void addToWishlist() {
			driver.findElement(btbWishlist).click();	
		
	}
	
}

