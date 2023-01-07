package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Base.TestBase;

public class AddressBookPage extends TestBase {

	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-firstname")
	WebElement firstName;

	@FindBy(css = "#input-lastname")
	WebElement lastName;

	@FindBy(css = "#input-company")
	WebElement company;

	@FindBy(css = "#input-address-1")
	WebElement address1;

	@FindBy(css = "#input-address-2")
	WebElement address2;

	@FindBy(css = "#input-city")
	WebElement city;

	@FindBy(css = "#input-postcode")
	WebElement postCode;

	@FindBy(css = "#input-country")
	WebElement country;

	@FindBy(css = "#input-zone")
	WebElement state;

	@FindBy(css = "input[value='Continue']")
	WebElement continueButton;

	@FindBy(css = "div.alert-success")
	WebElement successAlertBanner;

	private void editFirstName(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);
	}

	private void editLastName(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
	}

	private void editCompany(String companyName) {
		company.clear();
		company.sendKeys(companyName);
	}

	private void editAddress1(String addressValue1) {
		address1.clear();
		address1.sendKeys(addressValue1);
	}

	private void editAddress2(String addressValue2) {
		address2.clear();
		address2.sendKeys(addressValue2);
	}

	private void editCity(String cityName) {
		city.clear();
		city.sendKeys(cityName);
	}

	private void editPostCode(String postalCode) {
		postCode.clear();
		postCode.sendKeys(postalCode);
	}

	private void editCountry(String countryName) {
		Select sc = new Select(country);
		sc.selectByVisibleText(countryName);
	}

	private void editState(String stateName) {
		Select sc = new Select(state);
		sc.selectByVisibleText(stateName);
	}

	private void clickContinueButton() {
		continueButton.submit();
	}

	public String getTextFromSuccessAlert() {
		return successAlertBanner.getText();
	}

	public WebElement getElementFromTheAddressTable(String postalCode) {
		
		List<WebElement> rowsInTable = driver.findElements(By.cssSelector("table.table.table-bordered.table-hover tr"));
		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));
			String addressText = cells.get(0).getText();
			
			String[] addressArray = addressText.split("[' '\n]");
			
			for (int j = 0; j < addressArray.length; j++) {
				//comparing each element of splitted string with postal code
				if (addressArray[j].equals(postalCode)) {
					return cells.get(1);
				}
			}
		}
		System.out.println("Postal code not found!!!");
		return null;
	}

	public enum EditAddressBook {
		FNAME("Fname"),
		LNAME("Lname"),
		COMPANY("Company"),
		ADDRESS1("Address1"),
		ADDRESS2("Address2"),
		CITY("City"),
		POSTAL("Postal"),
		COUNTRY("Country"),
		STATE("Stae");

		String inputField;

		private EditAddressBook(String inputFieldToEdit) {
			this.inputField = inputFieldToEdit;
		}
	}

	public void clickEditButtonInWebTable(String postalCode, By locator) {
		getElementFromTheAddressTable(postalCode).findElement(locator).click();
	}

	public void updateAddressBook2(EditAddressBook field, String value) {
		switch (field) {
		case FNAME:
			editFirstName(value);
			break;
		case LNAME:
			editLastName(value);
			break;
		case COMPANY:
			editCompany(value);
			break;
		case ADDRESS1:
			editAddress1(value);
			break;
		case ADDRESS2:
			editAddress2(value);
			break;
		case CITY:
			editCity(value);
			break;
		case POSTAL:
			editPostCode(value);
			break;
		case COUNTRY:
			editCountry(value);
			break;
		case STATE:
			editState(value);
			break;
		default:
			System.out.println("Invalid input!");
			break;
		}

	}
	
	public void updateAddressBook(String fname,String lname, String company, String address1, String address2,String city, String postal, String country,String state ) {
		editFirstName(fname);
		editLastName(lname);
		editCompany(company);
		editAddress1(address2);
		editAddress2(address2);
		editCity(city);
		editPostCode(postal);
		editCountry(country);
		sleep();
		editState(state);
		clickContinueButton();
	}
	
	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
