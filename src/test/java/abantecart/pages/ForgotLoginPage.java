package abantecart.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abantecart.utility.BaseTest;
import abantecart.utility.Utilities;



public class ForgotLoginPage extends BaseTest
{
Utilities util = new Utilities();
//public WebDriver driver = util.browserSetup();



By loginlink = By.xpath("//a[normalize-space()='Login or register']");



public WebElement loginLink() {
return driver.findElement(loginlink);
}

By forgotLoginLink = By.xpath("//a[normalize-space()='Forgot your login?']");

public WebElement forgotLoginLink()
{
return driver.findElement(forgotLoginLink);
}

By lastname = By.id("forgottenFrm_lastname");
public WebElement lastname()
{
return driver.findElement(lastname);
}

By emailID = By.id("forgottenFrm_email");
public WebElement email()
{
return driver.findElement(emailID);
}

By continuebtn = By.cssSelector("button[title='Continue']");
public WebElement continueBtn()
{
return driver.findElement(continuebtn);
}

By backbtn = By.xpath("//a[@title='Back']");
public WebElement backBtn()
{
return driver.findElement(backbtn);
}
}