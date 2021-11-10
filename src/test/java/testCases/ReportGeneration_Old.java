    package testCases;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

	public class ReportGeneration_Old {
		// @SuppressWarnings("unlikely-arg-type")
		@Test
		public static void Assessment() throws IOException, InterruptedException, FileNotFoundException

		{

			// ==========================================================================================================================================//
			//LAUNCH BROWSER
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C://Users//akaur//Downloads//chromedriver_win32//chromedriver.exe");
			 * WebDriver Project = new ChromeDriver();
			 */
			WebDriver Project = null;
			 WebDriverManager.chromedriver().setup();

			 ChromeOptions options = new ChromeOptions();
			Project = new ChromeDriver(options); 
			Project.manage().window().maximize();
			Project.get("https://dev-idc-generic-lg-19.webappuat.com/");
			Project.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String titlecs = Project.getTitle();
			System.out.println("Text from dev site: TOOL NAME: " + titlecs);

			// ==========================================================================================================================================//

			// EXCEL FILE DECLARATION
			FileInputStream fis = new FileInputStream("C:\\Users\\akaur\\eclipse-workspace\\genericLG\\src\\test\\java\\DataDrivenTestFile.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			DataFormatter dataFormatter = new DataFormatter();
			// EXCEL SHEET 3
			XSSFSheet sheet = workbook.getSheetAt(2);
			Row rowcs = sheet.getRow(1);
			Cell cellcs = rowcs.getCell(0);
			String value = dataFormatter.formatCellValue(cellcs);
			System.out.println("EXCEL TAB 3 ---" + value);

			//RIGGON TEXT
			String RibbonTxt = Project.findElement(By.xpath("//*[@id=\"warning\"]/div/div/div[2]/h3")).getText();
			System.out.println("SITE INFO:" + RibbonTxt);

			// Close - Dev Site pop-up modal //*[@id="warning"]/div/div/div[3]/a 
			///html/body/div[3]/div/div/div[3]/a
			Thread.sleep(2000);
			Project.findElement(By.xpath("//div[@id='warning']/div/div/div[3]/a")).click();

			// AGREE AND CONTINUE - Cookie //*[@id="consent"] /html/body/div[5]/div/div/div[2]/p/a[2]
			Thread.sleep(2000);
			Project.findElement(By.xpath("//div[@class='cookie-section']/div/div/div[2]/p/a[2]")).click();

			// ==========================================================================================================================================//

			Thread.sleep(2000);
			// Verify if Begin Assessment button is present
			if (Project.findElements(By.xpath("/html/body/div/div[2]/div/div/div/a")).size() != 0) {
				System.out.println("Element is Present");
			} else {
				System.out.println("Element is Absent");
			}

			// Find number of buttons present on Landing Page
			int BeginAssessmentBtnSize = Project.findElements(By.xpath("/html/body/div/div[2]/div/div/div/a")).size();
			System.out.println("Number of begin button(s) present :  " + BeginAssessmentBtnSize);

			// Click - Begin Assessment
			Project.findElement(By.xpath("//div[@id=\"landing\"]/div/div/div/a")).click();
			// Project.findElement(By.xpath("/html/body/div/div[2]/div/div/div/a")).click();
			System.out.println("Begin Assessment button is clicked");

			// =================================   PAGE 1  =========================================================================================================//
			//INDUSTRY DROPDOWN
			Thread.sleep(2000);
			if (Project.findElements(By.xpath(
					"/html/body/div[1]/div[3]/div/div/div/div/form/div/section/fieldset[1]/div/div/div[2]/ul/li[1]/span"))
					.size() != 0) {
				System.out.println("Industry dropdown is Present");
				
			} else {
				System.out.println("Industry dropdown is Absent");
			}

			// Select Industry
			WebElement Industry = Project.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/form/div/section/fieldset[1]/div/div/div[2]/input"));

			Industry.click();
			System.out.println("Industry clicked");
			Industry.findElement(
					By.xpath("/html/body/div[1]/div[3]/div/div/div/div/form/div/section/fieldset[1]/div/div/div[2]/ul/li[2]/span")).click();
			System.out.println("====== industry selected ====== ");

			
			// Number of employees using business applications at your organization -/html/body/div[1]/div[3]/div/div/div/div/form/div/section/fieldset[2]/div[3]/div/input
			
			 Project.findElement(By.cssSelector("#Q2-QI3-AC3")).sendKeys(value);
			
			 // Tab out to prefill other fields on the Assessment Page-1
			 Project.findElement(By.cssSelector("#Q2-QI3-AC3")).sendKeys(Keys.TAB);
			// COUNTRY DROP-DOWN 
				// Select Country
				Thread.sleep(2000);

				WebElement Country = Project.findElement(By.xpath(
						"/html/body/div[1]/div[3]/div/div/div/div/form/div/section/fieldset[3]/div[2]/div/div[2]/ul"));
				Country.click();
				System.out.println("Country clicked");

				Country.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/form/div/section/fieldset[3]/div[2]/div/div[2]/ul/li[2]/span"))
						.click();
				System.out.println("Country selected");

		
			// click Next button
			Project.findElement(By.xpath("//form[@id='sectionForm1']/div/section/div/div/button[@id='btnNext']")).click();
			System.out.println("On Assessment Page-1, Next button is clicked");

			System.out.println("*****  PAGE1 IS DONE  ******");

			Thread.sleep(2000);
			// =================================================== PAGE 2 =======================================================================================//
			// Questionnaire page 2 text

			
			// Number of buttons present on assessment page 2
			int NextBtnSize2 = Project
					.findElements(By.xpath("//form[@id='sectionForm2']/div/section/div/div/button[@id='btnNext']")).size();
			System.out.println("Next button size on Assessment Page-2, is:  " + NextBtnSize2);

			// click Next button
			Project.findElement(By.xpath("//form[@id='sectionForm2']/div/section/div/div/button[@id='btnNext']")).click();
			System.out.println("On Assessment Page-2, Next button is clicked");

			System.out.println("*****  PAGE2 IS DONE  ******");

			Thread.sleep(2000);
			// ====================================================== PAGE 3 ====================================================================================//
			// Questionnaire page 3 text

			
			// Number of buttons present on assessment page 3
			int NextBtnSize3 = Project
					.findElements(By.xpath("//form[@id='sectionForm3']/div/section/div/div/button[@id='btnNext']")).size();
			System.out.println("Next button size on Assessment Page-3, is:  " + NextBtnSize3);

			// click Next button
			Project.findElement(By.xpath("//form[@id='sectionForm3']/div/section/div/div/button[@id='btnNext']")).click();
			System.out.println("On Assessment Page-3, Next button is clicked");

			System.out.println("*****  PAGE3 IS DONE  ******");

			Thread.sleep(2000);

			
			// ****************************************Registration Page***************************************************//
			// Find and Enter a value in First Name web element
//			cellcs = rowcs.getCell(1);
//			value = dataFormatter.formatCellValue(cellcs);
//			System.out.println("EXCEL TAB 3 ---" + value);
			Project.findElement(By.xpath("//*[@id='Q10-QI12-AC12']")).sendKeys(dataFormatter.formatCellValue(rowcs.getCell(1)));

			Project.findElement(By.xpath("//*[@id='Q11-QI13-AC13']")).sendKeys(dataFormatter.formatCellValue(rowcs.getCell(2)));

			Project.findElement(By.xpath("//*[@id='Q12-QI14-AC14']")).sendKeys(dataFormatter.formatCellValue(rowcs.getCell(3)));
			// Tab out to prefill other fields on the Assessment Page-1
			 Project.findElement(By.cssSelector("#Q12-QI14-AC14")).sendKeys(Keys.TAB);
			 //#sectionForm4 > div:nth-child(13) > div:nth-child(4) > div > label

			Project.findElement(By.cssSelector("#Q14-QI16-AC16")).sendKeys(dataFormatter.formatCellValue(rowcs.getCell(4)));

			Project.findElement(By.xpath("//*[@id='Q13-QI15-AC15']")).sendKeys(dataFormatter.formatCellValue(rowcs.getCell(5)));
			Project.findElement(By.cssSelector("#Q13-QI15-AC15")).sendKeys(Keys.TAB);
			Thread.sleep(2000);
		//	Project.findElement(By.xpath("/html/body/div[1]/div[3]/section/div[1]/div/div/div[2]/div[2]/blockquote/form/div[3]/div[6]")).click();
//
			//Select country = new Select()
			//System.out.println("Country clicked");
			//
			
			//Country.findElement(By.xpath("//*[@id=\"Q15-QI17\"]/option[2]"))
				//	.click();
			//"/html/body/div[1]/div[3]/section/div[1]/div/div/div[2]/div[2]/blockquote/form/div[3]/div[6]"
			////*[@id="sectionForm4"]/div[3]/div[6]
			WebElement CountryReg = Project.findElement(By.xpath( "//*[@id='sectionForm4']/div[3]/div[6]"));
			CountryReg.click();
			System.out.println("------Country selected-----------");
//			Select cReg = new Select(CountryReg);
//			cReg.selectByVisibleText("US");
//			System.out.println("Country clicked");
			//Thread.sleep(2000); //*[@id="select-options-38a47cd8-106c-443b-8bfe-28023d47e367"]/li[2]
			CountryReg.findElement(By.xpath("/html/body/div[1]/div[3]/section/div[1]/div/div/div[2]/div[2]/blockquote/form/div[3]/div[6]/div/div/div/div[2]/ul/li[4]"))
					.click();
			
			System.out.println("Country selected");
//Q17-QI19-AC19
			Project.findElement(By.xpath("//*[@id='Q17-QI19-AC19']")).sendKeys(dataFormatter.formatCellValue(rowcs.getCell(6)));
////*[@id="sectionForm4"]/div[3]/div[9]/div/div/div/div[2]/input	
			WebElement JobReg = Project.findElement(By.xpath( "//*[@id=\"sectionForm4\"]/div[3]/div[9]/div/div/div/div[2]/input"));
			JobReg.click();
			System.out.println("------job clicked-----------");
			///html/body/div[1]/div[3]/section/div[1]/div/div/div[2]/div[2]/blockquote/form/div[3]/div[9]/div/div/div/div[2]/ul/li[2]
//			
			JobReg.findElement(By.xpath("/html/body/div[1]/div[3]/section/div[1]/div/div/div[2]/div[2]/blockquote/form/div[3]/div[9]/div/div/div/div[2]/ul/li[2]"))
			.click();
	
			
			////*[@id="callThankyou"]
			Project.findElement(By.xpath("//*[@id='callThankyou']")).click();
			Thread.sleep(2000);
			//Project.close();
			System.out.println("*****  ASSESSMENT DONE  ******");
		}
	}


