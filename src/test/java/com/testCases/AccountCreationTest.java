package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.basePage.baseclass;
import com.pageObjects.AccountCreatingPage;
import com.pageObjects.IndexPage;
import com.pageObjects.LoginPage;

public class AccountCreationTest extends baseclass {
	LoginPage page;
	IndexPage ind;
	AccountCreatingPage accpage;
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
	
	public void  AccountCreationPage()
	{
		ind= new IndexPage(); 
		ind.clickSignIn();
		page= new LoginPage();
		page.createNewAccount(prop.getProperty("username1"));
		
		accpage=new AccountCreatingPage();
		String m=accpage.AccountexistsOrNot();
		System.out.println(m);
		 Assert.assertEquals(m, "CREATE AN ACCOUNT");
	}

}
