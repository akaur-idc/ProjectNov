package testCases;

import java.io.IOException;
import java.nio.charset.MalformedInputException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import initialization.Browser;
import initialization.ExcelData;
import initialization.LaunchURL;


public class ReportGeneration_All_Browsers2 {
	 public int tab = 0;
	  public int row = 1;
	  public ExcelData exlData = new ExcelData();
	  public Browser browser = new Browser();
	  public WebDriver Driver;
	  
		// LAUNCH URL
		public LaunchURL urlObj = new LaunchURL();
		public 	String url, nodeurl;	
		@Test
		@Parameters("browserType")
		public void setUp(String browserType) throws MalformedInputException, InterruptedException, IOException{
			System.out.println("-----TEST------");
			
			  
		        if(browserType.equalsIgnoreCase("Chrome")){
		        	Driver = browser.pickBrowser("Chrome");
		        	url=urlObj.lauchURL(Driver);
		        	// ASSESSMENT OBJECT
					Assessment asmt = new Assessment();		
		
					asmt.RunAssessment(Driver, url, exlData,row);
					Thread.sleep(2000);
					
		
					System.out.println("*****  ASSESSMENT is DONE WITH CHROME ******");
					Driver.quit();
		      //  System.setProperty("webdriver.chrome.driver","C://SeleniumGrid//chromedriver.exe"); 
		        
		     
		        }else{

			        if(browserType.equalsIgnoreCase("Firefox")){
			        	Driver = browser.pickBrowser("Firefox");
			        	url=urlObj.lauchURL(Driver);
			        	// ASSESSMENT OBJECT
						Assessment asmt = new Assessment();		
			
						asmt.RunAssessment(Driver, url, exlData,row);
						Thread.sleep(2000);
						System.out.println("*****  ASSESSMENT is DONE WITH FIRE FOX ******");
						Driver.quit();
//		        	 File pathBinary = new File("C://Program Files//Mozilla Firefox//firefox.exe");
//		             FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//		             dr = DesiredCapabilities.firefox();
//		             FirefoxOptions options = new FirefoxOptions();
//		             dr.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
//		             dr.setPlatform(Platform.WINDOWS);

		        }
		     
			        else {
			        	if(browserType.equalsIgnoreCase("Edge")){
			        }
			        	Driver = browser.pickBrowser("Edge");
			        	url=urlObj.lauchURL(Driver);
			        	// ASSESSMENT OBJECT
						Assessment asmt = new Assessment();		
			
						asmt.RunAssessment(Driver, url, exlData,row);
						Thread.sleep(2000);
			      //  System.setProperty("webdriver.chrome.driver","C://SeleniumGrid//chromedriver.exe"); 
			        }
			     
			        }
	//	}
	
//		@AfterTest
//		public void afterTest()
//		{
//			Driver.close();
//		}
//		
//		@Test
	//    public void testMethodsTwo() throws InterruptedException, IOException {
		 

			// ASSESSMENT OBJECT
//			Assessment asmt = new Assessment();		
//
//			asmt.RunAssessment(Driver, url, exlData,row);
//			Thread.sleep(2000);
//			
//
//			System.out.println("*****  ASSESSMENT is DONE WITH FIREFOX ******");
//			Driver.quit();
	    
	
		
		        }	

		}

// ==========================================================================================================================================//

	

