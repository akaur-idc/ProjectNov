package objectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieConsent {

	// constructor
	public CookieConsent() {

		System.out.println("CookieConsent CONSTRUCTOR");

	}

	public static void consent(WebDriver Project, By consentBttn, By cookieClass)
			throws IOException, InterruptedException {

		if (Project.findElement(cookieClass).getAttribute("style").contains("hidden"))

			System.out.println("consent is hidden");
		else {
			Project.findElement(consentBttn).click();
			System.out.println("consent not is hidden");
		}

	}
}
