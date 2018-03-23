package mhsi.customeListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mhsi.actions.Action;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;



public class Listner extends Action implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
	
		Action.ExecutionEnd();
		
	}

	@Override
	public void onStart(ITestContext result) {
		
		Action.ExecutionStarts();
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
         if(!result.isSuccess()){
        	 String userDirector = System.getProperty("user.dir");
        	 String customLocator = "\\src\\companyName\\screenShot\\";
        	 String failureImageFileName = userDirector+customLocator+new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date())+"-"+result.getMethod().getMethodName()+".png";
        	 File capture = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	 try {
				Files.copy(capture, new File(failureImageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
        	 Reporter.log("<a href=\"" + failureImageFileName + "\"><img src=\"file:///" + failureImageFileName +"\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
        	   Reporter.setCurrentTestResult(null);
         }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		Action.ExecutionStarts();
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}
	
}