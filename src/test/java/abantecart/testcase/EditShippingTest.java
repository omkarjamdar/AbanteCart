package abantecart.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import abantecart.pages.EditShippingPage;
import abantecart.utility.BaseTest;



public class EditShippingTest extends BaseTest {


	EditShippingPage editshipobj;
	AccountMainPageTest acc = new AccountMainPageTest();

	@BeforeClass()
	public void setup()
	{
		editshipobj=new EditShippingPage();
		driver.get("http://localhost/public_html/");
		userLogin("user_test", "pass",driver);

	}
	@SuppressWarnings("deprecation")
	@Test
	public void verifyEditShipping() 
	{

		FileInputStream FileInput;
		File src;
		@SuppressWarnings("unused")
		int length;
		Workbook wb;
		XSSFSheet Sheet;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(verifyCheckoutBtnClickable()) {


			System.out.println("checkout is clickable ");
			editshipobj.checkoutbtn().click();
			if(checkCartEmpty())
			{
				System.out.println("Cart is Empty");

			}

			else {

				try {
					src = new File("D:\\EditAddress.xlsx");
					FileInput = new FileInputStream(src);
					wb = new XSSFWorkbook(FileInput);
					Sheet = (XSSFSheet) wb.getSheetAt(0);
					length=Sheet.getLastRowNum() + 1;

					String fname=Sheet.getRow(1).getCell(0).getStringCellValue();
					String lname=Sheet.getRow(1).getCell(1).getStringCellValue();
					String Add1=Sheet.getRow(1).getCell(2).getStringCellValue();
					String city=Sheet.getRow(1).getCell(3).getStringCellValue();
					String state=Sheet.getRow(1).getCell(4).getStringCellValue();

					String country=Sheet.getRow(1).getCell(6).getStringCellValue();

					DataFormatter formatter = new DataFormatter();
					String postalc=formatter.formatCellValue(Sheet.getRow(1).getCell(5));



					if(verifyEditbtnclickable())
					{
						editshippingbtn.click();

						editshipobj.changeaddressbtn().click();

						editshipobj.firstnamefield().sendKeys(fname);

						editshipobj.lastnamefield().sendKeys(lname);
						WebElement Address1field=driver.findElement(By.name("address_1"));
						Address1field.sendKeys(Add1);
						WebElement Cityfield=driver.findElement(By.name("city"));
						Cityfield.sendKeys(city);
						System.out.println(postalc);

						editshipobj.postcodefield().sendKeys(postalc);

						editshipobj.countryfield().selectByVisibleText(country);

						editshipobj.Statefield().selectByVisibleText(state);

						editshipobj.continubtn().click();
						String address =driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/table[1]/tbody/tr/td[2]/address")).getText();
						if(address.contains(city)&&address.contains(state)&&address.contains(Add1)&&address.contains(postalc))
						{
							System.out.println("Address edited successfully ");

						}
						String namefield=driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/table[1]/tbody/tr/td[1]")).getText();
						if(namefield.contains(fname)&&namefield.contains(lname))
						{
							System.out.println("Name edited successfully ");
						}
					}
					else {
						System.out.println("Edit shipping button is not clickable");
					}


				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test(priority = 15)
	public void loggoff()
	{
		acc.logoffCheck();
	}

}
