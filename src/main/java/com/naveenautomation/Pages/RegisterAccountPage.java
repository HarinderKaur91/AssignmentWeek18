package com.naveenautomation.Pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class RegisterAccountPage extends TestBase {

	public RegisterAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement fName;

	@FindBy(id = "input-lastname")
	WebElement lName;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement telephone;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement confirmPassword;

	@FindBy(css = "label.radio-inline input[value='1']")
	WebElement subscribeRadioBtn;

	@FindBy(css = "input[name='agree']")
	WebElement privacyPolicyCheckBox;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	private void enterFirstName(String fname) {
		fName.sendKeys(fname);
	}

	private void enterLastName(String lname) {
		lName.sendKeys(lname);
	}

	private void enterEmail(String emailInput) {
		email.sendKeys(emailInput);
	}

	private void enterPhoneNumber(String phone) {
		telephone.sendKeys(phone);
	}

	private void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	private void enterConfirmPwd(String cPwd) {
		confirmPassword.sendKeys(cPwd);
	}

	private void clickPrivacyPolicy() {
		privacyPolicyCheckBox.click();
	}

	public AccountCreated signUp(String fname, String lname, String emailInput, String phone, String pwd, String cPwd) {
		enterFirstName(fname);
		enterLastName(lname);
		enterEmail(emailInput);
		enterPhoneNumber(phone);
		enterPassword(pwd);
		enterConfirmPwd(cPwd);
		subscribeRadioBtn.click();
		clickPrivacyPolicy();
		continueBtn.click();
		return new AccountCreated();
	}

	public String generateRandomEmail() {
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		String randomEmail= "harinder" + randomInt + "@gmail.com";
		return randomEmail;
	}

}
