package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver = null;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static WebDriver OpenBrowser(String sBrowserName) throws Exception{
		try{
			if(sBrowserName.toLowerCase().equals("chrome")){
				System.setProperty("webdriver.chrome.driver",Constant.chromeDriverLocation);
				driver = new ChromeDriver();
				Log.info("New Chrome driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");
				driver.get(Constant.URL);
				Log.info("Web application launched successfully");
			}else if(sBrowserName.toLowerCase().equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",Constant.firefoxDriverLocation); 
				driver = new FirefoxDriver();
				Log.info("New Firefox driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");
				driver.get(Constant.URL);
				Log.info("Web application launched successfully");
			}else if(sBrowserName.toLowerCase().equals("firefoxheadless")) {
				System.setProperty("webdriver.gecko.driver",Constant.firefoxDriverLocation); 
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
				Log.info("New Firefox driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");
				driver.get(Constant.URL);
				Log.info("Web application launched successfully");
			}else if(sBrowserName.toLowerCase().equals("chromeheadless")){
				System.setProperty("webdriver.chrome.driver",Constant.chromeDriverLocation);
				ChromeOptions options = new ChromeOptions();
		        options.addArguments("headless");
//		        options.setHeadless(true);
//		        options.addArguments("window-size=1200x600");
				driver = new ChromeDriver(options);
				Log.info("New Chrome Headless driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");
				driver.get(Constant.URL);
				Log.info("Web application launched successfully");
			}
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
			System.out.println("Unable to open browser");
		}
		return driver;
	}

	public static void mouseHoverAction(WebElement mainElement, String subElement){

		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		if(subElement.equals("Accessories")){
			action.moveToElement(driver.findElement(By.linkText("Accessories")));
			Log.info("Accessories link is found under Product Category");
		}
		if(subElement.equals("iMacs")){
			action.moveToElement(driver.findElement(By.linkText("iMacs")));
			Log.info("iMacs link is found under Product Category");
		}
		if(subElement.equals("iPads")){
			action.moveToElement(driver.findElement(By.linkText("iPads")));
			Log.info("iPads link is found under Product Category");
		}
		if(subElement.equals("iPhones")){
			action.moveToElement(driver.findElement(By.linkText("iPhones")));
			Log.info("iPhones link is found under Product Category");
		}
		action.click();
		action.perform();
		Log.info("Click action is performed on the selected Product Type");
	}
	public static void waitForElement(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}// try
		catch (Exception e) {
			return false;
		}// catch
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void enterData(WebElement we,String data) {
		we.click();
		we.clear();
		we.sendKeys(data);
	}

	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));	
		} catch (Exception e){
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
		}
	}

	public static void waitForElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public static String randomAlphaNumeric() {
		int count = Constant.randomStringLength;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
