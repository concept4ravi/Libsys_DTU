package testCases;

import org.openqa.selenium.support.ui.Select;

import bsh.util.Util;
import pageObjects.Home_Page;
import utility.Constant;
import utility.Utils;

public class StudentNameUpdate {
	public static void update() throws Exception {
//	    driver.get("https://libsys10.com/dtu_test/onlineAdmissions/onlineAdmissionsDynamic/loginForm.jsp");
	    Home_Page.lnk_Login().click();
	    
	    new Select(Home_Page.dropdown_ApplyingFor()).selectByVisibleText("M.Tech FT");
//	    driver.findElement(By.name("admnType")).click();
	    Utils.enterData(Home_Page.txtbx_Email(), Constant.Username);
	    Utils.enterData(Home_Page.txtbx_Password(), Constant.Password); 
	    
	    Home_Page.btn_Login().click();
	   /* driver.findElement(By.id("NAME OF THE APPLICANT1")).click();
	    driver.findElement(By.id("NAME OF THE APPLICANT1")).clear();
	    driver.findElement(By.id("NAME OF THE APPLICANT1")).sendKeys("abcd");
	    driver.findElement(By.id("save")).click();*/
	  }
}
