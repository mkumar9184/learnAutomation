package testcase;

import org.testng.annotations.Test;

import appModule.DFaTabOperation;
import appModule.DealerLocation;
import appModule.SearchDealerID;
import appModule.SignIn_Action;
import pageObject.BaseClass;
import pageObject.TopNavigstionPageObject;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
  @Test
  public void main() throws Exception {
	  
	// Every exception thrown from any class or method, will be catch here and will be taken care off
		  // For Exception handling please see http://www.toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/
		  try{
			  
			  
			// Here we are calling the SignIN Action and passing argument (iTestCaseRow)
			// This is called Modularization, when we club series of actions in to one Module
			// For Modular Driven Framework, please see http://www.toolsqa.com/modular-abdriven/  
			  SignIn_Action.Execute(iTestCaseRow);
			  Utils.takeScreenshot(driver, "AdminTest");
			///Search dealer Id In Dfa application
			  DFaTabOperation.AdminTab();	
			  
			  Log.info("'//////////////////Search  operation started////////");
			  SearchDealerID.SearchDealer();
			 Utils.takeScreenshot(driver, "DealerSearch");
			 
			 Log.info("'//////////////////Search operation End//////////");
			  Thread.sleep(1000);
			/*//  DFaTabOperation.AdminTab();	
			 // Utils.takeScreenshot(driver, sTestCaseName);
			//  TopNavigstionPageObject.LocationLink().click();	
			  */
			  
			  
			  //////////Add New Location functionality///////// 
			  Log.info("'//////////////////Location operation started/////////");
			//  TopNavigstionPageObject.LocationLink().click();	
			  
			  DealerLocation.AddLocation();
			  
			 // Utils.takeScreenshot(driver, "Locations");
			  Log.info("'//////////////////Location operation End////////////");
			  
			//  Utils.takeScreenshot(driver, "Locations");
			  
			  if(BaseClass.bResult==true){
				// If the value of boolean variable is True, then your test is complete pass and do this
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			}else{
				// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
				// This is to throw exception in case of fail test, this exception will be caught by catch block below
				throw new Exception("Test Case Failed because of Verification");
			}
			
		  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
		  }catch (Exception e){
			  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
			  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
			  Utils.takeScreenshot(driver, sTestCaseName);
			  // This will print the error log message
			  Log.error(e.getMessage());
			  // Again throwing the exception to fail the test completely in the TestNG results
			  throw (e);
		  }
		  
		
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	   // Configuring Log4j logs, please see the following posts to learn about Log4j Logging
	    // http://www.toolsqa.com/test-case-with-log4j/
	    // http://www.toolsqa.com/log4j-logging/
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		// For Constant Variables please see http://www.toolsqa.com/constant-variables/
		// For setting up Excel for Data driven testing, please see http://www.toolsqa.com/data-driven-testing-excel-poi/
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		// Now we do need to provide the Selenium driver to any of the Page classes or Module Actions
		// Will soon write a post on Base Class
		new BaseClass(driver);  
  }

  @AfterMethod
  public void afterMethod() {
	  Log.endTestCase(sTestCaseName);
	  driver.quit();
  }

}
