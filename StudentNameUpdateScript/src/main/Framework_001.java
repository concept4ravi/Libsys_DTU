package main;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import testCases.StudentNameUpdate;
import utility.Log;
import utility.Utils;

public class Framework_001{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  @BeforeTest
  @Parameters({"browser"})
  public void beforeMethod(String browser) throws Exception {
	  
	  	DOMConfigurator.configure("log4j.xml");
	  	
		Log.startTestCase("Update Student Name");
		driver = Utils.OpenBrowser(browser);
		
		new BaseClass(driver);  
        }
  
  // This is the starting of the Main Test Case
  @Test
  public void main() throws Exception {
	  // Every exception thrown from any class or method, will be catch here and will be taken care off
	  // For Exception handling please see http://www.toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/
	  try{
		  
		StudentNameUpdate.update();
		
		if(BaseClass.bResult==true){
			
		}else{
			
		}
		
	  }catch(AssertionError e) {
//		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  throw (e);
	  }
	  catch (Exception e){
//		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  throw (e);
	  }
		
  }
  
  	
  // Its time to close the finish the test case		
//  @AfterTest
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase("Update Student Name");
	    // Closing the opened driver
	    driver.close();
  		}

}
