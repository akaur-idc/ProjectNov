package testCases;

import java.io.IOException;
import java.nio.charset.MalformedInputException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import initialization.Browser;
import initialization.ExcelData;
import initialization.LaunchURL;

public class ReportGeneration_All_Browsers {
	public int tab = 0;
	public int row = 1;
	public ExcelData exlData = new ExcelData();
	public Browser browser = new Browser();

	public WebDriver Driver;

	// LAUNCH URL
	public LaunchURL urlObj = new LaunchURL();
	public String url;

	@Test
	@Parameters("browserType")
	public void testMethodsOne() throws InterruptedException, IOException {
		url = urlObj.lauchURL(Driver);

		// ASSESSMENT OBJECT
		Assessment asmt = new Assessment();
		
			 Driver = browser.pickBrowser("Chrome");
		
		asmt.RunAssessment(Driver, url, exlData, row);
		Thread.sleep(2000);

		System.out.println("*****  ASSESSMENT is DONE WITH CHROME ******");
		Driver.close();

	}

} // ==========================================================================================================================================//
