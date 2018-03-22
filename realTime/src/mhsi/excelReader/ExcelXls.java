/*open, close,sheet navigate ,read, write, row count, coloum count, data split by _ ,
 remove/count blank row/coloum from row count/coloum count, 
get/send cell data based on cell value(ex...D3),
count of all writen cells, count of blank cells

*/




package mhsi.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelXls {

	 static String path = System.getProperty("user.dir")+"\\src\\testData\\";
	 static File file;
	 static FileInputStream fis;
	 static HSSFWorkbook wb; 
	 static HSSFSheet sheet; 
	 static FileOutputStream fos;
	
	
	public static void Conncetion(String excelName,String sheetName) throws IOException{
		try {
			file = new File(path+excelName);
			fis = new FileInputStream(file);
			wb = new HSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
			fos = new FileOutputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void Connection(String excelName,int sheetNum) throws IOException{
		try {
			file = new File(path+excelName);
			fis = new FileInputStream(file);
			wb = new HSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetNum);
			fos = new FileOutputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getData(int rowNo,int colNo){
		return sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
	}
		
	public static void setData(int rowNo,int colNo,String text){
		try {
			sheet.getRow(rowNo).createCell(colNo).setCellValue(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
	public static int rowCount(){
		int count = sheet.getRow(0).getLastCellNum();
		return count;
	}
		
	public static int coloumCount(){
		int count = sheet.getColumnWidth(0);
		return count;
	}
	public static void closeExcel() throws IOException{
		wb.close();
	}
	public static void saveExcel() throws IOException{
		try {
			wb.write();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

