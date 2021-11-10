//package testCases;

//public class Assessment {

//}

//====================

package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import initialization.ElementLocators;
import initialization.ExcelData;

public class Assessment_Seq {

	// @SuppressWarnings("unlikely-arg-type")
	@Test
	public static void Assessment() throws IOException, InterruptedException, FileNotFoundException

	{

		// ==========================================================================================================================================//

		// EXCEL FILE DECLARATION

		ExcelData exlData = new ExcelData();
		// LAUNCH BROWSER
		System.setProperty("webdriver.chrome.driver",
				"C://Users//akaur//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver Project = new ChromeDriver();
		ElementLocators el = new ElementLocators(Project);

		Project.manage().window().maximize();
		Project.get("https://dev-idc-generic-lg-19.webappuat.com/");
		Project.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String titlecs = Project.getTitle();
		System.out.println("Text from dev site: TOOL NAME: " + titlecs);

		// RIGGON TEXT
		String RibbonTxt = Project.findElement(By.cssSelector("#warning  div.modal-body.text-center")).getText();
		System.out.println("SITE EXCEL :" + RibbonTxt);
		// String value= dataFormatter.formatCellValue(rowcs.getCell(0));
		// Project.findElement(By.cssSelector(value)).click();
		// System.out.println("SITE RIBBON TEXT :"+ RibbonTxt);

		// Close - Dev Site pop-up modal
		Thread.sleep(2000);
		Project.findElement(el.DevRibbonBttn).click();
		Project.findElement(By.linkText("Close")).click();

		// AGREE AND CONTINUE - Cookie
		Thread.sleep(2000);
		Project.findElement(By.cssSelector("#consent")).click();

		// ==========================================================================================================================================//

		Thread.sleep(2000);
		// Verify if Begin Assessment button is present
		// "//a[@href='/docs/configuration']"
		if (Project.findElements(By.xpath("//a[@href='/Assessment']")).size() != 0) {
			System.out.println("Element is Present");
		} else {
			System.out.println("Element is Absent");
		}

		// Find number of buttons present on Landing Page

		int BeginAssessmentBtnSize = Project.findElements(By.xpath("//a[@href='/Assessment']")).size();
		System.out.println("Number of begin button(s) present :  " + BeginAssessmentBtnSize);

		// Click - Begin Assessment
		Project.findElement(By.xpath("//a[@href='/Assessment']")).click();
		System.out.println("Begin Assessment button is clicked");
		Thread.sleep(1000);
		// PAGE 1
		System.out.println("======PAGE 1 =========");
		System.out.println("EXCEL DATA ---------" + exlData.getExcelData( 1, 1).toString());
		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Project.findElement(
				By.cssSelector("#section1page1Form label:nth-child(" + exlData.getExcelData( 1, 1).toString() + ")"))
				.click();

		
		System.out.println("Radio button is clicked on PAGE1");
		
		//document.querySelector("#section1page1Form > div > fieldset > section > div > div > section > div.row")
		//#section1page1Form > div > fieldset > section > div > div > section > div.row > div > label:nth-child(1)

		Project.findElement(By.id("btnNext")).click();
		Thread.sleep(2000);
		// PAGE 2
		System.out.println("======PAGE 2 =========");
		Project.findElement(By.cssSelector("#section2page1Form label:nth-child(2)")).click();
		System.out.println("Radio button is clicked on PAGE2");
		// Project.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		Project.findElement(By.xpath("//*[@id='questionnaire']//*[@id='section2page1Form']//*[@id='btnNext']")).click();

		// PAGE 3 #Q3-QI3
		System.out.println("======PAGE 3 =========");
		WebElement Country = Project.findElement(By.cssSelector("#Q3-QI3"));
		// .findElement(By.xpath("//*[@id='questionnaire']//*[@id='section3page1Form']//*[@id='Q3-QI3']"));

		// Select Country
		Country.click();
		System.out.println("Country clicked");

		Select CountryClick = new Select(Country);
		// CountryClick.selectByValue("Afghanistan");
		CountryClick.selectByIndex(12);

		Thread.sleep(2000);

		// Select Industry
		WebElement Industry = Project.findElement(By.cssSelector("#Q4-QI5"));
		// .findElement(By.xpath("//*[@id='questionnaire']//*[@id='section3page1Form']//*[@id='Q4-QI5']"));

		Industry.click();
		System.out.println("Industry clicked");
		Select IndustryClick = new Select(Industry);
		IndustryClick.selectByValue("60");

		// EMP SIZE #Q5-QI7-AC94
		// Project.findElement(By.xpath("//*[@id='Q5-QI7-AC94']")).clear();
		Project.findElement(By.cssSelector("#Q5-QI7-AC94")).clear();
		// Project.findElement(By.xpath("//*[@id='Q5-QI7-AC94']")).sendKeys("500");
		Project.findElement(By.cssSelector("#Q5-QI7-AC94")).sendKeys("500");
		Project.findElement(By.xpath("//*[@id='questionnaire']//*[@id='section3page1Form']//*[@id='btnNext']")).click();

		// PAGE 4
		System.out.println("======PAGE 4 =========");

		Thread.sleep(2000);

		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Project.findElement(By.cssSelector("#Q6-QI8-AC95")).clear();
		// Project.findElement(By.xpath("//*[@id='Q6-QI8-AC95']")).clear();
		Project.findElement(By.cssSelector("#Q6-QI8-AC95")).sendKeys("500");
		// Project.findElement(By.xpath("//*[@id='Q6-QI8-AC95']")).sendKeys("500");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Project.findElement(By.cssSelector("#section4page1Form label:nth-child(2)")).click();

		Project.findElement(By.xpath("//*[@id='questionnaire']//*[@id='section4page1Form']//*[@id='btnNext']")).click();

		// PAGE 5
		System.out.println("======PAGE 5 =========");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Q8-QI10-AC105 Q8-QI11-AC106
		Project.findElement(By.cssSelector("#Q8-QI10-AC105")).clear();
		// Project.findElement(By.xpath("//*[@id='Q8-QI10-AC105']")).clear();

		Project.findElement(By.cssSelector("#Q8-QI10-AC105")).sendKeys("20");
		// Project.findElement(By.xpath("//*[@id='Q8-QI10-AC105']")).sendKeys("20");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Project.findElement(By.cssSelector("#Q8-QI11-AC106")).clear();
		// Project.findElement(By.xpath("//*[@id='Q8-QI11-AC106']")).clear();

		Project.findElement(By.cssSelector("#Q8-QI11-AC106")).sendKeys("20");
		// Project.findElement(By.xpath("//*[@id='Q8-QI11-AC106']")).sendKeys("20");

		// Q9-QI12-AC107 Q9-QI13-AC108
		Project.findElement(By.cssSelector("#Q9-QI12-AC107")).clear();
		// Project.findElement(By.xpath("//*[@id='Q9-QI12-AC107']")).clear();

		// Project.findElement(By.xpath("//*[@id='Q9-QI12-AC107']")).sendKeys("20");
		Project.findElement(By.cssSelector("#Q9-QI12-AC107")).sendKeys("20");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Project.findElement(By.cssSelector("#Q9-QI13-AC108")).clear();
		// Project.findElement(By.xpath("//*[@id='Q9-QI13-AC108']")).clear();

		// Project.findElement(By.xpath("//*[@id='Q9-QI13-AC108']")).sendKeys("20");
		Project.findElement(By.cssSelector("#Q9-QI13-AC108")).sendKeys("20");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Project.findElement(By.cssSelector("#Q9-QI14-AC109")).clear();
		// Project.findElement(By.xpath("//*[@id='Q9-QI14-AC109']")).clear();//Q9-QI13-AC108

		// Project.findElement(By.xpath("//*[@id='Q9-QI14-AC109']")).sendKeys("20");
		Project.findElement(By.cssSelector("#Q9-QI14-AC109")).sendKeys("20");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Project.findElement(By.cssSelector("#Q9-QI15-AC110")).clear();
		// Project.findElement(By.xpath("//*[@id='Q9-QI15-AC110']")).clear();

		// Project.findElement(By.xpath("//*[@id='Q9-QI15-AC110']")).sendKeys("20");
		Project.findElement(By.cssSelector("#Q9-QI15-AC110")).sendKeys("20");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Project.findElement(By.xpath("//*[@id='questionnaire']//*[@id='section5page1Form']//*[@id='btnNext']")).click();

		// PAGE 6
		System.out.println("======PAGE 6 =========");
		// Q10-QI16-AC111 Q11-QI17-AC112 id="Q13-QI19-AC114"
		Project.findElement(By.cssSelector("#Q10-QI16-AC111")).clear();
		// Project.findElement(By.xpath("//*[@id='Q10-QI16-AC111']")).clear();

		Project.findElement(By.cssSelector("#Q10-QI16-AC111")).sendKeys("30");
		// Project.findElement(By.xpath("//*[@id='Q10-QI16-AC111']")).sendKeys("30");

		Project.findElement(By.cssSelector("#Q11-QI17-AC112")).clear();
		// Project.findElement(By.xpath("//*[@id='Q11-QI17-AC112']")).clear();

		// Project.findElement(By.xpath("//*[@id='Q11-QI17-AC112']")).sendKeys("30");
		Project.findElement(By.cssSelector("#Q11-QI17-AC112")).sendKeys("30");

		Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// SLIDER
		WebElement slider = Project.findElement(By.xpath("//span[contains(@class, 'irs-slider single')]"));
		// new Actions(Project).dragAndDropBy(slider, 150, 0).build().perform();
		Thread.sleep(5000);

		new Actions(Project).clickAndHold(slider).moveByOffset(100, 0).release().perform();

		Project.findElement(By.cssSelector("#Q13-QI19-AC114")).clear();
		// Project.findElement(By.xpath("//*[@id='Q13-QI19-AC114']")).clear();

		Project.findElement(By.cssSelector("#Q13-QI19-AC114")).sendKeys("30");
		// Project.findElement(By.xpath("//*[@id='Q13-QI19-AC114']")).sendKeys("30");

		Project.findElement(By.xpath("//*[@id='questionnaire']//*[@id='section6page1Form']//*[@id='btnNext']")).click();

		// PAGE REG PAGE
		System.out.println("====== REG PAGE =========");

		//
		Project.findElement(By.cssSelector("#Q14-QI20-AC115")).sendKeys("TESTFN");
		// Project.findElement(By.xpath("//*[@id='Q14-QI20-AC115']")).sendKeys("TESTFN");

		Project.findElement(By.cssSelector("#Q15-QI21-AC116")).sendKeys("TESTLN");
		// Project.findElement(By.xpath("//*[@id='Q15-QI21-AC116']")).sendKeys("TESTLN");

		Project.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Project.findElement(By.cssSelector("#Q16-QI22-AC117")).sendKeys("akaur@idc.com");
		// Project.findElement(By.xpath("//*[@id='Q16-QI22-AC117']")).sendKeys("akaur@idc.com");

		Project.findElement(By.cssSelector("#Q17-QI23-AC118")).sendKeys("TEST IDC.COM");
		// Project.findElement(By.xpath("//*[@id='Q17-QI23-AC118']")).sendKeys("TEST
		// IDC.COM");// id="callThankyou"
		Project.findElement(By.id("callThankyou")).click();

		// Project.findElement(By.xpath("//a[@href='https://www.redirecturl.com/']")).click();
		Project.close();
	}
}
