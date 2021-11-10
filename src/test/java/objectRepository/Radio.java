package objectRepository;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import initialization.ExcelData;

public class Radio {
	int totalOptions;
	static int firstRow = 0;
	static int secondRow = 1;
	int option1;

	// constructor
	public Radio() {
		// System.out.println("Inside RADIO Constructor");

	}

	public int getRadioCount(ExcelData exlData, int page) throws NumberFormatException, IOException {
		for (int cell = 1; cell <= exlData.excelColumnCount(ExcelData.tab); cell++)
			if (exlData.getExcelData(firstRow, cell).toString().contains("Radio_Page" + page))
				totalOptions = Integer.parseInt(exlData.getExcelData(secondRow, cell));
		System.out.println("      totalOptions            " + totalOptions); 
		
		return totalOptions;
	}

	public int fetchRadioCount(WebDriver Project,By radio) throws InterruptedException
	{
		Thread.sleep(2000);
		totalOptions =Project.findElements(radio).size();
		//System.out.println("RADIO "+ totalOptions );
		return totalOptions ;
		
	}
	public void getRadioOption(WebDriver Project, int page, int option, ExcelData exlData, int row)
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
				///	if(option!=0)
					// option 2 and assessment number (row) row 5-2=3 1-5 15 15-5=10
					// option = (int) (Math.random() * (option - 1)) + 1;
					option1 = Math.round(row / option);
				///	else option1 =row;
					
					if (option1 > option) {
						if (option1 - option != 0 && option1 - option < option)
							option = option1 - option;
						else {
							if (option - 1 != 0)
								option--;
							else
								option = option + 0;
						}
					} else
						option = option1;

					System.out.println("#######RANDOM            " + option);
					// option--;
				} else {
					option = row - option;

				}
				
			}
		}
		Thread.sleep(2000);
		Project.findElement(By.cssSelector("#section" + page + "page1Form label:nth-child(" + option + ") > i"))
				.click();
		System.out.println("%---------- Radio  option -----------% " + option);
	}

}
