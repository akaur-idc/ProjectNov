package initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementLocators {

	protected WebDriver Project;
	protected WebDriverWait wait;
	public By DevRibbonBttn = By.linkText("Close");
	public By ConsentBttn = By.cssSelector("#consent");
	public By CookieClass = By.className("cookie-section");
	public By BeginAsmtBttn = By.xpath("//a[@href='/Assessment']");
	public By Page1NxtBttn = By.id("btnNext");
	public By Page2NxtBttn = By.xpath("//*[@id='questionnaire']//*[@id='section2page1Form']//*[@id='btnNext']");
	public By Page3NxtBttn = By.xpath("//*[@id='questionnaire']//*[@id='section3page1Form']//*[@id='btnNext']");
	public By Page4NxtBttn = By.xpath("//*[@id='questionnaire']//*[@id='section4page1Form']//*[@id='btnNext']");
	public By Page5NxtBttn = By.xpath("//*[@id='questionnaire']//*[@id='section5page1Form']//*[@id='btnNext']");
	public By Page6NxtBttn = By.xpath("//*[@id='questionnaire']//*[@id='section6page1Form']//*[@id='btnNext']");
	public By Slider1 = By.xpath("//span[contains(@class, 'irs-slider single')]");
	public By Country = By.cssSelector("#Q3-QI3");
	public By Radio1 = By.xpath("//input[@name='Q1-QI1']");
	public By Radio2 = By.xpath("//input[@name='Q2-QI2']");
	public By Checkbox = By.xpath("//input[@name='Q7-QI9']");
	public By Industry = By.cssSelector("#Q4-QI5");
	public By Employee = By.cssSelector("#Q5-QI7-AC94");
	public By MiscInput0 = By.cssSelector("#Q6-QI8-AC95");
	public By MiscInput1 = By.cssSelector("#Q8-QI10-AC105");
	public By MiscInput2 = By.cssSelector("#Q8-QI11-AC106");
	public By MiscInput3 = By.cssSelector("#Q9-QI12-AC107");
	public By MiscInput4 = By.cssSelector("#Q9-QI13-AC108");
	public By MiscInput5 = By.cssSelector("#Q9-QI14-AC109");
	public By MiscInput6 = By.cssSelector("#Q9-QI15-AC110");
	public By MiscInput7 = By.cssSelector("#Q10-QI16-AC111");
	public By MiscInput8 = By.cssSelector("#Q11-QI17-AC112");
	public By MiscInput9 = By.cssSelector("#Q13-QI19-AC114");
//	public By MiscInput10 = By.cssSelector("#Q8-QI10-AC105");
//	public By MiscInput11 = By.cssSelector("#Q8-QI10-AC105");
	public By FirstName = By.cssSelector("#Q14-QI20-AC115");
	public By LastName = By.cssSelector("#Q15-QI21-AC116");
	public By email = By.cssSelector("#Q16-QI22-AC117");
	public By CompanyName = By.cssSelector("#Q17-QI23-AC118");
	public By ThankYou = By.id("callThankyou");
	public int CountryListSize;

	public ElementLocators(WebDriver Project) {
		this.Project = Project;
	}

	public void waitAndVerifyTitle() {

		System.out.println(" GENERIC LG");
	}

}
