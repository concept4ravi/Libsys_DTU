package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
public class LoggedIn_Page extends BaseClass{
	private static WebElement element = null;

	public LoggedIn_Page(WebDriver driver){
		super(driver);
	}    
	public static WebElement txtbx_FirstName() throws Exception{
		try{ 
			element = driver.findElement(By.id("NAME OF THE APPLICANT1"));
			Log.info("'First Name' text box is found on the LoggedIn Page");
		}catch (Exception e){
			Log.error("'First Name' text box is not found on the LoggedIn Page");
			throw(e);
		}
		return element;
	}
	
	public static boolean isApplicationFormAvailable() throws Exception{
		try{ 
			driver.findElement(By.id("Label140"));
			Log.info("Application Form available on the Home Page");
		}catch (Exception e){
			Log.error("Application Form not available on the Home Page on the Home Page");
			return false;
		}
		return true;
		
	}
	
	public static WebElement btn_SaveAndContinue() throws Exception{
		try{
			element = driver.findElement(By.id("save"));

			Log.info("'Save & Continue' Button found on the LoggedIn Page");
		}catch (Exception e){
			Log.error("'Save & Continue' Button not found on the LoggedIn Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement lnk_getActiveTab() throws Exception{
		try{
			element = driver.findElement(By.cssSelector(".activeTab"));

			Log.info("'Active Tab' found on the LoggedIn Page");
		}catch (Exception e){
			Log.error("'Active Tab' not found on the LoggedIn Page");
			throw(e);
		}
		return element;
	}
	
	

	



}
