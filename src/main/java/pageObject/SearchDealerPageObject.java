package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilityfile.Log;

public class SearchDealerPageObject extends BaseClass {

	private static WebElement element = null;
	
	public SearchDealerPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static WebElement txtbx_Dealer_Account() throws Exception{
     	try{
	            element = driver.findElement(By.id("dealerSearchText"));
	            System.out.println(element.getText());
	            Log.info("Search text box is found on the DFA Home Page");
     	}catch (Exception e){
        		Log.error("Search text box is not found on the DFA Home Page");
        		throw(e);
        		}
        	return element;
         }
	
	public static WebElement btn_Change() throws Exception{
     	try{
	            element = driver.findElement(By.name("Button223222"));
	            System.out.println(element.getText());
	            Log.info("'Change' button is found on the DFA Home Page");
     	}catch (Exception e){
        		Log.error("'Change' button is not found on the DFA Home Page");
        		throw(e);
        		}
        	return element;
         }
	
	
}
