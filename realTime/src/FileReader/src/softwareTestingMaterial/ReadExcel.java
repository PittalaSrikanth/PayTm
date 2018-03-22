package FileReader.src.softwareTestingMaterial;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
//How to read excel files using Apache POI
public class ReadExcel {
 public static void main (String [] args) throws IOException{
                        //I have placed an excel file 'Test.xlsx' in my D Driver 
 FileInputStream fis = new FileInputStream("C:\\Users\\wdev7\\Desktop\\Book1.xlsx");
 XSSFWorkbook workbook = new XSSFWorkbook(fis);
 
 
 XSSFSheet sheet = workbook.getSheetAt(0);
                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
 Row row = sheet.getRow(2);
 Cell cell = row.getCell(2);
                       System.out.println(cell);
 System.out.println(sheet.getRow(2).getCell(2));
 sheet.getRow(3).createCell(9).setCellValue("2.41.0"); 
 
 FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\wdev7\\Desktop\\Book1.xlsx"));
 //System.out.println(cellval);
 workbook.write(fout);
 } 
}