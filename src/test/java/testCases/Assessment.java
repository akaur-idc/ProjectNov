package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import initialization.ElementLocators;
import initialization.ExcelData;
import objectRepository.Checkbox;
import objectRepository.CookieConsent;
import objectRepository.Country;
import objectRepository.Employees;
import objectRepository.Industry;
import objectRepository.InputMisc;
import objectRepository.Radio;
import objectRepository.RegPage;

public class Assessment {

	int toolPage;
	int radio_Options;
	int checkBox_Options;

	// constructor
	public Assessment() {
		// System.out.println("Inside Assessment Constructor");

	}

	public void RunAssessment(WebDriver Project, String url, ExcelData exlData, int row)
			throws InterruptedException, IOException {

		// ELEMENT LOCATORS
		ElementLocators el = new ElementLocators(Project);
		// OBJECT DECLARATION AS PER ELEMENTS PRESENT IN THE ASSESSMENT
		Radio radioOption = new Radio();
		Checkbox chbox = new Checkbox();
		Employees emp = new Employees();
		InputMisc inputMisc = new InputMisc();
		Industry industryValue = new Industry();
		Country countryVal = new Country();
		RegPage rPage = new RegPage();

		Project.manage().window().maximize();
		Project.get(url);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// TOOL NAME
		String titlecs = Project.getTitle();
		System.out.println("Text from dev site: TOOL NAME: " + titlecs);

		// Close - Dev Site pop-up modal
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Thread.sleep(20000);
		Project.findElement(el.DevRibbonBttn).click();

		// AGREE AND CONTINUE - Cookie
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Consent Agree&Countiue
		CookieConsent.consent(Project, el.ConsentBttn, el.CookieClass);

		// ==========================================================================================================================================//

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Thread.sleep(20000);

		// Click - Begin Assessment
		Project.findElement(el.BeginAsmtBttn).click();
		// System.out.println("Begin Assessment button is clicked");
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Thread.sleep(20000);
		/////////////////////////////////////// PAGE1
		System.out.println("======PAGE 1 =========");
		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// RADIO ON PAGE 1
		toolPage = 1; // radio_Options=8;

		// to get radio options count
		radio_Options = radioOption.getRadioCount(exlData, toolPage);
		radioOption.getRadioOption(Project, toolPage, radio_Options, exlData, row);

		// NEXT BUTTON AT PAGE 1
		Project.findElement(el.Page1NxtBttn).click();
		// Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Thread.sleep(2000);
		////////////////////////////////////////////////// PAGE 2
		System.out.println("======PAGE 2 =========");

		// SELECT RADIO ON PAGE 2
		toolPage = 2;

		// to get radio options count
		radio_Options = radioOption.getRadioCount(exlData, toolPage);
		radioOption.getRadioOption(Project, toolPage, radio_Options, exlData, row);

		// Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Thread.sleep(2000);

		// NEXT BUTTON ON PAGE2
		Project.findElement(el.Page2NxtBttn).click();

		////////////////////////////////////////////////// PAGE 3
		System.out.println("======PAGE 3 =========");

		// SELECT COUNTRY ON PAGE3
		countryVal.getCountry(exlData, row, Project.findElement(el.Country));

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// Thread.sleep(20000);

		// SELECT INDUSTRY ON PAGE3
		industryValue.getIndustry(exlData, row, Project.findElement(el.Industry));

		// Get Employees
		emp.getEmployee(Project, exlData, row, Project.findElement(el.Employee));

		// next button on Page3
		Project.findElement(el.Page3NxtBttn).click();

		////////////////////////////////////////////////// PAGE 4
		System.out.println("======PAGE 4 =========");
		Thread.sleep(2000);

		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// select input for other fields in the assessment
		inputMisc.getInput(Project, exlData, row, el.MiscInput0);

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Thread.sleep(20000);

		// Select CHECKBOX
		toolPage = 4;
		// to get check options count

		checkBox_Options = chbox.getCheckCount(exlData, toolPage);

		chbox.getCheckboxOption(Project, toolPage, checkBox_Options, row);

		Project.findElement(el.Page4NxtBttn).click();

		////////////////////////////////////////////////// PAGE 5
		System.out.println("======PAGE 5 =========");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput1);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput2);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput3);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput4);
		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput5);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput6);

		// next button
		Project.findElement(el.Page5NxtBttn).click();
		////////////////////////////////////////////////// PAGE 6
		System.out.println("======PAGE 6 =========");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput7);

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput8);

		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// SLIDER
		WebElement slider = Project.findElement(el.Slider1);
		// new Actions(Project).dragAndDropBy(slider, 12000, 0).build().perform();

		Thread.sleep(5000);
        new Actions(Project).dragAndDropBy(slider, 100, 100).build().perform();
		Project.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		// input data
		inputMisc.getInput(Project, exlData, row, el.MiscInput9);

		Project.findElement(el.Page6NxtBttn).click();

		////////////////////////////////////////////////// REG PAGE
		System.out.println("===== REG PAGE ======");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		// input reg page

		rPage.InputRegPage(Project, exlData, row, el.FirstName, "FirstName");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		rPage.InputRegPage(Project, exlData, row, el.LastName, "LastName");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		rPage.InputRegPage(Project, exlData, row, el.email, "Email");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		rPage.InputRegPage(Project, exlData, row, el.CompanyName, "CompanyName");

		Project.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		Project.findElement(el.ThankYou).click();
		// Project.findElement(By.xpath("//a[@href='https://www.redirecturl.com/']")).click();

		////////////////////////////////////////////////// DONE

	}

}
