package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import initialization.Browser;
import initialization.ExcelData;
import initialization.LaunchURL;



@Test
public class ReportGeneration_DataDriven_NG {

		// @SuppressWarnings("unlikely-arg-type")
	public static void genericLGFucntion() throws IOException, InterruptedException, FileNotFoundException

	{

		// ==========================================================================================================================================//
	
		// EXCEL FILE DECLARATION
		ExcelData exlData = new ExcelData();
		//rowCount is number of assessments user wants to run through excel sheet
		int rowCount =  exlData.excelRowCount();
		rowCount = rowCount-1;
		System.out.println("*****  row count  ** "+ exlData.excelRowCount());
		
		// LAUNCH BROWSER
		Browser browser = new Browser();
		
		WebDriver Project = browser.pickBrowser("Chrome");
		
		// LAUNCH URL
		LaunchURL urlObj = new LaunchURL();
		String url = urlObj.lauchURL(Project);
		
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
     Project.close();
	}
}
