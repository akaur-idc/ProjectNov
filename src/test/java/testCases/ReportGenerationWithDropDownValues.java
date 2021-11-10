package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import initialization.Browser;
import initialization.ExcelData;
import initialization.LaunchURL;

@Test
public class ReportGenerationWithDropDownValues {
	static int tab = 0;
	static int secondRow = 1;
	static int thirdRow = 2;

	// @SuppressWarnings("unlikely-arg-type")
	public static void genericLGFucntion() throws IOException, InterruptedException, FileNotFoundException

	{

		// ==========================================================================================================================================//
		// EXCEL FILE DECLARATION
		ExcelData exlData = new ExcelData();
		int rowCount = exlData.excelRowCount();
		rowCount = rowCount - 1;
		System.out.println("*****  row count  ** " + exlData.excelRowCount());

		// LAUNCH BROWSER
		Browser browser = new Browser();
		WebDriver Project = browser.pickBrowser("Chrome");

		// LAUNCH URL
		LaunchURL urlObj = new LaunchURL();
		String url = urlObj.lauchURL(Project);

		// DECLARATION OF OBJECTS FOR DROPDOWN AND ASSESSMENT
		DropdownCount dropdown = new DropdownCount();
		AssessmentForDropdownList asmt = new AssessmentForDropdownList();

		// LOCAL DECLARATION
		int count;

		int dropDownlist[] = dropdown.getDropdownCount(Project, url, exlData, secondRow);

		System.out.println("*****  Array DAta ******" + dropDownlist[0]);
		int excelRow = exlData.excelRowCount();
		if (dropDownlist[0] <= excelRow)
			count = dropDownlist[0];
		else
			count = excelRow;
		for (int i = thirdRow; i <= excelRow; i++){// number of assessment data present in the excel file
			for (int j = thirdRow; j <= dropDownlist[1]; j++)//number of industries
				for (int k = thirdRow; k <= dropDownlist[0]; k++) //number of countries
					asmt.RunAssessment(Project, url, exlData, k);
				System.out.println("TEST CASE " + i + "  is Done.");	
				}
	
		System.out.println("*****  ASSESSMENTS ARE DONE  ******");
		Project.close();
	}
}
