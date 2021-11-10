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


public class IteratingAssessment_ReportGeneration {

	// @SuppressWarnings("unlikely-arg-type")
	// EXCEL FILE DECLARATION
	ExcelData exlData = new ExcelData();
	// rowCount is number of assessments user wants to run through excel sheet
	int rowCount;
	public static int assmt_count =1;


	// LAUNCH BROWSER
	Browser browser = new Browser();
	public WebDriver Project;
	LaunchURL urlObj;
	String url;
	
	
	@BeforeClass
	public void initiliazation()  throws IOException, InterruptedException, FileNotFoundException{
		//user can pick any browser from Chrome, Edge or Firefox by simply changing text in next line
		Project = browser.pickBrowser("Edge");
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

				
		// ASSESSMENT OBJECT
		AssessmentSubmission asmt = new AssessmentSubmission();
		
		//call assessment function - data driven via excel sheet
		
		if(rowCount>0)	{
			asmt.RunAssessment(Project, url, exlData,assmt_count);
		}
			
		else
		{
			System.out.println("***** DATA NOT PRESENT  ******");
			
		}
		System.out.println("*****  ASSESSMENT IS DONE  ******");
	}

    @AfterClass
    public void afterClassFunction(){
    	Project.close();
        System.out.println("After Class");
    }
	
}
