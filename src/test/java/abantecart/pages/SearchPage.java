package abantecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;

public class SearchPage extends BaseTest{
	

	Utilities utilitiesObj=new Utilities();	
	//public WebDriver driver=utilitiesObj.browserSetup();;

	//@FindBy(xpath="//*[@id=\"filter_keyword\"]")
	public By searchBoxWeb=By.xpath("//input[@id='filter_keyword']");
	
	public  By searchBtnWeb=By.className("button-in-search");
	
	public By searchResultWeb=By.xpath("//h4[normalize-space()='Products meeting the search criteria']");
	
	public By searchCategoriesweb=By.id("search-category");
	 
	 public WebElement searchBox() {
		// return searchBoxweb;
		 
		 return driver.findElement(searchBoxWeb);
	 }
	 
	 public WebElement serchBtn() {
		 return driver.findElement(searchBtnWeb);
	 }
	
	 public WebElement searchResult() {
		 return driver.findElement(searchResultWeb);
	 }
	 public WebElement searchCategory() {
		 return driver.findElement(searchCategoriesweb).findElement(By.xpath("//a[@id='category_36']"));
		 
	 }
}
