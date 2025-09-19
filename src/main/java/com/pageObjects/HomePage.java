package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Act;
import com.basePage.baseclass;

public class HomePage extends baseclass {

	public HomePage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	
	
	@FindBy(xpath="//h1[text()='My account']")
	WebElement myaccountexists;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderhistory;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement signout;
	public boolean accountExists()
	{
		 return Act.isDisplayed(getDriver(), myaccountexists);
	}
	
	public boolean orderHistoryExists()
	{
		 return Act.isDisplayed(getDriver(), orderhistory);
	}
	
	public String getHomePageurl()
	{
		String homepageurl=getDriver().getCurrentUrl();
		return homepageurl;
	}
	
	public void signOutPage()
	{
		Act.explicitwait(getDriver(), signout, 10);
		Act.click(getDriver(), signout);
	}
}
