package main;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import testCases.StudentInfo;
import utility.Log;
import utility.SendMail;
import utility.Utils;

public class Framework_001{
	public WebDriver driver;

	@BeforeTest
	@Parameters({"browser"})
	public void beforeMethod(String browser) throws Exception {

		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("'Update Student Name'");
		driver = Utils.OpenBrowser(browser);

		new BaseClass(driver); 

	}

	// This is the starting of the Main Test Case
	@Test
	public void main() throws Exception {
		// Every exception thrown from any class or method, will be catch here and will be taken care off
		// For Exception handling please see http://www.toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/
		if(Home_Page.header_serviceUnavailable()!=null) {

			if(Home_Page.header_serviceUnavailable().getText().equals("Service Unavailable")) {
				SendMail.sendMail("Server not available");
				driver.close();
			}
			throw new Exception("Server not available");
		}else {

			try{
				//			SendMail.sendMail("Error : Server Delay");
				StudentInfo.nameUpdate();

				if(BaseClass.bResult==true){
					Log.info("Complete");
					System.out.println("Complete : Server running normally");
				}

			}catch(AssertionError e) {
				//		  Utils.takeScreenshot(driver, sTestCaseName);
				Log.error(e.getMessage());
				throw (e);
			}
			catch (Exception e){
				//		  Utils.takeScreenshot(driver, sTestCaseName);
				Log.info("Not Complete");
				Log.error(e.getMessage());
				//			SendMail.sendMail("Error : Server Delay");
				System.out.println("Error : Server Delay, Please restart Server");
				throw (e);
			}
		}

	}


	// Its time to close the finish the test case		
	@AfterTest
	public void afterMethod() {
		// Printing beautiful logs to end the test case
		Log.endTestCase("'Update Student Name'");
		// Closing the opened driver
		driver.close();
	}

}
