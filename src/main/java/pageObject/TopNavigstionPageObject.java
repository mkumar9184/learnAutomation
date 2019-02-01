package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilityfile.Log;

public class TopNavigstionPageObject extends BaseClass {
	
	private static WebElement element = null;
	
	public TopNavigstionPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public static WebElement label_AdminTab() throws Exception{
     	try{
	            element = driver.findElement(By.xpath(".//*[@id='headerTabGreyAdmin']/a"));
	          //  System.out.println(element.getText());
	            Log.info(" 'Admin Tab' is found on the DFA Home Page");
     	}catch (Exception e){
        		Log.error("'Admin Tab' is not found on the DFA Home Page");
        		throw(e);
        		}
        	return element;
         }

	public static WebElement LocationLink() throws Exception{
     	try{
	            element = driver.findElement(By.xpath (".//*[@id='LocationMaintenance']/a"));
	          //  System.out.println(element.getText());
	            Log.info(" 'Location Link' is found on the DFA Home Page");
     	}catch (Exception e){
        		Log.error("'Location Link' is not found on the DFA Home Page");
        		throw(e);
        		}
        	return element;
         }

	
}
