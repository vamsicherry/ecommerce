package com.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
		protected static Properties prop;
		private static ThreadLocal<WebDriver>driver = new ThreadLocal<>();
		public static final Logger log = LogManager.getLogger(baseclass.class);

		public static void unloadDriver() {
		    driver.remove(); // ✅ safely removes thread-local instance
		}

		public static WebDriver getDriver()
		{
			 return driver.get();
		}
//		@BeforeSuite
//		public void logg()
//		{
//		  log =LogManager.getLogger(this.getClass());
//		}
		@BeforeTest
		public void configFile()
		{
			try
			{
				prop = new Properties();
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
				prop.load(file);                           //System.getProperty("user.dir") + "\\Configuration\\config.properties");
			}catch(IOException e)
			{
			   e.printStackTrace();
			}
			
			
		}
	   
		public void getBrowser(String browser)
		{
			//String browser =prop.getProperty("browser");
			 if(browser.equalsIgnoreCase("chrome"))
			 {
				 driver.set(new ChromeDriver());
			 }else if(browser.equalsIgnoreCase("firefox"))
			 {
				 driver.set(new FirefoxDriver());
			 }else if(browser.equalsIgnoreCase("edge"))
			 {
				 WebDriverManager.edgedriver().setup();
				 driver.set(new EdgeDriver());
			 }else
			 {
				 throw  new IllegalArgumentException("un supported browser"+ browser); 
			 }
			 
			 
			 getDriver().manage().window().maximize();
			 
			 getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 
			 getDriver().manage().deleteAllCookies();
			 
			 getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(40));
			 getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			 
			 getDriver().get(prop.getProperty("url"));
		}
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}
		
	   
		
}
