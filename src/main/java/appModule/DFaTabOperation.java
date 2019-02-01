package appModule;

import pageObject.SearchDealerPageObject;
import pageObject.TopNavigstionPageObject;
import utility.Constant;
import utility.Log;

public class DFaTabOperation {
	public static void AdminTab() throws Exception{
		
		TopNavigstionPageObject.label_AdminTab().click();
		 Log.info("Click on Admin Tab" );

		 Log.info("Click on Admin Tab In GitHub" );
		}
}
