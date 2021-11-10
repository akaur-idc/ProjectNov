package initialization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class LaunchURL {

	public LaunchURL() {
		System.out.println("LaunchURL CONSTRUCTOR");

	}

	// LAUNCH THE URL
	public String lauchURL(WebDriver driver) {
		String url = "https://dev-idc-generic-lg-19.webappuat.com/";
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return url;
	}

}
