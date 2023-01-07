package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Base.TestBase;

public class AddressPage extends TestBase {

	public AddressPage() {
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

	@FindBy(css = "input-zone")
	WebElement state;

	@FindBy(css = "input[value='Continue']")
	WebElement continueButton;

	@FindBy(css = "div.alert-success")
	WebElement successAlertBanner;

	public void editFirstName(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);
	}

	public void editLastName(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
	}

	public void editCompany(String companyName) {
		company.clear();
		company.sendKeys(companyName);
	}

	public void editAddress1(String addressValue1) {
		address1.clear();
		address1.sendKeys(addressValue1);
	}

	public void editAddress2(String addressValue2) {
		address2.clear();
		address2.sendKeys(addressValue2);
	}

	public void editCity(String cityName) {
		city.clear();
		city.sendKeys(cityName);
	}

	public void editPostCode(String postalCode) {
		postCode.clear();
		postCode.sendKeys(postalCode);
	}

	public void editCountry(String countryName) {
		Select sc = new Select(country);
		sc.selectByValue(countryName);
		System.out.println("country method "+countryName);
	}

	public void editState(String stateName) {
		//state.clear();
		Select sc = new Select(state);
		sc.selectByVisibleText(stateName);
		System.out.println("state method");

	}

	public void clickContinueButton() {
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
				System.out.println(j + ": " + addressArray[j]);
			}
			System.out.println();
			for (int j = 0; j < addressArray.length; j++) {
				if (addressArray[j].equals(postalCode)) {
					// System.out.println(cells.get(1));
					return cells.get(1);
				}
			}
		}

		System.out.println("Record not found!!!");
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

	public void editAddressBook(String postalCode, By locator) {
		getElementFromTheAddressTable(postalCode).findElement(locator).click();
		updateAddressBook("Harleen","Randhawa","ABC","2089","12st","Amritsar","143524","99","Punjab");
		clickContinueButton();
	}

	private void updateAddressBook(String fname,String lname, String company, String address1, String address2,String city, String postal, String country,String state ) {
		editFirstName(fname);
		editLastName(lname);
		editCompany(company);
		editAddress1(address2);
		editAddress2(address2);
		editCity(city);
		editPostCode(postal);
		sleep();
		editCountry(country);
		sleep();
		editState(state);

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
