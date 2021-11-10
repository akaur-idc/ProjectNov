package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import initialization.Browser;
import initialization.ExcelData;
import initialization.LaunchURL;


public class ReportGeneration_DataDriven {

	// @SuppressWarnings("unlikely-arg-type")
	// EXCEL FILE DECLARATION
	ExcelData exlData = new ExcelData();
	// rowCount is number of assessments user wants to run through excel sheet
	int rowCount;

	// LAUNCH BROWSER
	Browser browser = new Browser();
	public WebDriver Project;
	LaunchURL urlObj;
	String url;

	// browser.ChromeBrowserLaunch();
	// WebDriver Project = new ChromeDriver();
	@BeforeClass
	public void initiliazation()  throws IOException, InterruptedException, FileNotFoundException{
		Project = browser.pickBrowser("Chrome");
//	browser.FrieFoxBrowserLaunch();
//	WebDriver Project =  new FirefoxDriver();
		rowCount = exlData.excelRowCount();
		rowCount = rowCount - 1;
		System.out.println("***** BEFORE CLASS row count  ** " + exlData.excelRowCount());
		// LAUNCH URL
		LaunchURL urlObj = new LaunchURL();
		url = urlObj.lauchURL(Project);

	}

	@Test
	public  void genericLGFucntion() throws IOException, InterruptedException, FileNotFoundException

	{

		// ==========================================================================================================================================//
	
	
		
		// ASSESSMENT OBJECT
		AssessmentSubmission asmt = new AssessmentSubmission();
		
		//call assessment function for how many assessments user wants or assessment data present in excel sheet
		
		//for (int i = 1; i <= rowCount; i++) {
		//OR
			for (int i = 1; i <= 10; i++) {
		
			//	System.out.print("ITERATION  " + i);
			// RUN ASSESSMENTS WITH DATA FROM EXCEL SHEET AT GIVEN LOCATION
			asmt.RunAssessment(Project, url, exlData, i);
			System.out.println("TEST CASE " + i + "  is Done.");
		}
		System.out.println("*****  ASSESSMENTS ARE DONE  ******");
	}

    @AfterClass
    public void afterClassFunction(){
    	Project.close();
        System.out.println("After Class");
    }
	
}
