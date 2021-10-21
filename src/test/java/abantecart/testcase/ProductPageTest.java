package abantecart.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import abantecart.pages.ProductPage;
import abantecart.utility.Utilities;

public class ProductPageTest {
	WebDriver driver;
	public Logger logger;
	Utilities util = new Utilities();
	
	
	ProductPage prdPage; 
	
	public ProductPageTest(WebDriver driver)
	{
		this.driver= driver;
		prdPage =  new ProductPage(driver);
		logger = util.log4jSetup("ProductPageTest");
	}
	
	@Test(priority=0)
	public void verifyProductTitle(){
		String productName = prdPage.getProductName();
		String title = prdPage.getTitle();
		Assert.assertTrue(productName.equals(title));
	}

	public void verifyRitle() {
		String productName = prdPage.getProductName();
		String title = prdPage.getTitle();
		Assert.assertTrue(productName.equals(title));
	}
	
	@Test
	public void verifyAddToCart() {
		System.out.println("Entered in Product");
		prdPage.clickAddToCart("2");
		Assert.assertTrue(prdPage.getTitle().equals("Shopping Cart"));
	}
//	
//	@Test(priority=3)
//	public void verifyMultipleAddToCart() {
//		prdPage.multipleAddToCart("1","Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie");
//		
//		
//		
//	}
	
	
//	@Test
//	public void addToWishlist() {
//		try {
//			prdPage.addToWishlist();
//		}catch(NoSuchElementException e) {
//			
//		}
//		
//		
//	}
//	@Test
//	public void productSize() {
//		prdPage.selectSize();
//	}
//	@Test
//	public void productColor() {
//		prdPage.selectColor();
//	}
//	@Test
//	public void productQuantity() {
//		prdPage.selectQty("2");
//	}
//	
//
//	public void howerOverImage() {
//		
//		
//	}
//	@Test(priority=1)
//	public void thumbnails() {
//		prdPage.clickThumbnailImage();
//		
//	}
////	
//	@Test
//	public void latestProductSection() {
//		Assert.assertTrue(prdPage.isLatestProductSection());
//		
//	}
	@Test
	public void breadCrumbs() throws InterruptedException {
		//method from home and then navigate
		prdPage.verifyBreadcrump();

		
	}
	
}