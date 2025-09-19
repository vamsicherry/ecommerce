package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actiondriver.Act;
import com.basePage.baseclass;
import com.pageObjects.HomePage;
import com.pageObjects.IndexPage;
import com.pageObjects.LoginPage;
import com.utility.DataProviders;

public class LoginPageTest extends baseclass {
	LoginPage p ;
	IndexPage index;
	HomePage home;
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
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void loginPage(String uname,String pass)
	{
		log.info("user is at index page");
		 index = new IndexPage();
		 
		 index.clickSignIn();
		 log.info("user click on sign page");
		 p = new LoginPage();
		 log.info(" user is in home page");
		 //home= p.signupemailacc(prop.getProperty("username"), prop.getProperty("password"));
		 home= p.signupemailacc(uname,pass);
         log.info("getting the current url");
		 String url=home.getHomePageurl();
		 Act.implicitwait(getDriver(), 10);
		 String expected ="http://www.automationpractice.pl/index.php?controller=my-account";
		 Assert.assertEquals(url, expected);
		 log.info("verified url");
		 boolean s=home.accountExists();
		 Assert.assertTrue(s);
		 
		 
		 boolean order=home.orderHistoryExists();
		 Assert.assertTrue(order);
		 
		 home.signOutPage();
		 log.info("user signed out");
		 String hurl=home.getHomePageurl();
		 Act.implicitwait(getDriver(), 10);
		 Assert.assertEquals(hurl, "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		 log.info("finally completed test");
	}
}
