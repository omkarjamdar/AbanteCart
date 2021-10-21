package abantecart.utility;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import abantecart.testcase.SetupDriver;

public class ScreenShot extends BaseTest
{
	
	public void getScreenshot() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		Date currentdate = new Date();
		String screenshotefilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(".//screenshot" + screenshotefilename + ".png"));
	}
}
