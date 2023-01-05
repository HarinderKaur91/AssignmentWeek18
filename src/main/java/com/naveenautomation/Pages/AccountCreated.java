package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AccountCreated extends TestBase {

	public AccountCreated() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement accountCreationSuccessTxt;
	
	@FindBy(css = "div.buttons a")
	WebElement continueBtn;

	public String getSuccessAccountCreatedText() {
		return accountCreationSuccessTxt.getText();
	}

	public AccountLoginPage clickContinueButton() {
		continueBtn.click();
		return new AccountLoginPage();	
		
	}
}
