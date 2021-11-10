package objectRepository;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import initialization.ExcelData;

public class Industry {
	static int firstRow = 0;

	// constructor
	public Industry() {
		// System.out.println("Inside Assessment Constructor");

	}

	public void getIndustry(ExcelData exlData, int row, WebElement Industry) throws InterruptedException, IOException {

		// Select Industry
		Industry.click();

		Select IndustryClick = new Select(Industry);

		for (int cell = 1; cell <= exlData.excelColumnCount(ExcelData.tab); cell++) {
			if (exlData.getExcelData(firstRow, cell).toString().contains("Industry")) {

				IndustryClick.selectByVisibleText(exlData.getExcelData(row, cell).toString());
				break;
			}

		}
	}

	public int getIndustryListSize(WebElement Industry) {
		Select IndustryClick = new Select(Industry);

		int size = IndustryClick.getOptions().size();
		// System.out.println("Industry Country" + size);
		return size;
	}

	public void getIndustryFromList(WebElement Industry, int Index) throws InterruptedException {
		Select IndustryClick = new Select(Industry);

		Thread.sleep(2000);

		IndustryClick.selectByIndex(Index);
		// IndustryClick.selectByValue("Afghanistan");

	}
}
