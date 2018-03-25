package mhsi.testBase;

import java.io.IOException;

import java.util.List;
import java.util.Set;

import mhsi.ExcelReader.ExcelXlsx;
import mhsi.actions.TestBase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


public class Action extends TestBase {
static Alert alert = driver.switchTo().alert();
	
	static String alertTitle = alert.getText();
	static Set<String> NoOFWindows = driver.getWindowHandles();

	public static void BrowserLanch() throws IOException {
		ExcelXlsx.Connection("Configaration.xlsx", "Configaration");
		System.out.println(("Selected browser : " + ExcelXlsx.getData("B1")
				.toUpperCase()));
		selectBrowser(ExcelXlsx.getData("b1"));
		implicitWait(30);
		navigate(ExcelXlsx.getData("b2"));
		ExcelXlsx.closeExcel();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static WebElement getLocator(String keyWordType, String keyWordtValue)
			throws Exception {

		if (keyWordType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(keyWordtValue));

		} else if (keyWordType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("class")) {
			return driver.findElement(By.className(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("tag")) {
			return driver.findElement(By.tagName(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("link")) {
			return driver.findElement(By.linkText(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("partiallink")) {
			return driver.findElement(By.partialLinkText(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(keyWordtValue));
		} else
			throw new Exception("Unknown element loacatorType  : "
					+ keyWordtValue);

	}

	public static List<WebElement> getLocators(String keyWordType,
			String keyWordValue) throws Exception {

		if (keyWordType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("class")) {
			return driver.findElements(By.className(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("tag")) {
			return driver.findElements(By.tagName(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("link")) {
			return driver.findElements(By.linkText(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("partiallink")) {
			return driver.findElements(By.partialLinkText(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(keyWordValue));
		} else
			throw new Exception("Unknown element loacatorType  :"
					+ keyWordValue);

	}

	public static void selectDropDown(String keywordType, String keywordvalue,
			String value) throws Exception {

		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			Select s = new Select(getLocator(keywordType, keywordvalue));
			s.selectByValue(value);
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}
	}

	public static void selectDropDown(String keywordType, String keywordvalue,
			int index) throws Exception {

		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			Select s = new Select(getLocator(keywordType, keywordvalue));
			s.selectByIndex(index);
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}

	public static void actionDropDown(String keywordType, String keywordvalue,
			String text) throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
			a.sendKeys(text).build().perform();
			a.sendKeys(Keys.ENTER).build().perform();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}

	public static void actionClick(String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}
	}

	public static void actionSendKeys(String keywordType, String keywordvalue,
			String data) throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
			a.sendKeys(data).build().perform();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}
	}

	public static void javaScriptClick(String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("Arguments[0].click();",
					getLocator(keywordType, keywordvalue));
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}

	public static void click(String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			getLocator(keywordType, keywordvalue).click();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}

	public static void checkbox(String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			getLocator(keywordType, keywordvalue).click();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}

	public static void button(String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			getLocator(keywordType, keywordvalue).click();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}

	public static void link(String keywordType, String keywordvalue)
			throws Exception {

		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			getLocator(keywordType, keywordvalue).click();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}

	public static void textbox(String keywordType, String keywordvalue,
			String value) throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			getLocator(keywordType, keywordvalue).sendKeys(value);
		} else {
			System.out.println("Unable to locate the element  : " + keywordType
					+ " : " + keywordvalue);
		}

	}

	public static void toggle(String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			getLocator(keywordType, keywordvalue).click();
		} else {

			System.out.println(" Unable to locate the element   " + " : "
					+ keywordvalue + "   :   " + keywordType);
		}

	}
	public static void alertBoxAccept()
	{
		
		System.out.println("Alert appeared with the title is:"  + alertTitle);
		
		alert.accept();
		System.out.println("Alert Accepted");
		Reporter.log("Alert Accepted");
		
		
			
	}
	
	public static void alertBoxDismiss()
	{
		System.out.println("Alert appeared with the title is:"  + alertTitle);
		
		alert.dismiss();
		System.out.println("Alert Dismissed");
		Reporter.log("Alert Dismissed");
	}
	
	public static  void alertEnteringText(String inputText)
	{
		System.out.println("Alert appeared with the title is:"  + alertTitle);
		alert.sendKeys(inputText);
		System.out.println("Entered the text in the Prompt Popup");
		Reporter.log("Entered the text in the Prompt Popup");
		alert.accept();
	}
	public static void closeAllChildWindows(String ParentTitle) {
		for (String EachWindow : NoOFWindows) {

			if (!EachWindow.equals(ParentTitle)) {
				driver.switchTo().window(EachWindow).close();
			}

		}
		driver.switchTo().window(ParentTitle);
		System.out.println("Closed all child windows");
	}

	public static void closeAllWindowsExceptParentAndChild(String ParentTitle, String ChildTitle) {
		for (String EachWindow : NoOFWindows) {

			if (!EachWindow.equals(ParentTitle)) {

				if (EachWindow.equals(ChildTitle)) {
					continue;
				}
				driver.switchTo().window(EachWindow).close();
			}

		}
		driver.switchTo().window(ChildTitle);
		System.out.println("Closed all windows except Parent and Child");
	}

	public static void navigateToParentWindow(String ParentTitle) {
		driver.switchTo().window(ParentTitle);
		System.out.println("Navigated to parentWindow : "+ ParentTitle );

	}

	public static void navigateToChildWindow(String ChildTitle) {
		driver.switchTo().window(ChildTitle);
		System.out.println("Navigated to childWindow : "+ ChildTitle);
	}

}
