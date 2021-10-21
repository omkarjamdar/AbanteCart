package abantecart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile 
{
	public FileInputStream FileInput;
	public File src;
	public int length;
	public Workbook wb;
	public XSSFSheet Sheet;
	public XSSFSheet Cell;
	List<String> username = new ArrayList<String>();
	List<String> password = new ArrayList<String>();
	List<String> loginname = new ArrayList<String>();
	List<String> password_email = new ArrayList<String>();
	List<String> loginname_email = new ArrayList<String>();
	List<String> firstname =new ArrayList<String>();
	List<String> lastname =new ArrayList<String>();
	List<String> email =new ArrayList<String>();
	List<String> address =new ArrayList<String>();
	List<String> city =new ArrayList<String>();
	List<String> zipcode = new ArrayList<String>();
	List<String> registerloginname =new ArrayList<String>();
	List<String> registerpassword =new ArrayList<String>();
	List<String> confirmpassword =new ArrayList<String>();
	List<String> state =new ArrayList<String>();
	List<String> country =new ArrayList<String>();

		
	public void setup(int sheetnum)
	{
		src = new File("D:\\Login Credentials.xlsx");
		try 
		{
			FileInput = new FileInputStream(src);
			wb = new XSSFWorkbook(FileInput);
			Sheet = (XSSFSheet) wb.getSheetAt(sheetnum);
			length=Sheet.getLastRowNum() + 1;
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setupforregistration(int sheetnum)
	{
		src = new File("D:\\Register_Data.xlsx");
		try 
		{
			FileInput = new FileInputStream(src);
			wb = new XSSFWorkbook(FileInput);
			Sheet = (XSSFSheet) wb.getSheetAt(sheetnum);
			length=Sheet.getLastRowNum() + 1;
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<List<String>> loginCredentials(int sheetnum)
	{
		setup(sheetnum);
		for (int i = 0; i < length; i++) 
		{
			username.add(Sheet.getRow(i).getCell(2).getStringCellValue());
			password.add(Sheet.getRow(i).getCell(3).getStringCellValue());					// Fetching login name and password
		}
		
		List<List<String>>  credentials;
		credentials=Arrays.asList(username, password);
			
		return credentials;
	}
	
	public List<List<String>> forgotPasswordCredentials(int sheetnum)
	{
		setup(sheetnum);
		for (int i = 0; i < length; i++) 
		{
			loginname.add(Sheet.getRow(i).getCell(2).getStringCellValue());					// Fetching login name and email address
			password_email.add(Sheet.getRow(i).getCell(4).getStringCellValue());
		}
		
		List<List<String>>  forgotPassCredentials;
		forgotPassCredentials=Arrays.asList(loginname, password_email);
		return forgotPassCredentials;
	}
	
	
	public List<List<String>> forgotLoginCredentials(int sheetnum)
	{
		setup(sheetnum);
		for (int i = 0; i < length; i++) 
		{
			loginname.add(Sheet.getRow(i).getCell(1).getStringCellValue());							// Fetching last name and email address
			loginname_email.add(Sheet.getRow(i).getCell(4).getStringCellValue());
		}
		
		List<List<String>>  forgotLoginCredentials;
		forgotLoginCredentials=Arrays.asList(loginname, loginname_email);
		return forgotLoginCredentials;
	}
	
	public List<List<String>> registration(int sheetnum)
	{
		setupforregistration(sheetnum);
		for(int i=0;i<Sheet.getLastRowNum()+1;i++)
		{
			firstname.add(Sheet.getRow(i).getCell(0).getStringCellValue());
			lastname.add(Sheet.getRow(i).getCell(1).getStringCellValue());
			email.add(Sheet.getRow(i).getCell(2).getStringCellValue());
			address.add(Sheet.getRow(i).getCell(3).getStringCellValue());
			city.add(Sheet.getRow(i).getCell(4).getStringCellValue());
			//zipcode.add(Sheet.getRow(i).getCell(5).getNumericCellValue());
			//zipcode.add(Sheet.getRow(i).getCell(5).getNumericCellValue());
			//zipcode.add(Sheet.getRow(i).getCell(5).getStringCellValue());
			double z= Sheet.getRow(i).getCell(5).getNumericCellValue();
			DecimalFormat format = new DecimalFormat("0.#");
			String zip = format.format(z);
			zipcode.add(zip);
			state.add(Sheet.getRow(i).getCell(6).getStringCellValue());
			country.add(Sheet.getRow(i).getCell(7).getStringCellValue());
			registerloginname.add(Sheet.getRow(i).getCell(8).getStringCellValue());
			registerpassword.add(Sheet.getRow(i).getCell(9).getStringCellValue());
			confirmpassword.add(Sheet.getRow(i).getCell(10).getStringCellValue());
			//util.userLogin("Shetty_3579", "asdf1234",driver);					
		}
		List<List<String>>  registration;
		registration=Arrays.asList(firstname,lastname,email,address,city,zipcode,state,country,registerloginname,registerpassword,confirmpassword);
		return registration;	
	}
	
}
