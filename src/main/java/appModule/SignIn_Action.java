package appModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

import pageObject.LoginPageObject;
import utilityfile.Constant;
import utilityfile.ExcelUtils;
import utilityfile.Log;
import utilityfile.Utils;

public class SignIn_Action {
	 public static void Execute(int iTestCaseRow) throws Exception {
		 
		// Storing the UserName in to a String variable and Getting the UserName from Test Data Excel sheet
     	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
     	// Constant.Col_UserName is the column number for UserName column in the Test Data sheet
     	// Please see the Constant class in the Utility Package
     	// For Use of Constant Variables, please see http://www.toolsqa.com/constant-variables/
     	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
     	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
     	// This is call Page Object Model (POM)
     	// For use of POM, please see http://www.toolsqa.com/page-object-model/
     	Thread.sleep(20000);
     	
     	LoginPageObject.txtbx_UserName().sendKeys(sUserName);
         // Printing the logs for what we have just performed
         Log.info(sUserName+" is entered in UserName text box" );
         
         String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
         Log.info("Password:-"+sPassword );
         LoginPageObject.txtbx_PassWord().sendKeys(sPassword);
         Log.info(sPassword+" is entered in Password text box" );
         Thread.sleep(10000);
         LoginPageObject.btn_signin().click();
         Log.info("Click action is performed on Submit button");
         Thread.sleep(30000);
       
         Reporter.log("SignIn Action is successfully perfomred");
         
        
	 }

}
