package mhsi.ExcelReader;

import java.io.IOException;

public class ExcelTest {
	public static void main(String[] args) throws IOException {
		ExcelXlsx.Connection("Book123.xlsx", "Sheet1");

		ExcelXlsx.getData("W82");
		ExcelXlsx.Sheet("Sheet2");
		ExcelXlsx.getData("c5");

		ExcelXlsx.closeExcel();

	}
}
