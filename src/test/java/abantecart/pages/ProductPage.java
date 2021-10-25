package abantecart.pages;
//
//import java.io.IOException;
//import java.util.Collections;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class ProductPage extends BaseTest{

	Utilities util = new Utilities();
	//public WebDriver driver = util.browserSetup();

	By productName = By.cssSelector(".bgnone");
	By addToCart = By.cssSelector(".cart");
	By btnSize = By.cssSelector("input#option344750");
	By productColor = By.cssSelector("option[value='752']");
	By txtProductQantity = By.name("quantity");
	By btnWishlist = By.cssSelector("a.wishlist_add");
	By btnRemoveFromWishlist = By.cssSelector("a.wishlist_remove");
	By thumbnail = By.cssSelector(".thumbnails.mainimage.smallimage li");
	By btnSizeDisable = By.cssSelector("input#option344751");
	By latestProduct = By.cssSelector("ul.side_prd_list li");
	By relatedProduct = By.cssSelector("ul.row.side_prd_list li");
	By breadCrumbLast = By.xpath("//ul[@class='breadcrumb']/li[last()]");
	By breadCrumbFirst = By.xpath("//ul[@class='breadcrumb']/li[1]");
	By txtSearch = By.cssSelector("input.pull-left.input-medium.search-query.dropdown-toggle");
	By productSelectName = By.xpath("//a[@title='Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie']");
			

	By btnPrint = By.cssSelector("a.productprint");
	By txtAlert = By.cssSelector("div.alert-error");
	By productImage = By.cssSelector("a.local_image");
	
	By relatedProductSection = By.xpath("//a[@href='#relatedproducts']");
	
	By latestaddtocart = By.xpath("//a[@class='cart']");

	// METHODS
	public String getTitle() {
		return driver.getTitle();

	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectSize() {
		driver.findElement(btnSize).click();
	}

	public void selectColor() {
		driver.findElement(productColor).click();
	}

	@SuppressWarnings("deprecation")
	public void selectLatestProduct() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		List<WebElement> myLatestElements = driver.findElements(latestProduct);
		myLatestElements.get(0).click();

	}

	@SuppressWarnings("deprecation")
	public void selectRelatedProduct() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(relatedProductSection).click();
		List<WebElement> myRelatedProduct = driver.findElements(relatedProduct);
		myRelatedProduct.get(1).click();

	}

	public void selectQuantity(String arg) {
		driver.findElement(txtProductQantity).clear();
		driver.findElement(txtProductQantity).sendKeys(arg);
	}

	public boolean clickThumbnailImage() {
		List<WebElement> myElements = driver.findElements(thumbnail);
		for (WebElement element : myElements) {
			element.click();
		}

		if (myElements.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void searchProduct(String product) {
		driver.findElement(txtSearch).sendKeys(product);
		driver.findElement(txtSearch).sendKeys(Keys.ENTER);
		driver.findElement(productSelectName).click();
	}

	public boolean isLatestProductSection() {
		List<WebElement> myElements = driver.findElements(latestProduct);
		for (WebElement element : myElements) {
			if (!(element.getTagName().isEmpty())) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean checkBreadCrumb() {
		List<WebElement> ancestors = driver.findElement(By.className("breadcrumb")).findElements(By.tagName("a"));
		int countBreadCrumb = 0;
		String firstBreadCrumb = driver.findElement(breadCrumbFirst).getText();
		for (WebElement link : ancestors) {
			if (!(link.getText().isEmpty())) {
				countBreadCrumb += 1;
			}

			if (countBreadCrumb >= 2 && firstBreadCrumb.startsWith("Home")) {
				return true;
			}
		}
		return false;
	}

	public boolean isDisableSize() {
		WebElement checkDisable = driver.findElement(btnSizeDisable);
		if (checkDisable.isEnabled()) {
			return true;
		}
		return false;

	}
	
	public void clickCart1()
	{
		driver.findElement(latestaddtocart);
	}

	public void clickCart() {
		driver.findElement(addToCart).click();
	}

	public String alertMessage() {
		return driver.findElement(txtAlert).getText().substring(1);
	}

	// Flow method main business
	public void clickAddToCart(String quantity) {
		String prdType = driver.getTitle();
		if (!(prdType.contains("Shirt"))) {
			selectSize();
			selectColor();
			selectQuantity(quantity);

		}
		clickCart();

	}

	public void multipleAddToCart(String quantity, String product) {
		clickAddToCart(quantity);
		searchProduct(product);
		driver.findElement(addToCart).click();
	}

	public void addToWishlist() {
		
		driver.findElement(btnWishlist).click();
	}

	public void removeFromWishlist() {
		driver.findElement(btnRemoveFromWishlist).click();
	}

	public void hoverOver() {
		WebElement element = driver.findElement(productImage);

		((JavascriptExecutor) driver).executeScript("var mouseEvent = document.createEvent('MouseEvents');"
				+ "														mouseEvent.initEvent('mouseover', true, true); "
				+ "														arguments[0].dispatchEvent(mouseEvent);",
				element);

	}

	
//	@SuppressWarnings("deprecation")
//	public void performPrint() {
//		WebElement printButton = driver.findElement(btnPrint); // logMessage("Click the print sbutton!");
//		printButton.click(); // logMessage("The Print Preview is displayed!");
//		for (String winHandle : driver.getWindowHandles()) {
//			System.out.println("Window Handle: " + winHandle);
//		}
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		System.out.println("Get the cancel button!");
////		Thread.sleep(4000);
//		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
//		Actions act = new Actions(driver); // act.sendKeys(Keys.TAB).build().perform(); ////
////		Thread.sleep(4000); //// act.sendKeys(Keys.TAB).build().perform(); //
////		Thread.sleep(4000);
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		act.sendKeys(Keys.RETURN).build().perform(); //
//		act.sendKeys(Keys.RETURN).build().perform();
////		Thread.sleep(3000);
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		try {
//			Runtime.getRuntime().exec("D:\\Selenium\\download.exe" + "");
//		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
//
//	  }
// 
//	 
//}
}
