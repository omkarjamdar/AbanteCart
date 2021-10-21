package abantecart.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import abantecart.utility.Utilities;

public class SetupDriver 
{
	public WebDriver driver;
	public String filename;
	@BeforeClass
	public void setup()
	{
		 System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	
	}
}
