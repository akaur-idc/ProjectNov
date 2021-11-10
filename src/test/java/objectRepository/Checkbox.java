package objectRepository;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import initialization.ExcelData;

public class Checkbox {
	int totalOptions;
	static int firstRow = 0;
	static int secondRow = 1;

	// constructor
	public Checkbox() {
		// System.out.println("Inside CHECKBOX Constructor");

	}

	public int getCheckCount(ExcelData exlData, int page) throws NumberFormatException, IOException {
		for (int cell = 1; cell <= exlData.excelColumnCount(ExcelData.tab); cell++)
			if (exlData.getExcelData(firstRow, cell).toString().contains("Checkbox_Page" + page))
				totalOptions = Integer.parseInt(exlData.getExcelData(secondRow, cell));
		System.out.println("  Checkbox    option            " + totalOptions);
		return totalOptions;
	}
	public int fetchChekboxCount(WebDriver Project,By checkBox) throws InterruptedException
	{
		Thread.sleep(2000);
		totalOptions =Project.findElements(checkBox).size();
		//System.out.println("CHECKBOX "+totalOptions );
		return totalOptions;
		
	}
	public void getCheckboxOption(WebDriver Project, int page, int option, int row)
			throws InterruptedException, IOException {
		if (row == 1) {
			option = option + 0;

		} else {
			if (option >= row) {
				if (option - row == 0) {

					option = 1;

				} else {

					option = option - row;

				}
			} else if (option <= row) {

				if (option == row) {

					option = row;

				} else if (option < row - option) {
					option = (int) (Math.random() * (option - 1)) + 1;
					// option--;
				} else {
					option = row - option;

				}

			}
		}
		Project.findElement(By.cssSelector("#section" + page + "page1Form label:nth-child(" + option + ") > i"))
				.click();
		System.out.println("%---------- Checkbox  option -----------% " + option);

	}

}