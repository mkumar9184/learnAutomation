package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObject.BaseClass;

public class ScreenShortslog extends BaseClass {
private static WebElement element = null;
 
	
	public ScreenShortslog(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public static String screenImapgePath(String filePath) throws IOException{
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,110)", "");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(filePath));
		return filePath;
		
	}

}
