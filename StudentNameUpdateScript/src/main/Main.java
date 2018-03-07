package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import utility.Constant;

public class Main {
	public static void main(String args[]) throws InterruptedException, IOException {
		Constant.basePath =  new java.io.File( "." ).getCanonicalPath();
		Constant.initializeVariables(Constant.basePath);
		System.out.println(Constant.basePath);
		while(true) {		
			TestListenerAdapter tla = new TestListenerAdapter();
			TestNG tng = new TestNG();
			List<String> suites = new ArrayList<String>();
			suites.add(Constant.xmlFilePath);
			// suites.add("/home/intern/Desktop/Libsys_DTU/StudentNameUpdateScript/testng.xml");

			tng.addListener((ITestNGListener)tla);;
			tng.setTestSuites(suites);
			tng.run();
			Thread.sleep(60000);
		}
	}
}
