package appModule;

import pageObject.TopNavigstionPageObject;
import utilityfile.Log;

public class DFaTabOperation {
	public static void AdminTab() throws Exception{
		
		TopNavigstionPageObject.label_AdminTab().click();
		 Log.info("Click on Admin Tab" );
		 
		 Log.info("Successfully Click on Admin Tab" );

				}
}
