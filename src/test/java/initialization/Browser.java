package initialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public Browser() {
		System.out.println("Browser CONSTRUCTOR");

	}

	public WebDriver Driver;
	public WebDriver DriverList[] = new WebDriver[3];

	public WebDriver pickBrowser(String browser) {

		if (browser == "Chrome") {

			/*
			 * String path = System.getProperty("user.dir"); // return project folder path
			 * System.out.println("project folder path for chrome: "+path);
			 * 
			 * String driverpath = path + "\\Chrome\\chromedriver.exe"; // return driver
			 * folder path System.out.println("driverpath: "+driverpath);
			 * System.setProperty("webdriver.chrome.driver",driverpath); Driver = new
			 * ChromeDriver();
			 */

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			Driver = new ChromeDriver(options);
			System.out.println("Browser CHROME");
			return Driver;

		} else if (browser == "Edge") {

			WebDriverManager.edgedriver().setup();

			Driver = new EdgeDriver();
			return Driver;
		}

		else if (browser == "Firefox")

		{
			WebDriverManager.firefoxdriver().setup();

			Driver = new FirefoxDriver();
			return Driver;
		}
		return Driver;
	}

	public WebDriver[] pickAllBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//akaur//OneDrive - IDC//Desktop//My IDC//Automation Scripts//Drivers//chromedriver_win32//chromedriver.exe");

		DriverList[0] = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver",
				"C://Users//akaur//OneDrive - IDC//Desktop//My IDC//Automation Scripts//Drivers//Firefox//geckodriver.exe");
		DriverList[1] = new FirefoxDriver();

		return DriverList;
	}
}
