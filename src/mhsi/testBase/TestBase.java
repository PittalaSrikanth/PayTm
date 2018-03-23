package mhsi.testBase;


import java.io.IOException;
import java.util.List;

import mhsi.ExcelReader.ExcelXlsx;
import mhsi.actions.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class TestBase extends Action {

	
	public static void BrowserLanch() throws IOException {
		ExcelXlsx.Connection("Configaration.xlsx", "Configaration");
		System.out.println(("Selected browser :"+ ExcelXlsx.getData("b1")));
		selectBrowser(ExcelXlsx.getData("b1"));
		implicitWait(30);
		navigate(ExcelXlsx.getData("url"));
	}

	public static WebElement getLocator(String keyWordType,
			String keyWordtValue) throws Exception {

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
			throw new Exception("Unknown element loacatorType"
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
			throw new Exception("Unknown element loacatorType"
					+ keyWordValue);
	}

	
	
	public static void selectDropDown(String keywordType, String keywordvalue,String value) throws Exception {
	
		try {
			Select s = new Select(getLocator(keywordType, keywordvalue));
			s.selectByValue(value);
		} catch (Exception e) {
			if(e.getMessage().equals("NoSuchElementException")){
				System.out.println("Faild to find element :"+ keywordvalue);	
			}else if (e.getMessage().equals("Timeout"))
				
				{
				System.out.println("Timeout to find element"+ keywordvalue);	
				}
			}
		}

	public static void selectDropDown(String keywordType, String keywordvalue, int index) throws Exception {
		
		try {
			Select s = new Select(getLocator(keywordType, keywordvalue));
			s.selectByIndex(index);
		} catch (Exception e) {
			if(e.getMessage().equals("NoSuchElementException")){
				System.out.println("Faild to find element :"+ keywordvalue);	
			}else if (e.getMessage().equals("Timeout"))
				
				{
				System.out.println("Timeout to find element"+ keywordvalue);	
				}
			}
		}

	public static void actionDropDown(String keywordType, String keywordvalue, String text) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
			a.sendKeys(text).build().perform();
			a.sendKeys(Keys.ENTER).build().perform();
		}catch (Exception e) {
			if(e.getMessage().equals("NoSuchElementException")){
				System.out.println("Faild to find element :"+ keywordvalue);	
			}else if (e.getMessage().equals("Timeout"))
				
				{
				System.out.println("Timeout to find element"+ keywordvalue);	
				}
			}
		}
	public static void actionClick(String keywordType, String keywordvalue) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
		} catch (Exception e) {
			if(e.getMessage().equals("NoSuchElementException")){
				System.out.println("Faild to find element : :"+ keywordvalue);	
			}else if (e.getMessage().equals("Timeout"))
				
				{
				System.out.println("Timeout to find element"+ keywordvalue);	
				}
			}
		}
	public static void actionSendKeys(String keywordType, String keywordvalue, String data) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
			a.sendKeys(data).build().perform();
		} catch (Exception e) {
			if(e.getMessage().equals("NoSuchElementException")){
				System.out.println("Faild to find element :"+ keywordvalue);	
			}else if (e.getMessage().equals("Timeout"))
				
				{
				System.out.println("Timeout to find element"+ keywordvalue);	
				}
			}
		}

	public static void javaScriptClick(String keywordType, String keywordvalue) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("Arguments[0].click();", getLocator(keywordType, keywordvalue));
		} catch (Exception e) {
			if(e.getMessage().equals("NoSuchElementException")){
				System.out.println("Faild to find element :"+ keywordvalue);	
			}else if (e.getMessage().equals("Timeout"))
				
				{
				System.out.println("Timeout to find element"+ keywordvalue);	
				}
			}
		}
public static void click(String keywordType, String keywordvalue) throws Exception {
		
		try {
			getLocator(keywordType, keywordvalue).click();
		}catch (Exception e) {
			if(e.getMessage().equals("NoSuchElementException")){
				System.out.println("Faild to find element :"+ keywordvalue);	
			}else if (e.getMessage().equals("Timeout"))
				
				{
				System.out.println("Timeout to find element"+ keywordvalue);	
				}
			}
		}
		public static void checkbox(String keywordType, String keywordvalue) throws Exception {
			
			try {
				getLocator(keywordType, keywordvalue).click();
			}catch (Exception e) {
				if(e.getMessage().equals("NoSuchElementException")){
					System.out.println("Faild to find element :"+ keywordvalue);	
				}else if (e.getMessage().equals("Timeout"))
					
					{
					System.out.println("Timeout to find element"+ keywordvalue);	
					}
				}
			}	
			public static void link(String keywordType, String keywordvalue) throws Exception  {
				
				try {
					getLocator(keywordType, keywordvalue).click();
				} catch (Exception e) {
					if(e.getMessage().equals("NoSuchElementException")){
						System.out.println("Faild to find element :"+ keywordvalue);	
					}else if (e.getMessage().equals("Timeout"))
						
						{
						System.out.println("Timeout to find element"+ keywordvalue);	
						}
					}
				}
			
			
				public static void textbox(String keywordType, String keywordvalue, String value) throws Exception {
					
					try {
						getLocator(keywordType, keywordvalue).sendKeys(value);
					} catch (Exception e) {
						if(e.getMessage().equals("NoSuchElementException")){
							System.out.println("Faild to find element :"+ keywordvalue);	
						}else if (e.getMessage().equals("Timeout"))
							
							{
							System.out.println("Timeout to find element"+ keywordvalue);	
							}
						}
					}
					public static void toggle(String keywordType, String keywordvalue) throws Exception  {
						
						try {
							getLocator(keywordType, keywordvalue).click();
						}
						catch (Exception e) {
							if(e.getMessage().equals("NoSuchElementException")){
								System.out.println("Faild to find element :"+ keywordvalue);	
							}else if (e.getMessage().equals("Timeout"))
								
								{
								System.out.println("Timeout to find element"+ keywordvalue);	
								}
							}
						}
					
		
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

