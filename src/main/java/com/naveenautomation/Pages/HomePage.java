package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountDropDown;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(css = "ul.dropdown-menu.dropdown-menu-right li:last-of-type a")
	WebElement loginLink;

	public void openDropDown() {
		myAccountDropDown.click();
	}

	public RegisterAccountPage clickRegisterLink() {
		openDropDown();
		registerLink.click();
		return new RegisterAccountPage();
	}
	public AccountLoginPage clickLoginLink() {
		openDropDown();
		loginLink.click();
		return new AccountLoginPage();
	}
	
}
