package mhsi.testScripts.login;

import java.io.IOException;

import mhsi.ExcelReader.ExcelXlsx;
import mhsi.testBase.Action;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(mhsi.customeListner.Listner1.class)	
public class TestLogin extends ExcelXlsx {

	@BeforeTest
	public void setUp() throws IOException {
	//	Action.ExecutionStarts();
		Action.BrowserLanch();
		Action.implicitWait(30);
	}

	@Test
	public void applanch() throws Exception {
		Connection("Login1.xlsx", "LoginPage_LoginTab");

		Action.button(getData("e2"), getData("f2"));
		Action.implicitWait(30);
		Action.textbox(getData("e3"), getData("f3"),
				getData("g3"));
		Action.button(getData("e4"), getData("f4"));
		Action.implicitWait(30);
		Action.link(getData("e5"),getData("f5"));
		Action.textbox(getData("e5"),getData("f5"),
				getData("g5"));
		Action.button(getData("e6"), getData("f6"));
		Action.button(getData("e6"), getData("f6"));
		Action.button(getData("e6"), getData("f6"));
		Action.button(getData("e6"), getData("f6"));
		Action.implicitWait(30);
		closeExcel();
	}

	@AfterTest
	public void clsApp() {
	//	Action.ExecutionEnd();
		Action.closeBrowser();
	}
}
