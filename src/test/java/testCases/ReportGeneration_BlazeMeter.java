package testCases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import initialization.ExcelData;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReportGeneration_BlazeMeter {
	
	private WebDriver driver;
	// private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//akaur//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// baseUrl = "https://www.blazedemo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// ==========DECLARATION==========
		// ElementLocators el = new ElementLocators(SysDig);

	}

	@Test
	public void testLocaters() throws Exception {
		ExcelData exlData = new ExcelData();
		// String TestOrg = exlData.getExcelData(0, i, 0,excelFileLoc);
		// Label: Test
		// ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1536,722
		// | ]]
		driver.get("https://dev-idc-generic-lg-19.webappuat.com/#three");
		// ERROR: Caught exception [ERROR: Unsupported command [openWindow | | ]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1
		// | ]]
		driver.findElement(By.linkText("Close")).click();
		// AGREE AND CONTINUE - Cookie
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#consent")).click();
		driver.findElement(By.linkText("Begin Assessment")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		System.out.println("EXCEL DATA ---------" + exlData.getExcelData( 1, 1).toString());
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(
				By.cssSelector("#section1page1Form label:nth-child(" + exlData.getExcelData( 1, 1).toString() + ")"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("btnNext")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(
				By.xpath("//form[@id='section2page1Form']/div/fieldset/section/div/div/section/div[2]/div/label[2]"))
				.click();

		driver.findElement(
				By.cssSelector("#section2page1Form > div.tag-box.tag-box-v3.no-bg > fieldset > footer > #btnNext"))
				.click();
		driver.findElement(By.id("Q3-QI3")).click();
		new Select(driver.findElement(By.id("Q3-QI3"))).selectByVisibleText("Aland Islands");
		driver.findElement(By.id("Q3-QI3")).click();
		driver.findElement(By.id("Q4-QI5")).click();
		new Select(driver.findElement(By.id("Q4-QI5"))).selectByVisibleText("Hospitality");
		driver.findElement(By.id("Q4-QI5")).click();
		driver.findElement(By.id("Q5-QI7-AC94")).click();
		driver.findElement(
				By.cssSelector("#section3page1Form > div.tag-box.tag-box-v3.no-bg > fieldset > footer > #btnNext"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Project.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#Q6-QI8-AC95")).clear();
		// Project.findElement(By.xpath("//*[@id='Q6-QI8-AC95']")).clear();
		driver.findElement(By.cssSelector("#Q6-QI8-AC95")).sendKeys("500");
		// Project.findElement(By.xpath("//*[@id='Q6-QI8-AC95']")).sendKeys("500");

		//// *[@id="section4page1Form"]/div/fieldset/section[2]/div/div/section/div[2]/div/label[9]
		// driver.findElement(By.cssSelector("label.checkbox")).click();
		driver.findElement(By.cssSelector("#section4page1Form label:nth-child(2)")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// findElement(By.xpath("//*[@id='questionnaire']//*[@id='section4page1Form']//*[@id='btnNext']")).click();
		driver.findElement(By.xpath("//*[@id='questionnaire']//*[@id='section4page1Form']//*[@id='btnNext']")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector("#section5page1Form > div.tag-box.tag-box-v3.no-bg > fieldset > footer > #btnNext"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(
				By.cssSelector("#section6page1Form > div.tag-box.tag-box-v3.no-bg > fieldset > footer > #btnNext"))
				.click();
		driver.findElement(By.id("Q14-QI20-AC115")).click();
		driver.findElement(By.id("Q14-QI20-AC115")).clear();
		driver.findElement(By.id("Q14-QI20-AC115")).sendKeys("TESTFN");
		driver.findElement(By.id("Q15-QI21-AC116")).clear();
		driver.findElement(By.id("Q15-QI21-AC116")).sendKeys("TESTLN");
		driver.findElement(By.id("Q16-QI22-AC117")).clear();
		driver.findElement(By.id("Q16-QI22-AC117")).sendKeys("AKAUR@IDC.COM");
		driver.findElement(By.id("Q17-QI23-AC118")).clear();
		driver.findElement(By.id("Q17-QI23-AC118")).sendKeys("TEST IDC");
		driver.findElement(By.id("callThankyou")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
