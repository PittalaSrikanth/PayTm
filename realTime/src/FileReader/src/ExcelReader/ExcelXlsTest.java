package FileReader.src.ExcelReader;

import java.io.IOException;



public class ExcelXlsTest {
public static void main(String[] args) throws IOException{
	ExcelXls.Connection("Book2.xls",0);
	
	
	
	ExcelXls.getData(2,2);
	ExcelXls.setData(8,8,"Testpassed");
	//ExcelXls.closeExcel();
	
	
	
	
	
	
	
	
	
	
	
}
}
