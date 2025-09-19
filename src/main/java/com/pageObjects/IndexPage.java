package com.pageObjects;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Act;
import com.basePage.baseclass;

public class IndexPage extends baseclass {
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//img[@class ='logo img-responsive']")
	WebElement  signInLogo;
	
	@FindBy(id="search_query_top")
	WebElement  enterProductName;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement  searchProduct;
	
	
	public LoginPage clickSignIn() 
	{
			
		   Act.explicitwait(getDriver(), signIn, 10);
		   Act.click(getDriver(), signIn);
		   return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		  return Act.isDisplayed(getDriver(),signInLogo);
	}
	
	public String myStoreTitle()
	{
		  String title=getDriver().getTitle();
		  return title;
	}
	
	public SearchResultPage searchProduct(String prodname)
	{
		Act.send(enterProductName, prodname);
		Act.click(getDriver(), searchProduct);
		return new SearchResultPage();
	}
	
	
	
}
