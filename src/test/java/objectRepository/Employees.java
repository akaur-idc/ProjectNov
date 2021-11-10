package objectRepository;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import initialization.ExcelData;

public class Employees {

	static int firstrow = 0;

	// constructor
	public Employees() {
		// System.out.println("Inside Employee Constructor");

	}

	public void getEmployee(WebDriver Project, ExcelData exlData, int row, WebElement Employee)
			throws InterruptedException, IOException {
		Employee.clear();

		for (int cell = 1; cell <= exlData.excelColumnCount(ExcelData.tab); cell++) {

			if (exlData.getExcelData(firstrow, cell).toString().contains("EMP")) {
				// System.out.println("EMP VALUE" + exlData.getExcelData(tab,
				// row, j,excelLoc).toString());
				Employee.sendKeys(exlData.getExcelData(row, cell).toString());
				break;
			}
		}

	}

	public void clearEmployee(WebElement Employee) throws InterruptedException, IOException {
		Employee.clear();
	}
}
