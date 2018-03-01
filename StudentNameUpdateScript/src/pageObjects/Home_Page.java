package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;
public class Home_Page extends BaseClass{
	private static WebElement element = null;

	public Home_Page(WebDriver driver){
		super(driver);
	}

	public static WebElement header_serviceUnavailable() throws Exception{

		try {
			turnOffImplicitWaits();
			WebDriverWait wait  = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/h1")));
			turnOnImplicitWaits();
		}catch(Exception e) {
			turnOnImplicitWaits();
			return null;
		}
		//			boolean size = driver.findElements(By.xpath("/html/body/h1")).size() > 0;
		//			System.out.println(size);
		//			if(size) {
		//				System.out.println("null nahi h");
		return  driver.findElement(By.xpath("/html/body/h1"));
		//			}


	}
	
	public static WebElement txtbx_Email() throws Exception{
		try{ 
			element = driver.findElement(By.id("emailFld"));
			Log.info("Email text box is found on the Home Page");
		}catch (Exception e){
			Log.error("Email text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	public static WebElement txtbx_Password() throws Exception{
		try{
			element = driver.findElement(By.id("pwdFld"));

			Log.info("Password Text box is found on the Home Page");
		}catch (Exception e){
			Log.error("Password Text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}

	public static WebElement lnk_Login() throws Exception{
		try{
			element = driver.findElement(By.id("lblLogin"));

			Log.info("Login Link found on the Home Page");
		}catch (Exception e){
			Log.error("Login Link not found on the Home Page");
			throw(e);
		}
		return element;
	}

	public static WebElement btn_Login() throws Exception{
		try{
			element = driver.findElement(By.id("logInButton"));

			Log.info("Login Button found on the Home Page");
		}catch (Exception e){
			Log.error("Login Button not found on the Home Page");
			throw(e);
		}
		return element;
	}

	public static WebElement dropdown_ApplyingFor() throws Exception{
		try{
			element = driver.findElement(By.name("admnType"));

			Log.info("ApplyingFor DropDown found on the Home Page");
		}catch (Exception e){
			Log.error("ApplyingFor DropDown not found on the Home Page");
			throw(e);
		}
		return element;
	}





}
