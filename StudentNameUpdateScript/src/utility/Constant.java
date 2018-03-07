package utility;

public class Constant {
	public static String basePath;
	// CourseType indexes
	// M.Tech (Part Time) index : 0
	// M.Tech FT index          : 1
	// MBA index                : 2
	// PHD index 				: 3
	/*String current = new java.io.File( "." ).getCanonicalPath();
    System.out.println("Current dir:"+current);*/
	public static  String URL = "https://libsys10.com/dtu_test/onlineAdmissions/onlineAdmissionsDynamic/loginForm.jsp";
	public static  String browserName = "firefox";
	public static  int randomStringLength = 6;
	public static  String Username = "abc@libsys.co.in";
	public static  String CourseType = "M.Tech FT";
	public static  String Password ="libsys";
	public static  String xmlFilePath ;
	public static  String firefoxDriverLocation ;//=  "/home/intern/git/Libsys_DTU/StudentNameUpdateScript/Browser Driver/geckodriver";
	public static  String chromeDriverLocation ;//= "/home/intern/git/Libsys_DTU/StudentNameUpdateScript/Browser Driver/chromedriver";
	//		public static final String ghostDriverLocation = "/home/intern/git/Libsys_DTU/StudentNameUpdateScript/Browser Driver/phantomjs";
	//		Test Data Sheet Columns
	public static final String Path_ScreenShot = "/home/intern/git/Libsys_DTU/StudentNameUpdateScript/src/Screenshots";
	public static void initializeVariables(String basePath) {
		firefoxDriverLocation = basePath+"/Browser Driver/geckodriver";
		chromeDriverLocation = basePath+"/Browser Driver/chromedriver";
		xmlFilePath = basePath+"/testng.xml";
	}
}
