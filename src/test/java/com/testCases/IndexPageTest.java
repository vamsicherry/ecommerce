package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.basePage.baseclass;
import com.pageObjects.IndexPage;

public class IndexPageTest extends baseclass {
	IndexPage page;
	 @Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		getBrowser(browser);
	}
	
	 @AfterMethod
		public void tearDown()
		
		{
			getDriver().quit();
			unloadDriver();
		}
	
	
	@Test
	public void validateLogo()
	{
		page= new IndexPage();
		boolean log=page.validateLogo();
		Assert.assertTrue(log);
	}
	
	@Test
	public void validateTitle()
	{
		String title= page.myStoreTitle();
		
		Assert.assertEquals(title, "My Shop");
	}
	
	
	
}
