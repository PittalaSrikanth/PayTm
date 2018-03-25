package mhsi.customeListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mhsi.actions.TestBase;
import mhsi.testBase.Action;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class Listner1 extends TestBase implements ITestListener {

	@Override
	public void onStart(ITestContext Result) {
		Reporter.log("Execution Started at : " + Result.getStartDate());
		System.out.println("Execution Started at : " + Result.getStartDate());
		Reporter.log(Result.getName() + ": TestCase started at : "
				+ Action.currentTime() + " Seconds");
		System.out.println(Result.getName() + ": TestCase started at : "
				+ Action.currentTime() + " Seconds");

	}

	@Override
	public void onTestStart(ITestResult Result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	@Override
	public void onTestFailure(ITestResult Result) {
		System.out.println(Result.getMethod().getMethodName() + " Method"
				+ "-> Failed In -> " + Result.getTestClass());

		System.out.println(Result.getTestClass() + " Failed at : "
				+ Action.currentTime() + " Seconds");

		if (!Result.isSuccess()) {
			String userDirector = System.getProperty("user.dir");
			String customLocator = "\\src\\mhsi\\screenShot\\";
			String failureImageFileName = userDirector
					+ customLocator
					+ new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss")
							.format(new Date()) + "_"
					+ Result.getMethod().getMethodName() + "_Method" + ".png";
			File capture = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(capture, new File(failureImageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Reporter.log("<a href=\"" + failureImageFileName
					+ "\"><img src=\"file:///" + failureImageFileName
					+ "\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
			Reporter.setCurrentTestResult(null);
		}
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println(Result.getTestClass() + " Skipped at: "
				+ Action.currentTime() + " Seconds");

	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println(Result.getTestClass() + " Success at : "
				+ Action.currentTime());
	}

	@Override
	public void onFinish(ITestContext Result) {

		System.out.println(Result.getName() + " TestCase Ended");
		System.out.println("Execution Finished at : " + Result.getEndDate());

	}

}