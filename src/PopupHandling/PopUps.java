package PopupHandling;

import org.openqa.selenium.Alert;
import org.testng.Reporter;

import mhsi.actions.*;

public class PopUps extends Action {

	static Alert alert = driver.switchTo().alert();
	
	static String alertTitle = alert.getText();
	
	public static void alertBoxAccept()
	{
		//String alertTitle = driver.switchTo().alert().getText();
		
		System.out.println("Alert appeared with the title is:"  + alertTitle);
		
		alert.accept();
		Reporter.log("Alert Accepted");
		
		
			
	}
	
	public static void alertBoxDismiss()
	{
		System.out.println("Alert appeared with the title is:"  + alertTitle);
		
		alert.dismiss();
		Reporter.log("Alert Dismissed");
	}
	
	public static  void alertEnteringText(String inputText)
	{
		System.out.println("Alert appeared with the title is:"  + alertTitle);
		alert.sendKeys(inputText);
		Reporter.log("Entered the text in the Prompt Popup");
		alert.accept();
	}
	
}
