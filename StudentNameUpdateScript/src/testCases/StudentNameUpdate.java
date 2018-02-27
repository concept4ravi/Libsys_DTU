package testCases;

import org.openqa.selenium.support.ui.Select;

import pageObjects.Home_Page;
import utility.Constant;

public class StudentNameUpdate {
	public static void update() throws Exception {
//	    driver.get("https://libsys10.com/dtu_test/onlineAdmissions/onlineAdmissionsDynamic/loginForm.jsp");
	    Home_Page.lnk_Login().click();
	    
	    new Select(Home_Page.dropdown_ApplyingFor()).selectByVisibleText("M.Tech FT");
//	    driver.findElement(By.name("admnType")).click();
	    Home_Page.txtbx_Email().click();
	    Home_Page.txtbx_Email().clear();
	    Home_Page.txtbx_Email().sendKeys(Constant.Username);
	    Home_Page.txtbx_Email().click();
	    Home_Page.txtbx_Email().clear();
	    Home_Page.txtbx_Email().sendKeys(Constant.Username);
	    Home_Page.txtbx_Password().click();
	    Home_Page.txtbx_Password().clear();
	    Home_Page.txtbx_Password().sendKeys(Constant.Password);
	    Home_Page.btn_Login().click();
	   /* driver.findElement(By.id("NAME OF THE APPLICANT1")).click();
	    driver.findElement(By.id("NAME OF THE APPLICANT1")).clear();
	    driver.findElement(By.id("NAME OF THE APPLICANT1")).sendKeys("abcd");
	    driver.findElement(By.id("save")).click();*/
	  }
}
