package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilityfile.Log;

public class LoginPageObject extends BaseClass {
	private static WebElement element = null;
 
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	 
	
	 public static WebElement txtbx_UserName() throws Exception{
     	try{
	            element = driver.findElement(By.id("okta-signin-username"));
	            System.out.println(element.getText());
	            Log.info("Username text box is found on the Login Page");
     	}catch (Exception e){
        		Log.error("UserName text box is not found on the Login Page");
        		throw(e);
        		}
        	return element;
         }
	 
	 public static WebElement txtbx_PassWord() throws Exception{
	     	try{
		            element = driver.findElement(By.id("okta-signin-password"));
		            Log.info("Password text box is found on the Login Page");
	     	}catch (Exception e){
	        		Log.error("Password text box is not found on the Login Page");
	        		throw(e);
	        		}
	        	return element;
	         }
		
	 
	 public static WebElement btn_signin() throws Exception{
	     	try{
		            element = driver.findElement(By.id("okta-signin-submit"));
		            Log.info("'Sigin Buton'  is found on the Login Page");
	     	}catch (Exception e){
	        		Log.error("'Sigin Buton'  is not found on the Login Page");
	        		throw(e);
	        		}
	        	return element;
	         }
//   
	
	 public static WebElement btn_OctaVerification() throws Exception{
	     	try{
		            element = driver.findElement(By.id(".//*[@id=form60]/div[2]/input"));
		            Log.info("OctaVerification button  is found on the Login Page");
	     	}catch (Exception e){
	        		Log.error("OctaVerification button  is found on the Login Page");
	        		throw(e);
	        		}
	        	return element;
	         }
}
