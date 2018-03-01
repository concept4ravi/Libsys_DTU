package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

	public static String getTitle(){

		return driver.getTitle();
	}
	
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public static void turnOffImplicitWaits() {
	    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void turnOnImplicitWaits() {
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
