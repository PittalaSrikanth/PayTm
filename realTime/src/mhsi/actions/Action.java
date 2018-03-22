package mhsi.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Action {
	public static WebDriver driver;

	public static WebDriver selectBrowser(String browser) {
		Reporter.log("Selected Browser is : " + browser);

		if (browser.toLowerCase().equals("chrome")) {
			System.setProperty(
					"webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\src\\companyName\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log(browser + ":Browser opend successfully");
			driver.manage().window().maximize();
			Reporter.log("Maximized " + browser + ":Browser");
			return driver;
		} else if (browser.toLowerCase().equals("firefox")) {
			driver = new FirefoxDriver();
			Reporter.log(browser + ":Browser opend successfully");
			driver.manage().window().maximize();
			Reporter.log("Maximized " + browser + ":Browser");
			return driver;
		} else if (browser.toLowerCase().equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\src\\companyName\\BrowserDrivers\\ie.exe");
			driver = new InternetExplorerDriver();
			Reporter.log(browser + ":Browser opend successfully");
			driver.manage().window().maximize();
			Reporter.log("Maximized " + browser + ":Browser");
			return driver;
		}
		return driver;

	}

	public static String getPageTittle() {
		return driver.getTitle();

	}

	public static void implicitWait(int sec) {
		Reporter.log("implicitWait for" + getPageTittle() + " page loading:"
				+ sec);
		try {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
			Reporter.log(getPageTittle() + "page loaded compleatly");
		} catch (Throwable error) {
			Reporter.log("Timeout for" + getPageTittle() + "page load in" + sec);
		}
	}

	public static void explecitWati(WebElement element, int sec) {
		try {
			Reporter.log("explecitWati for" + getPageTittle()
					+ " page loading:" + sec);
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log(getPageTittle() + "page loaded compleatly");
		} catch (Throwable error) {
			Reporter.log("Timeout for" + getPageTittle() + "page load in" + sec);
		}
	}

	public static void mandatoryWait(int sec) throws InterruptedException {
		try {
			Reporter.log("mandatoryWait for" + getPageTittle()
					+ " page loading:" + sec);
			Thread.sleep(sec * 1000);
			Reporter.log(getPageTittle() + "page loaded compleatly");
		} catch (Throwable error) {
			Reporter.log("Timeout for" + getPageTittle() + "page load in" + sec);
		}
	}

	
	public static String displayDateTime() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		return s.format(d);
	}

	public static void ExecutionStarts() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		Reporter.log("Execution Started at" + s.format(d));
		// return s.format(d);
	}

	public static void ExecutionEnd() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		Reporter.log("Execution Ends at" + s.format(d));
		// return s.format(d);
	}

	public static WebDriver navigate(String url) {
		driver.navigate().to(url);
		return driver;
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}
}
