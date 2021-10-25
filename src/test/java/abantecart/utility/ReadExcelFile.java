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
	
	List<String> accFname=new ArrayList<String>();
	List<String> accLname =new ArrayList<String>();
	List<String> accEmail =new ArrayList<String>();
	List<String> acccurrentpassword =new ArrayList<String>();
	List<String> newpassword =new ArrayList<String>();
	List<String> accconfirmpassword =new ArrayList<String>();
	List<String> data = new ArrayList<String>();
	public String acccity,fname,lname,accaddress,city2;
	public double acczipcode,zipcode2;

		
	public void setup(int sheetnum)
	{
		src = new File("D:\\resource\\Register_Data.xlsx");
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
		setup(sheetnum);
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
	
	public List<List<String>> account(int sheetnum)
	{
		setup(sheetnum);
		for(int i=0;i<=2;i++)
		{
			
		    accFname.add(Sheet.getRow(i).getCell(0).getStringCellValue());
			accLname.add(Sheet.getRow(i).getCell(1).getStringCellValue());
			accEmail.add(Sheet.getRow(i).getCell(2).getStringCellValue());
				
		}
		for(int j=3;j<=5;j++)
		{
			acccurrentpassword.add(Sheet.getRow(j).getCell(0).getStringCellValue());
			newpassword.add(Sheet.getRow(j).getCell(1).getStringCellValue());
			accconfirmpassword.add(Sheet.getRow(j).getCell(2).getStringCellValue());
		}
		
		data.add(Sheet.getRow(6).getCell(0).getStringCellValue());
		acczipcode=Sheet.getRow(6).getCell(1).getNumericCellValue();
		String acc_zipcode = Double.toString(acczipcode);
		data.add(acc_zipcode);
		data.add(Sheet.getRow(7).getCell(0).getStringCellValue());
		data.add(Sheet.getRow(7).getCell(1).getStringCellValue());
		data.add(Sheet.getRow(7).getCell(2).getStringCellValue());
		data.add(Sheet.getRow(7).getCell(3).getStringCellValue());
		zipcode2=Sheet.getRow(7).getCell(4).getNumericCellValue();
		String zip2 = Double.toString(zipcode2);
		data.add(zip2);
		
		
		List<List<String>>  account;
		account=Arrays.asList(accFname,accLname,accEmail,acccurrentpassword,newpassword,accconfirmpassword,data);
		return account;
	}
	
}
