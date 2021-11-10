package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

//import credentials.SysDig_ElementLocators;
//import objectRepository.SysDig_LoginPage;
//import objectRepository.SysDig_HomePage;
//import objectRepository.SysDig_MyProfilePage;

public class LaunchTool_AllBrowsersTest 
{
	
	
		
	@Test
	public void TC_MyProfile() throws InterruptedException
	{
		//Firefox Launch
		//=====================================================================================================
		System.setProperty("webdriver.gecko.driver", "C://sarath_eclipse//sarath_eclipse_jars//geckodriver-v0.26.0-win32//geckodriver.exe");
		WebDriver SysDigFirefox = new FirefoxDriver();
		System.out.println("Firefox launched cs");
		
		//maximize browser
		SysDigFirefox.manage().window().maximize();
		SysDigFirefox.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		SysDigFirefox.get("https://dev-SysDigroi.webappuat.com");
		
		//Chrome Launch
		//======================================================================================================
		System.setProperty("webdriver.chrome.driver", "C://sarath_eclipse//sarath_eclipse_jars//chromedriver_win32//chromedriver.exe");
		WebDriver SysDigChrome = new ChromeDriver();
		System.out.println("Chrome launched cs");
		
		//maximize browser
		SysDigChrome.manage().window().maximize();
		SysDigChrome.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		SysDigChrome.get("https://dev-SysDigroi.webappuat.com");
		
		//Edge Launch
		//======================================================================================================
		System.setProperty("webdriver.edge.driver", "C://Windows//System32//MicrosoftWebDriver.exe");
		WebDriver SysDigEdge = new EdgeDriver();
		System.out.println("MicrosoftEdge launched cs");
		
		//maximize browser
		SysDigEdge.manage().window().maximize();
		SysDigEdge.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		SysDigEdge.get("https://dev-SysDigroi.webappuat.com");
		
		//Opera Launch
		//======================================================================================================
			
		System.setProperty("webdriver.opera.driver","C://sarath_eclipse//sarath_eclipse_jars//operadriver_win64//operadriver_win64//operadriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		OperaOptions options = new OperaOptions();
		options.setBinary("C://Users//schandrasekhar//AppData//Local//Programs//Opera//65.0.3467.48//Opera.exe");
		capabilities.setCapability(OperaOptions.CAPABILITY, options);
		@SuppressWarnings("deprecation")
		OperaDriver SysDigOpera = new OperaDriver(capabilities);
		
		System.out.println("Opera launched cs");
		
		//maximize browser
		SysDigOpera.manage().window().maximize();
		SysDigOpera.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		SysDigOpera.get("https://dev-SysDigroi.webappuat.com");
		
		
						
	}
	
	

}
