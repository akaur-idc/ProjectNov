package objectRepository;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import initialization.ExcelData;

public class Country {
	static int firstRow = 0;

	// constructor
	public Country() {
		// System.out.println("Inside Assessment Constructor");

	}

	public void getCountry(ExcelData exlData, int row, WebElement Country) throws InterruptedException, IOException {

		Select CountryClick = new Select(Country);

		for (int cell = 1; cell <= exlData.excelColumnCount(ExcelData.tab); cell++) {

			if (exlData.getExcelData(firstRow, cell).toString().contains("Country")) {
				// System.out.println("Country:-" + exlData.getExcelData(row, cell).toString());
				Thread.sleep(2000);
				CountryClick.selectByValue(exlData.getExcelData(row, cell).toString());
				break;
			}
		}

	}

	public int getCountryListSize(WebElement Country) {
		Select CountryClick = new Select(Country);

		int size = CountryClick.getOptions().size();
		// System.out.println("Country:" + size);
		return size;
	}

	public void getCountryFromList(WebElement Country, int Index) throws InterruptedException {
		Select CountryClick = new Select(Country);

		Thread.sleep(2000);
		CountryClick.selectByIndex(Index);

	}
}
