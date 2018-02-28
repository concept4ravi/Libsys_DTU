package testCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.Home_Page;
import pageObjects.LoggedIn_Page;
import utility.Constant;
import utility.Utils;

public class StudentNameUpdate {
	public static void update() throws Exception {
//	    driver.get("https://libsys10.com/dtu_test/onlineAdmissions/onlineAdmissionsDynamic/loginForm.jsp");
	    Home_Page.lnk_Login().click();
	    
	    new Select(Home_Page.dropdown_ApplyingFor()).selectByVisibleText(Constant.CourseType);
//	    driver.findElement(By.name("admnType")).click();
	    Utils.enterData(Home_Page.txtbx_Email(), Constant.Username);
	    Utils.enterData(Home_Page.txtbx_Password(), Constant.Password); 
	    Home_Page.btn_Login().click();
	    
	    Utils.enterData(LoggedIn_Page.txtbx_FirstName(),Utils.randomAlphaNumeric() );
	    LoggedIn_Page.btn_SaveAndContinue().click();
	    
	    String currentUtl = LoggedIn_Page.getCurrentUrl();
	    String pattern = "currentActiveLinkId=2";
	    Assert.assertTrue(currentUtl.contains(pattern),"Updation Failed");
	   
	  }
}
