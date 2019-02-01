package appModule;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageObject.BaseClass;
import pageObject.LocationPageObject;
import pageObject.TopNavigstionPageObject;
import utilityfile.HTMLTableBuilder;
import utilityfile.Log;
import utilityfile.ScreenShortslog;
import utilityfile.Utils;

public class DealerLocation extends BaseClass {
	
	

	public DealerLocation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void AddLocation() throws Exception { 
		
	int count = 0;
	String imgfilepath= null;
	count= count+1;
	String popupmsg = null;
	
	HTMLTableBuilder htmlpage = new HTMLTableBuilder("Add New Location", true, 3, 5);
	String Filepath = htmlpage.CreateDirectory("F://DFALogFile_TestNGAutomation//", "Add_New_Location");
	htmlpage.addTableHeader("TestCaseID", "Step", "Expected Result", "Status", "SnapLink");
	
	TopNavigstionPageObject.LocationLink().click();
	
	Log.info("Successfully Click on Location link ");
	imgfilepath=ScreenShortslog.screenImapgePath(Filepath+"//LocationsPage.png");
	htmlpage.addRowValues(imgfilepath,String.valueOf(count++), "Click on Location link" ,
			"Locations page is successfuly displayed", "Pass", "ClickLog");

	Log.info("Successfully Click on Location link ");
	//Click on "Create New Location" button
	LocationPageObject.CreateNewLocation().click();
	Log.info("Successfully Click on Location link ");
	imgfilepath=ScreenShortslog.screenImapgePath(Filepath+"//AddnewLocationPage.png");
	htmlpage.addRowValues(imgfilepath,String.valueOf(count++), "Click on 'Create New Location' Button" ,
			"Add new location page is successfuly displayed", "Pass", "ClickLog");
	
	

	//Enter Location number
	LocationPageObject.LocationCodetxtBox().sendKeys("55");
	Log.info("Successfully Enter location code in 'Location code' text box ");
	imgfilepath=ScreenShortslog.screenImapgePath(Filepath+"//AddnewLocationcodePage.png");
	htmlpage.addRowValues(imgfilepath,String.valueOf(count++), "Enter  Location code in 'Location code text box'" ,
			"Successfully Enter location code in 'Location code' text box", "Pass", "ClickLog");
	
	
	//Enter Location number
		LocationPageObject.LocationDesctxtBox().sendKeys("Test New Location");
		Log.info("Successfully Enter location description in 'Location description' text box ");
		imgfilepath=ScreenShortslog.screenImapgePath(Filepath+"//AddnewLocationcodedescPage.png");
		htmlpage.addRowValues(imgfilepath,String.valueOf(count++), "Enter  Location description in ''Location description' text box'" ,
				"Successfully Enter location description in 'Location description'text box", "Pass", "ClickLog");
		
	
		//Click on "Add new Location" button
		LocationPageObject.addLcoationButton().click();
		
		/*Log.info("Successfully click on 'Add location' button ");
		imgfilepath=Filepath+"//AddnewLocationPopup.png";
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(imgfilepath));
		htmlpage.addRowValues(imgfilepath,String.valueOf(count++), "Click on 'Add New Location' button" ,
				"Popup dialog is displyed with messge 'Are you sure want to add new location'", "Pass", "ClickLog");
		*/
		
		popupmsg= LocationPageObject.popupDialogMsg();
		
		Log.info(popupmsg);
		
		LocationPageObject.acceptPopupDialog();
		Log.info("Successfully click on popup' button ");
		imgfilepath=ScreenShortslog.screenImapgePath(Filepath+"//AddnewLocationsuccess.png");
		htmlpage.addRowValues(imgfilepath,String.valueOf(count++), "Click on 'Add New Location' button and Click on 'Ok' button of popup dialog" ,
				"Location code is successfully added for the dealer", "Pass", "ClickLog");
		
		
	String table = htmlpage.build();
	
	HTMLTableBuilder.Htmfilecreateor(Filepath + "//Add_New_Location.html", table);
	}
}
