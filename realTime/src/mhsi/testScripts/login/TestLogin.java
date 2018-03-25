package mhsi.testScripts.login;

import java.io.IOException;

import mhsi.ExcelReader.ExcelXls;
import mhsi.ExcelReader.ExcelXlsTest;
import mhsi.ExcelReader.ExcelXlsx;
import mhsi.customeListner.Listner1;
import mhsi.testBase.Action;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestLogin extends Listner1 {

	@BeforeTest
	public void setUp() throws IOException {
		Action.BrowserLanch();
		Action.implicitWait(30);
	}

	@Test
	public void applanch() throws Exception {
		ExcelXlsx.Connection("Login1.xlsx", "LoginPage_LoginTab");

		Action.button(ExcelXlsx.getData("e2"), ExcelXlsx.getData("f2"));
		Action.implicitWait(30);
		Action.textbox(ExcelXlsx.getData("e3"), ExcelXlsx.getData("f3"),
				ExcelXlsx.getData("g3"));
		Action.button(ExcelXlsx.getData("e4"), ExcelXlsx.getData("f4"));
		Action.implicitWait(30);
		/*Action.link(ExcelXlsx.getData("e5"),ExcelXlsx.getData("f5"));
		Action.textbox(ExcelXlsx.getData("e5"),ExcelXlsx.getData("f5"),
				ExcelXlsx.ExcelXlsx.getData("g5"));*/
		Action.button(ExcelXlsx.getData("e6"), ExcelXlsx.getData("f6"));
		Action.button(ExcelXlsx.getData("e6"), ExcelXlsx.getData("f6"));
		Action.button(ExcelXlsx.getData("e6"), ExcelXlsx.getData("f6"));
		Action.button(ExcelXlsx.getData("e6"), ExcelXlsx.getData("f6"));
		Action.implicitWait(30);
		ExcelXlsx.closeExcel();
	}

	@AfterTest
	public void clsApp() {
		Action.closeBrowser();
	}
}
