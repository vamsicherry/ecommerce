package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Act;
import com.basePage.baseclass;

public class AddToCart extends baseclass {

	
	public AddToCart()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(name="group_1")
	WebElement selectsize;
	
	@FindBy(css="#availability_value")
	WebElement productavailable;
	public void selectSize(String m)
	{
		Act.selectByValue(selectsize, m);
	}
	
	public String productAvaibale()
	{
		String prod=productavailable.getText();
		
		return prod;
	}
	
}
