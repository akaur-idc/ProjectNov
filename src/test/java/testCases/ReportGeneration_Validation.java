package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import initialization.Browser;
import initialization.ExcelData;
import initialization.LaunchURL;
import objectRepository.TakeScreenShot;

@Test
public class ReportGeneration_Validation {
	static int tab = 0;
	static int row=1;
	// @SuppressWarnings("unlikely-arg-type")
	public static void genericLGFucntion() throws IOException, InterruptedException, FileNotFoundException

	{

		// ==========================================================================================================================================//

		// EXCEL FILE DECLARATION
		ExcelData exlData = new ExcelData();
	
		// LAUNCH BROWSER
		Browser browser = new Browser();
		WebDriver Project = browser.pickBrowser("Chrome");
		// LAUNCH URL
		LaunchURL urlObj = new LaunchURL();
		String url = urlObj.lauchURL(Project);

		// ASSESSMENT OBJECT
		Assessment_Validation asmt = new Assessment_Validation();
		
		//Create folder		
		TakeScreenShot.createFolder("Screenshot");

		asmt.RunValidationAssessment(Project, url, exlData,row);

		System.out.println("*****  ASSESSMENT is DONE  ******");
		Project.close();
	}
}
