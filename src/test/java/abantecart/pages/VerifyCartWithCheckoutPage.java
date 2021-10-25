package abantecart.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import abantecart.utility.BaseTest;

public class VerifyCartWithCheckoutPage extends BaseTest{

	
	public List<WebElement> checkoutprodlist() {
		List<WebElement>checkoutprodlist=driver.findElements(By.xpath("//td[@class='align_left valign_top']//a"));
		return checkoutprodlist;
	}
	
}
