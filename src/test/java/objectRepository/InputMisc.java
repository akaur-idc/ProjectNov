package objectRepository;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import initialization.ExcelData;

public class InputMisc
{	
	static int firstRow=0;	
	//constructor
		public  InputMisc()
		{
			//System.out.println("Inside Misc Input  Constructor");
			
		}

	
		public void getInput(WebDriver Project, ExcelData exlData, int row, By by)
				throws InterruptedException, IOException {
			Thread.sleep(2000);
			Project.findElement(by).clear();
			for (int cell = 1; cell <= exlData.excelColumnCount(ExcelData.tab); cell++) {
				if (exlData.getExcelData(firstRow, cell).toString().contains("MiscInput")) {
					Project.findElement(by)
							.sendKeys(exlData.getExcelData(row, cell).toString());
						break;
				}
			}

		}
		public void clearInput(WebDriver Project, By by)
				throws InterruptedException, IOException {
			Project.findElement(by).clear();
		}
	
}
