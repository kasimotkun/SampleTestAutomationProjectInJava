package automationFramework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;




public class testBase  {
	


    

	@Parameters({"killAllChromeAndDriverProcessesBeforeSuite","baseUrl","deleteAllScreenshots","takeScreenshotOnTestFailure","screenshotsDir","driversDir","driverType"})
	@BeforeSuite
	public void beforeSuitFunc(ITestContext d,  String  killAllChromeAndDriverProcessesBeforeSuite, String baseUrl, String deleteAllScreenshots,String takeScreenshotOnTestFailure , String screenshotsDir, String driversDir, String driverType) {
		
		Reporter.log("killAllChromeAndDriverProcessesBeforeSuite:"+killAllChromeAndDriverProcessesBeforeSuite,true);
		Reporter.log("deleteAllScreenshots:"+deleteAllScreenshots,true);
		Reporter.log("takeScreenshotOnTestFailure:"+takeScreenshotOnTestFailure,true);
		Reporter.log("screenshotsDir:"+screenshotsDir,true);
		Reporter.log("driversDir:"+driversDir,true);
		Reporter.log("driverType:"+driverType,true);
		Reporter.log("baseUrl:"+baseUrl,true);
		
		
		d.setAttribute("takeScreenshotOnTestFailure", takeScreenshotOnTestFailure);
		d.setAttribute("screenshotsDir", screenshotsDir);
		d.setAttribute("driversDir", driversDir);
		d.setAttribute("driverType", driverType);
		d.setAttribute("baseUrl", baseUrl);
		
		
		
		if (killAllChromeAndDriverProcessesBeforeSuite.equals("true")) {
			
		  killProcesses(driverType);
		}
		
		  
		if (deleteAllScreenshots.equals("true"))
	    {
			  
		File destFile = new File(screenshotsDir);
        try {
			FileUtils.cleanDirectory(destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	    }
		 
		   
	
	}

	@BeforeTest
	public void beforeTestFunc(ITestContext d) {
	
	
	}

	@BeforeClass
	public void beforeClassFunc(ITestContext d) {
	
	}

	public WebDriver testSetup(ITestContext d)
	{
		
		String  driversDir = (String) d.getAttribute("driversDir");
		String  driverType = (String) d.getAttribute("driverType");
		String  baseUrl = (String) d.getAttribute("baseUrl");
		
		 
		
		WebDriver  driver = null;
		
		if ( driverType.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver", driversDir+"chromedriver.exe");
		 driver = new ChromeDriver();
		 }
		
		if ( driverType.equals("firefox")) {
			 System.setProperty("webdriver.gecko.driver", driversDir+"geckodriver.exe");
			 
			 driver = new FirefoxDriver();
			 }
		
		if ( driverType.equals("ie")) {
			 System.setProperty("webdriver.ie.driver", driversDir+"IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 }
		
		 driver.get(baseUrl);
		
		 return driver;
	}
	
	@AfterMethod
	public void testStop(ITestContext d)
	{
		



		 
		  
	}
	

	@AfterClass
	public void afterClassFunc(ITestContext d) {


	
	}

	@AfterTest
	public void afterTestFunc(ITestContext d) {
	
	
	}
	@Parameters("killAllChromeAndDriverProcessesAfterSuite")
	@AfterSuite
	public void afterSuitFunc(ITestContext d, String killAllChromeAndDriverProcessesAfterSuite) {
		
		
		Reporter.log("killAllChromeAndDriverProcessesAfterSuite:"+killAllChromeAndDriverProcessesAfterSuite,true);
		
		String  driverType = (String) d.getAttribute("driverType");
		
		if (killAllChromeAndDriverProcessesAfterSuite.equals("true")) {
		  killProcesses(driverType);
		}
		    
	}
	
	private void killProcesses(String driverType)
	{

		  try { 
				if ( driverType.equals("chrome")) { 
		  Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		  Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); 
				}
				if ( driverType.equals("firefox")) {
					  Runtime.getRuntime().exec("taskkill /F /IM geckoDriver.exe");
					  Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
				
				}
				if ( driverType.equals("ie")) {
					  Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
					  Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe"); 
		  
		  }
				}
		  
		  catch (IOException
		  e) { 
			  
		  }
	}
}
