package abantecart.testcase;

import java.io.File;
import abantecart.pages.*;
import abantecart.testcase.*;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import abantecart.pages.ProductPage;
import abantecart.utility.BaseTest;
import abantecart.utility.ScreenShot;
import abantecart.utility.Utilities;

public class ProductPageTest extends BaseTest{

	ProductPage productPage = new ProductPage();
	AccountMainPageTest acc = new AccountMainPageTest();
	//Utilities util;
	public Logger logger;
	SoftAssert softAssert = new SoftAssert();
	public int var=0;
	
	
	@BeforeClass
	public void login() {
		driver.get("http://localhost/public_html/");
		var=1;
		//util = new Utilities();
		userLogin("user_test", "pass",driver);
		logger = BaseTest.log4jSetup("ProductPageTest");
		driver.navigate().to("http://localhost/public_html/index.php?rt=product/product&path=68_69&product_id=116");
		
	}
	
	public void ProductPageSetup(String className)
	{
		this.logger=BaseTest.log4jSetup(className);
	}
	//check corresponding product title and name is correct
	@Test(priority = 0, groups={"UI","Regression"})
	public void verifyProductTitle() {
		String productName = productPage.getProductName();
		String title = productPage.getTitle();
		if(var==1)
		logger.info("product title is correct");
		softAssert.assertTrue(productName.equals(title));
	}
	//check product image thumbnails 
	@Test(priority = 0, groups={"UI","Regression"})
	public void verifyProductImageThumbnails() {
		boolean expected = productPage.clickThumbnailImage();
		softAssert.assertTrue(expected, "No thumbnails present");
		logger.info("product thumbnails are correct");
	}

	@Test(priority = 2, groups={"Functional","Regression"})
	public void verifyProductAddToWishlist() {
		try {
			productPage.addToWishlist();
			//log - added to wish list
		} catch (Exception e) {
			//log - exception e occured for add to wish list
			//TakesScreenshot scrShot = (TakesScreenshot) productPage.driver;
			ScreenShot src = new ScreenShot();
			try {
				String abc = src.getScreenshot();
				//FileUtils.copyFile(SrcFile, new File("D:\\Selenium\\categoryHome2.png"));
			
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
	}

	/*@Test(priority = 3, groups={"Functional","Regression"})
	public void verifyRemoveFromWishlist() {
		try {
			if(var==1)
			productPage.removeFromWishlist();
			logger.info("product removed from wish list successfully");
		} catch (NoSuchElementException e) {
			if(var==1)
			logger.info("exception e occured for add to wish list");
			//screenshot
		}

	}*/

	//verify latest section
	@Test(priority = 1)
	public void verifyLatestProductSection() {
		softAssert.assertTrue(productPage.isLatestProductSection());
		if(var==1)
		logger.info("latest product section correct");
	}
	//add to cart
	@Test(priority = 4)
	public void verifyProductAddToCart() {
		productPage.clickAddToCart("1");
		softAssert.assertTrue(productPage.getTitle().equals("Shopping Cart"));
		if(var==1)
		{
		logger.info("Added product to cart with quantity");
		}
	}

	public void cartadd()
	{
		productPage.clickCart1();
	}
	// COMMENTS add to cart throught latest product
	@Test(priority = 6)
	public void verifyLatestProductAdd() {
		productPage.driver.navigate().to("http://localhost/public_html/index.php?rt=product/product&path=68_69&product_id=116");
		productPage.selectLatestProduct();
		productPage.clickCart();
		if(var==1)
		logger.info("latest product added to cart");

	}
	// verify related product add to cart
	@Test(priority = 7)
	public void verifyRelatedProductAdd() {
		productPage.driver.navigate().to("http://localhost/public_html/index.php?rt=product/product&path=68_69&product_id=116");
		productPage.selectRelatedProduct();
		productPage.clickCart();
		if(var==1)
		logger.info("related product add to cart");
	}
	// multiple product add to cart
	@Test(priority = 5)
	public void verifyMultipleAddToCart() {
		productPage.driver.navigate().back();
		productPage.multipleAddToCart("1", "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie");
		softAssert.assertTrue(productPage.getTitle().equals("Shopping Cart"), "Add multiple product to cart failed!");
		//log 
	}
	// check product size field
	@Test(priority = 1)
	public void productSize() {
		productPage.selectSize();
	}
	// check product color field
	@Test(priority = 1)
	public void productColor() {
		productPage.selectColor();
	}
	// check product quantity
	@Test(priority = 1)
	public void productQuantity() {
		productPage.selectQuantity("2");
	}
	//verify product size is disable
	@Test(priority = 1)
	public void verifyProductSizeDisable() {
		softAssert.assertFalse(productPage.isDisableSize());
	}
	//check add to cart without size shows alert
	@Test(priority = 0)
	public void verifyAddToCartWithoutSize() {
		productPage.selectColor();
		productPage.selectQuantity("2");
		productPage.clickCart();
		softAssert.assertTrue(productPage.alertMessage().equals("\nUK size: Please select all required options!"));
	}
	//check hover over product image
	@Test(priority = 1)
	public void verifyHowerOverProductImage() {

		try {
			productPage.hoverOver();
		} catch (Exception e) {
			//TakesScreenshot scrShot = (TakesScreenshot) productPage.driver;
			ScreenShot src = new ScreenShot();
			try {
				String abc = src.getScreenshot();
				//FileUtils.copyFile(SrcFile, new File("D:\\Selenium\\categoryHome2.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	//check breadcrumb is valid
	@Test(priority = 1)
	public void verifyBreadCrumbs() throws InterruptedException {

		softAssert.assertTrue(productPage.checkBreadCrumb());

	}
	
	@Test(priority = 15)
	public void loggoff()
	{
		acc.logoffCheck();
	}

//	
//	@Test
//	public void verifyPrint() {
//		productPage.performPrint();
//		
//		
//	}
}