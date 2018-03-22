package FileReader.src.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelXlsx {

	static String path = "C:\\Users\\srikanth\\Desktop\\";
	static File file;
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static FileOutputStream fos;

	public static void Conncetion(String excelName, String sheetName)
			throws IOException {
		try {
			file = new File(path + excelName);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Connection(String excelName, int sheetNum)
			throws IOException {
		try {
			file = new File(path + excelName);

			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetNum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getData(String cellvalue) {
		String[] a = (cellvalue).split("");
		if (a.length == 3) {
			a[1] = cellvalue.substring(1,3);
			a[0] = cellvalue.substring(0,1);
		}
		int pars = (Integer.parseInt(a[1]) - 1);
		System.out.println(sheet.getRow(pars).getCell(
				alphaNumeric.alpha(a[0].toUpperCase())));
		return cellvalue ;
	}

	public static void getData(int rowNo, int colNo) {
		try {
			System.out.println(sheet.getRow(rowNo).getCell(colNo)
					.getStringCellValue());
		} catch (Exception error) {
			error.printStackTrace();
			System.out.println("getData Fail Due to Null Data in Excel");
		}
	}

	public static void setData(int rowNo, int colNo, String text)
			throws IOException {

		sheet.getRow(rowNo).createCell(colNo).setCellValue(text);
		fos = new FileOutputStream(file);
		wb.write(fos);

	}

	public static void rowCount() {
		int count = sheet.getRow(0).getLastCellNum();
		System.out.println(count);
	}

	public static void coloumCount() {
		int count = sheet.getColumnWidth(0);
		System.out.println(count);
	}

	public static void closeExcel() throws IOException {
		wb.close();
	}

	public static void saveExcel() throws IOException {
		try {
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
