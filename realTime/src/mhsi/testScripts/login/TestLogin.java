package mhsi.testScripts.login;

import java.io.IOException;

import mhsi.pageLibrary.LoginPage.LoginPage;
import mhsi.testBase.TestBase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestLogin extends TestBase {

	@BeforeTest
	public void setUp() throws IOException {
		BrowserLanch();
	}

	@Test
	public void applanch() throws Exception {
		new LoginPage().loginApplication();
		mandatoryWait(5);

	}

	@AfterTest
	public void clsApp() {
		closeBrowser();
	}
}
