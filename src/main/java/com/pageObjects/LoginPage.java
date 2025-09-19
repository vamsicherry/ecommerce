package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Act;
import com.basePage.baseclass;

public class LoginPage extends baseclass {

	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css="#email")
	WebElement signUpEmail;
	
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement signUpPassword;
	
	
	@FindBy(css="#SubmitLogin")
	WebElement submitlogin;
	
	@FindBy(css="#email_create")
	WebElement  createEmailId;
	
	@FindBy(css="#SubmitCreate")
	WebElement createanaccount;
	
	
	
	public HomePage signupemailacc(String username,String pass)
	{
		Act.send(signUpEmail, username);
		Act.send(signUpPassword, pass);
		Act.click(getDriver(), submitlogin);
		return new HomePage();
		
		
	}
	
	public AccountCreatingPage createNewAccount(String newem)
	{
		Act.send(createEmailId, newem);
		Act.click(getDriver(), createanaccount);
		return new AccountCreatingPage();
	}
	
}
