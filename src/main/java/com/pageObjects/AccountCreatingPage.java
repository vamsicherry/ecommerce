package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Act;
import com.basePage.baseclass;

public class AccountCreatingPage extends baseclass {

	public AccountCreatingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement   createaccexists;
	
	
	public String AccountexistsOrNot()
	{
		  Act.explicitwait(getDriver(), createaccexists, 10);
		  //Create an account
		  String text=createaccexists.getText();
		  return text;
	}
	
}
