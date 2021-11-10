package objectRepository;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import initialization.URLsAndLocations;

public class TakeScreenShot {

	public static String Path;

	// constructor
	public TakeScreenShot() {

		System.out.println("SCREEN SHOT CONSTRUCTOR");

	}

	public static void createFolder(String foldername) {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File outputFile = new File(URLsAndLocations.fileWithPath + timeStamp + "_" + foldername);
		outputFile.mkdir();
		System.out.println("Output File" + outputFile.getPath());
		Path = outputFile.getPath();
		// return Path;

	}

	public void screenshot(WebDriver Project, String Page) throws IOException, InterruptedException {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) Project);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move to new destination
		File DestFile = new File(Path + "\\" + Page + " - " + System.currentTimeMillis() + ".png");

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

		Thread.sleep(2000);
	}

	public void takeShot(WebDriver Project, String Page, WebElement element) throws IOException, InterruptedException {

		element.click();

		screenshot(Project, Page);
	}

}
