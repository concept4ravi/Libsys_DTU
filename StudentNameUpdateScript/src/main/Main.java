package main;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Main {
	public static void main(String args[]) throws InterruptedException {
		while(true) {		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG tng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("/home/intern/git/Libsys_DTU/StudentNameUpdateScript/testng.xml");
//		suites.add("/home/intern/Desktop/Libsys_DTU/StudentNameUpdateScript/testng.xml");
		
		tng.addListener((ITestNGListener)tla);;
		tng.setTestSuites(suites);
		tng.run();
		Thread.sleep(5000);
		}
	}
}
