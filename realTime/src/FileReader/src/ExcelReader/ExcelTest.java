package FileReader.src.ExcelReader;

import java.io.IOException;

public class ExcelTest {
public static void main(String[] args) throws IOException{
	ExcelXlsx.Conncetion("Book123.xlsx","Sheet1");
	
	;
	
/*	ExcelXlsx.getData(3,3);
	ExcelXlsx.setData(2,10,"Test  counts&save   11      ");
	*/
	/*ExcelXlsx.rowCount();
    ExcelXlsx.coloumCount();*/
	
	ExcelXlsx.getData("j10");
	ExcelXlsx.getData("b1");
	ExcelXlsx.getData("c1");
	ExcelXlsx.getData("b2");
	ExcelXlsx.getData("c3");
	ExcelXlsx.getData("z77");
	ExcelXlsx.getData("d2");
	ExcelXlsx.getData("d5");
	ExcelXlsx.getData("z13");
	ExcelXlsx.getData("z77");
	
	ExcelXlsx.getData(12,27);
//	ExcelXlsx.setData(2,3,"Test  counts&save   2      ");
	
	
	
	
	
	
	
	ExcelXlsx.closeExcel();
	
	
}
}
