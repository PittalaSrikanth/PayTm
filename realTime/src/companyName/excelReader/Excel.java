package companyName.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {

	 static String path = System.getProperty("user.dir")+"\\src\\companyName\\testData\\";
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
	
	public static String read(int rowNo,int colNo){
		return sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
	}
		
	public static void write(int rowNo,int colNo,String text){
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

