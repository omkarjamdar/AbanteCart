package abantecart.utility;



import java.util.concurrent.TimeUnit;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Utilities
{
public WebDriver driver;
public Actions A;
public String LoginFile="D:\\Login Credentials.xlsx";



public String accountFile="D:\\Account_Data.xlsx";
public String registerFile="D:\\Register_Data.xlsx";

public Utilities()
{


}

@SuppressWarnings("deprecation")
public WebDriver browserSetup()
{
System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("http://localhost/public_html/");
A=new Actions(driver);
return driver;
}

public void userLogin(String username,String password,WebDriver driver)
{
driver.findElement(By.xpath("//a[normalize-space()='Login or register']")).click();
driver.findElement(By.id("loginFrm_loginname")).click();
driver.findElement(By.id("loginFrm_loginname")).sendKeys(username);
driver.findElement(By.id("loginFrm_password")).click();
driver.findElement(By.id("loginFrm_password")).sendKeys(password);
driver.findElement(By.cssSelector("button[title='Login']")).click();
}

public void scoller(int x,int y,WebDriver driver)
{
JavascriptExecutor js= (JavascriptExecutor)driver;
js.executeScript("window.scrollBy("+x+","+y+")");
}

public Logger log4jSetup(String ClassName)
{
Logger logger = Logger.getLogger(ClassName);
PropertyConfigurator.configure("Log4j.properties");
return logger;
}

}