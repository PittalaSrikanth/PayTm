package companyName.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import companyName.actions.Action;


public class TestBase extends Action{
	

	public static Properties rep = new Properties();
	public static File F;
	public static FileInputStream fis;
	
	
	    public static void loadProperitces() throws IOException{
		F = new File(System.getProperty("user.dir")+"\\src\\companyName\\config\\config.properties");
		fis = new FileInputStream(F);
		rep.load(fis);
		
		F =new File(System.getProperty("user.dir")+"\\src\\companyName\\pageLocators\\loginpage.properties");
		fis = new FileInputStream(F);
		rep.load(fis);
	    }
		
		public static void BrowserLanch() throws IOException{
			loadProperitces();
			Reporter.log("Selected browser :" + rep.getProperty("browsre"));
			selectBrowser(rep.getProperty("browsre"));
			implicitWait(30);
			navigate(rep.getProperty("url"));
		}
		
		public static WebElement getLocator(String locator) throws Exception{
			String[] a = locator.split("_");
			String locatorType = a[0];
			String locatorValue = a[1];
			
			if(locatorType.toLowerCase().equals("id")){
				return driver.findElement(By.id(locatorValue));
			}
			else if (locatorType.toLowerCase().equals("name")){
				return driver.findElement(By.name(locatorValue));
			}
			else if (locatorType.toLowerCase().equals("classname") ||
					locatorType.toLowerCase().equals("class")){
				return driver.findElement(By.className(locatorValue));
			}
			else if (locatorType.toLowerCase().equals("tagname") ||
					locatorType.toLowerCase().equals("tag")){
				return driver.findElement(By.tagName(locatorValue));
			}
			else if (locatorType.toLowerCase().equals("cssselector")||
					locatorType.toLowerCase().equals("css")){
				return driver.findElement(By.cssSelector(locatorValue));
			}
			else if (locatorType.toLowerCase().equals("linktext") ||
					locatorType.toLowerCase().equals("link")){
				return driver.findElement(By.linkText(locatorValue));
			}
			else if (locatorType.toLowerCase().equals("partiallinktext")){
				return driver.findElement(By.partialLinkText(locatorValue));
			}
			else if (locatorType.toLowerCase().equals("xpath")){
				return driver.findElement(By.xpath(locatorValue));
			}
			else throw new Exception("Unknown element loacatorType"+locatorType);
		}
			
			public static List<WebElement> getLocators(String locator) throws Exception{
				String[] a = locator.split("_");
				String locatorType = a[0];
				String locatorValue = a[1];
				
				if(locatorType.toLowerCase().equals("id")){
					return driver.findElements(By.id(locatorValue));
				}
				else if (locatorType.toLowerCase().equals("name")){
					return driver.findElements(By.name(locatorValue));
				}
				else if (locatorType.toLowerCase().equals("classname") ||
						locatorType.toLowerCase().equals("class")){
					return driver.findElements(By.className(locatorValue));
				}
				else if (locatorType.toLowerCase().equals("tagname") ||
						locatorType.toLowerCase().equals("tag")){
					return driver.findElements(By.tagName(locatorValue));
				}
				else if (locatorType.toLowerCase().equals("cssselector")||
						locatorType.toLowerCase().equals("css")){
					return driver.findElements(By.cssSelector(locatorValue));
				}
				else if (locatorType.toLowerCase().equals("linktext") ||
						locatorType.toLowerCase().equals("link")){
					return driver.findElements(By.linkText(locatorValue));
				}
				else if (locatorType.toLowerCase().equals("partiallinktext")){
					return driver.findElements(By.partialLinkText(locatorValue));
				}
				else if (locatorType.toLowerCase().equals("xpath")){
					return driver.findElements(By.xpath(locatorValue));
				}
				else throw new Exception("Unknown element loacatorType"+locatorType);
		}
		
public static WebElement getElement(String locator) throws Exception{
	return getLocator(rep.getProperty(locator));
}
public static List<WebElement> getElements(String locator) throws Exception{
	return getLocators(rep.getProperty(locator));
}	
		/*
		public static WebElement getelement(String locatorType, String locatorValue){
			switch(locatorType)
			{
				case "id":
					return driver.findElement(By.id(locatorValue));
				case "classname":
					return driver.findElement(By.className(locatorValue));
				case "tagname":
					return driver.findElement(By.tagName(locatorValue));
				case "linktext":
					return driver.findElement(By.linkText(locatorValue));
				case "partialLinkText":
					return driver.findElement(By.partialLinkText(locatorValue));
				case "xpath":
					return driver.findElement(By.xpath(locatorValue));
				case "name":
					return driver.findElement(By.name(locatorValue));
				case "cssSelector":
					return driver.findElement(By.cssSelector(locatorValue));
			}
					return driver.findElement(By.id(locatorValue));
			}
			
			
		public static List<WebElement> getelements(String locatorType, String locatorValue){
			switch(locatorType)
			{
				case "id":
					return driver.findElements(By.id(locatorValue));
				case "classname":
					return driver.findElements(By.className(locatorValue));
				case "tagname":
					return driver.findElements(By.tagName(locatorValue));
				case "linktext":
					return driver.findElements(By.linkText(locatorValue));
				case "partialLinkText":
					return driver.findElements(By.partialLinkText(locatorValue));
				case "xpath":
					return driver.findElements(By.xpath(locatorValue));
				case "name":
					return driver.findElements(By.name(locatorValue));
				case "cssSelector":
					return driver.findElements(By.cssSelector(locatorValue));
			}
					return driver.findElements(By.id(locatorValue));
			}
			*/
			
			
			
			
			
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
