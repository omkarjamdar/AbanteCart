package abantecart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import abantecart.utility.BaseTest;

public class VerifyOrderSummeryPage extends BaseTest {
	

	public List<WebElement> prodpricelist() {
		List<WebElement>prodpricelist=driver.findElements(By.cssSelector("td[class='align_right valign_top']"));
		return prodpricelist;
	}

	public List<WebElement> productls() {
		List<WebElement>productls=driver.findElements(By.cssSelector("td[class$='align_left valign_top']"));
		return productls;
	}

	public List<WebElement> totalpricels() {
		List<WebElement>totalpricels=driver.findElements(By.cssSelector(".sidewidt table:nth-child(5) td:nth-child(2)"));
		return totalpricels;
	}
}
