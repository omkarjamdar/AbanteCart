package abantecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import abantecart.utility.BaseTest;

public class EditShippingPage extends BaseTest {
	
	
	 By changeaddressbtn=By.xpath("//a[normalize-space()='Change Address']");
	public WebElement changeaddressbtn() {
		return driver.findElement(changeaddressbtn);
	}

	By firstnamefield=By.name("firstname");
	public WebElement firstnamefield() {
		return driver.findElement(firstnamefield);
	}

	By lastnamefield=By.name("lastname");
	public WebElement lastnamefield() {
		return driver.findElement(lastnamefield);
	}

	By Address1field=By.name("address_1");
	public WebElement Address1field() {
		return driver.findElement(Address1field);
	}

	By Cityfield=By.name("city");
	public WebElement Cityfield() {
		return driver.findElement(Address1field);
	}

	By  postcodefield=By.name("postcode");

	public WebElement  postcodefield()
	{
		return driver.findElement(postcodefield);
	}
	By countryfield = By.name("country_id");
	public Select  countryfield()
	{
		return new Select(driver.findElement(countryfield));
	}
	

	By Statefield= By.name("zone_id");
	public Select  	Statefield() 
	{
		return new Select(driver.findElement(Statefield));
	}

	By continubtn=By.xpath("//*[@id=\"Address2Frm\"]/div/fieldset/div[10]/div/button");
	public WebElement continubtn()
	{
		return driver.findElement(continubtn);
	}
	By checkoutbtn = By.xpath("//span[normalize-space()='Checkout']");

	public WebElement checkoutbtn() {
		return driver.findElement(checkoutbtn);
	}
}
