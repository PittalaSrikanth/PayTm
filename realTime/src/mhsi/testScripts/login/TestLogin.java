package mhsi.testScripts.login;

import java.io.IOException;

import mhsi.ExcelReader.ExcelXlsx;
import mhsi.Actions.Action;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(mhsi.CustomeListner.Listner1.class)	
public class TestLogin extends ExcelXlsx {

	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
	//	Action.ExecutionStarts();
		Action.BrowserLanch();
		Action.mandatoryWait(3);
	}

	@Test
	public void applanch() throws Exception {
		Connection("Login1.xlsx", "LoginPage_LoginTab");
		Action.implicitWaitForElement(getData("d2"),30);
		Action.button(getData("d2"),getData("e2"), getData("f2"));
		Action.implicitWaitForElement(getData("d3"),30);
		Action.textbox(getData("d3"),getData("e3"), getData("f3"),
				getData("g3"));
		Action.implicitWaitForElement(getData("d4"),30);
		Action.button(getData("d4"),getData("e4"), getData("f4"));
		Action.implicitWaitForElement(getData("d5"),30);
		Action.textbox(getData("d5"),getData("e5"),getData("f5"),
				getData("g5"));
		Action.implicitWaitForElement(getData("d6"),30);
		Action.button(getData("d6"),getData("e6"), getData("f6"));
	
		closeExcel();
	}

	@AfterTest
	public void clsApp() {
	//	Action.ExecutionEnd();
		Action.closeBrowser();
	}
}
