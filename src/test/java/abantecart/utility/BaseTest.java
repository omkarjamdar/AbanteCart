package abantecart.utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class BaseTest
{
public static WebDriver driver;

@BeforeSuite
public void launchBrowser()
{
//System.out.println("ssssss");
System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
driver=new ChromeDriver();
System.out.println("ssssss1111");
driver.get("http://localhost/public_html/");
}

@AfterSuite
public void closingBrowser()
{
driver.close();
}
}