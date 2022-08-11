/**
 * 
 */
package com.testVagrant.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testVagrant.pageLayer.IMDbPage;
import com.testVagrant.pageLayer.WikipediaPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author SUJIT
 *
 */
public class TestBase {
	
	public static WebDriver driver;
	
	public WikipediaPage wikiPage;
	public IMDbPage imdbPage;
	
	@BeforeMethod
	public void setUp() {
		
		String browser ="chrome";
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		else
		{
			System.out.println("Please enter correct browser name.");
		}
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//code to handle popup iframe
		WebElement signIn_iframe = driver.findElement(By.name("callout"));
		driver.switchTo().frame(signIn_iframe);
		driver.findElement(By.xpath("//button[contains(@class,\"M6CB1c rr4y5c\")]")).click();  //click on No Thanks button
		driver.switchTo().parentFrame();
		
		//Google Search movie
		driver.findElement(By.name("q")).sendKeys("Pushpa: The Rise");
		driver.findElement(By.xpath("//input[@name=\"btnK\"]")).click();
		
		
		
		//objects of different pages
		wikiPage = new WikipediaPage();
		imdbPage = new IMDbPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
