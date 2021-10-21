package abantecart.utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends ScreenShot implements ITestListener  
{
	public void onTestStart(ITestResult result)
	{
			System.out.println("Test case is starting");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test case is success");
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test case is Failed");
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		
	}
}
