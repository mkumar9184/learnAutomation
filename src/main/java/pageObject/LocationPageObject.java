/**
 * 
 */
package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilityfile.*;

/**
 * @author manoj.kumar
 *
 */
public class LocationPageObject extends BaseClass {

	private static WebElement element = null;

	public LocationPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	////////////// //Create New Location Button///////////////
	public static WebElement CreateNewLocation() throws Exception {
		try {

			element = driver.findElement(By.name("Button2"));
			Log.info("'Create New Location' button is found on the 'Location' Page");

		} catch (Exception e) {
			Log.error("'Create New Location' button is not found on the 'Location' Page");
			throw (e);
		}
		return element;
	}

	//////////////// Location code text Box///////////////
	public static WebElement LocationCodetxtBox() throws Exception {
		try {

			element = driver.findElement(By.id("selectedLocationCode"));
			Log.info("'Location Code' text box  is found on the 'Add Location' page");

		} catch (Exception e) {
			Log.error("'Location Code' text box  is not found on the 'Add Location' page");
			throw (e);
		}
		return element;
	}

	//////////////// Location Description text box///////////////
	public static WebElement LocationDesctxtBox() throws Exception {
		try {
			element = driver.findElement(By.id("selectedLocationDesc"));
			Log.info("'Location Description' text box  is found on the 'Add Location' page");

		} catch (Exception e) {
			Log.error("'Location Description' text box  is not found on the 'Add Location' page");
			throw (e);
		}
		return element;
	}

	//////////////// Location Add Location Button///////////////
	public static WebElement addLcoationButton() throws Exception {
		try {
			
			element = driver.findElement(By.name("add_btn"));
			Log.info("'Add Location' button  is found on the 'Add Location' page");
			
		} catch (Exception e) {
			
			Log.error("'Add Location' button  is not found on the 'Add Location' page");
			throw (e);
		}
		return element;
	}
	
	//////////////Messsage 
	public static WebElement successfulMsgtxt() throws Exception {
		try {
			
			element = driver.findElement(By.id("messageError"));
			Log.info("'Message;-  "+ element.getText() +" found  is  on the 'Locations' page");
			
		} catch (Exception e) {
			
			Log.error("'Add Location' button  is not found on the 'Add Location' page");
			throw (e);
		}
		return element;
	}
	
	public static void acceptPopupDialog() throws Exception{
		try{
			
			Alert alrt =driver.switchTo().alert();
			alrt.accept();
			
		} catch (Exception e){
			Log.error("Class Utils | Dialog Box | Exception occured while click on 'Ok' button on popupdialog : "+e.getMessage());
			throw new Exception();
		}
	}

	
	public static String popupDialogMsg() throws Exception{
		String msg= null;
		try{
			
			Alert alrt =driver.switchTo().alert();
			msg =alrt.getText();
			
			
		} catch (Exception e){
			Log.error("Class Utils | Dialog Box | Exception occured while click on 'Ok' button on popupdialog : "+e.getMessage());
			throw new Exception();
		}
		return msg;
	}

	
	public static void cancelPopupDialog() throws Exception{
		try{
			
			Alert alrt =driver.switchTo().alert();
			alrt.dismiss();
			
		} catch (Exception e){
			Log.error("Class Utils | Dialog Box | Exception occured while click on 'Cancel' button on popupdialog : : "+e.getMessage());
			throw new Exception();
		}
	}

}
