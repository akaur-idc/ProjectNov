package objectRepository;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import initialization.ExcelData;

public class Slider {
	static int firstRow = 0;

	// constructor
	public Slider() {
		// System.out.println("Inside Misc Input Constructor");

	}

	public void getSlider(WebDriver Project, ExcelData exlData, int row) throws IOException {
		String numb = "";
		for (int cell = 1; cell <= exlData.excelColumnCount(ExcelData.tab); cell++)
			if (exlData.getExcelData(firstRow, cell).toString().contains("Slider"))
				numb = exlData.getExcelData(row, cell);
		System.out.println("SLIDER:- " + numb);
		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-single')[0].style.left='" + numb + "%'");
		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-single')[0].textContent='" + numb + "'");
		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-bar')[0].style.width='" + numb + "%'");
		// document.getElementById('email').value

		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-slider single')[0].style.left='" + numb + "%'");

	}

	public void minSlider(WebDriver Project) throws InterruptedException, IOException {
		// irs-min
		((JavascriptExecutor) Project).executeScript("document.getElementsByClassName('irs-min')[0]");

	}

	public void maxSlider(WebDriver Project) throws InterruptedException, IOException {
		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-single')[0].style.left='" + 100 + "%'");
		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-single')[0].textContent='" + 100 + "'");
		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-bar')[0].style.width='" + 100 + "%'");
		// document.getElementById('email').value

		((JavascriptExecutor) Project)
				.executeScript("document.getElementsByClassName('irs-slider single')[0].style.left='" + 100 + "%'");

	}

}
