package appModule;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageObject.BaseClass;
import pageObject.SearchDealerPageObject;
import utilityfile.Constant;
import utilityfile.ExcelUtils;
import utilityfile.HTMLTableBuilder;
import utilityfile.Log;
import utilityfile.ScreenShortslog;

public class SearchDealerID {

	

	public static void SearchDealer() throws Exception {
		int count = 0;
		String imgfilepath= null;
		count= count+1;
		HTMLTableBuilder htmlpage = new HTMLTableBuilder("Dealer Search", true, 3, 5);
		String Filepath = htmlpage.CreateDirectory("F://DFALogFile_TestNGAutomation//", "SearchDealer");
		System.out.println(Filepath);
		htmlpage.addTableHeader("TestCaseID", "Step", "Expected Result", "Status", "SnapLink");
		String dealerID = Constant.DeaelrId;
		
		SearchDealerPageObject.txtbx_Dealer_Account().sendKeys(dealerID);
		Log.info(dealerID + " is entered in UserName text box");
		imgfilepath=ScreenShortslog.screenImapgePath(Filepath+"//Dealersearchpage.png");
		htmlpage.addRowValues(imgfilepath,String.valueOf(count++), "Enter " +  dealerID+ " in 'Dealer Account Number ' text box for Search dealer " ,
				"Dealer - " + dealerID + " is successfully entered  in 'Dealer Account Number ' text box", "Pass", "ClickLog");
	
		//count= count+1;
		SearchDealerPageObject.btn_Change().click();
		Log.info("Click action is performed on Change button");
		imgfilepath =ScreenShortslog.screenImapgePath(Filepath+"//DealersearchSuccessfull.png");
		
		
		htmlpage.addRowValues(imgfilepath, String.valueOf(count++), "Click action is performed on Change button ",
				"Dealer - " + dealerID + " is successfully Search", "Pass", "ClickLog");


	//	htmlpage.addRowValues(imgfilepath, String.valueOf(count++), "Click action is performed on Change button ",
		//		"Dealer - " + dealerID + " is successfully Search", "Pass", "ClickLog");

		String table = htmlpage.build();
		// /F://SearchDealer.html
		HTMLTableBuilder.Htmfilecreateor(Filepath + "//SearchDealer.html", table);

	}
}
