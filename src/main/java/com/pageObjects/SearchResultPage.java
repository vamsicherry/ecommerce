package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Act;
import com.basePage.baseclass;

public class SearchResultPage extends baseclass{

	
	
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement  shorttshirt;
	
	
	public boolean isProductAvailabe()
	{
		return Act.isDisplayed(getDriver(), shorttshirt);
	}
	
	public AddToCart clickOnProduct()
	{
		Act.click(getDriver(), shorttshirt);
		return new AddToCart();
	}
	
}



