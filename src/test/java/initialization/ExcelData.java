package initialization;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static String excelLoc = "C:\\Users\\akaur\\OneDrive - IDC\\Desktop\\My IDC\\Automation Scripts\\Projects\\Generic\\src\\test\\java\\DataDrivenTestFile.xlsx";
	public static XSSFSheet sheet;
	public XSSFWorkbook workbook;
	DataFormatter dataFormatter = new DataFormatter();
	// String value;
	public static int tab = 0;

	// constructor
	public ExcelData() {
		System.out.println("EXCEL CONSTRUCTOR");

	}

	public static XSSFWorkbook excelWorkbook() throws IOException {
		// fileInputStream argument
		FileInputStream fis = new FileInputStream(excelLoc);
		@SuppressWarnings("resource")
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		return wbook;

	}

	public String getExcelData(int row, int cell) throws IOException {

		workbook = excelWorkbook();

		// ROW NUMBER
		sheet = workbook.getSheetAt(tab);
		Row rowVar = sheet.getRow(row);

		Cell cellVar = rowVar.getCell(cell);
		// CONVERT TO STRING
		return dataFormatter.formatCellValue(cellVar);

	}

	public int excelRowCount() throws IOException {

		workbook = excelWorkbook();
		// EXCEL SHEET
		sheet = workbook.getSheetAt(tab);

		// ROW NUMBER
		return sheet.getLastRowNum();
	}

	public int excelColumnCount(int tab) throws IOException {
		workbook = excelWorkbook();
		// EXCEL SHEET
		sheet = workbook.getSheetAt(tab);

		// COLUMN NUMBER System.out.println(" EXCEL COLUMN
		// COUNT"+sheet.getRow(0).getPhysicalNumberOfCells());

		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
}
