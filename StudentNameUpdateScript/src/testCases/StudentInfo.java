package testCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.LoggedIn_Page;
import utility.Constant;
import utility.Utils;

public class StudentInfo {
	public static void nameUpdate() throws Exception {

		Home_Page.lnk_Login().click();

		Select sel = new Select(Home_Page.dropdown_ApplyingFor());
		Thread.sleep(2000);
		//		sel.selectByVisibleText(Constant.CourseType);
		sel.selectByIndex(Constant.CourseType);
		Utils.enterData(Home_Page.txtbx_Email(), Constant.Username);
		Utils.enterData(Home_Page.txtbx_Password(), Constant.Password); 
		Home_Page.btn_Login().click();
		if(BaseClass.getCurrentUrl().contains("OnlineAdmissionsModule")) {
			if(LoggedIn_Page.isApplicationFormAvailable()) {
				Utils.enterData(LoggedIn_Page.txtbx_FirstName(),Utils.randomAlphaNumeric() );
				LoggedIn_Page.btn_SaveAndContinue().click();
				/*
	    String currentUrl = LoggedIn_Page.getCurrentUrl();
	    String pattern = "currentActiveLinkId=2";
	    Assert.assertTrue(currentUrl.contains(pattern),"Updation Failed");
				 */
				Assert.assertTrue(LoggedIn_Page.lnk_getActiveTab().getText().equals("Educational Details"),"Updation Failed");
			}else {
				System.out.println("Application Form not available");
			}
		}else {
			System.out.println("Login Failed");
		}
	}
}
